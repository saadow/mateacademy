package lesson_hibernate;

import java.io.File;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import lesson_jpa.Customer;
import lesson_jpa.Office;
import lesson_jpa.Order;
import lesson_jpa.Product;
import lesson_jpa.Salesreps;

public class OrderDaoImpl implements OrderDao {
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	private static final Logger LOG = LogManager.getLogger(OrderDaoImpl.class);

	private static SessionFactory buildSessionFactory() {
		Locale.setDefault(Locale.ENGLISH);

		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration();
		configObj.addAnnotatedClass(Order.class);
		configObj.addAnnotatedClass(Customer.class);
		configObj.addAnnotatedClass(Office.class);
		configObj.addAnnotatedClass(Product.class);
		configObj.addAnnotatedClass(Salesreps.class);
		configObj.configure(new File("src/resources/hibernate.cfg.xml"));

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		// Creating Hibernate SessionFactory Instance
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	@Override
	public Order findOrderById(BigDecimal id) {
		Order order = null;
		try {
			// Getting Session Object From SessionFactory
			sessionObj = buildSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			order = (Order) sessionObj.load(Order.class, id);
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		}
		return order;
	}

	@Override
	public boolean insertOrder(Order order) {
		boolean result = false;
		try {
			// Getting Session Object From SessionFactory
			sessionObj = buildSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			sessionObj.save(order);

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
			result = true;
			LOG.info("\nSuccessfully Created Records In The Database!\n");
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		return result;
	}

	@Override
	public boolean updateOrder(Order order) {
		boolean result = false;
		try {
			// Getting Session Object From SessionFactory
			sessionObj = buildSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			Order stuObj = sessionObj.get(Order.class, order.getOrderNum());
			stuObj.setAmount(order.getAmount());
			stuObj.setQty(order.getQty());

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
			result = true;
			LOG.info("\nOrder With Id={} Is Successfully Updated In The Database!\n", order.getOrderNum());
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		return result;
	}

	@Override
	public boolean deleteOrder(BigDecimal id) {
		boolean result = false;
		try {
			// Getting Session Object From SessionFactory
			sessionObj = buildSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			sessionObj.delete(sessionObj.get(Order.class, id));

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
			result = true;
			LOG.info("\nOrder With Id={} Is Successfully deleted from The Database!\n", id);
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		return result;
	}

	@Override
	public Set<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}
}
