package ch17.sec10;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList< >();
		//list.add(3);
		//list.add(5);

		//예외 발생(java.util.NoSuchElementException)
 		/*double avg2 = list.stream()
 			.mapToInt(Integer :: intValue)
 			.average()
 			.getAsDouble();*/

		//방법1
		OptionalDouble optional = list.stream()
			.mapToInt(Integer :: intValue)
			.average();
		if(optional.isPresent()) {
			System.out.println("방법1_평균: " + optional.getAsDouble());
		} else {
			System.out.println("방법1_평균: 0.0입니다.");
		}

		//방법2
		double avg = list.stream()
			.mapToInt(Integer :: intValue)
			.average()
			.orElse(0.0);
		System.out.println("방법2_평균: " + avg+"입니다");
		
		//방법3
		list.stream()
			.mapToInt(Integer :: intValue)
			.average()
			.ifPresent(a -> System.out.println("방법3_평균: "+a));
			//.ifPresentOrElse(a -> System.out.println("방법3_평균: " + a),()->System.out.println("값이 없습니다."));
	}
}