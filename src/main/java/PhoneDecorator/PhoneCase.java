package PhoneDecorator;

public class PhoneCase extends PhoneFunctionsDecorator {
	
	Phone phone;
	
	public PhoneCase(Phone phone) {
		this.phone = phone;	
	}

	@Override
	public String getKit() {
		return phone.getKit() + ", Case";
	}

	@Override
	public int cost() {
		return phone.cost() + 100;
	}

}
