package ch14.forkjoin;


import java.util.concurrent.ForkJoinPool;

public class ForkJoinSample {
    static final ForkJoinPool mainPool = new ForkJoinPool(); // 스레드 풀을 생성

    public static void main(String[] args) {
        ForkJoinSample sample = new ForkJoinSample();
        //sample.calculate();
        sample.calculate2();
    }

    public void calculate(){
        long from = 0;
        long to = 10;

        GetSum sum = new GetSum(from, to); // 수행할 작업
        Long result = mainPool.invoke(sum); // invoke()를 호출해서 작업을 수행한다.
        System.out.println("Fork Join: Total sum of "+from+" ~ "+to+" = "+result);
    }

    public void calculate2(){
        long from = 0;
        long to = 10;

        GetSum2 sum = new GetSum2(from, to);
        Long result = mainPool.invoke(sum);
        System.out.println("Fork Join: Total sum of "+from+" ~ "+to+" = "+result);
    }
}
