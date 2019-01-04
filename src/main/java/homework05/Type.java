package homework05;

public enum Type {
	APPLE("Italy"), STRAWBERRY("Poland"), PEAR("Ukraine"), ORANGE("Spain"), PINEAPPLE("Turkey"), BANANA("Ecuador");

	private String country;

	Type(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
