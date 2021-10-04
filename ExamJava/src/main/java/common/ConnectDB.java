package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	
	private static Connection connect = null;
	private static String url = "jdbc:sqlserver://";
	private static String serverName = "LAPTOP-LP892MBM";
	private static String portNumber = "1433";
	private static String databaseName = "Baithi";
	private static String username = "sa";
	private static String password = "123456789";

	public static String getConnectionUrl() {
		return url + serverName + ":" + portNumber + "; databaseName=" + databaseName + "; user=" + username
				+ "; password=" + password;
	}

	public static Connection getConnection() {
		try {
			connect = DriverManager.getConnection(getConnectionUrl());
		} catch (Exception e) {
			e.printStackTrace();
			connect = null;
		}

		return connect;
	}

}
