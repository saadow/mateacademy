package homework09;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainFuture {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		List<Future<String>> list = new ArrayList<Future<String>>();
		Callable<String> callable = new CountThread(300);
		for (int i = 0; i < 15; i++) {
			Future<String> future = es.submit(callable);
			list.add(future);
		}
		for (Future<String> fut : list) {
			try {
				System.out.println(fut.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		es.shutdown();
	}
}