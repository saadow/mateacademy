package Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class CountThread implements Runnable {

	private AtomicInteger res;
	private String name;

	public CountThread(AtomicInteger res, String name) {
		this.res = res;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println(name + " waiting");
			for (int i = 0; i < 5; i++) {
				System.out.println(this.name + ": " + res.incrementAndGet());
				Thread.sleep(120);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(name + " end work");
	}

}
