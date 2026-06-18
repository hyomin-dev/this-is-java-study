package ch06.problems.problem20;

import java.util.Scanner;

public class BankApplication {

    private Account[] accounts;
    private int count;
    static Scanner scanner = new Scanner(System.in);

    public BankApplication(){
        accounts = new Account[100];
        count = 0;
    }

    public void createAccount(){
        String accountNumber = "111-"+(count+1)+(count+1)+(count+1);
        System.out.println("계좌번호: "+accountNumber);
        System.out.print("계좌주: ");
        String name = BankApplication.scanner.next();
        System.out.print("초기입금액: ");
        int deposit = scanner.nextInt();
        accounts[count] = new Account(accountNumber, name, deposit);
        count++;
    }

    public void showAccountList(){
        if(count!=0){
            for(int i=0; i<count;i++){
                System.out.println(accounts[i].getAccountNumber()+"\t"+accounts[i].getAccountName()+"\t"+accounts[i].getDeposit());
            }

        }

    }

    public void saveDeposit(){
        System.out.print("계좌번호: ");
        String accountNumber = scanner.next();
        System.out.print("예금액: ");
        int deposit = scanner.nextInt();
        int idx = Character.getNumericValue(accountNumber.charAt(4));
        accounts[idx-1].setDeposit(deposit+accounts[idx-1].getDeposit());
    }

    public void withdrawDeposit(){
        System.out.print("계좌번호: ");
        String accountNumber = scanner.next();
        System.out.print("출금액: ");
        int deposit = scanner.nextInt();
        int idx = Character.getNumericValue(accountNumber.charAt(4));
        accounts[idx-1].setDeposit(accounts[idx-1].getDeposit()-deposit);
    }

    public static void main(String[] args) {

        BankApplication bankapplication = new BankApplication();

        int input;

        while(true){

            System.out.println("-----------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("-----------------------------------------------");

            input = BankApplication.scanner.nextInt();

            if(input ==1) {
                System.out.println("----------");
                System.out.println("계좌생성");
                System.out.println("----------");
                bankapplication.createAccount();
                System.out.println("결과: 계좌가 생성되었습니다.");
            }
            else if(input==2) {
                System.out.println("----------");
                System.out.println("계좌목록");
                System.out.println("----------");
                bankapplication.showAccountList();
            }
            else if(input==3) {
                System.out.println("----------");
                System.out.println("예금");
                System.out.println("----------");
                bankapplication.saveDeposit();
            }
            else if(input==4) {
                System.out.println("----------");
                System.out.println("출금");
                System.out.println("----------");
                bankapplication.withdrawDeposit();
                System.out.println("결과: 출금이 성공되었습니다.");
            }
            else if(input==5){
                System.out.println("프로그램 종료");
                break;
            }

        }

        scanner.close();





    }
}
