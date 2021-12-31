package com.pharmacy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.pharmacy.dao.LoginDaoImpl;

public class LoginTest {

	public static void main(String[] args) throws IOException 
	{
		String userName,newPassword,password;
		Scanner scanner=new Scanner(System.in);
		BufferedReader bufferreader=new BufferedReader(new InputStreamReader(System.in));
		int choice;
		boolean flag;
		LoginDaoImpl ldao=new LoginDaoImpl(); 
		while(true)
		{
		System.out.println("Enter \n"
				+ "1. User Login \n"
				+ "2. User Change Password \n"
				+ "3. Admin Login\n"
				+ "4. Admin Change Password\n"
				+ "5. Exit\n");
		
		System.out.println("Enter Choice : ");
		choice=scanner.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("----User Login----");
			System.out.println("Enter user Name : ");
			userName=bufferreader.readLine();
			System.out.println("Enter password : ");
			password=bufferreader.readLine();
			
			flag=ldao.userLogin(userName, password);
			
			if(flag)
				System.out.println("successfully added");
			else
				System.out.println("Failed");
			
			break;
		case 2:
			System.out.println("Enter user Name : ");
			userName=bufferreader.readLine();
			System.out.println("Enter New Password : ");
			newPassword=bufferreader.readLine();
			
			flag=ldao.userChangePassword(userName, newPassword);
			if(flag)
				System.out.println("Password successfully changed");
			else
				System.out.println("Failed");
			break;
		case 3:
			System.out.println("----Admin Login----");
			System.out.println("Enter user Name : ");
			userName=bufferreader.readLine();
			System.out.println("Enter password : ");
			password=bufferreader.readLine();
			
			flag=ldao.adminLogin(userName, password);
			
			if(flag)
				System.out.println("successfully Login");
			else
				System.out.println("Enter valid usename and password");
			
			break;
		case 4:
			System.out.println("----Admin Change Password----");
			System.out.println("Enter user Name : ");
			userName=bufferreader.readLine();
			System.out.println("Enter New Password : ");
			newPassword=bufferreader.readLine();
			
			flag=ldao.adminChangePassword(userName, newPassword);
			if(flag)
				System.out.println("Password successfully changed");
			else
				System.out.println("Enter valid usename and password");
			break;

		case 5:
			System.exit(0);
		default:
			System.out.println("Please enter valid choice");
		}
		}
	}

}
