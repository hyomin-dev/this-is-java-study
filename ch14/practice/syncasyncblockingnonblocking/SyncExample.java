package ch14.practice.syncasyncblockingnonblocking;


import java.util.concurrent.TimeUnit;

public class SyncExample {
    public static void main(String[] args) {
        System.out.println("[Main] 메인 스레드 시작");

        // 1. 첫 번째 작업 실행 및 완료 대기
        String result1 = doWork("Task 1", 2);
        System.out.println("[Main] 결과 받음: " + result1);

        // 2. 두 번째 작업 실행 및 완료 대기 (Task 1이 끝나야만 실행됨)
        String result2 = doWork("Task 2", 1);
        System.out.println("[Main] 결과 받음: " + result2);

        System.out.println("[Main] 메인 스레드 종료");
    }

    private static String doWork(String taskName, int seconds) {
        System.out.println("[" + taskName + "] 작업 시작...");
        try {
            TimeUnit.SECONDS.sleep(seconds); // 시간 걸리는 작업 시뮬레이션
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return taskName + " 완료!";
    }
}