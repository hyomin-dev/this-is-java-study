package practice;

public class Init {
    public int sum;
    public void sum(int n){



        for(int i=0;i<n;i++)
            sum+=i;
        System.out.println(sum);
    }
    public static void main(String[] args) {
        Init init = new Init();
        init.sum(10);

    }
}
