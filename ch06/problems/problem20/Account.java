package ch06.problems.problem20;

public class Account {

    private final String accountNumber;
    private final String accountName;
    private int deposit;

    public Account(String accountNumber, String accountName, int deposit){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.deposit = deposit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName(){
        return accountName;
    }

    public int getDeposit(){
        return deposit;
    }

    public void setDeposit(int deposit){
        this.deposit = deposit;
    }





}
