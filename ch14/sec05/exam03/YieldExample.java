package ch14.sec05.exam03;

public class YieldExample {
	public static void main(String[] args) {
		WorkThread workThreadA = new WorkThread("workThreadA");
		WorkThread workThreadB = new WorkThread("workThreadB");
		workThreadA.start();
		workThreadB.start();
		
		try { Thread.sleep(10); } catch (InterruptedException e) {}
		workThreadA.work = false;

		try { Thread.sleep(3); } catch (InterruptedException e) {}
		workThreadB.work = false;

		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){

		}
		//workThreadA.work = false;
	}
}