package lesson_factory_pattern_simple;

import lesson_factory_pattern.NosochekInterface;

public class Nosochek implements NosochekInterface {
	protected int size;
	protected String color;

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Nosochek [size=" + size + ", color=" + color + "]";
	}

}
