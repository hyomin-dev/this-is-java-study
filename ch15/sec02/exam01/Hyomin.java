package ch15.sec02.exam01;

import java.util.List;
import java.util.ArrayList;

public class Hyomin {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("test");
		list.add(new Board("t","t","t"));
		list.add(111);
		
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
	


		
	}
}
