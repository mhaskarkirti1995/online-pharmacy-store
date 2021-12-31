package com.pharmacy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.pharmacy.dao.CustomerDaoImpl;
import com.pharmacy.pojo.Customer;


public class CustomerTest
{

	public static void main(String[] args) throws IOException 
	{
		Scanner scanner=new Scanner(System.in);
		BufferedReader bufferreader=new BufferedReader(new InputStreamReader(System.in));
		int customerId,choice;
		long contactNumber;
		String customerName,customerEmailId,customerPassword,customerAddress;
		Customer customer;
		boolean flag;
		CustomerDaoImpl cdao=new CustomerDaoImpl();
		List<Customer> custlist=new ArrayList<Customer>();
		
		while(true)
		{
		System.out.println("Enter\n"
				+ "1. Add Customer\n"
				+ "2. Update Customer\n"
				+ "3. Delete Customer \n"
				+ "4. Search Customer By Email Id\n"
				+ "5. Show All Customer Details\n"
				+ "6. Exit ");
		choice=scanner.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("----Add Customer----");
			System.out.println("Enter customer name : ");
			customerName=bufferreader.readLine();
			System.out.println("Enter cutsomer email ID : ");
			customerEmailId=bufferreader.readLine();
			System.out.println("Enter password : ");
			customerPassword=bufferreader.readLine();
			System.out.println("Enter Contact Number : ");
			contactNumber=scanner.nextLong();
			System.out.println("Enter cutsomer Address : ");
			customerAddress=bufferreader.readLine();
			
			customer=new Customer(customerName, customerEmailId, customerPassword, contactNumber, customerAddress);
			flag=cdao.addCustomer(customer);
			
			if(flag==true)
			{
				System.out.println("Customer added successfully");
			}
			else
			{
				System.out.println("Failed");
			}
			break;
		case 2:
			System.out.println("----Update Details----");
			System.out.println("Enter existing customer ID : ");
			customerId=scanner.nextInt();
			
			custlist=cdao.displayAllCustomer();
			Iterator<Customer> itr=custlist.iterator();
			Customer objCustomer=null;
			while(itr.hasNext())
			{
				Customer cust=itr.next();
				if(cust.getCustomerId()==customerId)
				{
					objCustomer=cust;
				}
			}
			if(objCustomer !=null && objCustomer.getCustomerId()>0)
			{
				System.out.println("Enter customer name : ");
				customerName=bufferreader.readLine();
				System.out.println("Enter cutsomer email ID : ");
				customerEmailId=bufferreader.readLine();
				System.out.println("Enter password : ");
				customerPassword=bufferreader.readLine();
				System.out.println("Enter Contact Number : ");
				contactNumber=scanner.nextLong();
				System.out.println("Enter cutsomer Address : ");
				customerAddress=bufferreader.readLine();
				
				customer=new Customer(customerName, customerEmailId, customerPassword, contactNumber ,customerAddress);
				customer.setCustomerId(customerId);
				flag=cdao.updateCustomer(customer);
				
			if(flag==true)
			{
				System.out.println("Customer updated successfully");
			}
			else
			{
				System.out.println("Failed");
			}
			}
			else
			{
				System.out.println("Enter valid cust id");
			}
			
			break;
		case 3:
			System.out.println("----Delete Record----");
			System.out.println("Enter existing customer ID : ");
			customerId=scanner.nextInt();
			flag=cdao.deleteCustomer(customerId);
		
			if(flag==true)
			{
				System.out.println("Customer deleted successfully");
			}
			else
			{
				System.out.println("Failed");
			}
			break;
		case 4:
			System.out.println("----Search customer By email Id----");
			System.out.println("Enter Email Id");
			customerEmailId=bufferreader.readLine();
			
			customer=cdao.searchCustomerByEmailId(customerEmailId);
			if(customer!=null)
			{
				System.out.println(customer);
			}
			else
			{
				System.out.println("No such Customer...");
			}
			break;
		case 5:
			System.out.println("----All Customer Details----");
			custlist=cdao.displayAllCustomer();
			if(!custlist.isEmpty())
			{
				for(Customer cust : custlist)
				{
					System.out.println(cust);
				}
			}
			else
			{
				System.out.println("No such customer ");
			}
			break;
		case 6:
			System.exit(0);
		default:
			System.out.println("Please enter valid choice");
		}
		}
	}

}
