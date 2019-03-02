package homework_hibernate;

import java.math.BigDecimal;
import java.util.Set;

import lesson_jpa.Order;

public interface OrderDao {

	Set<Order> getAllOrders();

	Order findOrderById(BigDecimal id);

	boolean insertOrder(Order order);

	boolean updateOrder(Order order);

	boolean deleteOrder(BigDecimal id);
}
