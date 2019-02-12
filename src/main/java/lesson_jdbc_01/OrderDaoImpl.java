package lesson_jdbc_01;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OrderDaoImpl implements OrderDao {

	@Override
	public Set<Order> getAllOrders() throws SQLException {
		Set<Order> orders = new HashSet<>();
		Connection conn = ConnectToDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * orders");
		ResultSet rs = stmt.executeQuery();
		return orders;
	}

	@Override
	public Order findOrderById(BigDecimal id) throws SQLException {
		Connection conn = ConnectToDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from orders where order_num = ?");
		stmt.setBigDecimal(1, id);
		ResultSet rs = stmt.executeQuery();

		Order order = null;
		if (rs.next()) {
			order = new Order(rs.getBigDecimal("order_num"), null, rs.getDate("order_date"), rs.getString("mfr"),
					rs.getBigDecimal("qty"), rs.getBigDecimal("amount"));
		}
		rs.close();
		stmt.close();
		conn.close();
		// TODO Auto-generated method stub
		return order;
	}

	@Override
	public boolean insertOrder(Order order) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOrder(Order order) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOrder(BigDecimal id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
