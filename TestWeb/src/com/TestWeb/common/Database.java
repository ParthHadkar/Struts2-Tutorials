package com.TestWeb.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	private static Connection conn = null;
	private static String serverUrl = "jdbc:mysql://localhost:3306/struts2";//?useSSL=false
	private static String userName = "root";
	private static String password = "";
	
	public static Connection getDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(serverUrl, userName, password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
