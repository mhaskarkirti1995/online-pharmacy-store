package com.pharmacy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.pharmacy.dao.MedicineDaoImpl;
import com.pharmacy.pojo.Medicine;

public class MedicineTest {

	public static void main(String[] args) throws IOException
	{
		Scanner scanner=new Scanner(System.in);
		BufferedReader bufferreader=new BufferedReader(new InputStreamReader(System.in));
		String medicineName,medicineType,medicineBrand,medicineDescription,mfgDate , expiryDate;
		int medicineId,medicineQty,choice;
		double medicinePrice ;
		boolean flag;
		Medicine medicine;
		MedicineDaoImpl mdao=new MedicineDaoImpl();	
		List<Medicine> medlist=new ArrayList<Medicine>();
		
		while(true)
		{
		System.out.println("Enter \n"
				+ "1. Add Medicine \n"
				+ "2. Update Medicine \n"
				+ "3. Delete Medicine\n"
				+ "4. SearchMedicineById\n"
				+ "5. SearchMedicineByName\n"
				+ "6. SearchMedicineByBrand\n"
				+ "7. Show All Medicines\n"
				+ "8. Exit");
		System.out.println("Enter Choice : ");
		choice=scanner.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("----Add Medicine----");
			System.out.println("Enter medicine name : ");
			medicineName=bufferreader.readLine();
			System.out.println("Enter medicine type : ");
			medicineType=bufferreader.readLine();
			System.out.println("Enter medicine brand : ");
			medicineBrand=bufferreader.readLine();
			System.out.println("Enter medicine description : ");
			medicineDescription=bufferreader.readLine();
			System.out.println("Enter medicine quantity : ");
			medicineQty=scanner.nextInt();
			System.out.println("Enter medicine Manufacture date : ");
			mfgDate=bufferreader.readLine();
			System.out.println("Enter medicine expiry date : ");
			expiryDate=bufferreader.readLine();
			System.out.println("Enter medicine price : ");
			medicinePrice=scanner.nextDouble();
			
			medicine=new Medicine(medicineName,medicineType,medicineBrand,medicineDescription,medicineQty,mfgDate,expiryDate,medicinePrice);
			flag=mdao.addMedicine(medicine);
		
			if(flag==true)
			{
				System.out.println("Medicine added successfully");
			}
			else
			{
				System.out.println("failed");
			}
			break;
		case 2:
			System.out.println("----Update Details----");
			
			System.out.println("Enter existing medicineId For update medicine details : ");
			medicineId=scanner.nextInt();
			
			medlist=mdao.showAllMedicine();
			Iterator<Medicine> itr=medlist.iterator();
			Medicine objMedicine=null;
			
			while(itr.hasNext())
			{
				Medicine med=itr.next();
				if(med.getMedicineId()==medicineId)
				{
					objMedicine=med;
				}
			}
			if(objMedicine!=null && objMedicine.getMedicineId()>0)
			{
			System.out.println("Enter medicine name : ");
			medicineName=bufferreader.readLine();
			System.out.println("Enter medicine type : ");
			medicineType=bufferreader.readLine();
			System.out.println("Enter medicine brand : ");
			medicineBrand=bufferreader.readLine();
			System.out.println("Enter medicine description : ");
			medicineDescription=bufferreader.readLine();
			System.out.println("Enter medicine quantity : ");
			medicineQty=scanner.nextInt();
			System.out.println("Enter medicine Manufacture date : ");
			mfgDate=bufferreader.readLine();
			System.out.println("Enter medicine expiry date : ");
			expiryDate=bufferreader.readLine();
			System.out.println("Enter medicine price : ");
			medicinePrice=scanner.nextDouble();
			
			medicine=new Medicine(medicineName,medicineType,medicineBrand,medicineDescription,medicineQty,mfgDate,expiryDate,medicinePrice);
			medicine.setMedicineId(medicineId);
			flag=mdao.updateMedicine(medicine);
			
			if(flag==true)
			{
				System.out.println("Medicine Updated successfully");
			}
			else
			{
				System.out.println("failed");
			}
			}
			else
			{
				System.out.println("Enter Valid Medicine Id");
			}
			break;
		case 3:
			System.out.println("----Delete Medicine----");
			System.out.println("Enter existing Medicine Id : ");
			medicineId=scanner.nextInt();
			flag=mdao.deleteMedicine(medicineId);
			if(flag==true)
			{
				System.out.println("Medicine deleted successfully");
			}
			else
			{
				System.out.println("failed");
			}
			break;
		case 4:
			System.out.println("----Search Medicine By Id----");
			System.out.println("Enter existing Medicine Id : ");
			medicineId=scanner.nextInt();
			
			medicine=mdao.searchMedicineById(medicineId);
			
			if(medicine !=null)
			{
				System.out.println(medicine);
			}
			else
			{
				System.out.println("No such Id...");
			}

			break;
		case 5:
			System.out.println("----Search Medicine By Name----");
			System.out.println("Enter Medicine Name : ");
			medicineName=bufferreader.readLine();
			
			medlist=mdao.searchMedicineByMedicineName(medicineName);
			
			if(!medlist.isEmpty())
			{
				for(Medicine med : medlist)
				{
					System.out.println(med);
				}
			}
			else
			{
				System.out.println("No such Medicine found...");
			}
			break;
		case 6:
			System.out.println("----Search Medicine By Brand----");
			System.out.println("Enter  Medicine Brand : ");
			medicineBrand=bufferreader.readLine();
			
			medlist=mdao.searchMedicineByBrand(medicineBrand);
			
			if(!medlist.isEmpty())
			{
				for(Medicine med : medlist)
				{
					System.out.println(med);
				}
			}
			else
			{
				System.out.println("No such Medicine found...");
			}
			
			break;
		case 7:
			System.out.println("----Show All Medicine----");
			medlist=mdao.showAllMedicine();
			if(!medlist.isEmpty())
			{
				for(Medicine med : medlist)
				{
					System.out.println(med);
				}
			}
			else
			{
				System.out.println("No such Data found...");
			}
			break;
		default:
			System.out.println("Enter valid choice");
			break;
		case 8:
			System.out.println("Thanking You For Visiting");
			System.exit(0);
		}
		}
	}

}
