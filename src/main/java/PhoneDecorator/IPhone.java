package PhoneDecorator;

public class IPhone extends Phone {
	
	public IPhone() {
		kit = "Included: Apple";
	}
	
	@Override
	public int cost() {
		return 1200;
	}

}
