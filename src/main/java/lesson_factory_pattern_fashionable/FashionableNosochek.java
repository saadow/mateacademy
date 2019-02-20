package lesson_factory_pattern_fashionable;

import lesson_factory_pattern.NosochekInterface;

public class FashionableNosochek implements NosochekInterface {
	static final boolean vechniy = true;
	int size;
	String color;
	
	boolean getVechniy() {
		return vechniy;
	}

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

}
