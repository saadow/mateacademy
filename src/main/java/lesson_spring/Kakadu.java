package lesson_spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.mchange.net.SocketUtils;

@Component
@Lazy
public class Kakadu {
	@Override
	public String toString() {
		return "Kakadu [name=" + name + ", weight=" + weight + "]";
	}

	private String name;
	private int weight;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public Kakadu(@Value("DefaultName")String name, @Value("1")int weight) {
		this.name = name;
		this.weight = weight;
		System.out.println("In constructor " + this);
	}
	
	@PostConstruct
	private void init() {
		name = this.getClass().getSimpleName();
		System.out.println("in init of " + this);
	}
	
	@PreDestroy
	private void preDestroy() {
		System.out.println("in preDestroy of " + this);
	}
}
