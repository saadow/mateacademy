package lesson_factory_pattern_simple;

public class SportNosok extends Nosochek{
	boolean waterProof;
	
	void setWaterProof(boolean waterProof) {
		this.waterProof = waterProof;
	}
	
	boolean getWaterProof() {
		return waterProof;
	}

	@Override
	public String toString() {
		return "SportNosok [waterProof=" + waterProof + ", size=" + size + ", color=" + color + ", getWaterProof()="
				+ getWaterProof() + ", getSize()=" + getSize() + ", getColor()=" + getColor() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
