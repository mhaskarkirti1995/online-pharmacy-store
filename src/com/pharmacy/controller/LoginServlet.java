package com.pharmacy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pharmacy.dao.LoginDaoImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	LoginDaoImpl ldao=new LoginDaoImpl();
	boolean flag;
	
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 	{
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("Index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String type,username,password,key;
		
		key=request.getParameter("action");
		
		type=request.getParameter("type");
		username=request.getParameter("uname");
		password=request.getParameter("pass");
		
		HttpSession session=request.getSession();
		
		PrintWriter out=response.getWriter();
		
		if(key!=null && key.equals("login"))
		{
			if(type!=null && type.equals("customer"))
			{
				flag=ldao.userLogin(username, password);
				
				if(flag==true)
				{
					session.setAttribute("user", username);//session set for user login
					response.sendRedirect("Index.jsp");
				}
				else
				{
					request.setAttribute("status", "Please enter correct Credentials");
				}
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			}
			else if(type!=null && type.equals("admin"))
			{
				
				flag=ldao.adminLogin(username, password);
				
				if(flag==true)
				{
					session.setAttribute("admin", username);//session set for admin login
					response.sendRedirect("Index.jsp");
				}
				else
				{
					request.setAttribute("status", "Please enter correct Credentials");
				}
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			}
		}
		else if(key!=null && key.equals("change"))
		{
			if(type!=null && type.equals("customer"))
			{
				flag=ldao.userChangePassword(username, password);
				if(flag==true)
				{
					request.setAttribute("status", "Password changed successfully");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("status", "Password has not been changed ");
					RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
					rd.forward(request, response);
				}
				
			}
			else if(type!=null && type.equals("admin"))
			{
				flag=ldao.adminChangePassword(username, password);
				
				if(flag==true)
				{
					request.setAttribute("status", "Password changed successfully");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("status", "Password has not been changed ");
					RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
					rd.forward(request, response);
				}
				
			}
		}
	}

}
