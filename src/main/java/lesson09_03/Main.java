package lesson09_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(1);
		CommonResource res = new CommonResource(0);
		es.execute(new CountThread(res, "first"));
		es.execute(new CountThread(res, "second"));
		es.execute(new CountThread(res, "third"));
		es.shutdown();
	}
}
