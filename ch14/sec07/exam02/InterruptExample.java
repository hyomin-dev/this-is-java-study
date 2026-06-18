package ch14.sec07.exam02;

public class InterruptExample {
	public static void main(String[] args) {
		Thread thread = new PrintThread();
		thread.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}

		thread.interrupt();
		System.out.println("main thread 종료");
	}
}