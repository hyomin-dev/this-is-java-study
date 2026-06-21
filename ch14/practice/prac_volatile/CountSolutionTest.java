package ch14.practice.prac_volatile;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CountSolutionTest {
    static volatile int volatileCount = 0;
    static AtomicInteger atomicCount = new AtomicInteger(0);
    static int synchronizedCount = 0;

    static synchronized void syncIncrement() {
        synchronizedCount++;
    }

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 1000;
        int incrementPerThread = 10000;
        CountDownLatch latch = new CountDownLatch(threadCount * 3);

        for (int i = 0; i < threadCount; i++) {
            // ❌ volatile - 원자성 없음
            new Thread(() -> {
                for (int j = 0; j < incrementPerThread; j++) volatileCount++;
                latch.countDown();
            }).start();

            // ✅ AtomicInteger - CAS로 원자성 보장
            new Thread(() -> {
                for (int j = 0; j < incrementPerThread; j++) atomicCount.incrementAndGet();
                latch.countDown();
            }).start();

            // ✅ synchronized - lock으로 원자성 보장
            new Thread(() -> {
                for (int j = 0; j < incrementPerThread; j++) syncIncrement();
                latch.countDown();
            }).start();
        }

        latch.await();
        System.out.println("기대값         : " + (threadCount * incrementPerThread)); // 10000000
        System.out.println("volatile       : " + volatileCount);        // ❌ 매번 다름 6772538
        System.out.println("AtomicInteger  : " + atomicCount.get());    // ✅ 항상 10000000
        System.out.println("synchronized   : " + synchronizedCount);    // ✅ 항상 10000000
    }
}
