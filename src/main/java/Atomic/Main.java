package Atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		AtomicInteger ai = new AtomicInteger(0);
		es.execute(new CountThread(ai, "first"));
		es.execute(new CountThread(ai, "second"));
		es.execute(new CountThread(ai, "third"));
		es.shutdown();
	}
}
