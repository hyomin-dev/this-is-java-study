package ch14.practice.prac_volatile;


import java.util.concurrent.CountDownLatch;

public class VolatileCountTest {
    static volatile int volatileCount = 0;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 1000;
        int incrementPerThread = 10000;
        CountDownLatch latch = new CountDownLatch(threadCount);

        // volatile count 테스트
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                for (int j = 0; j < incrementPerThread; j++) {
                    volatileCount++; // 위험!
                }
                latch.countDown();
            }).start();
        }

        latch.await(); // 모든 스레드 끝날 때까지 대기
        System.out.println("기대값: " + (threadCount * incrementPerThread)); // 10000000
        System.out.println("volatile 결과: " + volatileCount); // 2747120
    }
}