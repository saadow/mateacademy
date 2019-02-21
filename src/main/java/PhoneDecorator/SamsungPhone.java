package PhoneDecorator;

public class SamsungPhone extends Phone{
	
	public SamsungPhone() {
		kit = "Included: Gnusmas";
	}

	@Override
	public int cost() {
		return 1000;
	}

}
