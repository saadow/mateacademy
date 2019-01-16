package homework08;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainForBooks {

	public static void main(String[] args) throws InterruptedException {

		BlockingQueue queue = new ArrayBlockingQueue(5);
		
		BringBook bb = new BringBook(queue);
        TakeBook tb = new TakeBook(queue);

        new Thread(bb).start();
        new Thread(tb).start();

        Thread.sleep(4000);
		
	}

}
