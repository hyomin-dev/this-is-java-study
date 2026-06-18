package ch14.godofjava.prac1;


public class RunSync {
    public static void main(String[] args) {
        RunSync runSync = new RunSync();
        for(int i=0;i<5;i++)
            runSync.runCommonCalculate();

    }

    public void runCommonCalculate(){
        CommonCalculate calc = new CommonCalculate();
        ModifyAmountThread thread1 = new ModifyAmountThread(calc, true);
        thread1.setName("thread1");
        ModifyAmountThread thread2 = new ModifyAmountThread(calc, true);
        thread2.setName("thread2");

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
            System.out.println("Final value is "+calc.getAmount());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
