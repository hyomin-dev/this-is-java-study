package ch14.practice.syncasyncblockingnonblocking;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SyncAsyncBlockingNonBlockingDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("=== 4가지 조합 실습 시작 (메인 스레드 시작) ===");

        // 💡 아래 4가지 메서드 중 하나씩 주석을 풀며 실행해 보세요!
        //runSyncBlocking();
         runSyncNonBlocking();
         //runAsyncNonBlocking();
         //runAsyncBlocking();

        System.out.println("=== 메인 스레드 종료 ===");
    }

    /**
     * 1. Sync-Blocking (동기 + 블로킹)
     * 가장 익숙한 일반적인 코드 흐름입니다.
     */
    private static void runSyncBlocking() {
        System.out.println("\n[1. Sync-Blocking 시작]");

        // 다른 스레드(혹은 외부 I/O)에게 작업을 시키고, 끝날 때까지 제어권을 뺏겨 멈춰 서서 기다림
        String result = getDbDataBlocking();

        // 데이터가 올 때까지 아래 줄은 실행조차 못 함 (Blocking)
        // 결과를 리턴받아 처리하므로 동기 (Sync)
        System.out.println("결과 처리: " + result);
    }

    /**
     * 2. Sync-NonBlocking (동기 + 논블로킹)
     * 제어권을 바로 돌려받았지만, 결과가 궁금해서 "끝났냐?"고 계속 물어보는(Polling) 형태입니다.
     */
    private static void runSyncNonBlocking() throws InterruptedException, ExecutionException {
        System.out.println("\n[2. Sync-NonBlocking 시작]");

        // 작업을 던지자마자 제어권을 바로 돌려받음 (Non-Blocking) -> FutureTask 활용
        FutureTask<String> task = new FutureTask<>(() -> {
            Thread.sleep(2000); // 2초 걸리는 작업
            return "DB 데이터 완료";
        });
        new Thread(task).start();

        System.out.println("제어권을 바로 돌려받아서 메인 스레드는 멈추지 않고 딴짓을 할 수 있음!");


        // 동기(Sync)이므로 결과는 내가 직접 확인해야 함. "끝났어?" 무한 쪼기 (Polling)
        while (!task.isDone()) {
            System.out.println("메인 스레드: 아직 안 끝났네? 딴짓(로그 출력) 중...");
            Thread.sleep(500);
        }

        try {
            System.out.println("결과 처리: " + task.get());
        } catch (ExecutionException e) { e.printStackTrace(); }
    }

    /**
     * 3. Async-NonBlocking (비동기 + 논블로킹)
     * 백엔드 대용량 아키텍처의 이상향. 작업을 던지고 제어권도 바로 받고, 결과는 신경 꺼두면 알아서 콜백이 처리함.
     */
    private static void runAsyncNonBlocking() throws InterruptedException {
        System.out.println("\n[3. Async-NonBlocking 시작]");

        // CompletableFuture를 사용하여 작업을 비동기로 던짐
        CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            return "DB 데이터 완료";
        }).thenAccept(result -> {
            // 결과가 나오면 실행될 Callback 함수 정의. 메인 스레드는 이 결과를 기다리지 않음 (Async)
            System.out.println("[콜백 스레드] 결과 전달받아서 알아서 처리함: " + result);
        });

        // 제어권을 즉시 돌려받았으므로(Non-Blocking) 메인 스레드는 갈 길 갑니다.
        System.out.println("메인 스레드: 난 내 할 일 다 했으니 퇴근한다~");

        // 비동기 스레드가 끝나는 걸 보기 위해 잠시 메인 스레드를 붙잡아둠
        Thread.sleep(3000);
    }

    /**
     * 4. Async-Blocking (비동기 + 블로킹)
     * 설계 실수로 주로 발생하거나, NodeJS 환경에서 자바 라이브러리 잘못 쓰면 발생하는 기괴한 구조.
     * 비동기로 처리하라고 콜백(thenAccept)을 걸어놨는데, 뜬금없이 중간에 Blocking 코드가 있어서 멈추는 현상.
     */
    private static void runAsyncBlocking() throws InterruptedException {
        System.out.println("\n[4. Async-Blocking 시작]");

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            return "DB 데이터 완료";
        });

        // 원래는 non-blocking으로 가야 하는데, 개발자가 갑자가 .join()이나 .get()으로 스레드를 틀어막음 (Blocking)
        System.out.println("작업을 비동기로 넘겼지만... 갑자기 여기서 락(Blocking)을 걸어버림");
        String result = future.join(); // 여기서 스레드가 2초간 멈춤

        System.out.println("결과 처리: " + result);
    }

    // 2초 걸리는 가상의 무거운 DB 작업 (Blocking 함수)
    private static String getDbDataBlocking() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) { e.printStackTrace(); }
        return "DB 데이터 완료";
    }
}