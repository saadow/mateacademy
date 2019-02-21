package WaterPoloPlayerAdapter;

public class WaterPoloPlayerAdapter implements HandBallPlayerInterface{
	WaterPoloPlayer wpp = new WaterPoloPlayer();
	
	WaterPoloPlayerAdapter (WaterPoloPlayer wpp){
		this.wpp = wpp;
	}

	@Override
	public boolean canRun() {
		return wpp.canSwim();
	}

	@Override
	public boolean hasSwimmingCap() {
		return wpp.hasSwimmingCap();
	}
	
	
}
