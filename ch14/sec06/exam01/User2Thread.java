package ch14.sec06.exam01;

public class User2Thread extends Thread {
	private Calculator calculator;
	
	public User2Thread() {
		setName("User2Thread");
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
//		System.out.println("User2Thread 시작");
		calculator.setMemory2(50);
//		calculator.setMemory(50);
//		calculator.setMemorySyn(50);
//		calculator.setMemoryGeneral(50);
	}
}