package lesson_jdbc_01;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

public class DBRun {
	public static void main(String[] args) throws SQLException {
		OrderDaoImpl odi = new OrderDaoImpl();
		Order order = new Order(BigDecimal.valueOf(111111), null, Date.valueOf("2019-02-14"), "REI",
				BigDecimal.valueOf(10), BigDecimal.valueOf(100));
		//System.out.println(odi.findOrderById(new BigDecimal(112961)));
		odi.insertOrder(order);
	}
}
