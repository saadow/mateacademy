package lesson_jdbc_01;

import java.sql.SQLException;

public interface CustomerDaoInterface {

	boolean insertCustomer(Customer customer) throws SQLException;
	boolean updateCustomer(Customer customer) throws SQLException;
	boolean deleteCustomer(Customer customer) throws SQLException;
}
