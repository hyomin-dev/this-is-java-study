package ch14.godofjava.prac1;


public class ModifyAmountThread extends Thread{
    private CommonCalculate calc;

    private boolean addFlag;

    public ModifyAmountThread(CommonCalculate calc, boolean addFlag) {
        this.calc = calc;
        this.addFlag = addFlag;
    }

    @Override
    public void run() {
        for(int loop=0;loop<100;loop++){
            if(addFlag){
                calc.plus(1);
            }else{
                calc.minus(1);
            }
        }
    }
}
