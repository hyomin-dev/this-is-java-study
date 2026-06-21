package ch14.practice.prac_volatile;


public class WithVolatile {
    static volatile boolean running = true; // ← volatile 추가

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            while (running) { // 항상 메인 메모리에서 읽음
            }
            System.out.println("Worker stopped");
        });

        worker.start();
        Thread.sleep(1000);
        running = false;
        System.out.println("Set running = false");
        worker.join();
    }
}