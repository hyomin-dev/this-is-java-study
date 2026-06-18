package ch14.practice.thread_vs_multi;


public class MultiThread {
    public static void main(String[] args) {
        MultiThread multiThread = new MultiThread();

        Long start = System.currentTimeMillis();

        Thread thread1 = new Thread(()->{
            int result = 0;
            for(int i=0;i<5000000;i++){
                result = i;
            }
            System.out.println("result = " + result);
        });

        Thread thread2 = new Thread(()->{
            int result = 0;
            for(int i=0;i<5000000;i++){
                result = i;
            }
            System.out.println("result = " + result);
        });

        try{
            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Long end = System.currentTimeMillis();

        System.out.println("end-start = " + (end - start));


    }


}
