package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pharmacy.dbutility.DBUtility;
import com.pharmacy.pojo.Customer;

public class CustomerDaoImpl implements CustomerDao
{
	Connection con=DBUtility.getConnection();
	int row;
	Customer customer;
	String addCust="insert into customer_22063 (customer_name,customer_email_id,customer_password,contact_number,customer_address) values(?,?,?,?,?)";
	String updateCust="update customer_22063 set customer_name=?,customer_email_id=?,customer_password=?,contact_number=?,customer_address=? where customer_id=?";
	String deleteCust="delete from customer_22063 where customer_id=?";
	String searchCustByEmailId="select * from customer_22063 where customer_email_id=?";
	String displayAllCustDetails="select * from customer_22063";
	String sortCustomer = "select * from customer_22063 order by customer_name asc" ;

	@Override
	public boolean addCustomer(Customer customer)
	{
		try
		{
			PreparedStatement ps=con.prepareStatement(addCust);
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getCustomerEmailId());
			ps.setString(3, customer.getCustomerPassword());
			ps.setLong(4, customer.getContactNumber());
			ps.setString(5, customer.getCustomerAddress());
			
			row=ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		if(row>0)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean updateCustomer(Customer customer) 
	{
		try
		{
		PreparedStatement ps=con.prepareStatement(updateCust);
		ps.setString(1, customer.getCustomerName());
		ps.setString(2, customer.getCustomerEmailId());
		ps.setString(3,customer.getCustomerPassword());
		ps.setLong(4, customer.getContactNumber());
		ps.setString(5, customer.getCustomerAddress());
		ps.setInt(6, customer.getCustomerId());
		
		row=ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) 
	{
		try
		{
			PreparedStatement ps=con.prepareStatement(deleteCust);
			ps.setInt(1, customerId);
			row=ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public Customer searchCustomerByEmailId(String customerEmailId) 
	{
		try
		{
			PreparedStatement ps=con.prepareStatement(searchCustByEmailId);
			ps.setString(1, customerEmailId);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				customer=new Customer 
						(
						rs.getString("customer_name"),
						rs.getString("customer_email_id"),
						rs.getString("customer_password"),
						rs.getLong("contact_number"),
						rs.getString("customer_address")
						);
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setCustomerEmailId(rs.getString("customer_email_id"));
				return customer;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Customer> displayAllCustomer()
	{
		List<Customer> custlist=new ArrayList<Customer>();
		try
		{
			PreparedStatement ps=con.prepareStatement(displayAllCustDetails);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{	
				customer=new Customer
					(
							rs.getString("customer_name"),
							rs.getString("customer_email_id"),
							rs.getString("customer_password"),
							rs.getLong("contact_number"),
							rs.getString("customer_address")
					);
				customer.setCustomerId(rs.getInt("customer_id"));
				custlist.add(customer);
				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		return custlist;
	}

	@Override
	public String getEncryptedPassword(String customerPassword) 
	{
		String customerPassword1="";
		
		char ch[]= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U',
					'V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
					'r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9','0','!','@','#',
					'$','%','^','&','*'};
		
		char ch1[]= { 'Z','Y','X','W','V','U','T','S','R','Q','P','O','N','M','L','K','J','I','H','G','F',
					  'E','D','C','B','A','z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k',
					  'j','i','h','g','f','e','d','c','b','a','0','9','8','7','6','5','4','3','2','1',
					   '*','&','^','%','$','#','@','!'};
		for(int i=0;i<customerPassword.length();i++)
		{
			for(int j=0;j<ch.length;j++)
			{
				if(customerPassword.charAt(i)==(j))
				{
					customerPassword1=customerPassword1+ch1[j];
				}
			}
		}
		
		return customerPassword1;
	}

	@Override
	public Customer searchCustomerByContactNo(long contactNumber) 
	{
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from customer_22063 where contact_number=?");
			ps.setLong(1, contactNumber);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				customer=new Customer 
						(
						rs.getString("customer_name"),
						rs.getString("customer_email_id"),
						rs.getString("customer_password"),
						rs.getLong("contact_number"),
						rs.getString("customer_address")
						);
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setCustomerEmailId(rs.getString("customer_email_id"));
				return customer;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer searchCustomerByPassword(String customerPassword) 
	{
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from customer_22063 where customer_password=?");
			ps.setString(1, customerPassword);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				customer=new Customer 
						(
						rs.getString("customer_name"),
						rs.getString("customer_email_id"),
						rs.getString("customer_password"),
						rs.getLong("contact_number"),
						rs.getString("customer_address")
						);
						customer.setCustomerId(rs.getInt("customer_id"));
						customer.setCustomerEmailId(rs.getString("customer_email_id"));
						return customer;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
}
