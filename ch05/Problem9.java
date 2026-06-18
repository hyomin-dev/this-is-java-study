package ch05;
import java.util.Scanner;

public class Problem9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input;
        int[] scores=null;

        Loop : while(true){
            System.out.println("------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("------------------------------");

            System.out.print("선택> ");
            input = scanner.nextInt();

            switch(input){
                case 1:
                    System.out.print("학생수> ");
                    input = scanner.nextInt();
                    scores = new int[input];
                    break;
                case 2:
                    for(int i=0;i<scores.length;i++){
                        System.out.print("score["+i+"]> ");
                        input = scanner.nextInt();
                        scores[i] = input;
                    }
                    break;
                case 3:
                    for(int i=0;i<scores.length;i++){
                        System.out.printf("score[%1$d]> %2$d",i,scores[i]);
                        System.out.println();
                    }
                    break;
                case 4:
                    int maxIndex = 0;
                    int totalScore = scores[0];
                    double averageScore = 0.0;
                    for(int i=1;i<scores.length;i++){
                        totalScore +=scores[i];
                        if(scores[maxIndex]<scores[i])
                            maxIndex = i;
                    }
                    averageScore = (double) totalScore/scores.length;
                    System.out.println("최고 점수: "+ scores[maxIndex]);
                    System.out.println("평균 점수: "+ averageScore);
                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    break Loop;
            }

        }

    }
}
