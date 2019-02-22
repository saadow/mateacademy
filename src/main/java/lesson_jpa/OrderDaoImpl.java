package lesson_jpa;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderDaoImpl implements OrderDao {
	private static EntityManagerFactory factory;

	static {
		Locale.setDefault(Locale.ENGLISH);
		factory = Persistence.createEntityManagerFactory("PERSISTENCE");
	}

	private static final Logger LOG = LogManager.getLogger(OrderDaoImpl.class);

	private EntityManager entityManager = factory.createEntityManager();

	@Override
	public boolean insertOrder(Order order) {
		LOG.debug("persisting Order instance");
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(order);
			entityManager.getTransaction().commit();
			LOG.debug("persist successful");
			return true;
		} catch (RuntimeException re) {
			if (entityManager != null) {
				System.out.println("Transaction is being rolled back.");
				entityManager.getTransaction().rollback();
			}
			LOG.error("persist failed", re);
			throw re;
		}
	}


	@Override
	protected void finalize() throws Throwable {
		if (Objects.nonNull(entityManager)) {
			entityManager.close();
		}
	}

	@Override
	public Set<Order> getAllOrders() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Order> getAllOrdersJoin() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOrderById(BigDecimal id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean updateOrder(Order order) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean deleteOrder(BigDecimal id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
