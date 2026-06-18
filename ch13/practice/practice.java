package ch13.practice;

public class practice {
	
	public static <T> void print(T[] t){
		System.out.println(t[0]);
		System.out.println(t[1]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(new String[]{"hyomin","choi"});
	}

}
