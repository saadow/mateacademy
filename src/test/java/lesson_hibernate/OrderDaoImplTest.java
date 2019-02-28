package lesson_hibernate;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import lesson_jpa.Order;
import lesson_hibernate.OrderDao;
import lesson_hibernate.OrderDaoImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDaoImplTest {
	
	private OrderDao orderDao = new OrderDaoImpl();

	@Test
	public void testFindOrderById() {
		Order order = orderDao.findOrderById(BigDecimal.valueOf(113055));
		System.out.println(order);
		assertNotNull(order);
	}
}
