package ch14.practice.syncasyncblockingnonblocking;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AsyncExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("[Main] 메인 스레드 시작");

        // 1. Task 1을 별도 스레드에서 비동기로 실행하도록 위임
        CompletableFuture.supplyAsync(() -> doWork("Task 1", 2))
                .thenAccept(result -> System.out.println("[Callback] Task 1 결과 처리: " + result));

        // 2. Task 2를 별도 스레드에서 비동기로 실행하도록 위임 (Task 1을 기다리지 않음)
        CompletableFuture.supplyAsync(() -> doWork("Task 2", 1))
                .thenAccept(result -> System.out.println("[Callback] Task 2 결과 처리: " + result));

        // 메인 스레드는 작업을 맡기자마자 멈춤 없이 바로 아래 코드로 내려옴
        System.out.println("[Main] 메인 스레드는 자기 할 일 하러 바로 내려옴 (종료 직전)");

        // 비동기 스레드들이 작업을 마칠 때까지 메인 스레드가 먼저 죽지 않도록 잠시 대기
        TimeUnit.SECONDS.sleep(3);
    }

    private static String doWork(String taskName, int seconds) {
        System.out.println("[" + taskName + "] 별도 스레드에서 작업 시작...");
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return taskName + " 완료!";
    }
}