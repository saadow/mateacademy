package lesson09;

public class MultithreadSingleton {
	private static MultithreadSingleton instance;

	private MultithreadSingleton() {

	}

	public static MultithreadSingleton getInstance() {
		if (instance == null) {
			synchronized (MultithreadSingleton.class) {
				if (instance == null) {
					instance = new MultithreadSingleton();
				}
			}
		}
		return instance;
	}
}
