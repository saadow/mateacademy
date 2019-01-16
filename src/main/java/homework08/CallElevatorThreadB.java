package homework08;

public class CallElevatorThreadB extends Thread{

	protected Elevator elevator = null;
	
	public CallElevatorThreadB(Elevator elevator) {
		this.elevator = elevator;
	}
	public void run() {
		elevator.call(2, 7);
		elevator.moveTime(elevator, 3, 8);
	}
}
