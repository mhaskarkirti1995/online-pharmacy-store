package com.pharmacy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pharmacy.dao.FeedbackDaoImpl;
import com.pharmacy.pojo.Feedback;

public class FeedbackTest {

	public static void main(String[] args) throws IOException
	{
		Scanner scanner=new Scanner(System.in);
		BufferedReader bufferreader=new BufferedReader(new InputStreamReader(System.in));
		String rateUs;
		String customerEmailId,suggestion;
		int choice,rateMedicine;
		FeedbackDaoImpl fdao=new FeedbackDaoImpl();
		Feedback feedback;
		boolean flag;
		List<Feedback> feedlist=new ArrayList<>();
		
		while(true)
		{
		System.out.println("Enter\n"
				+ "1. Add Feedback\n"
				+ "2. Show All Feedback\n"
				+ "3. Exit ");
		choice=scanner.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("----Add Feedback----");
			System.out.println("Enter cutsomer emailID : ");
			customerEmailId=bufferreader.readLine();
			System.out.println("Enter medicine rating between 1 to 5: ");
			rateMedicine=scanner.nextInt();
			System.out.println("Enter Suggestion : ");
			suggestion=bufferreader.readLine();
			
			feedback=new Feedback(customerEmailId,rateMedicine, suggestion);
			
			flag=fdao.addFeedback(feedback);
			if(flag==true)
				System.out.println("Feedback added successfully");
			else
				System.out.println("Failed");
			break;
		case 2:
			System.out.println("----All Feedback----");
			
			feedlist=fdao.showAllFeedback();
			
			if(!feedlist.isEmpty())
			{
				for(Feedback feed : feedlist)
				{
					System.out.println(feed);
				}
			}
			else
			{
				System.out.println("No such feedback");
			}
			break;
			
		}
		}
		
	}

}
