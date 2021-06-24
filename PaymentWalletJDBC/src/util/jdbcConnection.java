package util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcConnection {
	
	private static Properties p;

	// Static initializer block
	static {
		try {
			p = new Properties();
			// Loading the file - "dbinfo.txt"
			p.load(new FileReader("src/util/dbUtil.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// private Constructor to avoid instantiation
	private jdbcConnection() {
	}

	/**
	 *  Method that returns jdbcConnection object
	 * 
	 * @return conn (jdbcConnection object)
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String driver = p.getProperty("driver");
		Connection conn = null;

		// Registering driver
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}

		// Get jdbcConnection
		conn =  DriverManager.getConnection(url, username, password);

		return conn;

	}

}
