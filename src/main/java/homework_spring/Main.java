package homework_spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("homework_spring");
		Bike bike = context.getBean(Bike.class);
		System.out.println(bike);
		Truck truck = context.getBean(Truck.class);
		System.out.println(truck);
		
		DeadMoto dm = context.getBean(DeadMoto.class);
		System.out.println(dm);
		DeadMoto dm2 = context.getBean(DeadMoto.class);
		System.out.println(dm2);
		Musorovoz musorovoz = context.getBean(Musorovoz.class);
		System.out.println(musorovoz);
		Musorovoz musorovoz2 = context.getBean(Musorovoz.class);
		System.out.println(musorovoz2);
		
		context.close();
	}
}
