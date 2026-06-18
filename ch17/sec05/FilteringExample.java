package ch17.sec05;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilteringExample {
	public static void main(String[] args) {
		//List 컬렉션 생성
		List<String> list = new ArrayList<>();
		list.add("홍길동"); 	list.add("신용권");
		list.add("감자바");		list.add("신용권");		list.add("신민철");
		
		//중복 요소 제거
		list.stream()
			.distinct()
			.forEach(n -> System.out.println(n));
		System.out.println();
		
		//신으로 시작하는 요소만 필터링
		list.stream()
			.filter(n -> n.startsWith("신"))
			.forEach(n -> System.out.println(n));
		System.out.println();

		list.stream()
			.filter(new Predicate<String>(){
				@Override
				public boolean test(String str) {
					if(str.startsWith("신"))
						return true;
					else
						return false;
				}
			}).forEach(new Consumer<String>(){
				@Override
				public void accept(String str){
					System.out.println(str);
				}}
				);
		System.out.println();


		//중복 요소를 먼저 제거하고, 신으로 시작하는 요소만 필터링
		list.stream()
			.distinct()
			.filter(n -> n.startsWith("신"))
			.forEach(n -> System.out.println(n));		
	}
}