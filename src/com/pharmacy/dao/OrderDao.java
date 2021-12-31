package com.pharmacy.dao;

import java.util.List;

import com.pharmacy.pojo.Customer;
import com.pharmacy.pojo.Order;

public interface OrderDao 
{
	Order placeOrder(String customerEmailId);//this is for core java
	Order placeOrder(String customerEmailId,double totalBill);//this is for adv java
	List<Order> showAllOrder(String customerEmailId);//for customer
	List<Order> showAllOrder();//For admin
	List<Order> searchOrderByCustomerEmailId(String customerEmailId);
	boolean cancelOrder(int orderId);
	
	
}
