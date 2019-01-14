package homework08;

public class TakeBookThread extends Thread {
	protected BookCrossingLibrary bcl;

	public TakeBookThread(BookCrossingLibrary bcl) {
		this.bcl = bcl;
	}

	public void run() {
		for (int i = 0; i <= 9; i++) {
			try {
				bcl.takeBook();
				bcl.printBooks();
				System.out.println("______________________");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
