package lesson_adapter_pattern;

public class TurkeyAdapter implements Duck {
	Turkey turkey;

	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	@Override
	public void sing() {
		turkey.sing();
	}

	@Override
	public void fly() {
		turkey.run();
	}

}
