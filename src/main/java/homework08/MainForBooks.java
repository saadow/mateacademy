package homework08;

import java.util.Arrays;
import java.util.List;

public class MainForBooks {

	public static void main(String[] args) throws InterruptedException {
		Book book1 = new Book("To Kill a Mockinbird", "Harper Lee");
		Book book2 = new Book("Pride and Prejudice", "Jane Austen");
		Book book3 = new Book("The Diary of Anne Frank", "Anne Frank");
		Book book4 = new Book("1984", "George Orwell");
		Book book5 = new Book("Harry Potter and the Sorcerer's Stone","J.K. Rowling ");
		Book book6 = new Book("The Lord of the Rings", "J.R.R. Tolkien" );
		Book book7 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
		Book book8 = new Book("Charlotte's Web", "E.B. White");
		Book book9 = new Book("The Hobbit", "J.R.R. Tolkien");
		Book book10 = new Book("Little Women", "Louisa May Alcott");
		Book book11 = new Book("Farenheit 451", "Ray Bradbury");

		List<Book> books = Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10);
		BookCrossingLibrary lib = new BookCrossingLibrary(10);
		for (Book book : books) {
			lib.bringBook(book);
		}
		TakeBookThread tbt = new TakeBookThread(lib);
		BringBookThread bbt = new BringBookThread(lib);
		tbt.run();
		bbt.run();
		
	}

}
