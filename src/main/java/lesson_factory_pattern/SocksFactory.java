package lesson_factory_pattern;

import lesson_factory_pattern_fashionable.FashionableNosochekFactory;
import lesson_factory_pattern_simple.NosochekFactory;

public class SocksFactory {
	public static AbstractNosochekFactory createFactory(String type) {
		AbstractNosochekFactory anf = null;
		if(type.equals("NosochekFactory")) {
			anf = new NosochekFactory();
		} else if (type.equals("FashionableNosochekFactory")) {
			anf = new FashionableNosochekFactory();
		}
		return anf;
	}
}
