package ch17.sec06.pratice.as_double_stream;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Run {
    public static void main(String[] args) {
        int[] intArr = {1,2,3,4,5};
        long[] longArr = {1L,2L,3L,4L,5L};

        IntStream.of(intArr)
                .asDoubleStream()
                .forEach(System.out::println);
        System.out.println("==========================");
        LongStream.of(longArr)
                .asDoubleStream()
                .forEach(System.out::println);
    }
}
