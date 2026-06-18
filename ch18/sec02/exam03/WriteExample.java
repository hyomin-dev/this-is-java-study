package ch18.sec02.exam03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
	
public class WriteExample {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("./ch18/data/test3.db");

			byte[] array = { -1, -2, 30, 40, 50 };

			os.write(array, 1, 3);

			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}