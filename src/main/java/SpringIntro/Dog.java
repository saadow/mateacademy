package SpringIntro;

import org.springframework.stereotype.Component;

@Component("dog")
public class Dog extends AbstractAnimal {

	@Override
	public String getVoice() {
		return "Gav-gav";
	}

}
