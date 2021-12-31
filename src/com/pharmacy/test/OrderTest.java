package com.pharmacy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pharmacy.dao.OrderDaoImpl;
import com.pharmacy.pojo.Order;

public class OrderTest {

	public static void main(String[] args) throws IOException
	{
		Scanner scanner=new Scanner(System.in);
		BufferedReader bufferreader=new BufferedReader(new InputStreamReader(System.in));
		int orderId,choice;
		String customerEmailId,orderStatus;
		double totalBill;
		String orderdate;
		Order order;
		OrderDaoImpl odao=new OrderDaoImpl();
		List<Order> ordlist=new ArrayList<Order>();
		boolean flag;
		while(true)
		{
		System.out.println("Enter \n"
				+ "1. Place Order \n"
				+ "2. Show All Order(Customer) \n"
				+ "3. Show All Order(Admin)\n"
				+ "4. Cancel Order\n"
				+ "5. Exit");
		
		System.out.println("Enter Choice : ");
		choice=scanner.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("----Place Order----");
			System.out.println("Enter customer Email Id : ");
			customerEmailId=bufferreader.readLine();
			
			order=odao.placeOrder(customerEmailId);
			System.out.println("Your order has been placed and your id is "+order.getOrderId());
			System.out.println(order);
			
			break;
		case 2:
			System.out.println("----Show All Orders to Customer");
			System.out.println("Enter customer Email Id");
			customerEmailId=bufferreader.readLine();
			ordlist=odao.showAllOrder(customerEmailId);
			if(!ordlist.isEmpty())
			{
				for(Order ord : ordlist)
				{
					System.out.println(ord);
				}
			}
			else
			{
				System.out.println("No such order");
			}
			break;
		case 3:
			System.out.println("----Show All Orders to Admin");
			ordlist=odao.showAllOrder();
			if(!ordlist.isEmpty())
			{
				for(Order ord : ordlist)
				{
					System.out.println(ord);
				}
			}
			else
			{
				System.out.println("No such order");
			}
			break;
		case 4:
			System.out.println("----Cancel Order----");
			System.out.println("Enter customer Order Id");
			orderId=scanner.nextInt();
		
			flag=odao.cancelOrder(orderId);
			
			if(flag)
			{
				System.out.println("Order cancel successfully");
			}
			else
			{
				System.out.println("failed");
			}
			break;
		case 5:
			System.exit(0);
			default:
				System.out.println("Please enter valid choice");
		}
		}
	}

}
