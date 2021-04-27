package com.student.manage;

import java.sql.*;
public class ConnectionProvider {
	
	static Connection con;
	public static Connection createConnection() {
		
		try {
			// 1. load Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. create connection
			String userName = "root";
			String password = "difficultmysql";
			String url = "jdbc:mysql://localhost:3306/student_manage";
			
			con = DriverManager.getConnection(url, userName, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
}
