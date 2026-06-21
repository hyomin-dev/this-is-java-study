package jvm.ch02;

/*
* jsp -l # 프로세스 ID 확인
* jcmd $PID Thread.print > ./jvm/ch02/threadump.txt
* */


public class ThreadDumpExample {

    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (lock1) {
                sleep();
                synchronized (lock2) {}
            }
        }).start();

        new Thread(() -> {
            synchronized (lock2) {
                sleep();
                synchronized (lock1) {}
            }
        }).start();
    }

    static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {}
    }
}