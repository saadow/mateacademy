package homework08;

import java.util.concurrent.BlockingQueue;

public class BringBook implements Runnable{

    protected BlockingQueue<Book> queue = null;

    public BringBook(BlockingQueue<Book> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put(new Book("To Kill a Mockinbird", "Harper Lee"));
            Thread.sleep(1000);
            queue.put(new Book("Pride and Prejudice", "Jane Austen"));
            Thread.sleep(1000);
            queue.put(new Book("The Hobbit", "J.R.R. Tolkien"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}