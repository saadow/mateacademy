package lesson09;

public class LazyInitializationSingleton {
	private static LazyInitializationSingleton instance;

	private LazyInitializationSingleton() {
		// TODO Auto-generated constructor stub
	}

	public static LazyInitializationSingleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializationSingleton();
		}
		return instance;
	}
}