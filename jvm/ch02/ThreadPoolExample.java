package jvm.ch02;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,2,0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        for(int i=0;i<100;i++){
            int num = i;

            executor.execute(()->{
                System.out.println(num);

                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }

        System.out.println("for문 종료");
    }
}
