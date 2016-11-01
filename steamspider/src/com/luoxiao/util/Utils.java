package com.luoxiao.util;


import java.sql.DriverManager;
import java.sql.SQLException;


public class Utils {

	//获取数据库连接对象
	public java.sql.Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/steam_spider";
		String username = "root";
		String password = "1111";
		java.sql.Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
	
}
