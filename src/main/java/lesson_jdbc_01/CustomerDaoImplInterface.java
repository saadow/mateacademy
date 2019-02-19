package lesson_jdbc_01;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDaoImplInterface {

	public boolean insertCustomer(Customer customer) throws SQLException {
		return ((TemplateInterface) conn -> {
			PreparedStatement stmt;
			conn = ConnectToDB.getConnection();
			stmt = conn.prepareStatement("INSERT INTO customers values (?, ?, ?, ?)");
			stmt.setBigDecimal(1, customer.getCustNum());
			stmt.setString(2, customer.getCompany());
			stmt.setBigDecimal(3, customer.getCustRep());
			stmt.setBigDecimal(4, customer.getCreditLimit());
			return stmt;
		}).operationTemplate();
	}

	public boolean updateCustomer(Customer customer) throws SQLException {
		return ((TemplateInterface) conn -> {
			PreparedStatement stmt;
			conn = ConnectToDB.getConnection();
			stmt = conn.prepareStatement("UPDATE customers SET company=?, credit_limit=?  WHERE cust_num=?");
			stmt.setString(1, customer.getCompany());
			stmt.setBigDecimal(2, customer.getCreditLimit());
			stmt.setBigDecimal(3, customer.getCustNum());
			return stmt;
		}).operationTemplate();
	}

	public boolean deleteCustomer(Customer customer) throws SQLException {
		return ((TemplateInterface) conn -> {
			PreparedStatement stmt;
			conn = ConnectToDB.getConnection();
			stmt = conn.prepareStatement("DELETE FROM customers WHERE cust_num = ?");
			stmt.setBigDecimal(1, customer.getCustNum());
			return stmt;
		}).operationTemplate();
	}
}
