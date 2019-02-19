package lesson_jdbc_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface TemplateInterface {
	default boolean operationTemplate() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean result = false;
		try {
			conn = ConnectToDB.getConnection();
			stmt = returnPrepareStatement(conn);
			result = stmt.executeUpdate() > 0;
		} finally {
			stmt.close();
			conn.close();
		}
		return result;
	}

	PreparedStatement returnPrepareStatement(Connection conn) throws SQLException;
}