package practice;

import java.util.*;

public class ListIter {
    public static void main(String[] args) {
//        Collection<Integer> list = new ArrayList<>();
        List<Integer> list = Arrays.asList(new Integer[]{1,2,3,4});

        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            int a = iter.next();
            System.out.println(a);
        }
    }
}
