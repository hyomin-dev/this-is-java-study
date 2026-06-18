package ch17.sec04.exam03;

import java.util.stream.IntStream;

public class StreamExample {
	public static int sum;

	public static void main(String[] args) {
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(a -> sum += a);
		System.out.println("총합: " + sum);

		System.out.println("====================================");
		IntStream intStream2 = IntStream.range(1,100);
		sum = 0;
		intStream2.forEach(ele -> sum+=ele);
		System.out.println("총합: "+sum);

	}
}