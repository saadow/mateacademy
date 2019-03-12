package SpringIntro;

public abstract class AbstractAnimal implements Animal {

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public abstract String getVoice();

	@Override
	public String toString() {
		return "AbstractAnimal [getName()=" + getName() + ", getVoice()=" + getVoice() + "]";
	}

}
