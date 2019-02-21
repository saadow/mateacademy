package PhoneDecorator;

public class Headphones extends PhoneFunctionsDecorator {
	
	Phone phone;
	
	public Headphones(Phone phone) {
		this.phone = phone;
	}

	@Override
	public String getKit() {
		return phone.getKit() + ", Headphones";
	}

	@Override
	public int cost() {
		return phone.cost() + 200;
	}

}
