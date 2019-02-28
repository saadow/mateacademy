package lesson_jpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Locale;

public class ShowTablesInfo {

	private static EntityManagerFactory factory;

	static {
		Locale.setDefault(Locale.ENGLISH);
		factory = Persistence.createEntityManagerFactory("PERSISTENCE");
	}

	private static final Logger LOG = LogManager.getLogger(OrderDaoImpl.class);
	private static EntityManager entityManager = factory.createEntityManager();

	public static void main(String[] args) {
		ShowTablesInfo.showProductInfo(BigDecimal.valueOf(112989));
		OrderDaoImpl odi = new OrderDaoImpl();
		System.out.println(odi.getAllOrders());
	}

	public static Order showProductInfo(BigDecimal id) {
		LOG.debug("gettin info for Products");
		Order order = null;
		try {
			order = entityManager.find(Order.class, id);
			System.out.println(order);
			System.out.println(order.getProduct());
			System.out.println(order.getCustomers());
			System.out.println(order.getSalesreps().getRepOffice());
			System.out.println(order.getSalesreps());
			
			LOG.debug("find succeded");
		} catch (RuntimeException re) {
			LOG.error("find failed", re);
			throw re;
		}
		return order;
	}
}
