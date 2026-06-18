package ch16.pratice;

public class TestType {

    public void test(Calculable calculable){
        double x= 10.4;
        double y = -11.0;

        double result = calculable.cal(x,y);

        System.out.printf("result: %.2f",result);
    }
}
