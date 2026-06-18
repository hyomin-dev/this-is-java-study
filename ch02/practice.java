package ch02;

public class practice {
    public static void main(String[] args) {
        System.out.println("0123456789 |");
        System.out.printf("%-10s |\n","aaaaaaaaaa");
        System.out.printf("%-10s |\n",changeTitleBytes("가나다"));
        System.out.println("aaaaaaaaaa".getBytes().length);
        System.out.println("가나다 ".getBytes().length);
        System.out.println(isKorean('가'));
        System.out.println(isKorean('a'));
        System.out.println(isKorean(' '));



    }

    private static boolean isKorean(char c) {
        return (c >= 0xAC00 && c <= 0xD7A3);  // 한글 범위 (가~힣)
    }

    public static String changeTitleBytes(String str){
        //str = "거제 포로수용소 유적공원 평화파크";
        int num = 0;
        for(int i=0;i<str.length();i++)
            num = isKorean(str.charAt(i)) ? num+2: num+1 ;
       // System.out.println(num);

        for(int i = num; i<10;i++) {
            str = str + ' ';

        }
        //System.out.println(s.getBytes().length);
//        num = 0;
//        for(int i=0;i<str.length();i++)
//            num = isKorean(str.charAt(i)) ? num+2: num+1 ;
       // System.out.println(num);
        return str;
    }
}
