package ch14.sec06.exam01;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory1(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}

	public void setMemory2(int memory) {
		System.out.println("test111");
		//this.memory = memory;
		synchronized(this) {
			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {}
			System.out.println(Thread.currentThread().getName() + ": " + this.memory);
		}
		System.out.println("test222");
	}
	
	/*//symchronized하지 않았을 경우
	
	public void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName()+":"										+this.memory);
		}
		catch (InterruptedException e){
			
		}
	}
	
	//synchronized method 만든 경우
	public synchronized void setMemorySyn(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName()+":"										+this.memory);
		}
		catch (InterruptedException e){
			
		}
	}
	
	//synchronized method 만든 후 따로 일반 method로 memory field에 접근 하는 경우
	public void setMemoryGeneral(int memory) {
		this.memory = memory;
		System.out.println(Thread.currentThread().getName()+":"										+this.memory);
	}*/
}