package ch14.practice.virtual_thread;


import java.util.concurrent.CountDownLatch;

public class PlatformThreadMemory {
    public static void main(String[] args) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        int threadCount = 1000;
        CountDownLatch latch = new CountDownLatch(1);

        System.gc();
        long beforeMem = runtime.totalMemory() - runtime.freeMemory();
        long beforeTime = System.currentTimeMillis();

        for (int i = 0; i < threadCount; i++) {
            Thread.ofPlatform().start(() -> {
                try { latch.await(); } catch (InterruptedException e) {}
            });
        }

        long afterTime = System.currentTimeMillis();
        long afterMem = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("=== 플랫폼 스레드 " + threadCount + "개 ===");
        System.out.println("생성 시간: " + (afterTime - beforeTime) + "ms");
        System.out.printf("메모리 증가: %.1fMB%n", (afterMem - beforeMem) / 1024.0 / 1024.0);

        latch.countDown();
    }
}