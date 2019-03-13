package homework_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Musorovoz {
	@Autowired
	private DeadMoto deadMoto;

	private String id;

	public Musorovoz() {
		id = "ID " + (int) (Math.random() * 1000);
	}

	@Override
	public String toString() {
		return "Musorovoz - " + id + " with " +  deadMoto.toString();
	}

}
