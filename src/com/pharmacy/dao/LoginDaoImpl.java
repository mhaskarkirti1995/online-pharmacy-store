package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pharmacy.dbutility.DBUtility;

public class LoginDaoImpl implements LoginDao 
{

	Connection con=DBUtility.getConnection();
	PreparedStatement ps;
	ResultSet rs;
	boolean flag;
	int row;
	
	@Override
	public boolean userLogin(String userName, String password) 
	{
		try
		{
			ps=con.prepareStatement("select * from customer_22063 where customer_email_id=? and customer_password=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			rs=ps.executeQuery();
			
			if(rs.next())
				flag=true;
			else
				flag=false;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean userChangePassword(String userName, String newPassword) 
	{
		try
		{
			ps=con.prepareStatement("update customer_22063 set customer_password=? where customer_email_id=?");
			ps.setString(1, newPassword);
			ps.setString(2, userName);
		
			row=ps.executeUpdate();
			if(row>0)
				flag=true;
			else
				flag=false;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return flag;

		
	}

	@Override
	public boolean adminLogin(String userName, String password) 
	{
		try
		{
			ps=con.prepareStatement("select * from admin_22063 where username=? and password=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			if(rs.next())
				flag=true;
			else 
				flag=false;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean adminChangePassword(String userName, String newPassword) 
	{
		
		try
		{
			ps=con.prepareStatement("update admin_22063 set password=? where username=?");
			ps.setString(1, newPassword);
			ps.setString(2, userName);
			
			row=ps.executeUpdate();
			
			if(row>0)
				flag=true;
			else
				flag=false;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return flag;
	}

}
