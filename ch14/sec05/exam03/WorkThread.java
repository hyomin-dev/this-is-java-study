package ch14.sec05.exam03;

public class WorkThread extends Thread {
	//필드
	public boolean work = true;
	private int count;
	
	//생성자
	public WorkThread(String name) {
		count = 0;
		setName(name);
	}
	
	//메소드
	@Override
	public void run() {
		while(work) {
			if(work) {
				System.out.println(getName() + ": 작업처리 "+ ++this.count+"번째");
			} else {
				Thread.yield();
			}
		}
	}
}