package ch17.sec06.pratice.as_long_stream;

import java.util.stream.IntStream;

public class Run {
    public static void main(String[] args) {
        int[] intArr = {1,2,3,4,5};

        IntStream.of(intArr)
                .asLongStream()
                .forEach(n-> System.out.println(n));
    }
}
