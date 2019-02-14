package lesson_jdbc_01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Set;

import org.junit.Test;

public class OrderDaoImplIntegrationTest {
	private static final BigDecimal NOT_EXIST_ORDER = BigDecimal.valueOf(111111);
	private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(112961);
	private static final Order ORDER = new Order(BigDecimal.valueOf(112961), null, Date.valueOf("1989-12-17"), "REI",
			BigDecimal.valueOf(7), BigDecimal.valueOf(31.5));
	private OrderDao orderDao = new OrderDaoImpl();

	@Test
	public void testFindOrderByIdNotExistOrder() throws SQLException {
		Order order = orderDao.findOrderById(NOT_EXIST_ORDER);
		System.out.println(order);
		assertNull(order);
	}

	@Test
	public void testFindOrderById() throws SQLException {
		Order order = orderDao.findOrderById(ALREADY_EXIST_ORDER);
		System.out.println(order);
		assertEquals(order, ORDER);
	}

	@Test
	public void testGetAllOrders() throws SQLException {
		Set<Order> orders = orderDao.getAllOrders();
		System.out.println(orders);
		assertFalse(orders.isEmpty());

	}

	@Test
	public void testGetAllOrdersJoin() throws SQLException {
		Set<Order> orders = orderDao.getAllOrdersJoin();
		System.out.println(orders);
		assertFalse(orders.isEmpty());
	}
}
