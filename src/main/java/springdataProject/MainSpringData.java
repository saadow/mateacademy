package springdataProject;

import java.math.BigDecimal;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import springdata.project01.repository.OrdersRepository;

public class MainSpringData {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("springdata.project01.config");
		OrdersRepository or = context.getBean(OrdersRepository.class);
		or.findAll().forEach(System.out::println);
		or.findByOrderNumIs(BigDecimal.valueOf(113065)).forEach(System.out::println);
		or.findByProduct_ProductIdIs("XK47").forEach(System.out::println);
		System.out.println("RAZDELENIE");
		or.findByProduct_ProductIdIs("XK47").forEach(System.out::println);
	}

}
