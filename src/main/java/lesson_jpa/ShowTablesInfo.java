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
		ShowTablesInfo.showProductInfo("114");
		ShowTablesInfo.showOrderInfo(BigDecimal.valueOf(113045));
		ShowTablesInfo.showCustomerInfo(BigDecimal.valueOf(2111));
		ShowTablesInfo.showOfficeInfo(BigDecimal.valueOf(22));
		ShowTablesInfo.showSalesrepsInfo(BigDecimal.valueOf(109));
	}

	public static void showProductInfo(String productId) {
		LOG.debug("showing info for Products");
		try {
			System.out.println(entityManager.find(Product.class, productId));
			LOG.debug("find succeded");
		} catch (RuntimeException re) {
			LOG.error("find failed", re);
			throw re;
		}
	}

	public static void showOrderInfo(BigDecimal orderNum) {
		LOG.debug("showing info for Orders");
		try {
			System.out.println(entityManager.find(Order.class, orderNum));
			LOG.debug("find succeded");
		} catch (RuntimeException re) {
			LOG.error("find failed", re);
			throw re;
		}
	}

	public static void showCustomerInfo(BigDecimal custNum) {
		LOG.debug("showing info for Customers");
		try {
			System.out.println(entityManager.find(Customer.class, custNum));
			LOG.debug("find succeded");
		} catch (RuntimeException re) {
			LOG.error("find failed", re);
			throw re;
		}
	}

	public static void showOfficeInfo(BigDecimal office) {
		LOG.debug("showing info for Offices");
		try {
			System.out.println(entityManager.find(Office.class, office));
			LOG.debug("find succeded");
		} catch (RuntimeException re) {
			LOG.error("find failed", re);
			throw re;
		}
	}

	public static void showSalesrepsInfo(BigDecimal emplNum) {
		LOG.debug("showing info for Salesreps");
		try {
			System.out.println(entityManager.find(Salesreps.class, emplNum));
			LOG.debug("find succeded");
		} catch (RuntimeException re) {
			LOG.error("find failed", re);
			throw re;
		}
	}
}
