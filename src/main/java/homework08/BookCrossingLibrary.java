package homework08;

import java.util.LinkedList;
import java.util.List;

public class BookCrossingLibrary {
	private List<Book> books = new LinkedList<Book>();
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
		this.books.remove(0);
	}

	public List<Book> getLibrary() {
		return books;
	}
	
	public void printBooks() {
		for (Book book : this.getLibrary()) {
			System.out.println(book);
		}
	}
}
