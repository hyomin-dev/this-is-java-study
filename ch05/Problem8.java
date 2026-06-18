package ch05;

public class Problem8 {
    public static void main(String[] args) {
        int[][] array = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };

        int totalScore=0;
        int numStudent=0;
        double averageScore = 0.0;

        for(int i=0;i<array.length;i++){
            numStudent +=array[i].length;
            for(int j=0;j<array[i].length;j++){
                totalScore +=array[i][j];
            }
        }
        averageScore = (double) totalScore/numStudent;

        System.out.println("전체합: "+totalScore);
        System.out.println("평균: "+averageScore);

    }
}
