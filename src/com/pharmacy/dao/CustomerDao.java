package com.pharmacy.dao;

import java.util.List;

import com.pharmacy.pojo.Customer;

public interface CustomerDao
{
	boolean addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(int customerId);
	Customer searchCustomerByEmailId(String customerEmailId);
	Customer searchCustomerByContactNo(long contactNumber);
	Customer searchCustomerByPassword(String customerPassword);
	List<Customer> displayAllCustomer();
	String getEncryptedPassword(String customerPassword);
	
	
}
