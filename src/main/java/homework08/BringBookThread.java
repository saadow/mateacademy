package homework08;

public class BringBookThread extends Thread {
	protected BookCrossingLibrary bcl;

	public BringBookThread(BookCrossingLibrary bcl) {
		this.bcl = bcl;
	}

	public void run() {
		try {
			bcl.bringBook(new Book("book", "author"));
			bcl.printBooks();
			System.out.println("______________________");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
