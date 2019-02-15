import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	protected static Connection conn = null;

	public static Connection getConnection() {

		try {
			// conncection to H2 server
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost//C://Users//DELL-//H2 Server", "shack", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return conn;
		}
	}
}
