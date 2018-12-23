package homework02;

public class MainForRestMenu {

	public static void main(String[] args) {
		RestaurantMenuBuilder rmb = RestaurantMenuBuilder.builder().withFirst_course("salad").withMain_course("chiken")
				.withDessert("cake").withBeverage("coffee").withPrice(200).build();
		System.out.println(rmb);

	}

}
