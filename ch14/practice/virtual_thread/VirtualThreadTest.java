package ch14.practice.virtual_thread;


import java.util.List;
import java.util.stream.IntStream;

public class VirtualThreadTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Thread> threads = IntStream.range(0,10_000_000).mapToObj(i->Thread.ofVirtual().unstarted(()->{})).toList();

        threads.forEach(Thread::start);
        long end = System.currentTimeMillis();

        System.out.println("(end-start) = " + (end - start)); // 337: 백만, 3036: 천만
    }
}
