package lesson_jdbc_01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDaoImplIntegrationTest {
	private static final BigDecimal NOT_EXIST_CUSTOMER = BigDecimal.valueOf(100000000);
	private static final BigDecimal SOME_RICH_CUSTOMERS = BigDecimal.valueOf(60);
	private static final Customer MOST_VALUED_CUSTOMER = new Customer(BigDecimal.valueOf(2199), "Супер Пупс",
			BigDecimal.valueOf(120), BigDecimal.valueOf(150.876));
	private static final Customer INSERT_DELETE_CUSTOMER = new Customer(BigDecimal.valueOf(11111), "SCOOBY DOOPS",
			BigDecimal.valueOf(103), BigDecimal.valueOf(120000));
	private static final Customer UPDATE_CUSTOMER = new Customer(BigDecimal.valueOf(11111), "SCOOBY DOOBY DOOPS",
			BigDecimal.valueOf(103), BigDecimal.valueOf(12000));
	private CustomerDao customerDao = new CustomerDaoImpl();

	@Test
	public void testGetAllCustomers() throws SQLException {
		Set<Customer> customers = customerDao.getAllCustomers();
		System.out.println(customers);
		assertFalse(customers.isEmpty());
	}

	@Test
	public void testFindCustomersByCreditLimitMoreThanEmpty() throws SQLException {
		Set<Customer> customers = customerDao.findCustomersByCreditLimitMoreThan(NOT_EXIST_CUSTOMER);
		System.out.println(customers);
		assertTrue(customers.isEmpty());
	}

	@Test
	public void testFindCustomersByCreditLimitMoreThan() throws SQLException {
		Set<Customer> customers = customerDao.findCustomersByCreditLimitMoreThan(SOME_RICH_CUSTOMERS);
		System.out.println(customers);
		assertFalse(customers.isEmpty());
	}

	@Test
	public void testFindCustomersByCreditLimitMoreThanHundred() throws SQLException {
		Set<Customer> customers = customerDao.findCustomersByCreditLimitMoreThan(BigDecimal.valueOf(100));
		System.out.println(customers);
		assertTrue(customers.contains(MOST_VALUED_CUSTOMER));
	}

	@Test
	public void test1InsertCustomer() throws SQLException {
		Customer expected = INSERT_DELETE_CUSTOMER;
		assertTrue(customerDao.insertCustomer(INSERT_DELETE_CUSTOMER));
		assertEquals(expected, customerDao.findCustomersByCustNum(INSERT_DELETE_CUSTOMER.getCustNum()));
	}

	@Test
	public void test2UpdateCustomer() throws SQLException {
		Customer expected = UPDATE_CUSTOMER;
		assertTrue(customerDao.updateCustomer(UPDATE_CUSTOMER));
		assertEquals(expected, customerDao.findCustomersByCustNum(UPDATE_CUSTOMER.getCustNum()));
		
	}

	@Test
	public void test3DeleteCustomer() throws SQLException {
		assertTrue(customerDao.deleteCustomer(INSERT_DELETE_CUSTOMER.getCustNum()));
		assertNull(customerDao.findCustomersByCustNum(INSERT_DELETE_CUSTOMER.getCustNum()));
	}
}
