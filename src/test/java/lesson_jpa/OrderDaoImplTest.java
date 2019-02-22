package lesson_jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDaoImplTest {
	private static final BigDecimal NOT_EXIST_ORDER = BigDecimal.valueOf(1111110);
	private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(112961);
	private static final Order ORDER = new Order(BigDecimal.valueOf(112961), null, Date.valueOf("1989-12-17"), "REI",
			BigDecimal.valueOf(7), BigDecimal.valueOf(31.5));
	private static final Order INSERT_DELETE_ORDER = new Order(BigDecimal.valueOf(111112), null, Date.valueOf("2019-02-14"), "REI",
			BigDecimal.valueOf(10), BigDecimal.valueOf(100));

	private static final Order UPDATE_ORDER = new Order(BigDecimal.valueOf(111111), null, Date.valueOf("2019-02-14"), "REI",
			BigDecimal.valueOf(100), BigDecimal.valueOf(1000));
	private OrderDao orderDao = new OrderDaoImpl();

	@Test
	public void test1InsertOrder() throws SQLException {
		assertTrue(orderDao.insertOrder(INSERT_DELETE_ORDER));
	}
	
}
