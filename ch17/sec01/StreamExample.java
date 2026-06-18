package ch17.sec01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		//Set 컬렉션 생성
		Set<String> set = new HashSet< >();
		set.add("홍길동");
		set.add("신용권");
		set.add("감자바");

		//Stream을 이용한 요소 반복 처리
		Stream<String> stream = set.stream();
//		stream.forEach( name -> System.out.println(name) );
		stream.forEach( System.out::println );

		System.out.println("=======================================");

		int[] intArr = {1,2,3,4,5};
		IntStream intstream = Arrays.stream(intArr);
//		intstream.forEach(System.out::println);
		/*intstream.forEach( new IntConsumer(){
			@Override
			public void accept(int value){
				System.out.println(value);
			}
		});*/
		intstream.forEach(ele -> System.out.println(ele));

	}

}