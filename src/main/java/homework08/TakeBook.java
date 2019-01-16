package homework08;

import java.util.concurrent.BlockingQueue;

public class TakeBook implements Runnable{

    protected BlockingQueue<Book> queue = null;

    public TakeBook(BlockingQueue<Book> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
