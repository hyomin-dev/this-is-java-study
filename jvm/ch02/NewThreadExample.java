package jvm.ch02;


public class NewThreadExample {
    public static void main(String[] args) {
        while(true){
            new Thread(()->{
                while(true){

                }
            }).start();
        }
    }
}
