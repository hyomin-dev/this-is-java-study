package ch17.sec07.pratice;

import java.util.Arrays;
import java.util.Comparator;

public class Run {
    public static void main(String[] args) {
        double[] arrDouble = {1.1,2.2,3.3,4.4,5.5};
        Arrays.stream(arrDouble)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

    }
}
