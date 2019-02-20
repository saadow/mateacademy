package lesson_factory_pattern_simple;

public class AnimalNosok extends Nosochek{
	int countInPack;
	
	void setCountInPack(int countInPack) {
		this.countInPack = countInPack;
	}
	
	int getCountInPack() {
		return countInPack;
	}

	@Override
	public String toString() {
		return "AnimalNosok [countInPack=" + countInPack + ", size=" + size + ", color=" + color + ", getCountInPack()="
				+ getCountInPack() + ", getSize()=" + getSize() + ", getColor()=" + getColor() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
