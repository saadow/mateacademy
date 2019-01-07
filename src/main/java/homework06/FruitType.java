package homework06;

public enum FruitType {
	STRAWBERRY("Strawberry"), APPLE("Apple"), PEAR("Pear"), ORANGE("Orange");

	FruitType(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public String toString() {
		return name;
	}
}
