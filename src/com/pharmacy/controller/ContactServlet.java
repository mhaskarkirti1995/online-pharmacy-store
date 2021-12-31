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

import com.pharmacy.dao.ContactDaoImpl;
import com.pharmacy.pojo.Contact;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Contact contact;
	ContactDaoImpl cdao =new ContactDaoImpl();
	List<Contact> contactlist = new ArrayList<Contact>();
	boolean flag;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();

		String key=request.getParameter("action");
		if(key !=null && key.equals("contactlist"))
		{
			contactlist = cdao.showAllDetails();
			session.setAttribute("conlist", contactlist);
			response.sendRedirect("contactlist.jsp");
		}
		else
		{
			out.print("failed");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String firstName,lastName,emailId,subject,message;
		PrintWriter out = response.getWriter();
		
		firstName=request.getParameter("fname");
		lastName=request.getParameter("lname");
		emailId=request.getParameter("emailid");
		subject=request.getParameter("subject");
		message=request.getParameter("message");
		
		contact = new Contact(firstName, lastName, emailId, subject, message);
		
		flag = cdao.addContactDetails(contact);
		
		if(flag==true)
		{
			request.setAttribute("status", "Your Meassage Sent Successfully");
		}
		else
		{
			request.setAttribute("status", "Your Meassage Has Not Sent ");
		}
			
		RequestDispatcher rd=request.getRequestDispatcher("contact.jsp");
		rd.include(request, response);
	}

}
