package ch14.practice.virtual_thread;


import java.util.ArrayList;
import java.util.List;

public class PlatformThreadExample {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            });

            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("elapsed = "
                + (System.currentTimeMillis() - start)); // 4639
    }
}