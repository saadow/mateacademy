package lesson_factory_pattern_fashionable;

import lesson_factory_pattern.AbstractNosochekFactory;
import lesson_factory_pattern.NosochekInterface;

public class FashionableNosochekFactory extends AbstractNosochekFactory{

	@Override
	public NosochekInterface createSocks(String simpleName) {
		FashionableNosochek nosochek = null;
		if ("BerlinSocks".equals(simpleName)) {
			nosochek = new BerlinSocks();
		} else if ("ParisSocks".equals(simpleName)) {
			nosochek = new ParisSocks();
		} else if ("MilanSocks".equals(simpleName)) {
			nosochek = new MilanSocks();
		} else {
			nosochek = new FashionableNosochek();
		}
		return nosochek;
	}
}
