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

import com.pharmacy.dao.CartDaoImpl;
import com.pharmacy.pojo.Cart;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	Cart cart=new Cart();
	CartDaoImpl cdao=new CartDaoImpl();
	boolean flag;
	List<Cart> clist=new ArrayList<>();
			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			PrintWriter out=response.getWriter();
			HttpSession session=request.getSession();
			String key=request.getParameter("action");
			
			String customerEmailId=(String)session.getAttribute("user");
		
		if(key!=null && key.equals("addtocart"))
		{
			boolean present=false;
			int medicineId=Integer.parseInt(request.getParameter("medid"));
			clist=cdao.showCart(customerEmailId);
			
			for(Cart c:clist)
			{
				//to check th medicine already present or not
				int m=c.getMedicineId();
				if(m==medicineId)
				{
					//if medicine already present in cart in this if loop
					present=true;
					int cartmquantity=c.getMedicineQty();
					int medicineQuantity=cartmquantity+1;
					flag=cdao.updateMedicineQuantity(c.getCartId(), medicineQuantity);
				}
			}
			if(present==false)
			{
				//if medicine not present in cart then in this if loop
				cart.setMedicineQty(1);
				cart.setMedicineId(medicineId);
				cart.setCustomerEmailId(customerEmailId);
				flag=cdao.addToCart(cart);
			}
			if(flag)
			{
				//	clist=cdao.showCart(customerEmailId);
				//	session.setAttribute("cartlist", clist);
					request.setAttribute("status", "Your Item has been added to cart");
				//	response.sendRedirect("Index.jsp");
			}	
			else
			{
				request.setAttribute("status", "Your Item has not been added to cart");
			}
			RequestDispatcher rd=request.getRequestDispatcher("MedicineList.jsp");
			rd.forward(request, response);
		}
		else if(key!=null && key.equals("delete"))
		{
				int cartId = Integer.parseInt(request.getParameter("cartid"));
				flag = cdao.deleteFromCart(cartId);
			
			  if(flag)
			  {
				  clist = cdao.showCart(customerEmailId); 
				  session.setAttribute("cartlist",clist); 
				  request.setAttribute("status", "Your Item has been deleted");
			  }
			  else
			  {
				request.setAttribute("status", "Your Item has not been deleted");
			  }
			  
			  RequestDispatcher rd=request.getRequestDispatcher("CartList.jsp");
			  rd.forward(request, response);
		}
		else
		{
			clist=cdao.showCart(customerEmailId);
			session.setAttribute("cartlist", clist);
			response.sendRedirect("CartList.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int medicineQuantity , cartId;
		String key=request.getParameter("action");
		PrintWriter out =response.getWriter();
		
		if(key!=null && key.equals("updatequantity"))
		{
			medicineQuantity = Integer.parseInt(request.getParameter("medicineQuantity"));
			cartId = Integer.parseInt(request.getParameter("cartId"));
			
			flag=cdao.updateMedicineQuantity(cartId, medicineQuantity);
		
			/*
			 * if(flag) out.print("done"); else out.print("Not Done");
			 */	 
		}
	}
}
