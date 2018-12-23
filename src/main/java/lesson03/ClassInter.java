package lesson03;

public class ClassInter {

	public static class StaticTest implements TestInterface{

		@Override
		public void print() {
			System.out.println("StaticTest print");
			
		}

		@Override
		public void printWord() {
			System.out.println("StaticTest printWord");
			
		}
		
	}
	
	public class NonStaticTest implements TestInterface{

		@Override
		public void print() {
			System.out.println("NonStaticTest print");
			
		}

		@Override
		public void printWord() {
			System.out.println("NonStaticTest printWord");
			
		}
	}
}
