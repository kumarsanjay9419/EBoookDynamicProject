package com.sk.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static Connection conn;
	
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
	 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook-app","root","root"); 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
