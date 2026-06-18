package ch18.practice;

import java.io.IOException;
import java.io.InputStreamReader;

public class Prac_System_in {
    public static void main(String[] args) {

        try( InputStreamReader rd = new InputStreamReader(System.in)){

            while(true){
                System.out.print("입력하세요: ");
                int c = rd.read();

                if(c==-1)
                    break;

                System.out.println((char)c);
                System.out.println(c); //utf-8 10진수
            }
        }catch(IOException  e){
            System.out.println("IOException 발생");
        }
        System.out.println("프로그램 종료");

    }
}
