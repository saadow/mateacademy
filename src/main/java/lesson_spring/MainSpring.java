package lesson_spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainSpring {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("lesson_spring");
		Pig pig = context.getBean(Pig.class);
		System.out.println(pig);
		Tiger tiger = context.getBean("tiger1101", Tiger.class);
		System.out.println(tiger);
		Tiger tiger1 = context.getBean("tiger", Tiger.class);
		System.out.println(tiger1);
		Kakadu akadu = context.getBean(Kakadu.class);
		System.out.println(akadu);
		
		Bloha bloha = context.getBean(Bloha.class);
		System.out.println(bloha);
		Bloha bloha2 = context.getBean(Bloha.class);
		System.out.println(bloha2);
		Cat cat = context.getBean(Cat.class);
		System.out.println(cat);
		Cat cat2 = context.getBean(Cat.class);
		System.out.println(cat2);
		
		context.close();
	}
}
