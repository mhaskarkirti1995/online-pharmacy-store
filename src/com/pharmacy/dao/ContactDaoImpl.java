package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pharmacy.dbutility.DBUtility;
import com.pharmacy.pojo.Contact;

public class ContactDaoImpl implements ContactDao 
{
	PreparedStatement ps;
	ResultSet rs;
	Connection con=DBUtility.getConnection();
	String addContactDetails="insert into contact_22063 (first_name,last_name,email_id,subject,message) values(?,?,?,?,?)";
	String showAllDetails="select * from contact_22063";
	int row;
	Contact contact;
	
	@Override
	public boolean addContactDetails(Contact contact) 
	{
		try
		{
			ps=con.prepareStatement(addContactDetails);
			
			ps.setString(1, contact.getFirstName());
			ps.setString(2, contact.getLastName());
			ps.setString(3, contact.getEmailId());
			ps.setString(4, contact.getSubject());
			ps.setString(5, contact.getMessage());
			
			row = ps.executeUpdate();
			
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
	public List<Contact> showAllDetails() 
	{
		List<Contact> contactlist = new ArrayList<Contact>();
		try
		{
			ps=con.prepareStatement(showAllDetails);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				contact = new Contact
						(
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("email_id"),
							rs.getString("subject"),
							rs.getString("message")
						);
				contact.setContactId(rs.getInt("contact_id"));
				contactlist.add(contact);
				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return contactlist;
	}

}
