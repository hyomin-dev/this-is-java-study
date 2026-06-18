package ch14.godofjava.prac2;


public class RunSupportThreads {
    public static void main(String[] args) {
        RunSupportThreads sample = new RunSupportThreads();
        //sample.checkThreadState1();
        sample.checkJoin();

    }

    public void checkThreadState1(){
        SleepThread thread = new SleepThread(2000);

        try{
            System.out.println(thread.getState());
            thread.start();
            System.out.println(thread.getState());

            Thread.sleep(1000);
            System.out.println(thread.getState());

            thread.join();
            thread.interrupt();
            System.out.println(thread.getState());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkJoin(){
        SleepThread thread = new SleepThread(2000);
        try{
            thread.start();
            thread.join(500);
            thread.interrupt();
            System.out.println(thread.getState());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
