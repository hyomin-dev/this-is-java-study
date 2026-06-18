package ch14.practice.syncasyncblockingnonblocking;


public class ThreadBlockingDemo {

    // 1. Lock 블로킹 실습을 위한 공유 객체
    private static final Object lockObject = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 자바 17 스레드 블로킹 실습 시작 ===");
        System.out.println("메인 스레드 이름: " + Thread.currentThread().getName());
        System.out.println("----------------------------------------------");

        // ==========================================
        // 시나리오 ①: synchronized Lock으로 인한 블로킹 (BLOCKED)
        // ==========================================

        // Lock을 먼저 선점하고 10초간 안 놓아줄 스레드 A
        Thread threadA = new Thread(() -> {
            synchronized (lockObject) {
                System.out.println("[스레드 A] Lock을 획득했습니다. 5초간 작업합니다.");
                try {
                    // 비즈니스 로직이나 I/O 작업 중이라고 가정 (TIMED_WAITING 상태가 됨)
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("[스레드 A] 작업을 마치고 Lock을 반환합니다.");
            }
        }, "Thread-A");

        // 동일한 Lock을 얻으려고 시도하다가 블로킹될 스레드 B
        Thread threadB = new Thread(() -> {
            try {
                // 스레드 A가 먼저 Lock을 잡을 수 있도록 아주 잠깐 대기
                Thread.sleep(500);
            } catch (InterruptedException e) { e.printStackTrace(); }

            System.out.println("[스레드 B] Lock을 얻으려고 시도합니다...");
            synchronized (lockObject) {
                System.out.println("[스레드 B] (블로킹 해제!) 드디어 Lock을 획득했습니다.");
            }
        }, "Thread-B");

        // 두 스레드 실행
        threadA.start();
        threadB.start();

        // 스레드 B가 Lock을 얻으려다 블로킹된 타이밍에 상태 점검
        Thread.sleep(1500);
        System.out.println("\n>>> [상태 모니터링]");
        System.out.println(">>> 스레드 A 상태 (sleep 중): " + threadA.getState());
        System.out.println(">>> 스레드 B 상태 (Lock 대기 중): " + threadB.getState()); // 여기서 BLOCKED 확인 가능
        System.out.println("----------------------------------------------\n");

        // 다음 실습을 위해 두 스레드가 끝날 때까지 대기
        threadA.join();
        threadB.join();


        // ==========================================
        // 시나리오 ②: 대량의 I/O 블로킹 상황 가정 (스레드 고갈 체험용)
        // ==========================================
        System.out.println("=== 시나리오 ②: 대량의 블로킹 스레드 생성 ===");

        int threadCount = 5;
        Thread[] ioThreads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            final int id = i + 1;
            ioThreads[i] = new Thread(() -> {
                System.out.println("[IO 스레드-" + id + "] DB 조회 (I/O) 요청 시작... (3초 소요 예상)");
                try {
                    // 실제 DB 요철이나 외부 API 호출 시 스레드가 멈추는(Blocking) 현상을 sleep으로 대체
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("[IO 스레드-" + id + "] DB 조회 완료!");
            }, "IO-Thread-" + id);

            ioThreads[i].start();
        }

        // 잠시 후 이 스레드들의 상태를 보면 모두 TIMED_WAITING (또는 OS 레벨 대기) 상태입니다.
        Thread.sleep(1000);
        System.out.println("\n>>> [상태 모니터링] 5개의 스레드가 모두 블로킹(대기)되어 아무 일도 안 하고 자원만 먹고 있습니다.");
        for (Thread t : ioThreads) {
            System.out.println(">>> " + t.getName() + " 상태: " + t.getState());
        }

        for (Thread t : ioThreads) {
            t.join();
        }

        System.out.println("\n=== 실습 종료 ===");
    }
}