package lesson09_03;

public class CountThread implements Runnable {

	private CommonResource res;
	private String name;

	public CountThread(CommonResource res, String name) {
		this.res = res;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println(name + " waiting");
			for (int i = 0; i < 5; i++) {
				res.incrementValue();
				System.out.println(this.name + ": " + res.getValue());
				Thread.sleep(120);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(name + " end work");
	}

}
