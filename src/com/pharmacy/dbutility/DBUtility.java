package com.pharmacy.dbutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility 
{
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/pharmacy_22063", "root", "9082695154");
		}
		catch(ClassNotFoundException | SQLException ex)
		{
			ex.printStackTrace();
		}
		return con;
	}
}
