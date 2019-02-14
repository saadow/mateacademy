package lesson_jdbc_02;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import oracle.jdbc.driver.OracleDriver;

public class DatabaseUtility {

	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USER = "MA_STUDENT";
	public static final String PASS = "KOLOBOK";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Locale.setDefault(Locale.ENGLISH);
			ComboPooledDataSource dataSource = getDataSource();
			conn = dataSource.getConnection();
		} catch (PropertyVetoException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static ComboPooledDataSource getDataSource() throws PropertyVetoException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl(URL);
		cpds.setUser(USER);
		cpds.setPassword(PASS);

		// Optional Settings
		cpds.setInitialPoolSize(5);
		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		cpds.setMaxStatements(100);

		return cpds;
	}
}