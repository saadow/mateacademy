package lesson_factory_pattern_simple;

import lesson_factory_pattern.AbstractNosochekFactory;
import lesson_factory_pattern.NosochekInterface;

public class NosochekFactory extends AbstractNosochekFactory {

	@Override
	public NosochekInterface createSocks(String simpleName) {
		Nosochek nosochek = null;
		if ("OdnorazoviyNosok".equals(simpleName)) {
			nosochek = new OdnorazoviyNosok();
		} else if ("SportNosok".equals(simpleName)) {
			nosochek = new SportNosok();
		} else if ("PlyazhniyNosok".equals(simpleName)) {
			nosochek = new PlyazhniyNosok();
		} else if ("AnimalNosok".equals(simpleName)) {
			nosochek = new AnimalNosok();
		} else {
			nosochek = new Nosochek();
		}
		return nosochek;
	}
}
