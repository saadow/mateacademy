package springdata.project01.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import lesson_jpa.Order;
import springdata.project01.repository.OrdersRepository;
import springdata.project01.exception.DeleteException;

@Service
public class OrdersServiceImpl implements OrdersService {

	private static final Logger LOG = LogManager.getLogger(OrdersServiceImpl.class);

	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public Set<Order> getAllOrders() {
		LOG.debug("get all orders");
		HashSet<Order> result = new HashSet<>(ordersRepository.findAll());
		LOG.debug("{} results", result.size());
		return result;
	}

	@Override
	public Set<Order> findByQtyBetween(int minQty, int maxQty) {
		LOG.debug("findByQtyBetween, min={}, max={}", minQty, maxQty);
		HashSet<Order> result = new HashSet<>(
				ordersRepository.findByQtyBetween(BigDecimal.valueOf(minQty), BigDecimal.valueOf(maxQty)));
		LOG.debug("findByQtyBetween, result={}", result);
		return result;
	}

	@Override
	public Order findOrderById(BigDecimal id) {
		LOG.debug("findOrderById, id={}", id);
		Order result = ordersRepository.findById(id).orElse(null);
		LOG.debug("findOrderById, result={}", result);
		return result;
	}

	@Override
	public void insertOrder(Order order) {
		LOG.debug("insertOrder, order={}", order);
		ordersRepository.save(order);
		LOG.debug("insertOrder completed");
	}

	@Override
	public void updateOrder(Order order) {
		LOG.debug("updateOrder, order={}", order);
		ordersRepository.save(order);
		LOG.debug("updateOrder completed");
	}

	@Override
	public void deleteOrder(BigDecimal id) {
		LOG.debug("delete order, id = {} ", id);
		try {
			ordersRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			LOG.warn("Can't delete order with id = {}", id + ", EmptyResultData");
			throw new DeleteException("Can't delete order by Id = " + id + ", EmptyResultData");
		}
		LOG.debug("delete order completed");
	}

}
