package lesson09_02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		Lock locker = new ReentrantLock();
		CommonResource res = new CommonResource(0);
		new Thread(new CountThread(res, locker, "first")).start();
		new Thread(new CountThread(res, locker, "second")).start();
		new Thread(new CountThread(res, locker, "third")).start();
	}

}
