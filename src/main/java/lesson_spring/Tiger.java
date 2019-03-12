package lesson_spring;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component("tiger")
@DependsOn("pig")
public class Tiger {
	private Pig pig = new Pig() {
		@Override
		public String getVoice() {
			return "Pig never dies";
		}
	};
	private String voice;

	public Tiger() {

	}

	@Autowired
	public Tiger(Pig pig) {
		this.pig = pig;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getVoice() {
		return voice;
	}

	public String toString() {
		return "Tiger says " + getVoice()
				+ (Objects.nonNull(pig) ? " and Pig says: " + pig.getVoice() : "");
	}
}
