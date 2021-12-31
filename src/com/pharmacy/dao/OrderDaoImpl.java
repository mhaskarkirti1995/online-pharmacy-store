package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.pharmacy.dbutility.DBUtility;
import com.pharmacy.pojo.Customer;
import com.pharmacy.pojo.Order;

public class OrderDaoImpl implements OrderDao
{
	Connection con=DBUtility.getConnection();
	PreparedStatement ps;
	ResultSet rs;
	int row;
	String status="Processing";
	double totalBill;
	Order order=new Order();
	long ms=System.currentTimeMillis();
	Date orderDate= new Date(ms);
	//Date date=new Date();
	//String orderDate=date.toString();
	
	CartDaoImpl cdao=new CartDaoImpl();
	
	String placeOrder="insert into orders_22063 (customer_email_id,order_status,total_bill,order_date) values(?,?,?,?) ";
	String showAllOrderCust="select * from orders_22063 where customer_email_id=?";
	String showAllOrderAdmin="select * from  orders_22063 ";
	String searchOrderByCustEmailId="select * from orders_22063 where customer_email_id like ?";
	
	@Override
	public Order placeOrder(String customerEmailId) 
	{
		try
		{
			//totalBill
			ps=con.prepareStatement("select sum(m.medicine_price * c.medicine_qty) as TotalBill from medicine_22063 m inner join cart_22063 c "
					+ "on m.medicine_id=c.medicine_id where customer_email_id=?");
			ps.setString(1, customerEmailId);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				totalBill = rs.getDouble("TotalBill");
				ps=con.prepareStatement(placeOrder);
				ps.setString(1, customerEmailId);
				ps.setString(2, status);
				ps.setDouble(3, totalBill);
				ps.setDate(4, orderDate);
				
				row=ps.executeUpdate();
				cdao.clearCart(customerEmailId);//for clear cart once order placed
				
				if(row>0)
				{
					ps=con.prepareStatement("select * from orders_22063 where customer_email_id=? and order_date=?");
					ps.setString(1,customerEmailId);
					ps.setDate(2, orderDate);
					
					rs=ps.executeQuery();
					if(rs.next())
					{
						order.setOrderId(rs.getInt("order_id"));
						order.setCustomerEmailId(rs.getString("customer_Email_Id"));
						order.setOrderStatus(rs.getString("order_status"));
						order.setTotalBill(rs.getDouble("total_bill"));
						order.setOrderdate(rs.getString("order_date"));
						
					}
					
				}
			}
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();;
		}
		return order;
	}

	@Override
	public Order placeOrder(String customerEmailId, double totalBill)//this is for adv java 
	{
		try
		{
			ps=con.prepareStatement(placeOrder);
			ps.setString(1, customerEmailId);
			ps.setString(2, "status");
			ps.setDouble(3, totalBill);
			ps.setDate(4, orderDate);
			
			row=ps.executeUpdate();
			cdao.clearCart(customerEmailId);//for clear cart once order placed
			
			if(row>0)
			{
				ps=con.prepareStatement("select * from orders_22063 where customer_email_id=? and order_date=? order by order_id desc");
				ps.setString(1,customerEmailId);
				ps.setDate(2, orderDate);
				
				rs=ps.executeQuery();
				if(rs.next())
				{
					order.setOrderId(rs.getInt("order_id"));
					order.setCustomerEmailId(rs.getString("customer_Email_Id"));
					order.setOrderStatus(rs.getString("order_status"));
					order.setTotalBill(rs.getDouble("total_bill"));
					order.setOrderdate(rs.getString("order_date"));
				}
			}
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return order;
	}

	@Override
	public List<Order> showAllOrder(String customerEmailId) 
	{
		List<Order> ordlist=new ArrayList<Order>();
		try
		{
			ps=con.prepareStatement(showAllOrderCust);
			ps.setString(1, customerEmailId);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
			order=new Order
					(
						rs.getInt("order_id"),//rs.getInt(1),//its column index no 
						rs.getString("customer_email_id"),//rs.getString(2),
						rs.getString("order_date"),
						rs.getString("order_status"),
						rs.getDouble("total_bill")
						
					);
				ordlist.add(order);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ordlist;
	}

	@Override
	public List<Order> showAllOrder()
	{
		List<Order> ordlist=new ArrayList<Order>();
		try
		{
			ps=con.prepareStatement(showAllOrderAdmin);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				order=new Order
						(
								rs.getInt("order_id"),
								rs.getString("customer_email_id"),
								rs.getString("order_date"),
								rs.getString("order_status"),
								rs.getDouble("total_bill")
						);
				ordlist.add(order);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ordlist;
	}

	@Override
	public boolean cancelOrder(int orderId) 
	{
		try
		{
			ps=con.prepareStatement("update orders_22063 set order_status=? where order_id=?");
			ps.setString(1, "Cancelled");
			ps.setInt(2, orderId);
			
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
	public List<Order> searchOrderByCustomerEmailId(String customerEmailId) 
	{
		List<Order> ordlist=new ArrayList<Order>();
		try
		{
			ps=con.prepareStatement(searchOrderByCustEmailId);
			ps.setString(1,"%"+customerEmailId+"%");
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				order=new Order
						(
								rs.getInt("order_id"),
								rs.getString("customer_email_id"),
								rs.getString("order_date"),
								rs.getString("order_status"),
								rs.getDouble("total_bill")
						);
				
				ordlist.add(order);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ordlist;
	}

	
}
