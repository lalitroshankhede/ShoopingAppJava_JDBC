package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConn() {
		Connection con=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://IMCVBCP157-MSL2\\SQLEXPRESS2019;databaseName=ProductConnection;user=sa;password=Password_123");
			 
			
		} catch (ClassNotFoundException | SQLException e) {	
		}	
		return con;
	}
}
