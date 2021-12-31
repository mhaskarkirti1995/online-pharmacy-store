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

import com.google.gson.Gson;
import com.pharmacy.dao.CustomerDaoImpl;
import com.pharmacy.pojo.Customer;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	Customer customer;
	CustomerDaoImpl cdao=new CustomerDaoImpl();
	boolean flag;
	List<Customer> customerlist=new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		String key=request.getParameter("action");
		String operation=request.getParameter("name");
		
		if(operation!=null && operation.equals("checkemailid"))
		{
			String customerEmailId =request.getParameter("custemailid");
			customer = cdao.searchCustomerByEmailId(customerEmailId);
			if(customer != null)
			{
				String msg="You Have Already Registered";
				
				Gson gson =new Gson();//Gson is a class used for converting java obj to Json object
				 
				String message = gson.toJson(msg);
				 
				response.setContentType("application/json");//by default text/html
				
				out.print(message);
			}
			else
				out.print("");
		}
		else if(operation!=null && operation.equals("checkcustcontactno"))
		{
			long contactNumber=Long.parseLong(request.getParameter("custcontactno"));
			customer = cdao.searchCustomerByContactNo(contactNumber);
			
			if(customer != null)
			{
		
				String msg="Contact Number Already Exist";
				
				Gson gson =new Gson();//Gson is a class used for converting java obj to Json object 
				 
				String message = gson.toJson(msg);
				 
				response.setContentType("application/json");//by default text/html
				
				out.print(message);
			}
			else
				out.print("");
		}
		else if(operation!=null && operation.equals("checkcustpassword"))
		{
			String customerPassword=request.getParameter("custpassword");			
			customer = cdao.searchCustomerByPassword(customerPassword);
			
			if(customer != null)
			{
				String msg="Password Already Exist Please Choose Another";
				
				Gson gson =new Gson();//Gson is a class used for converting java obj to Json object 
				 
				String message = gson.toJson(msg);
				 
				response.setContentType("application/json");//by default text/html
				
				out.print(message);
			}
			else
				out.print("");
		}
		else if(key !=null && key.equals("delete"))
		{
			int customerId=Integer.parseInt(request.getParameter("custid"));
			flag=cdao.deleteCustomer(customerId);
			
			if(flag)
			{
				customerlist = cdao.displayAllCustomer();
				session.setAttribute("custlist", customerlist);
			
				request.setAttribute("status", "Customer has been deleted");
				
				//response.sendRedirect("CustomerList.jsp");
			}
			else
			{
				request.setAttribute("status", "Customer has not been deleted");
			}
			RequestDispatcher rd=request.getRequestDispatcher("CustomerList.jsp");
			rd.forward(request, response);
		}
		else if(key != null && key.equals("update"))
		{
			String customerEmailId=request.getParameter("custemailid");
			
			customer = cdao.searchCustomerByEmailId(customerEmailId);
		
			if(customer!=null)
			{
				session.setAttribute("cust", customer);
				response.sendRedirect("UpdateCustomer.jsp");
			}
			
		}
		else
		{
			customerlist = cdao.displayAllCustomer();
			session.setAttribute("custlist", customerlist);
			response.sendRedirect("CustomerList.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String customerName,customerEmailId,customerPassword,customerAddress;
		long contactNumber;
		int customerId;
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		String key=request.getParameter("action");
		
		if(key != null && key.equals("add"))
		{
			
			customerName=request.getParameter("custname");
			customerEmailId=request.getParameter("custemailid");
			customerPassword=request.getParameter("custpassword");
			contactNumber=Long.parseLong(request.getParameter("custcontactno"));
			customerAddress=request.getParameter("custaddress");
			
			
			customer = new Customer(customerName, customerEmailId, customerPassword, contactNumber, customerAddress);
			flag = cdao.addCustomer(customer);
			
			if(flag)
			{
			//	customerlist = cdao.displayAllCustomer();
				session.setAttribute("custlist", customerlist);
				
				request.setAttribute("status", "Your Registration has been done successfully");
				
				//response.sendRedirect("CustomerList.jsp");
			}	
			else
			{
				request.setAttribute("status", "Your Registration has not been done");
			}
			RequestDispatcher rd=request.getRequestDispatcher("AddCustomer.jsp");
			rd.include(request, response);
							
		}
		else if(key != null && key.equals("update"))
		{	
			customerId=Integer.parseInt(request.getParameter("custid"));
			customerName=request.getParameter("custname");
			customerEmailId=request.getParameter("custemailid");
			customerPassword=request.getParameter("custpass");
			contactNumber=Long.parseLong(request.getParameter("custcontact"));
			customerAddress=request.getParameter("custaddress");
			
			customer = new Customer(customerName, customerEmailId, customerPassword, contactNumber, customerAddress);
			customer.setCustomerId(customerId);
			
			flag=cdao.updateCustomer(customer);
			
			if(flag)
			{
			//	customerlist = cdao.displayAllCustomer();
			//	session.setAttribute("custlist", customerlist);
			//  response.sendRedirect("CustomerList.jsp");
				request.setAttribute("status", " Customer has been Updated");
			}	
			else
			{
					request.setAttribute("status", "Customer has not been Updated");
			}
			RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		}		
	}
}
