package homework02;

public class RestaurantMenuBuilder {
	
	private String first_course;
	private String main_course;
	private String dessert;
	private String beverage;
	private double price;
	
	private RestaurantMenuBuilder(Builder builder) {
		this.first_course = builder.first_course;
		this.main_course = builder.main_course;
		this.dessert = builder.dessert;
		this.beverage = builder.beverage;
		this.price = builder.price;
	}
	/**
	 * Creates builder to build {@link RestaurantMenuBuilder}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}
	/**
	 * Builder to build {@link RestaurantMenuBuilder}.
	 */
	public static final class Builder {
		private String first_course;
		private String main_course;
		private String dessert;
		private String beverage;
		private double price;

		private Builder() {
		}

		public Builder withFirst_course(String first_course) {
			this.first_course = first_course;
			return this;
		}

		public Builder withMain_course(String main_course) {
			this.main_course = main_course;
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
	public String toString(){
		return "Menu: " + first_course + ", " + main_course + ", " + dessert 
				+ ", " + beverage + "\nTotal price: " + price;
	}
	
}
