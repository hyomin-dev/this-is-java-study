package ch15.Problem.P9;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("blue", 96);
        map.put("hong",86);
        map.put("white",92);

        String name = null;
        int maxScore = 0;
        int totalScore = 0;

        //여기에 코드를 작성하세요.
        //while 사용
//        Iterator<String> keySet = map.keySet().iterator();
//
//        while(keySet.hasNext()){
//            String key= keySet.next();
//            int score = map.get(key);
//
//            totalScore +=score;
//            if(maxScore<score){
//                name = key;
//                maxScore = score;
//            }
//        }
//
//

        //forEach 사용
        Set<String> set = map.keySet();
        for(String key: set){
            int score = map.get(key);
            totalScore +=score;
            if(maxScore<score){
                name = key;
                maxScore = score;
            }
        }

        System.out.println("평균 점수: "+(double)totalScore/map.size());
        System.out.println("최고 점수: "+maxScore);
        System.out.println("최고 점수를 받은 아이디: "+name);
    }
}
