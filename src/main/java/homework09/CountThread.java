package homework09;

import java.util.concurrent.Callable;

public class CountThread implements Callable<String> {
	private int sleepTime;
	
	public CountThread(int sleepTime) {
		this.sleepTime = sleepTime;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(sleepTime);
		return Thread.currentThread().toString();
	}
}
