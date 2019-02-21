package NotebookFactory;

public abstract class Notebook {

	String complete() {
		return "Completed " + this.getClass().getSimpleName();
	}

	String collect() {
		return "Collected " + this.getClass().getSimpleName();
	}

	abstract int estimatePrice();
}
