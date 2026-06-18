package ch18.sec07.exam02;

import java.io.*;

public class ReadLineExample {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
			new FileReader("./ch18/sec07/exam02/ReadLineExample.java")
		);
		
		int lineNo = 1;
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			System.out.println(lineNo + "\t" + str);
			lineNo++;
		}
		
		br.close();

		/*FileReader fileReader = new FileReader("./ch18/sec07/exam02/ReadLineExample.java");

		int lineNo = 1;
		System.out.print(lineNo+"\t");
		while(true){
			int c = fileReader.read();
			if(c==-1)
				break;
			System.out.print((char)c);
			if((char)c=='\n') {
				lineNo++;
				System.out.print(lineNo + "\t");
			}
		}
		fileReader.close();*/
	}
}