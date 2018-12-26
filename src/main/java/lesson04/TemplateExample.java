package lesson04;

public abstract class TemplateExample {
	public void open() {
		System.out.println("Open");
	}
	public void close() {
		System.out.println("Close");
	}
	
	public abstract void doOperation();
	
	public void templateMethod() {
		open();
		doOperation();
		close();
	}
}

