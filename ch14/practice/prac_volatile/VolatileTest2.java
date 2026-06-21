package ch14.practice.prac_volatile;


public class VolatileTest2 {

    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
                //System.out.println(i);
            }
        });
        backgroundThread.start();

        Thread.sleep(5000);
        stopRequested = true;
    }
}