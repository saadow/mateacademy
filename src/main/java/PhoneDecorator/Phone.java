package PhoneDecorator;

public abstract class Phone {
	String kit = "phone";

	public String getKit() {
		return kit;
	}

	public abstract int cost();
}
