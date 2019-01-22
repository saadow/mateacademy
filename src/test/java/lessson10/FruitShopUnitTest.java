package lessson10;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Matchers;

import lesson10.Fruit;
import lesson10.FruitShop;
import lesson10.FruitType;

public class FruitShopUnitTest {
	private FruitShop fruitShop;
	private static Fruit apple;
	private static Fruit strawberry;
	private static Fruit pear;
	private static Fruit monkey;

	@BeforeClass
	public static void beforeClass() {
		apple = new Fruit(FruitType.APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
		strawberry = new Fruit(FruitType.STRAWBERRY, 30, LocalDate.of(2019, 1, 4), 12, null);
		pear = new Fruit(FruitType.PEAR, 30, LocalDate.of(2019, 1, 14), 12, null);
		monkey = new Fruit(FruitType.ORANGE, 30, LocalDate.of(2019, 1, 14), 12, null);

		System.out.println("Before Class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}

	@Before
	public void testBefore() {
		List<Fruit> fruits = new ArrayList<>();
		fruits.add(apple);
		fruits.add(strawberry);
		fruits.add(pear);
		fruits.add(monkey);
		fruitShop = new FruitShop("1", fruits);
		System.out.println("Before each");
	}

	@After
	public void testAfter() {
		System.out.println("After Each");
	}

	@Test
	public void testAllFresh() {
		List<Fruit> expected = new ArrayList<>();
		expected.add(apple);
		expected.add(strawberry);
		expected.add(pear);
		expected.add(monkey);
		List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, 1, 20));
		assertEquals(expected, actual);
	}

	@Test
	public void testAllFreshShouldBeNothing() {
		
		List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, 11, 25));
		assertTrue(actual.size() == 0);
	}
}
