package homework06;

import static homework06.FruitType.APPLE;
import static homework06.FruitType.ORANGE;
import static homework06.FruitType.PEAR;
import static homework06.FruitType.STRAWBERRY;
import static homework06.Vitamins.A;
import static homework06.Vitamins.B;
import static homework06.Vitamins.B1;
import static homework06.Vitamins.B2;
import static homework06.Vitamins.C;
import static homework06.Vitamins.D;
import static homework06.Vitamins.E;
import static homework06.Vitamins.P;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MainLambdaTemplateStudents {
	public static void main(String[] args) {

		List<Fruit> fruits = fillFruitsList();
		fruits.forEach(System.out::println);

		System.out.println("filter");
		fruits.stream().filter(f -> f.getFruitType().equals(APPLE)).forEach(System.out::println);

		System.out.println("skip");
		fruits.stream().skip(7).forEach(System.out::println);

		System.out.println("distinct");
		fruits.stream().distinct().forEach(System.out::println);

		System.out.println("map");
		fruits.stream().map(f -> "Fruit: " + f.getFruitType() + ", Price: " + f.getPrice())
				.forEach(System.out::println);

		System.out.println("peek");
		fruits.stream().peek(f -> System.out.println(f.getClass().getName())).forEach(System.out::println);

		System.out.println("limit");
		fruits.stream().limit(1).forEach(System.out::println);

		System.out.println("sorted");
		fruits.stream().sorted(new FruitComparator()).forEach(System.out::println);

		System.out.println("mapToInt");
		fruits.stream().mapToInt(Fruit::getPrice).forEach(System.out::println);

		System.out.println("flatMapToInt");
		fruits.stream().flatMapToInt(f -> IntStream.of(f.getPrice())).forEach(System.out::println);

		System.out.println("findFirst");
		System.out.println(
				fruits.stream().findFirst().orElse(new Fruit(FruitType.APPLE, 30, LocalDate.of(2019, 1, 4), 12, null)));

		System.out.println("findAny");
		System.out.println(fruits.stream().findAny());

		System.out.println("count");
		System.out.println(fruits.stream().filter(f -> f.getFruitType().equals(APPLE)).count());

		System.out.println("anyMatch");
		System.out.println(fruits.stream().anyMatch(f -> f.getFruitType().equals(STRAWBERRY)));

		System.out.println("noneMatch");
		System.out.println(fruits.stream().noneMatch(f -> f.getFruitType().equals(APPLE)));

		System.out.println("allMatch");
		System.out.println(fruits.stream().allMatch(f -> f.getVitamins().contains(B1)));

		System.out.println("min");
		System.out.println(fruits.stream().min(new FruitComparator()));

		System.out.println("max");
		System.out.println(fruits.stream().max(new FruitComparator()));

		System.out.println("forEach");
		fruits.stream().forEach(System.out::println);

		System.out.println("forEachOrdered");
		fruits.stream().forEachOrdered(System.out::println);

		System.out.println("toArray");
		FruitType[] fruitTypeArr = fruits.stream().map(Fruit::getFruitType).toArray(FruitType[]::new);
		Arrays.asList(fruitTypeArr).stream().forEach(System.out::println);

		System.out.println("reduce");
		System.out.println(fruits.stream().map(Fruit::getPrice).reduce((s1, s2) -> s1 + s2));
	}

	private static List<Fruit> fillFruitsList() {

		List<Fruit> fruits = new ArrayList<>();

		Fruit fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);

		fruit.setVitamins(Arrays.asList(new Vitamins[] { B, C }));

		fruits.add(fruit);

		fruit = new Fruit(STRAWBERRY, 15, LocalDate.of(2019, 1, 2), 50, null);

		fruit.setVitamins(Arrays.asList(new Vitamins[] { A, C }));

		fruits.add(fruit);

		fruit = new Fruit(PEAR, 30, LocalDate.of(2019, 1, 4), 40, null);

		fruit.setVitamins(Arrays.asList(new Vitamins[] { A, B1, B2, C }));

		fruits.add(fruit);

		fruit = new Fruit(ORANGE, 60, LocalDate.of(2019, 1, 3), 30, null);

		fruit.setVitamins(Arrays.asList(new Vitamins[] { E, B, A }));

		fruits.add(fruit);

		fruit = new Fruit(STRAWBERRY, 25, LocalDate.of(2019, 1, 2), 60, null);

		fruit.setVitamins(Arrays.asList(new Vitamins[] { A, C, D }));

		fruits.add(fruit);

		fruit = new Fruit(PEAR, 15, LocalDate.of(2019, 1, 4), 40, null);

		fruit.setVitamins(Arrays.asList(new Vitamins[] { A, B, B1, B2, P }));

		fruits.add(fruit);

		fruit = new Fruit(PEAR, 5, LocalDate.of(2019, 1, 6), 10, null);

		fruit.setVitamins(Arrays.asList(new Vitamins[] { B1, B2, P }));

		fruits.add(fruit);

		fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);

		fruit.setVitamins(Arrays.asList(new Vitamins[] { B, C }));

		fruits.add(fruit);

		return fruits;

	}
}
