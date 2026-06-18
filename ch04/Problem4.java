package ch04;

public class Problem4 {
    public static void main(String[] args) {
        int num1, num2;

        while(true){
            num1 = (int) (Math.random()*6) + 1;
            num2 = (int)(Math.random()*6) +1;
            System.out.printf("주사위: (%1$d, %2$d)\n",num1, num2);
            if(num1+num2 == 5)
                break;
        }

    }
}
