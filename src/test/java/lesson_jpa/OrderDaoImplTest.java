package lesson_jpa;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDaoImplTest {
	private static final Order INSERT_DELETE_ORDER = new Order(BigDecimal.valueOf(111112), null,
			Date.valueOf("2019-02-14"), "REI", BigDecimal.valueOf(10), BigDecimal.valueOf(100));

	private static final Order UPDATE_ORDER = new Order(BigDecimal.valueOf(111112), null, Date.valueOf("2019-02-14"),
			"REI", BigDecimal.valueOf(100), BigDecimal.valueOf(1000));
	private OrderDao orderDao = new OrderDaoImpl();

	@Test
	public void test1InsertOrder() throws SQLException {
		assertTrue(orderDao.insertOrder(INSERT_DELETE_ORDER));
	}

	@Test
	public void test2UpdateOrder() throws SQLException {
		assertTrue(orderDao.updateOrder(UPDATE_ORDER));
	}

	@Test
	public void test3DeleteOrder() throws SQLException {
		assertTrue(orderDao.deleteOrder(UPDATE_ORDER.getOrderNum()));
	}

}
