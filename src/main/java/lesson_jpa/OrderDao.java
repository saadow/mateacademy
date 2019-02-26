package lesson_jpa;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

public interface OrderDao {
	Set<Order> getAllOrders();

	Set<Order> getAllOrdersJoin();

	Order findOrderById(BigDecimal id);

	boolean insertOrder(Order order);

	boolean updateOrder(Order order);

	boolean deleteOrder(BigDecimal id);
}
