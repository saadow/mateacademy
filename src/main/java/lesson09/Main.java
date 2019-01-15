package lesson09;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SingletonExample.getInstance().getClass().getSimpleName());
		Semaphore sem = new Semaphore(1);
		CommonResource res = new CommonResource(0);
		new Thread(new CountThread(res, sem, "first")).start();;
		new Thread(new CountThread(res, sem, "second")).start();;
		new Thread(new CountThread(res, sem, "third")).start();;
	}

}
