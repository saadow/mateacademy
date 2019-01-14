package homework08;

public class Elevator {
	private volatile int floor = 9;

	// Synchronized method
	public synchronized void call(int callFloor, int goFloor) {
		if (callFloor > this.floor) {
			for (int i = this.floor; i <= callFloor; i++) {
				System.out.println("Elevator is on: " + i + " floor");
			}
		} else if (callFloor < this.floor) {
			for (int i = this.floor; i >= callFloor; i--) {
				System.out.println("Elevator is on: " + i + " floor");
			}
		} else {
			System.out.println("Elevator is already here.");
		}
		System.out.println("Stop, enter");
		this.floor = callFloor;
		if (goFloor > this.floor) {
			for (int i = this.floor; i <= goFloor; i++) {
				System.out.println("Elevator is on: " + i + " floor");
			}
		} else {
			for (int i = this.floor; i >= goFloor; i--) {
				System.out.println("Elevator is on: " + i + " floor");
			}
		}
		System.out.println("Stop, out");
		this.floor = goFloor;
	}

	// Synchronized block
	public int moveTime(Elevator el, int callFloor, int goFloor) {
		int floors = 0;
		synchronized (el) {
			floors = Math.abs(this.floor - callFloor) + Math.abs(callFloor - goFloor);
		}
		System.out.println("Move time: " + floors * 3);
		return floors * 3;
	}
}
