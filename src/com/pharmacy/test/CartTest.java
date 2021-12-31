package com.pharmacy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pharmacy.dao.CartDaoImpl;
import com.pharmacy.pojo.Cart;

public class CartTest 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner scanner=new Scanner(System.in);
		BufferedReader bufferreader=new BufferedReader(new InputStreamReader(System.in));
		int cartId,medicineId;
		String medicineName,customerEmailId;
		int medicineQty,choice;
		double medicinePrice;
		Cart cart;
		CartDaoImpl cdao=new CartDaoImpl();
		boolean flag;
		List<Cart> cartlist=new ArrayList<Cart>();
				
		while(true)
		{
		System.out.println("Enter \n"
				+ "1. Add To Cart \n"
				+ "2. Delete from Cart\n"
				+ "3. Clear Cart\n"
				+ "4. Show Cart\n"
				+ "5. Exit");
		System.out.println("Enter Choice : ");
		choice=scanner.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("----Add Medicine To Cart----");
			System.out.println("Enter medicine Id");
			medicineId=scanner.nextInt();
			System.out.println("Enter customer Email Id");
			customerEmailId=bufferreader.readLine();
			System.out.println("Enter medicine Quantity");
			medicineQty=scanner.nextInt();
			
			cart=new Cart(medicineId, customerEmailId, medicineQty );
			flag=cdao.addToCart(cart);
			if(flag==true)
			{
				System.out.println("Medicine added to Cart successfully");
			}
			else
			{
				System.out.println("failed");
			}
			break;
		case 2:
			System.out.println("----Delete from cart----");
			System.out.println("Enter cart Id");
			cartId=scanner.nextInt();
			flag=cdao.deleteFromCart(cartId);
			if(flag==true)
			{
				System.out.println("Medicine deleted successfully");
			}
			else
			{
				System.out.println("failed");
			}
			break;
		case 3:
			System.out.println("----Clear cart----");
			System.out.println("Enter customer Email Id");
			customerEmailId=bufferreader.readLine();
			flag=cdao.clearCart(customerEmailId);
			
			if(flag==true)
			{
				System.out.println("Cart clear successfully");
			}
			else
			{
				System.out.println("failed");
			}
			break;
		case 4:
			System.out.println("----Details of Cart----");
			System.out.println("Enter customer Email Id");
			customerEmailId=bufferreader.readLine();
			cartlist=cdao.showCart(customerEmailId);
			
			if(!cartlist.isEmpty())
			{
				for(Cart car:cartlist)
				{
					System.out.println(car);
				}
			}
			else
			{
				System.out.println("No such data");
			}
			
			break;
		case 5:
			System.exit(0);
			break;
			
		}
		}
		
	}

}
