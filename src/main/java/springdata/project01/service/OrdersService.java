package springdata.project01.service;

import java.math.BigDecimal;
import java.util.Set;

import lesson_jpa.Order;

public interface OrdersService {

	Set<Order> getAllOrders();

	Set<Order> findByQtyBetween(int minQty, int maxQty);

	Order findOrderById(BigDecimal id);

	void insertOrder(Order order);

	void updateOrder(Order order);

	void deleteOrder(BigDecimal id);

}
