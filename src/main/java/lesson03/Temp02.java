package lesson03;

public class Temp02 extends Temp01{
	
	public Temp02(String vendor, String model, String color) { 
		super(vendor, model, color);
	}
	
	@Override
	void some() {
		System.out.println("some Temp02");
	}
	public static void main(String[] args) {
		Temp01 tt = new Temp02("","","");
		System.out.println(tt instanceof Temp01);
		System.out.println(tt.getClass().getName());
	}
}
