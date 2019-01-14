package homework08;

public class MainForElevator {

	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		Thread a = new CallElevatorThreadA(elevator);
		Thread b = new CallElevatorThreadB(elevator);
		
		a.start();
		b.start();
	}
}
