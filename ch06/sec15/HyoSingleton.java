package ch06.sec15;


public class HyoSingleton {

    private static HyoSingleton hyoSingleton = new HyoSingleton();

    public HyoSingleton(){

    }

    public static HyoSingleton getInstance(){
        return hyoSingleton;
    }
}
