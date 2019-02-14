package lesson_jdbc_01;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Set<Customer> getAllCustomers() throws SQLException {
		Set<Customer> customers = new HashSet<>();
		Connection conn = ConnectToDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customers");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Customer customer = new Customer(rs.getBigDecimal("cust_num"), rs.getString("company"),
					rs.getBigDecimal("cust_rep"), rs.getBigDecimal("credit_limit"));
			customers.add(customer);
		}
		rs.close();
		stmt.close();
		conn.close();
		return customers;
	}

	@Override
	public Set<Customer> findCustomersByCreditLimitMoreThan(BigDecimal creditLimit) throws SQLException {
		Set<Customer> customers = new HashSet<>();
		Connection conn = ConnectToDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customers WHERE credit_limit > ?");
		stmt.setBigDecimal(1, creditLimit);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Customer customer = new Customer(rs.getBigDecimal("cust_num"), rs.getString("company"),
					rs.getBigDecimal("cust_rep"), rs.getBigDecimal("credit_limit"));
			customers.add(customer);
		}

		rs.close();
		stmt.close();
		conn.close();
		return customers;
	}

	@Override
	public boolean insertCustomer(Customer customer) throws SQLException {
		Connection conn = ConnectToDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO customers values (?, ?, ?, ?)");
		stmt.setBigDecimal(1, customer.getCustNum());
		stmt.setString(2, customer.getCompany());
		stmt.setBigDecimal(3, customer.getCustRep());
		stmt.setBigDecimal(4, customer.getCreditLimit());

		int rowsChanged = stmt.executeUpdate();
		if (rowsChanged > 0) {
			stmt.close();
			conn.close();
			return true;
		}
		stmt.close();
		conn.close();
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) throws SQLException {
		Connection conn = ConnectToDB.getConnection();
		String sql = "UPDATE customers SET company=?, credit_limit=?  WHERE cust_num=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getCompany());
		stmt.setBigDecimal(2, customer.getCreditLimit());
		stmt.setBigDecimal(3, customer.getCustNum());
		
		int rowsChanged = stmt.executeUpdate();
		if (rowsChanged > 0) {
			stmt.close();
			conn.close();
			return true;
		}
		stmt.close();
		conn.close();
		return false;
	}

	@Override
	public boolean deleteCustomer(BigDecimal id) throws SQLException {
		Connection conn = ConnectToDB.getConnection();
		String sql = "DELETE FROM customers WHERE cust_num = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setBigDecimal(1, id);

		int rowsChanged = stmt.executeUpdate();
		if (rowsChanged > 0) {
			stmt.close();
			conn.close();
			return true;
		}
		stmt.close();
		conn.close();
		return false;
	}

	@Override
	public Customer findCustomersByCustNum(BigDecimal cust_num) throws SQLException {
		Connection conn = ConnectToDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customers WHERE cust_num = ?");
		stmt.setBigDecimal(1, cust_num);
		ResultSet rs = stmt.executeQuery();

		Customer customer = null;
		if (rs.next()) {
			customer = new Customer(rs.getBigDecimal("cust_num"), rs.getString("company"),
					rs.getBigDecimal("cust_rep"), rs.getBigDecimal("credit_limit"));
		}
		rs.close();
		stmt.close();
		conn.close();
		return customer;
	}

}
