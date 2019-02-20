package lesson_factory_pattern_simple;

public class PlyazhniyNosok extends Nosochek{
	boolean sunScreen;
	
	void setSunScreen(boolean sunScreen) {
		this.sunScreen = sunScreen;
	}
	
	boolean getSunScreen() {
		return sunScreen;
	}

	@Override
	public String toString() {
		return "PlyazhniyNosok [sunScreen=" + sunScreen + ", size=" + size + ", color=" + color + ", getSunScreen()="
				+ getSunScreen() + ", getSize()=" + getSize() + ", getColor()=" + getColor() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
