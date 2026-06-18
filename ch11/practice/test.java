package ch11.practice;

import java.io.IOException;

public class test {
    public static void main(String[] args) {
        int a, b, c;
        try {
            a = 10;
            b = 0;
            c = a / b; // 10 나누기 0 → 산술오류 ArithmeticException
        } catch (ArithmeticException e) {
            c = -1;  // 예외가 발생하여 이 문장이 수행된다.
            throw new RuntimeException("0으로 나눴네 프로그램 종료");
        }
        System.out.println("프로그램이 끝까지 실행 됨");
    }
}

