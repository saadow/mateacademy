package homework07;

import static homework07.FruitType.APPLE;
import static homework07.FruitType.ORANGE;
import static homework07.FruitType.PEAR;
import static homework07.FruitType.STRAWBERRY;
import static homework07.Vitamins.A;
import static homework07.Vitamins.B;
import static homework07.Vitamins.B1;
import static homework07.Vitamins.B2;
import static homework07.Vitamins.C;
import static homework07.Vitamins.D;
import static homework07.Vitamins.E;
import static homework07.Vitamins.P;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFruitClone {
	public static void main(String[] args) {

		List<Fruit> fruits = fillFruitsList();

		// Serialization clone
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(fruits);
			oos.close();
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			@SuppressWarnings("unchecked")
			List<Fruit> cloneFruits = (List<Fruit>) ois.readObject();

			System.out.println("Original Fruits List");
			fruits.forEach(System.out::println);
			cloneFruits.get(0).setVitamins(Arrays.asList(new Vitamins[] { A, B, C }));
			System.out.println("Fruits List after vitamins addition");
			fruits.forEach(System.out::println);
			System.out.println("Fruits Clone List");
			cloneFruits.forEach(System.out::println);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Tests for Uncheckable/Checkable
		Fruit fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
		fruit.setVitamins(Arrays.asList(new Vitamins[] { B, C }));
		
		fruit.setNewPriceChecked(0);
		fruit.setNewPriceUnchecked();
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
