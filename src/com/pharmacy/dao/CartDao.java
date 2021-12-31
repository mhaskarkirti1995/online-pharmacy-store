package com.pharmacy.dao;

import java.util.List;

import com.pharmacy.pojo.Cart;

public interface CartDao 
{
	boolean addToCart(Cart cart);
	boolean deleteFromCart(int cartId);
	boolean updateMedicineQuantity(int cartId, int medicineQuantity);
	boolean clearCart(String customerEmailId);
	List<Cart> showCart(String customerEmailId);
	
}
