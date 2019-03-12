package lesson_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cat {
	@Autowired
	private Bloha bloha;

	private String catId;

	public Cat() {
		catId = "cat id " + (int) (Math.random() * 1000);
	}

	@Override
	public String toString() {
		return "Cat [bloha=" + bloha + ", catId=" + catId + "]";
	}

}
