package ch14.practice.virtual_thread;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.CountDownLatch;

public class ThreadMappingDemo {
    public static void main(String[] args) throws Exception {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        // 스레드 만들기 전 JVM 스레드 수
        System.out.println("=== 스레드 생성 전 ===");
        System.out.println("JVM 스레드 수: " + bean.getThreadCount());

        // OS 스레드 수 찍기 (Linux 전용)
        printOsThreadCount();

        CountDownLatch latch = new CountDownLatch(1);

        // 플랫폼 스레드 5개 생성
        for (int i = 0; i < 5; i++) {
            Thread.ofPlatform().name("my-thread-" + i).start(() -> {
                try { latch.await(); } catch (InterruptedException e) {}
            });
        }

        Thread.sleep(200); // 스레드 안정화 대기

        System.out.println("\n=== 플랫폼 스레드 5개 생성 후 ===");
        System.out.println("JVM 스레드 수: " + bean.getThreadCount());
        printOsThreadCount();

        latch.countDown();
    }

    static void printOsThreadCount() throws Exception {
        // /proc/self/status 에서 Threads 항목 읽기
        Process p = Runtime.getRuntime().exec("cat /proc/self/status");
        String output = new String(p.getInputStream().readAllBytes());
        for (String line : output.split("\n")) {
            if (line.startsWith("Threads:")) {
                System.out.println("OS  스레드 수: " + line);
            }
        }
    }
}
