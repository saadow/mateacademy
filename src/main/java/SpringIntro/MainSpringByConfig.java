package SpringIntro;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import SpringIntro.AppConfig;
import SpringIntro.Animal;
import SpringIntro.Cat;
import SpringIntro.Dog;
import SpringIntro.Mouse;

public class MainSpringByConfig {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Cat cat = context.getBean(Cat.class);
		Dog dog = (Dog) context.getBean("dog");
		Mouse mouse = context.getBean("mouse", Mouse.class);

		Animal animal = context.getBean(Animal.class);

		Animal animal2 = context.getBean("pig", Animal.class);

		System.out.println(cat);
		System.out.println(dog);
		System.out.println(mouse);
		System.out.println(animal);
		System.out.println(animal2);

		context.close();
	}
}
