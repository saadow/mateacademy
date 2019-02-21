package WaterPoloPlayerAdapter;

public class HandBallPlayer implements HandBallPlayerInterface {

	@Override
	public boolean canRun() {
		return true;
	}

	@Override
	public boolean hasSwimmingCap() {
		return false;
	}

}
