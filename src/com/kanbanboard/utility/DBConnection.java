package com.kanbanboard.utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

	static Connection con;
	static String url;

	public static Connection getConnection()
	{
		try
		{
			Properties properties = new Properties();
			properties.setProperty("user", "root");
			properties.setProperty("password", "Madhu143");
			properties.setProperty("useSSL", "false");
			String url = "jdbc:mysql://127.0.0.1:3306/KanbanBoard?serverTimezone=CET";
			Class.forName("com.mysql.cj.jdbc.Driver");
			try
			{            	
				con = DriverManager.getConnection(url, properties); 
			}
			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		return con;
	}
}


