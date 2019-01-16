package homework09;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExtraMainFutureTask {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		Callable<String> callable1 = new CountThread(300);
		Callable<String> callable2 = new CountThread(1000);

		FutureTask<String> ft1 = new FutureTask<String>(callable1);
		FutureTask<String> ft2 = new FutureTask<String>(callable2);

		es.execute(ft1);
		es.execute(ft2);

		while (true) {
			try {
				if (ft1.isDone() && ft2.isDone()) {
					System.out.println("Both Done");
					es.shutdown();
					return;
				}

				if (!ft1.isDone()) {
					System.out.println("FutureTask 1 : " + ft1.get());
				}

				System.out.println("Waiting for FutureTask 2");
				String s = ft2.get(1000, TimeUnit.MILLISECONDS);
				if (s != null) {
					System.out.println("FutureTask 2 : " + s);
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				System.out.println("Timeout");
			}
		}
	}
}
