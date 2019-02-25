package homework_jpa;

import java.math.BigDecimal;
import java.sql.SQLException;

public interface CustomerDao {
	boolean insertCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(BigDecimal id);
}
