package lesson_hibernate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import lesson_jpa.Order;
import homework_hibernate.OrderDao;
import homework_hibernate.OrderDaoImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDaoImplTest {
	
	private static final Order ORDER = new Order(BigDecimal.valueOf(111112), null,
			Date.valueOf("2019-02-14"), "REI", BigDecimal.valueOf(10), BigDecimal.valueOf(100));
	private OrderDao orderDao = new OrderDaoImpl();

	@Test
	public void testFindOrderById() {
		Order order = orderDao.findOrderById(BigDecimal.valueOf(113055));
		System.out.println(order);
		assertNotNull(order);
	}

    @Test
    public void testGetAllOrders(){
        assertFalse(orderDao.getAllOrders().isEmpty());
    }
	
    @Test
    public void test1InsertOrder()   {
        assertTrue(orderDao.insertOrder(ORDER));
    }

    @Test
    public void test2UpdateOrder()  {
        ORDER.setQty(BigDecimal.valueOf(20));
        assertTrue(orderDao.updateOrder(ORDER));
    }

    @Test
    public void test3DeleteOrder() {
        assertTrue(orderDao.deleteOrder(ORDER.getOrderNum()));
    }

}
