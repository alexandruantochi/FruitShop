package eu.ubis.eshop.bf.integration.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelperClass {
	private static Connection connection;
	private static final String URL = "jdbc:mysql://localhost/eshop?useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	private ConnectionHelperClass() {
	}

	public static Connection getMysqlConnection() {

		if (connection == null) {
			try {
				System.out.println("LOADING DRIVER...");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("DRIVER LOADED...");
				System.out.println("INITIALIZING CONNECTION...");
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				System.out.println("CONNECTION INITIALIZED!");
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("Cannot find the driver in the classpath!", e);
			} catch (SQLException e) {
				throw new IllegalStateException("Cannot connect the database!", e);
			}
		}

		return connection;
	}

}
