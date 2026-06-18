package ch05;

public class Problem7 {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 8, 2};
        int maxValue=0;

        for(int i=1;i<array.length;i++){
            if(array[maxValue]<array[i])
                maxValue = i;
        }
        System.out.println("최대값은: "+array[maxValue]);
    }
}
