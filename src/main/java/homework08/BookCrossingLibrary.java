package homework08;

import java.util.concurrent.BlockingQueue;

public class BookCrossingLibrary implements Runnable{
	private BlockingQueue<Book> books;
	private int bookLimit = 10;

	public BookCrossingLibrary(int bookLimit) {
		this.bookLimit = bookLimit;
	}

	public synchronized void bringBook(Book item) throws InterruptedException {
		while (this.books.size() == this.bookLimit) {
			wait();
		}
		if (this.books.size() == 0) {
			notifyAll();
		}
		this.books.add(item);
	}

	public synchronized void takeBook() throws InterruptedException {
		while (this.books.size() == 0) {
			wait();
		}
		if (this.books.size() == this.bookLimit) {
			notifyAll();
		}
		this.books.remove();
	}

	public BlockingQueue<Book> getLibrary() {
		return books;
	}
	
	public void printBooks() {
		this.getLibrary().forEach(System.out::println);	
	}

	@Override
	public void run() {
		for (int i=0; i < 10; i++) {
			try {
				books.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
