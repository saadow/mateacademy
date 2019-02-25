package homework_jpa;

import java.math.BigDecimal;
import java.sql.SQLException;

public interface CustomerDao {
	boolean insertCustomer(Customer customer) throws SQLException;
	boolean updateCustomer(Customer customer) throws SQLException;
	boolean deleteCustomer(BigDecimal id) throws SQLException;
}
