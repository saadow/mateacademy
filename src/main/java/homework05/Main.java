package homework05;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Fruit apple1 = new Fruit(Type.APPLE, 30, LocalDate.of(2019, Month.JANUARY, 1), 40);
		Fruit apple2 = new Fruit(Type.APPLE, 60, LocalDate.of(2018, Month.DECEMBER, 11), 55);
		Fruit banana1 = new Fruit(Type.BANANA, 30, LocalDate.of(2018, Month.NOVEMBER, 29), 30);
		Fruit strawberry1 = new Fruit(Type.STRAWBERRY, 30, LocalDate.of(2019, Month.JANUARY, 3), 300);
		Fruit pear1 = new Fruit(Type.PEAR, 30, LocalDate.of(2004, Month.APRIL, 4), 40);
		Fruit pear2 = new Fruit(Type.PEAR, 60, LocalDate.of(2018, Month.DECEMBER, 4), 60);
		
		List<Fruit> list = Arrays.asList(apple1, apple2, banana1, strawberry1, pear1, pear2);
		Shop shop = new Shop("SILPO", list);
		
		System.out.println(shop.allFruitOfType(Type.PEAR));
		System.out.println(shop.allFreshAndType(Type.APPLE, LocalDate.now()));
		System.out.println(shop.allFresh(LocalDate.now()));
		System.out.println(shop.checkExpireDate(45));
		shop.checkExpireDate(45).stream().map(f->f.getType().getCountry()).forEach(System.out::println);
		shop.checkRealizationDatePrice(LocalDate.now());
		System.out.println(list);
		System.out.println(ChronoUnit.DAYS.between(banana1.expireDate(), LocalDate.now()));
	}

}
