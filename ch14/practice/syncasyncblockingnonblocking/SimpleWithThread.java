package ch14.practice.syncasyncblockingnonblocking;


import ch08.sec10.exam01.C;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SimpleWithThread {
    public static void main(String[] args) {
        SimpleWithThread simpleWithThread = new SimpleWithThread();
        //simpleWithThread.runSyncBlocking();
        //simpleWithThread.runSyncNonBlocking();
        //simpleWithThread.runAsyncBlocking();
        simpleWithThread.runAsyncNonBlocking();
    }

    private void runSyncBlocking(){
        // sync: 결과가 나올 때까지 기다린다.
        // blocking: 제어권을 넘겨준다.

        System.out.println("run Synchronous+Blocking");

        String result = doWork();
        System.out.println("result = " + result);
    }

    private void runSyncNonBlocking() {
        // sync: 결과가 나올 때까지 기다린다.
        // non-blocking: 제어권을 다시 넘겨 받는다.

        System.out.println("run Synchronous+Non-Blocking");

        long count = 0;
        FutureTask<String> task = new FutureTask<>(()->doWork());
        Thread thread = new Thread(task);

        thread.start();

        while(task.isDone()){ // 작업이 끝날 때까지 기다린다.
            count++; //제어권이 나에게 있다.
        }

        try{
            String result = task.get();
            System.out.println("result = " + result);
            System.out.println("count = " + count); // 7,510,232,369
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void runAsyncBlocking(){
        // async: 결과가 완료될 때까지 기다리지 않고, 다른 작업을 계속할 수 있다.
        // blocking: 제어권을 넘겨준다.

        System.out.println("run Asynchronous+Blocking");

        FutureTask<String> task = new FutureTask<>(()->doWork());
        Thread thread = new Thread(task);

        thread.start(); // 제어권을 다시 넘겨 받는다.

        try{
            String result = task.get(); // 다른 것을 제어권을 넘겨주는 것을 선택함
            System.out.println("result = " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private void runAsyncNonBlocking(){
        // async: 결과가 완료될 때까지 기다리지 않고, 다른 작업을 계속할 수 있다.
        // non-blocking: 제어권을 다시 넘겨 받는다.

        System.out.println("run Asynchronous+Non-Blocking");

        Thread thread = new Thread(()->{
            String result = doWork();
            System.out.println("result = " + result);
        });

        thread.start();

        System.out.println("오늘 할일 끝 내일 와서 결과 볼게");

    }


    private String doWork(){
        try{
            System.out.println("wait 2 seconds");
            Thread.sleep(2000);

        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return "Finish doWork";
    }
}
