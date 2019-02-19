package lesson_jdbc_01;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDaoImplGenericTest {
	private static final Customer INSERT_CUSTOMER = new Customer(BigDecimal.valueOf(11111), "SCOOBY DOOPS",
			BigDecimal.valueOf(103), BigDecimal.valueOf(120000));
	private static final Customer UPDATE_CUSTOMER = new Customer(BigDecimal.valueOf(11111), "SCOOBY DOOBY DOOPS",
			BigDecimal.valueOf(103), BigDecimal.valueOf(12000));
	private CustomerDaoInterface customerDao = new CustomerDaoImplGeneric();

	@Test
	public void test1InsertCustomer() throws SQLException {
		assertTrue(customerDao.insertCustomer(INSERT_CUSTOMER));
	}

	@Test
	public void test2UpdateCustomer() throws SQLException {
		assertTrue(customerDao.updateCustomer(UPDATE_CUSTOMER));
	}

	@Test
	public void test3DeleteCustomer() throws SQLException {
		assertTrue(customerDao.deleteCustomer(UPDATE_CUSTOMER));
	}
}
