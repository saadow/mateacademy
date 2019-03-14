package homework_spring;

import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component("truck")
@DependsOn("bike")
public class Truck {
	private Bike bike = new Bike() {
		@Override
		public String getModel() {
			return "Bike on truck";
		}
	};

	private String model;
	private int numberOfBikes;
	private String name;

	public Truck() {
	}

	@Autowired
	public Truck(Bike bike) {
		this.bike = bike;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public String toString() {
		return "Truck - model " + getModel() + (Objects.nonNull(bike) ? " and Bike: " + bike.toString() : "");
	}

	public Truck(@Value("Default truck name") String name, @Value("1") int numberOfBikes) {
		this.name = name;
		this.numberOfBikes = numberOfBikes;
		System.out.println("in constructor of " + this);
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
