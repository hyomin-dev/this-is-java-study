package ch17.sec11;

import ch08.sec10.exam01.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReductionExample {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("홍길동", 92),
				new Student("신용권", 95),
				new Student("감자바", 88)
		);		
		//방법1
		int sum1 = studentList.stream()
				.mapToInt(Student :: getScore)
				.sum();		
		//방법2
//		studentList = new ArrayList<>(); //reduce()에 스트림 요소가 없는 경우 테스트
		int sum2 = studentList.stream()
						.map(Student :: getScore)
				.reduce( 3, (a, b) -> a*b);
		
		System.out.println("sum1: " + sum1); // 92+95+88 = 275
		System.out.println("sum2: " + sum2); // 3*92*95*88 = 2,307,360

		List<Student> studentList2 = Arrays.asList(
				new Student("홍길동", 92),
				new Student("신용권", 95),
				new Student("감자바", 88)
		);

		int sum3 = studentList2.stream()
				.map(s -> s.getScore()+100)
				.reduce(0,(a,b)->a-b);
		System.out.println("sum3: " + sum3);
		/*
		---> +100
		92+100 = 192
		 95+100 = 195
		 88+100 = 188
		 ---> a-b
		 0-192 = -192
		 -192-195 = -387
		 -387-188 = -575*/

	}
}