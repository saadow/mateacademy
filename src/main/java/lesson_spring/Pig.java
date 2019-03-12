package lesson_spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
 
@Component
@PropertySource({"classpath:lesson_spring/pig.properties"})
public class Pig {
	@Value("${voice}")
	private String voice;
	
	public String getVoice() {
		return voice;
	}
	 
	public String toString() {
		return "Pig says " + getVoice();
	}
}
