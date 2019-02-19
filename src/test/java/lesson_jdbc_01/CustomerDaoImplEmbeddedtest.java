package lesson_jdbc_01;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDaoImplEmbeddedtest {

	private static final Customer INSERT_CUSTOMER = new Customer(BigDecimal.valueOf(11111), "SCOOBY DOOPS",
			BigDecimal.valueOf(103), BigDecimal.valueOf(120000));
	private static final Customer UPDATE_CUSTOMER = new Customer(BigDecimal.valueOf(11111), "SCOOBY DOOBY DOOPS",
			BigDecimal.valueOf(103), BigDecimal.valueOf(12000));
	private CustomerDaoImplGeneric customerDao = new CustomerDaoImplGeneric();
	private static EmbeddedDatabase dataBase;

	@BeforeClass
	public void setUpEmbeddedDB() {
		dataBase = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:embedded_create_customerstable.sql").build();
	}

	@Test
	public void test1InsertCustomer() throws SQLException {
		customerDao.insertCustomer(INSERT_CUSTOMER);
		assertTrue(insertCustomer(UPDATE_CUSTOMER));
	}

	@Test
	public void test2UpdateCustomer() throws SQLException {
		customerDao.updateCustomer(UPDATE_CUSTOMER);
		assertTrue(updateCustomer(UPDATE_CUSTOMER));
	}

	@Test
	public void test3DeleteCustomer() throws SQLException {
		customerDao.deleteCustomer(UPDATE_CUSTOMER);
		assertTrue(deleteCustomer(UPDATE_CUSTOMER));
	}
	
    @AfterClass
    public static void after(){
        dataBase.shutdown();
    }
}
