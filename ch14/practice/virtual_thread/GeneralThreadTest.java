package ch14.practice.virtual_thread;


import java.util.List;
import java.util.stream.IntStream;

public class GeneralThreadTest {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        List<Thread> threads = IntStream.range(0,1_000_000).mapToObj(i->new Thread(()->{
            System.out.println("Thread.currentThread() = " + Thread.currentThread().getName());
        })).toList();

        threads.forEach(Thread::start);
        long end = System.currentTimeMillis();

        System.out.println("(end-start) = " + (end - start)); // 70067: 백만, 706511: 천만
    }
}
