package homework11;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import lesson10.Fruit;
import lesson10.FruitShop;
import lesson10.FruitType;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FruitShopMockSpyUnitTest {
	@Spy
	@InjectMocks
	private FruitShop fruitShop;
	@Mock
	private Fruit apple1;
	@Mock
	private Fruit apple2;
	@Mock
	private Fruit pear;
	@Mock
	private Fruit monkey;
	@Mock
	private Fruit strawberry;

	@Before
	public void beforeEach() {
		when(apple1.getFruitType()).thenReturn(FruitType.APPLE);
		when(apple1.getDayToLive()).thenReturn(20);
		when(apple1.getDeliveryDate()).thenReturn(LocalDate.of(2019, 1, 8));
		when(apple1.clone()).thenReturn(apple1);
		
		when(apple2.getFruitType()).thenReturn(FruitType.APPLE);
		when(apple2.getDayToLive()).thenReturn(25);
		when(apple2.getDeliveryDate()).thenReturn(LocalDate.of(2019, 1, 19));
		when(apple2.clone()).thenReturn(apple2);
		
		when(pear.getFruitType()).thenReturn(FruitType.PEAR);
		when(pear.getDayToLive()).thenReturn(10);
		when(pear.getDeliveryDate()).thenReturn(LocalDate.of(2018, 12, 25));
		
		when(monkey.getFruitType()).thenReturn(FruitType.ORANGE);
		when(monkey.getDayToLive()).thenReturn(10);
		when(monkey.getDeliveryDate()).thenReturn(LocalDate.of(2018, 12, 15));
		
		when(strawberry.getFruitType()).thenReturn(FruitType.STRAWBERRY);
		when(strawberry.getDayToLive()).thenReturn(10);
		when(strawberry.getDeliveryDate()).thenReturn(LocalDate.of(2010, 12, 15));
		
		doReturn(Arrays.asList(apple1, apple2, pear, monkey, strawberry)).when(fruitShop).getFruits();
	}

	@Test
	public void testAllFreshExpectedEmpty() {
		List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2222, 1, 20));
		assertTrue(actual.size() == 0);
	}
	
	@Test
	public void testAllFreshExpectedTwoApples() {
		List<Fruit> expected = Arrays.asList(apple1, apple2);
		List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, 1, 22));
		assertEquals(expected, actual);
	}

	@Test
	public void testAllFreshVerify() {
		//works with 2015 LOL
		fruitShop.allFresh(LocalDate.of(2015, 11, 30));
		verify(fruitShop, times(1)).getFruits();
		verify(apple1, times(1)).getDayToLive();
		verify(apple2, times(1)).getDayToLive();
		verify(pear, times(1)).getDayToLive();
		verify(monkey, times(1)).getDayToLive();
		verify(strawberry, times(1)).getDayToLive();
	}

	@Test
	public void testAllFruitOfFruitTypeApple() {
		List<Fruit> expected = Arrays.asList(apple1, apple2);
		List<Fruit> actual = fruitShop.allFruitOfFruitType(FruitType.APPLE);
		assertEquals(expected, actual);
	}

	@Test
	public void testAllFruitOfFruitTypeVerify() {
		fruitShop.allFruitOfFruitType(FruitType.APPLE);
		verify(fruitShop, times(1)).getFruits();
		verify(apple1, times(1)).getFruitType();
		verify(apple2, times(1)).getFruitType();
	}

	@Test
	public void testCheckByExpireDate() {
		List<Fruit> expected = Arrays.asList(apple1, apple2);
		List<Fruit> actual = fruitShop.checkByExpireDate(19);
		assertEquals(expected, actual);
	}

	@Test
	public void testAllFreshAndFruitType() {
		List<Fruit> expected = Arrays.asList(apple2);
		List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.APPLE, LocalDate.of(2019, 2, 1));
		assertEquals(expected, actual);
	}
	//Very good test checking deliveryDate call twice but not calling getPrice because fruit is outdated ;)
	@Test
	public void testReSetPricexRealizationVerifyStrawberryEmpty() {
		List<Fruit> actual = fruitShop.reSetPricexRealization(50, 0, FruitType.STRAWBERRY);
		verify(fruitShop, times(1)).getFruits();
		verify(strawberry, times(2)).getDeliveryDate();
		verify(strawberry, times(0)).getPrice();
		assertTrue(actual.size() == 0);
	}
}