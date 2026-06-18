package ch12.sec11.exam01;

public class GetClassExample {
	public static void main(String[] args) throws Exception {
		//how1
		Class clazz = Car.class;
		
		//how2
		Class clazz2 = Class.forName("ch12.sec11.exam01.Car");
		
		//how3
		Car car = new Car();
		Class clazz3 = car.getClass();
		System.out.println("패키지: " + clazz.getPackage().getName());
		System.out.println("클래스 간단 이름: " + clazz.getSimpleName());
		System.out.println("클래스 전체 이름: " + clazz.getName());
		System.out.println("=========================================");
		System.out.println("패키지: " + clazz2.getPackage().getName());
		System.out.println("클래스 간단 이름: " + clazz2.getSimpleName());
		System.out.println("클래스 전체 이름: " + clazz2.getName());
		System.out.println("==========================================");
		System.out.println("패키지: " + clazz3.getPackage().getName());
		System.out.println("클래스 간단 이름: " + clazz3.getSimpleName());
		System.out.println("클래스 전체 이름: " + clazz3.getName());
		System.out.println("=========================================");
		System.out.print("클래스이름.class == Class.forName() = "+(clazz==clazz2)+"\n");
		System.out.print("클래스이름.class == Obj.getClass() = "+(clazz==clazz3)+"\n");
		System.out.print("Class.forName() == Obj.getClass() = "+(clazz2==clazz3)+"\n");
	}
}