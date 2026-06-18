package ch11.sec06;

public class InsufficientException extends Exception {
	public InsufficientException() {
		System.out.println("InsufficientException 예외 발생");
	}

	public InsufficientException(String message) {
		super(message);
	}
}