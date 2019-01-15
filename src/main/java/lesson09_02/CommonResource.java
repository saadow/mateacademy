package lesson09_02;

public class CommonResource {
	private int value = 0;
	
	public CommonResource(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void incrementValue() {
		value++;
	}
}
