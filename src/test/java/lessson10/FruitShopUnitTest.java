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
	private static Fruit apple1;
	private static Fruit apple2;
	private static Fruit strawberry;
	private static Fruit pear;
	private static Fruit monkey;

	@BeforeClass
	public static void beforeClass() {
		apple1 = new Fruit(FruitType.APPLE, 40, LocalDate.of(2019, 1, 4), 12, null);
		strawberry = new Fruit(FruitType.STRAWBERRY, 30, LocalDate.of(2019, 1, 4), 12, null);
		pear = new Fruit(FruitType.PEAR, 40, LocalDate.of(2019, 1, 14), 12, null);
		monkey = new Fruit(FruitType.ORANGE, 30, LocalDate.of(2019, 1, 14), 12, null);
		apple2 = new Fruit(FruitType.APPLE, 30, LocalDate.of(2019, 1, 1), 12, null);

		System.out.println("Before Class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}

	@Before
	public void testBefore() {
		List<Fruit> fruits = new ArrayList<>();
		fruits.add(apple1);
		fruits.add(strawberry);
		fruits.add(pear);
		fruits.add(monkey);
		fruits.add(apple2);
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
		expected.add(apple1);
		expected.add(strawberry);
		expected.add(pear);
		expected.add(monkey);
		expected.add(apple2);
		List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, 1, 20));
		assertEquals(expected, actual);
	}

	@Test
	public void testAllFreshShouldBeNothing() {
		
		List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, 11, 25));
		assertTrue(actual.size() == 0);
	}

	@Test
	public void testAllFruitOfFruitType() {
		List<Fruit> expected = new ArrayList<>();
		expected.add(apple1);
		expected.add(apple2);
		assertEquals(expected, fruitShop.allFruitOfFruitType(FruitType.APPLE));
	}

	@Test
	public void testAllFruitOfFruitType2() {
		List<Fruit> noPearList = new ArrayList<>();
		noPearList.add(apple1);
		noPearList.add(strawberry);
		noPearList.add(monkey);
		noPearList.add(apple2);
		FruitShop fruitShop = new FruitShop("2", noPearList);
		List<Fruit> actual = fruitShop.allFruitOfFruitType(FruitType.PEAR);
		assertTrue(actual.size() == 0);
	}

	@Test
	public void testCheckByExpireDate() {
		List<Fruit> expected = new ArrayList<>();
		expected.add(apple1);
		expected.add(pear);
		List<Fruit> actual = fruitShop.checkByExpireDate(30);
		assertEquals(expected, actual);
	}

	@Test
	public void testCheckByExpireDate2() {
		List<Fruit> actual = fruitShop.checkByExpireDate(100);
		assertTrue(actual.size() == 0);	
	}

	@Test
	public void testAllFreshAndFruitType() {
		List<Fruit> expected = new ArrayList<>();
		expected.add(apple1);
		List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.APPLE, LocalDate.of(2019, 2, 5));
		assertEquals(expected, actual);
	}

	@Test
	public void testAllFreshAndFruitType2() {
		List<Fruit> expected = new ArrayList<>();
		expected.add(apple1);
		expected.add(apple2);
		List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.APPLE, LocalDate.of(2019, 1, 31));
		assertEquals(expected, actual);
	}

	@Test
	public void testReSetPricexRealization() {
		List<Fruit> actual = fruitShop.reSetPricexRealization(50, 14, FruitType.APPLE);
		assertFalse(actual.size() != 0);
	}

	@Test
	public void testReSetPricexRealization2() {
		List<Fruit> expected = new ArrayList<>();
		expected.add(new Fruit(FruitType.APPLE, 40, LocalDate.of(2019, 01, 04), 6, null));
		List<Fruit> actual = fruitShop.reSetPricexRealization(50, 17, FruitType.APPLE);
		assertEquals(expected, actual);
	}
}
