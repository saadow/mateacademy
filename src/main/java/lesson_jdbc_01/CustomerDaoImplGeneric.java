package lesson_jdbc_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDaoImplGeneric {

	public boolean insertCustomer(Customer customer) throws SQLException {
		return new TemplateAbstract<Customer>() {
			@Override
			public PreparedStatement returnPreparedStatement(Customer customer, Connection conn) throws SQLException {
				PreparedStatement stmt;
				conn = ConnectToDB.getConnection();
				stmt = conn.prepareStatement("INSERT INTO customers values (?, ?, ?, ?)");
				stmt.setBigDecimal(1, customer.getCustNum());
				stmt.setString(2, customer.getCompany());
				stmt.setBigDecimal(3, customer.getCustRep());
				stmt.setBigDecimal(4, customer.getCreditLimit());
				return stmt;
			}
		}.operationTemplate(customer);
	}

	public boolean updateCustomer(Customer customer) throws SQLException {
		return new TemplateAbstract<Customer>() {
			@Override
			public PreparedStatement returnPreparedStatement(Customer customer, Connection conn) throws SQLException {
				PreparedStatement stmt;
				conn = ConnectToDB.getConnection();
				stmt = conn.prepareStatement("UPDATE customers SET company=?, credit_limit=?  WHERE cust_num=?");
				stmt.setString(1, customer.getCompany());
				stmt.setBigDecimal(2, customer.getCreditLimit());
				stmt.setBigDecimal(3, customer.getCustNum());
				return stmt;
			}
		}.operationTemplate(customer);
	}

	public boolean deleteCustomer(Customer customer) throws SQLException {
		return new TemplateAbstract<Customer>() {
			@Override
			public PreparedStatement returnPreparedStatement(Customer customer, Connection conn) throws SQLException {
				PreparedStatement stmt;
				conn = ConnectToDB.getConnection();
				stmt = conn.prepareStatement("DELETE FROM customers WHERE cust_num = ?");
				stmt.setBigDecimal(1, customer.getCustNum());
				return stmt;
			}
		}.operationTemplate(customer);
	}
}