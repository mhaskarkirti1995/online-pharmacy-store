package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pharmacy.dbutility.DBUtility;
import com.pharmacy.pojo.Feedback;

public class FeedbackDaoImpl implements FeedbackDao
{

	Connection con=DBUtility.getConnection();
	PreparedStatement ps;
	ResultSet rs;
	int row;
	String custFeedback="insert into feedback_22063(customer_email_id,rate_medicine,suggestion) values(?,?,?)";
	String showAllFeedback="select * from feedback_22063";
	
	Feedback feedback;
	
	@Override
	public boolean addFeedback(Feedback feedback) 
	{
		try
		{
			ps=con.prepareStatement(custFeedback);
			
			ps.setString(1, feedback.getCustomerEmailId());
			ps.setInt(2, feedback.getRateMedicine());
			ps.setString(3, feedback.getSuggestion());
			
			row=ps.executeUpdate();
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public List<Feedback> showAllFeedback() 
	{
		List<Feedback> feedlist=new ArrayList<Feedback>();
		try
		{
			ps=con.prepareStatement(showAllFeedback);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				feedback=new Feedback 
						(
								rs.getString("customer_email_id"),
								rs.getInt("rate_medicine"),
								rs.getString("suggestion")
						);
				feedback.setFeedbackId(rs.getInt("feedback_id"));
				feedlist.add(feedback);
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return feedlist;
	}

}
