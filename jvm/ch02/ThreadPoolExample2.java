package jvm.ch02;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,2,0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        for(int i=0;i<100;i++){
            while (executor.getQueue().remainingCapacity() == 0) {
                Thread.sleep(10);
            }


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
    }
}
