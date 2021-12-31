package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pharmacy.dbutility.DBUtility;
import com.pharmacy.pojo.Cart;

public class CartDaoImpl implements CartDao
{
	Connection con=DBUtility.getConnection();
	PreparedStatement ps;
	ResultSet rs;
	int row;
	Cart cart;
	String addCart="insert into cart_22063(medicine_id,customer_email_id,medicine_qty) values(?,?,?)";
	String deleteCart="delete from cart_22063 where cart_id=?";
	String clearCart="delete  from cart_22063 where customer_email_id=?";
	String showAll="select c.cart_id,c.medicine_id ,m.medicine_name,c.customer_email_id,c.medicine_qty,m.medicine_price"
			+ " from medicine_22063 m inner join cart_22063 c on c.medicine_id=m.medicine_id where c.customer_email_id=?";
	
	@Override
	public boolean addToCart(Cart cart) 
	{
		try
		{
			PreparedStatement ps=con.prepareStatement(addCart);
			ps.setInt(1, cart.getMedicineId());
			ps.setString(2, cart.getCustomerEmailId());
			ps.setInt(3, cart.getMedicineQty());
			
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
	public boolean deleteFromCart(int cartId) 
	{
		try
		{
			ps=con.prepareStatement(deleteCart);
			ps.setInt(1, cartId);
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
	public boolean clearCart(String customerEmailId) 
	{
		try
		{
			PreparedStatement ps=con.prepareStatement(clearCart);
			ps.setString(1, customerEmailId);
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
	public List<Cart> showCart(String customerEmailId)
	{
		List<Cart> cartlist=new ArrayList<Cart>();
		try
		{
			PreparedStatement ps=con.prepareStatement(showAll);
			ps.setString(1, customerEmailId);
			rs=ps.executeQuery();

			while(rs.next())
			{
				cart=new Cart
						(
						rs.getInt("cart_id"),
						rs.getInt("medicine_id"),
						rs.getString("medicine_name"),
						rs.getString("customer_email_id"),
						rs.getInt("medicine_qty"),
						rs.getInt("medicine_price")
						);
				cartlist.add(cart);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return cartlist;
	}

	@Override
	public boolean updateMedicineQuantity(int cartId, int medicineQuantity) 
	{
		try
		{
			ps = con.prepareStatement("update cart_22063 set medicine_qty=? where cart_id=?");
			ps.setInt(1, medicineQuantity);
			ps.setInt(2, cartId);
			
			row=ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(row > 0)
			return true;
		else
			return false;
	}
	
}
