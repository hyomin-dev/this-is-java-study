package ch06.problems.problem19;

public class Account {
    private int balance;
    static final int MIN_BALANCE = 0;
    static final int MAX_BALANCE = 1000000;


    void setBalance(int balance){
//        if(!(balance<0 || balance>=1000000))
          if(balance>=0 && balance<=1000000)
            this.balance = balance;

    }

    int getBalance(){
        return this.balance;
    }

    public static void main(String[] args) {
        Account account = new Account();

        account.setBalance(10000);
        System.out.println("현재 잔고: "+account.getBalance());

        account.setBalance(-100);
        System.out.println("현재 잔고: "+account.getBalance());

        account.setBalance(2000000);
        System.out.println("현재 잔고: "+account.getBalance());

        account.setBalance(300000);
        System.out.println("현재 잔고: "+account.getBalance());

    }
}
