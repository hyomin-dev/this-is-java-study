package ch17.sec06.pratice.boxed;

import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        int[] intArr = {1,2,3,4,5};
        long[] longArr = {1L,2L,3L,4L,5L};
        double[] doubleArr = {1.1,2.2,3.3,4.4,5.5};

        Arrays.stream(intArr)
                .boxed()
                .forEach(obj-> System.out.println(obj.intValue()));
        System.out.println("=======================================");
        Arrays.stream(longArr)
                .boxed()
                .forEach(obj-> System.out.println(obj.longValue()));
        System.out.println("=======================================");

        Arrays.stream(doubleArr)
                .boxed()
                .forEach(obj-> System.out.println(obj.doubleValue()));

    }
}
