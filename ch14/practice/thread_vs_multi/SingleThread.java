package ch14.practice.thread_vs_multi;


public class SingleThread {
    public static void main(String[] args) {
        SingleThread singleThread = new SingleThread();
        Long start = System.currentTimeMillis();
        singleThread.sum();
        Long end = System.currentTimeMillis();
        System.out.println("end-start = " + (end - start));
    }

    public void sum(){
        int result=0;

        for(int i=0;i<10000000;i++){
            result = i;
        }

        System.out.println("result = " + result);
    }
}
