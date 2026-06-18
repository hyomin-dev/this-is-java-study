package ch04;
import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int deposit = 10000;
        int num;

        while(true){
            System.out.println("--------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("--------------------");

            System.out.print("선택>");
            num = scanner.nextInt();

            if(num==1){
                System.out.printf("예금액>%d\n",deposit);
            }
            else if(num==2){
                System.out.printf("출금액:%d\n", 2000);
                deposit -=2000;
            }
            else if(num==3){
                System.out.printf("잔고>%d\n", deposit);

            }
            else if(num==4){
                System.out.println("프로그램 종료");
                break;
            }


        }
        scanner.close();


    }
}
