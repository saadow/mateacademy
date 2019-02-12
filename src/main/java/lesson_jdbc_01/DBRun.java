package lesson_jdbc_01;

import java.math.BigDecimal;
import java.sql.SQLException;

public class DBRun {
	public static void main(String[] args) throws SQLException {
		OrderDaoImpl odi = new OrderDaoImpl();
		System.out.println(odi.findOrderById(new BigDecimal(112961)));
	}
}
