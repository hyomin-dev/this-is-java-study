package ch14.practice.prac_volatile;


public class SingletonTest {
    private static SingletonTest instance; // volatile

    private String name;
    private int value;

    private SingletonTest() {
        // 생성자가 무거운 상황 시뮬레이션
        this.name = "initialized";
        this.value = 42;
    }

    public static SingletonTest getInstance() {
        if (instance == null) {
            synchronized (SingletonTest.class) {
                if (instance == null) {
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }

    public String getName() { return name; }
    public int getValue() { return value; }

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 100000;
        SingletonTest[] results = new SingletonTest[threadCount];

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            final int idx = i;
            threads[idx] = new Thread(() -> {
                results[idx] = SingletonTest.getInstance();
            });
        }

        // 모든 스레드 동시에 출발
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        // 검증 - 모두 같은 인스턴스인지 + 초기화가 제대로 됐는지
        SingletonTest first = results[0];
        boolean allSame = true;
        boolean allInitialized = true;

        for (SingletonTest result : results) {
            if (result != first) allSame = false;
            if (result.getName() == null || result.getValue() != 42) allInitialized = false;
        }

        System.out.println("모두 같은 인스턴스? : " + allSame);
        System.out.println("모두 초기화 완료?   : " + allInitialized);
        System.out.println("name  : " + first.getName());
        System.out.println("value : " + first.getValue());
    }
}
