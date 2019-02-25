package homework_jpa;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerDaoImpl implements CustomerDao {

	private static EntityManagerFactory factory;

	static {
		Locale.setDefault(Locale.ENGLISH);
		factory = Persistence.createEntityManagerFactory("PERSISTENCE");
	}

	private static final Logger LOG = LogManager.getLogger(CustomerDaoImpl.class);

	private EntityManager entityManager = factory.createEntityManager();

	@Override
	public boolean insertCustomer(Customer customer) {
		LOG.debug("persisting Customer instance");
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(customer);
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
	public boolean updateCustomer(Customer customer) {
		LOG.debug("merging Customer instance");
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(customer);
			entityManager.getTransaction().commit();
			LOG.debug("merge successful");
			return true;
		} catch (RuntimeException re) {
			if (entityManager != null) {
				System.out.println("Transaction is being rolled back.");
				entityManager.getTransaction().rollback();
			}
			LOG.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public boolean deleteCustomer(BigDecimal id) {
		LOG.debug("removing Customer instance");
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.find(Customer.class, id));
			entityManager.getTransaction().commit();
			LOG.debug("remove successful");
			return true;
		} catch (RuntimeException re) {
			if (entityManager != null) {
				System.out.println("Transaction is being rolled back.");
				entityManager.getTransaction().rollback();
			}
			LOG.error("remove failed", re);
			throw re;
		}
	}
}
