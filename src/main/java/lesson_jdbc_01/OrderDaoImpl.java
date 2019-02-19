package lesson_jdbc_01;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OrderDaoImpl implements OrderDao {

	@Override
	public Set<Order> getAllOrders() throws SQLException {
		Set<Order> orders = new HashSet<>();
		Connection conn = ConnectToDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM orders");
		ResultSet rsOrder = stmt.executeQuery();
		ResultSetMetaData resultSetMetaData = rsOrder.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		for (int i = 1; i <= columnCount; ++i) {
			System.out.println("***************");
			System.out.print("Column Name : " + resultSetMetaData.getColumnLabel(i) + " \n");
			System.out.print("Column Type : " + resultSetMetaData.getColumnType(i) + " \n");
			System.out.print("Column Class Name : " + resultSetMetaData.getColumnClassName(i) + " \n");
			System.out.print("Column Type Name :" + resultSetMetaData.getColumnTypeName(i) + " \n");
		}
		while (rsOrder.next()) {
			Order order = new Order(rsOrder.getBigDecimal("order_num"), null, rsOrder.getDate("order_date"),
					rsOrder.getString("mfr"), rsOrder.getBigDecimal("qty"), rsOrder.getBigDecimal("amount"));

			stmt = conn.prepareStatement("SELECT * FROM products WHERE product_id=?");
			stmt.setString(1, rsOrder.getString("product"));
			ResultSet rsProduct = stmt.executeQuery();
			while (rsProduct.next()) {
				Product product = new Product(rsProduct.getString("product_Id"), rsProduct.getString("mfr_Id"),
						rsProduct.getString("description"), rsProduct.getBigDecimal("price"),
						rsProduct.getBigDecimal("qty_On_Hand"));
				order.setProduct(product);
			}
			rsProduct.close();
			orders.add(order);
		}

		rsOrder.close();
		stmt.close();
		conn.close();
		return orders;
	}

	@Override
	public Set<Order> getAllOrdersJoin() throws SQLException {
		Set<Order> orders = new HashSet<>();
		Connection conn = ConnectToDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement(
				"SELECT orders.order_num, orders.order_date, orders.mfr, products.product_id, products.mfr_id, "
						+ "products.description, products.price, products.qty_on_hand,  qty, amount FROM orders "
						+ "INNER   join products on orders.product = products.product_id");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Order order = new Order(rs.getBigDecimal("order_num"),
					new Product(rs.getString("product_Id"), rs.getString("mfr_Id"), rs.getString("description"),
							rs.getBigDecimal("price"), rs.getBigDecimal("qty_On_Hand")),
					rs.getDate("order_date"), rs.getString("mfr"), rs.getBigDecimal("qty"), rs.getBigDecimal("amount"));
			orders.add(order);
		}
		rs.close();
		stmt.close();
		conn.close();
		return orders;
	}

	@Override
	public Order findOrderById(BigDecimal id) throws SQLException {
		Connection conn = ConnectToDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM orders WHERE order_num = ?");
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
		return order;
	}

	@Override
	public boolean insertOrder(Order order) throws SQLException {
		return (new CRUDTemplate() {

			@Override
			public PreparedStatement setPreparedStatement(Order order, Connection conn) throws SQLException {
				String sql = "INSERT INTO orders values (?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setBigDecimal(1, order.getOrderNum());
				stmt.setDate(2, order.getOrderDate());
				stmt.setBigDecimal(3, null);
				stmt.setBigDecimal(4, null);
				stmt.setString(5, order.getMfr());
				stmt.setString(6, null);
				stmt.setBigDecimal(7, order.getQty());
				stmt.setBigDecimal(8, order.getAmount());
				return stmt;
			}
		}).operations(order);
	}

	@Override
	public boolean updateOrder(Order order) throws SQLException {
		return (new CRUDTemplate() {

			@Override
			public PreparedStatement setPreparedStatement(Order order, Connection conn) throws SQLException {
				String sql = "UPDATE orders SET qty=?, amount=?  WHERE order_num=?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setBigDecimal(1, order.getQty());
				stmt.setBigDecimal(2, order.getAmount());
				stmt.setBigDecimal(3, order.getOrderNum());
				return stmt;
			}
		}).operations(order);
	}

	public boolean deleteOrder(Order order) throws SQLException {
		return (new CRUDTemplate() {

			@Override
			public PreparedStatement setPreparedStatement(Order order, Connection conn) throws SQLException {
				String sql = "DELETE FROM orders WHERE order_num=?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setBigDecimal(1, order.getOrderNum());
				return stmt;
			}
		}).operations(order);
	}

	private abstract class CRUDTemplate {
		public boolean operations(Order order) throws SQLException {
			boolean result = false;
			Connection conn = null;
			PreparedStatement stmt = null;
			try {
				conn = ConnectToDB.getConnection();
				stmt = setPreparedStatement(order, conn);

				int rowsInserted = stmt.executeUpdate();
				if (rowsInserted > 0) {
					result = true;
				}
			} finally {
				stmt.close();
				conn.close();
			}
			return result;
		}

		public abstract PreparedStatement setPreparedStatement(Order order, Connection conn) throws SQLException;
	}

	@Override
	public boolean deleteOrder(BigDecimal id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
