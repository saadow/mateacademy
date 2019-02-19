package lesson_jdbc_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class TemplateAbstract<T> {
	boolean operationTemplate(T t) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean result = false;
		try {
			conn = ConnectToDB.getConnection();
			stmt = returnPreparedStatement(t, conn);
			result = stmt.executeUpdate() > 0;
		} finally {
			stmt.close();
			conn.close();
		}
		return result;
	}

	abstract PreparedStatement returnPreparedStatement(T t, Connection conn) throws SQLException;
}
