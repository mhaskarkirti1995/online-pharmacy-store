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
import com.pharmacy.dao.OrderDaoImpl;
import com.pharmacy.pojo.Customer;
import com.pharmacy.pojo.Order;


@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	OrderDaoImpl odao=new OrderDaoImpl();
	boolean flag;
	Order order;
	Customer customer ;
	CustomerDaoImpl cdao =new CustomerDaoImpl();
	List<Order> orderlist= new ArrayList<Order>();
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 	{
		PrintWriter out=response.getWriter();
 		HttpSession session=request.getSession();
 		
 		String key=request.getParameter("action");	
 		if(key!=null && key.equals("showallorders"))
 		{
 			orderlist = odao.showAllOrder();
 			
 			session.setAttribute("ordlist", orderlist);
 			
 			response.sendRedirect("OrderList.jsp");
 		}
 		else if(key!=null && key.equals("myorders"))
 		{
 			String customerEmailId=request.getParameter("custemailid");
 			customer = cdao.searchCustomerByEmailId(customerEmailId);
 			
 			orderlist = odao.showAllOrder(customerEmailId);
 			if(!orderlist.isEmpty())
 			{
 				session.setAttribute("ordlist", orderlist);
 			//	response.sendRedirect("OrderList.jsp");
 			}
 			else
 			{
 				session.setAttribute("ordlist", orderlist);
 				request.setAttribute("status", "No Such Order");
 			}
 			RequestDispatcher rd=request.getRequestDispatcher("OrderList.jsp");
			rd.forward(request, response);
 		}
 		else if(key!=null && key.equals("cancelorder")) 
		{
			
				int orderId = Integer.parseInt(request.getParameter("orderid"));
				
				flag=odao.cancelOrder(orderId);
				
				if(flag)
				{
					session.setAttribute("ordlist", orderlist);//
					request.setAttribute("status", "Your Order Has Been Cncelled");
				}
				RequestDispatcher rd=request.getRequestDispatcher("OrderList.jsp");
				rd.forward(request, response);
		}
 		else if(key !=null && key.equals("searchorder"))
 		{
 			String customerEmailId = request.getParameter("custemailid"); 
 			orderlist = odao.searchOrderByCustomerEmailId(customerEmailId);
 		
 			session.setAttribute("ordlist", orderlist);
 			response.sendRedirect("OrderList.jsp");
 		}
 		else
 		{
 			List<Order> orderlist = odao.showAllOrder();
			session.setAttribute("ordlist", orderlist);
			response.sendRedirect("OrderServlet");
 		}
 	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String key=request.getParameter("action");
		String customerEmailId = (String)session.getAttribute("user");
		double totalBill=0;
		
		if(key!=null && key.equals("placeorder")) 
		{
			String medicineQuantity[] = request.getParameterValues("medqty");
			String medicinePrice[] = request.getParameterValues("medprice");
			
			for(int i=0;i<medicineQuantity.length;i++)
			{
				totalBill = totalBill + (Integer.parseInt(medicineQuantity[i]) * Double.parseDouble(medicinePrice[i]));//calculation of bill
			}
			
			Order order = odao.placeOrder(customerEmailId, totalBill);
			
			if(order!=null)	//this is for print bill
			{
				request.setAttribute("placeorder", order);
				request.setAttribute("status", "Your Order Has Been Placed");
			}
			else
			{
				request.setAttribute("status", "Your Order Has Not Been Placed");
		  		
			}
			RequestDispatcher rd=request.getRequestDispatcher("Order.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("status", "Your Order Has Not Been Placed");
		}
		RequestDispatcher rd=request.getRequestDispatcher("Order.jsp");
		rd.forward(request, response);
	}
}


