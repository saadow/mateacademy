package lesson_adapter_pattern;

public class UkrDuck implements Duck {

	@Override
	public void sing() {
		System.out.println("duck sing");
	}

	@Override
	public void fly() {
		System.out.println("duck fly");
	}

}
