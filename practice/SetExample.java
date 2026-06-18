package practice;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        for(int i=10;i>0;i--)
            set.add(String.valueOf(i));

        for(String str:set){
            System.out.println(str);
        }
    }
}
