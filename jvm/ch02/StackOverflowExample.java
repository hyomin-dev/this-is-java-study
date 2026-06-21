package jvm.ch02;


public class StackOverflowExample {

    public static void recursive() {
        recursive();
    }

    public static void main(String[] args) {
        recursive();
    }
}
