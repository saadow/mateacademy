package homework05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
	private String name;
	private List<Fruit> fruits;

	public Shop(String name, List<Fruit> fruits) {
		this.name = name;
		this.fruits = fruits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Fruit> getFruits() {
		return fruits;
	}

	public void setFruits(List<Fruit> fruits) {
		this.fruits = fruits;
	}

	public List<Fruit> allFresh(LocalDate checkDate) {
		return (fruits.stream().filter(f -> f.isExpired(checkDate)).collect(Collectors.toList()));
	}

	public List<Fruit> allFruitOfType(Type type) {
		return fruits.stream().filter(f -> f.getType().equals(type)).collect(Collectors.toList());
	}

	public List<Fruit> checkExpireDate(int checkDays) {
		return fruits.stream().filter(f -> f.getExpireDays() > checkDays).collect(Collectors.toList());
	}

	public List<Fruit> allFreshAndType(Type type, LocalDate expDate) {
		return allFruitOfType(type).stream().filter(f -> f.isExpired(expDate)).collect(Collectors.toList());
	}

	public List<Fruit> reSetPricexRealization(int percent, Type ... types) {
		List<Fruit> newList = new ArrayList<Fruit>(fruits);
		for (Fruit f : newList) {
			if ((Arrays.asList(types).contains(f.getType()))
					&& (ChronoUnit.DAYS.between(LocalDate.now(), f.expireDate()) < 10) && (f.isExpired(LocalDate.now()) == false)) {
				f.setPrice(f.getPrice() * percent / 100);
			}
		}
		return newList;
	}

}
