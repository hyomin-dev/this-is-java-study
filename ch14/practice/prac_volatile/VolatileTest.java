package ch14.practice.prac_volatile;


public class VolatileTest {
    public static volatile int race = 0;

    public static void increase(){
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args){
        Thread[] threads = new Thread[THREADS_COUNT];
        for(int i=0;i<THREADS_COUNT;i++){
            threads[i] = new Thread(()->{
                for(int j=0;j<10000;j++){
                    increase();
                }
            });
            threads[i].start();
        }

        // 다른 모든 스레드가 종료할 때까지 대기
        while(Thread.activeCount()>2){
           Thread.yield();
        }

        System.out.println(race);
    }
}
