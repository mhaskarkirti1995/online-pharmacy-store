package com.pharmacy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pharmacy.dao.CustomerDaoImpl;
import com.pharmacy.dao.FeedbackDaoImpl;
import com.pharmacy.pojo.Customer;
import com.pharmacy.pojo.Feedback;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	Feedback feedback;
    FeedbackDaoImpl fdao =new FeedbackDaoImpl();
    boolean flag;
    List<Feedback> feedbacklist =new ArrayList<>();
    Customer customer;
	CustomerDaoImpl cdao=new CustomerDaoImpl();
	
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 	{
 		HttpSession session=request.getSession();
 		PrintWriter out=response.getWriter();
 		
 		String key=request.getParameter("action");
 		
 		if(key != null && key.equals("update"))
		{
			String customerEmailId=request.getParameter("custemailid");
			
			customer = cdao.searchCustomerByEmailId(customerEmailId);
		
			if(customer!=null)
			{
				session.setAttribute("cust", customer);
				response.sendRedirect("AddFeedback.jsp");
			}
		}
 		else
 		{
	 		feedbacklist=fdao.showAllFeedback();
	 		session.setAttribute("feedlist", feedbacklist);
	 		response.sendRedirect("FeedbackList.jsp");
 		}
 	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		String customerEmailId,suggestion;
		int rateMedicine;
		
		customerEmailId=request.getParameter("custemailid");
		rateMedicine=Integer.parseInt(request.getParameter("ratemed"));
		suggestion=request.getParameter("suggestion");
		
		feedback = new Feedback(customerEmailId, rateMedicine, suggestion);
		System.out.println(feedback);
		flag = fdao.addFeedback(feedback);
		
		if(flag)
		{
			
			  request.setAttribute("status", "We Appreciate Your Feedback  ");
			  
			  RequestDispatcher rd=request.getRequestDispatcher("AddFeedback.jsp");
			  rd.include(request,response);
			 	
		}
		else
		{
			out.print("Failed");
		}
	}
}
