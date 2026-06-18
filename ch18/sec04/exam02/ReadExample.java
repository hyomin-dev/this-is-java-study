package ch18.sec04.exam02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {
	public static void main(String[] args) {
		try {
			System.err.println("에러 발생");
			Reader reader = null;

			//1 문자씩 읽기
			reader = new FileReader("./ch18/data/test.txt");
			while(true) {
				int data = reader.read();
				if(data == -1) break;
				System.out.print((char)data);
			}
			reader.close();
			System.out.println();
			System.out.println("=================================================");

			//문자 배열로 읽기
			reader = new FileReader("./ch18/data/test.txt");
			char[] data = new char[100];
			while(true) {
				int num = reader.read(data);
				if(num == -1) break;
				for(int i=0; i<num; i++) {
					System.out.print(data[i]);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}