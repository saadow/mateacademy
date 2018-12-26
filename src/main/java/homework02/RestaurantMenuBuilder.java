package homework02;

public class RestaurantMenuBuilder {

	private String firstCourse;
	private String mainCourse;
	private String dessert;
	private String beverage;
	private double price;

	private RestaurantMenuBuilder(Builder builder) {
		this.firstCourse = builder.firstCourse;
		this.mainCourse = builder.mainCourse;
		this.dessert = builder.dessert;
		this.beverage = builder.beverage;
		this.price = builder.price;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String firstCourse;
		private String mainCourse;
		private String dessert;
		private String beverage;
		private double price;

		private Builder() {
		}

		public Builder withFirstCourse(String firstCourse) {
			this.firstCourse = firstCourse;
			return this;
		}

		public Builder withMainCourse(String mainCourse) {
			this.mainCourse = mainCourse;
			return this;
		}

		public Builder withDessert(String dessert) {
			this.dessert = dessert;
			return this;
		}

		public Builder withBeverage(String beverage) {
			this.beverage = beverage;
			return this;
		}

		public Builder withPrice(double price) {
			this.price = price;
			return this;
		}

		public RestaurantMenuBuilder build() {
			return new RestaurantMenuBuilder(this);
		}
	}

	@Override
	public String toString() {
		return "Menu: " + firstCourse + ", " + mainCourse + ", " + dessert + ", " + beverage + "\nTotal price: "
				+ price;
	}

}
