package ch14.practice.prac_volatile;

public class WithoutVolatile {
    static boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            while (running) { // Thread의 캐시된 값을 계속 읽음
                // 아무것도 안 함
            }
            System.out.println("Worker stopped");
        });

        worker.start();
        Thread.sleep(1000);
        running = false; // main 스레드가 바꿔도 worker는 모를 수 있음
        System.out.println("Set running = false");
        worker.join();
    }
}