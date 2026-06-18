package ch04;

public class Problem6 {
    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
            for(int j=0; j<i;j++)
                System.out.printf("%c",'*');
            System.out.printf("\n");
        }
    }
}
