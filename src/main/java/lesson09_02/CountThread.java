package lesson09_02;

import java.util.concurrent.locks.Lock;

public class CountThread implements Runnable{
	private CommonResource res;
	
	private Lock locker;
	private String name;
	
	public CountThread(CommonResource res, Lock locker, String name) {
		this.res = res;
		this.locker = locker;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println(name + " waiting");
			locker.lock();
			for (int i = 0; i < 5; i++) {
				res.incrementValue();
				System.out.println(this.name +": " + res.getValue());
				Thread.sleep(120);
			}
		} catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
		System.out.println(name + " end work");
		locker.unlock();
	}
	
}
