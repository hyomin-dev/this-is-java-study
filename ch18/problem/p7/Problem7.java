package ch18.problem.p7;

import java.io.BufferedReader;
import java.io.FileReader;

public class Problem7 {
    public static void main(String[] args) throws Exception {
        String filePath = "./ch02/sec01/VariableUseExample.java";





        try(FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);){
            int rowNumber = 0;
            String str = null;
            while(true){
                str = br.readLine();
                if(str==null)
                    break;
                System.out.println(++rowNumber+" "+str);

            }
        }catch(Exception e){

        }



    }
}
