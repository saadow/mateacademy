package PhoneDecorator;

public class XiaomiPhone extends Phone {

	public XiaomiPhone() {
		kit = "Included: Xiao8";
	}
	
	@Override
	public int cost() {
		return 800;
	}

}
