package ch14.godofjava.prac1;


public class CommonCalculate {
    private int amount;

    public CommonCalculate() {
        this.amount = 0;
    }

    public synchronized void plus(int value){
        amount+=value;
        System.out.println(Thread.currentThread());
    }

    public void minus(int value){
        synchronized (this) {
            amount -= value;
        }
    }

    public int getAmount(){
        return amount;
    }
}
