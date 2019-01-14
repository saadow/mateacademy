package homework08;

public class CallElevatorThreadA extends Thread{

	protected Elevator elevator = null;
	
	public CallElevatorThreadA(Elevator elevator) {
		this.elevator = elevator;
	}
	public void run() {
		elevator.call(2, 5);
		elevator.moveTime(11,  1);
	}
}
