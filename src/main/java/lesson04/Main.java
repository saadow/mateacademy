package lesson04;

public class Main {

	public static void main(String[] args) {
		TemplateExample te = new TemplateExample() {
			
			@Override
			public void doOperation() {
				System.out.println("Read book");
			}
		};
		te.templateMethod();
		te = new TemplateExample() {
			
			@Override
			public void doOperation() {
				System.out.println("Write to copybook");
			}
		};
		te.templateMethod();
		String[] ags = null;
		Main.main(ags, 7);
	}
	public static void main(String[] args, int i) {
		System.out.println(">>>");
	}

}
