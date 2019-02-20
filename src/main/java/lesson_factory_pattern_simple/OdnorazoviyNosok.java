package lesson_factory_pattern_simple;

public class OdnorazoviyNosok extends Nosochek {
	static final int timesToUse = 1;
	
	int getTimesToUse() {
		return timesToUse;
	}

	@Override
	public String toString() {
		return "OdnorazoviyNosok [size=" + size + ", color=" + color + ", getTimesToUse()=" + getTimesToUse()
				+ ", getSize()=" + getSize() + ", getColor()=" + getColor() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
