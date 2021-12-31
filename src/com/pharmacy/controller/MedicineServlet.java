package com.pharmacy.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.pharmacy.dao.MedicineDaoImpl;
import com.pharmacy.pojo.Medicine;

@MultipartConfig
@WebServlet("/MedicineServlet")
public class MedicineServlet extends HttpServlet 
{
		Medicine medicine;
		MedicineDaoImpl mdao=new MedicineDaoImpl();
		List<Medicine> medicinelist=new ArrayList<Medicine>();
		boolean flag;
				
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			PrintWriter out =response.getWriter();
			HttpSession session = request.getSession();
			
			String key = request.getParameter("action");
			
			if(key != null && key.equals("delete"))
			{
				int medicineId = Integer.parseInt(request.getParameter("medid"));
				flag=mdao.deleteMedicine(medicineId);
				
				if(flag)
				{
					medicinelist = mdao.showAllMedicine();
					session.setAttribute("medlist", medicinelist);//medlist is name of attribute ,and medicinelist is the refernce of List
					request.setAttribute("status", " Your Item has been deleted");		
						
					//response.sendRedirect("MedicineList.jsp");
				}
				else
				{
					request.setAttribute("status", "Your Item has not been deleted");
				}
				RequestDispatcher rd=request.getRequestDispatcher("MedicineList.jsp");
				rd.forward(request, response);
			}
			else if(key !=null && key.equals("update"))
			{
				int medicineId = Integer.parseInt(request.getParameter("medid"));
				medicine = mdao.searchMedicineById(medicineId);
				session.setAttribute("med", medicine);
				response.sendRedirect("UpdateMedicine.jsp");
			}
			else if(key !=null && key.equals("details"))
			{
				int medicineId = Integer.parseInt(request.getParameter("medid"));
				medicine =mdao.searchMedicineById(medicineId);
				
				session.setAttribute("med", medicine);
				
				response.sendRedirect("MedicineDetails.jsp");
			}
			  else if(key !=null && key.equals("search")) 
			  {
				String medicineName = request.getParameter("medname"); 
				medicinelist = mdao.searchMedicineByMedicineName(medicineName);
			  
				session.setAttribute("medlist", medicinelist);
				response.sendRedirect("MedicineList.jsp");
			   
			  }
			 else if(key !=null && key.equals("sort"))
			 {
				 String medicineName = request.getParameter("medname");
				 medicinelist = mdao.sortMedicineByMedicineName(medicineName);
				 
				 session.setAttribute("medlist", medicinelist);
				 response.sendRedirect("MedicineList.jsp"); 
			}
			else
			{
				medicinelist = mdao.showAllMedicine();
				session.setAttribute("medlist", medicinelist);//medlist is name of attribute ,and medicinelist is the refernce of List
				response.sendRedirect("MedicineList.jsp");
	
			}			
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			String medicineName,medicineType,medicineBrand,medicineDescription,mfgDate,expiryDate;
			int medicineQty,medicineId;
			double medicinePrice;
			InputStream medicineImage;
			
			Part part = null;
			
			PrintWriter out=response.getWriter();
			HttpSession session=request.getSession();
			
			String key=request.getParameter("action");
			if(key!=null && key.equals("add"))
			{
				medicineName=request.getParameter("medname");
				medicineType=request.getParameter("medtype");
				medicineBrand=request.getParameter("medbrand");
				medicineDescription=request.getParameter("meddescription");
				medicineQty=Integer.parseInt(request.getParameter("medqty"));
				mfgDate=request.getParameter("mfgdate");
				expiryDate=request.getParameter("expirydate");
				medicinePrice=Double.parseDouble(request.getParameter("medprice"));
				
				part = request.getPart("medimage");
				medicineImage = part.getInputStream();
				
				medicine=new Medicine(medicineName, medicineType, medicineBrand, medicineDescription, medicineQty, mfgDate, expiryDate, medicinePrice);
				medicine.setMedicineImage(medicineImage);
				
				flag=mdao.addMedicine(medicine);
				
				if(flag==true)
				{
					medicinelist = mdao.showAllMedicine();
					session.setAttribute("medlist", medicinelist);//medlist is name of attribute ,and medicinelist is the refernce of List
					request.setAttribute("status", "Your Item has been Added");				
					//response.sendRedirect("MedicineList.jsp");
				}
				else
				{
					request.setAttribute("status", "Your Item has not been Added");
				}
									
				RequestDispatcher rd=request.getRequestDispatcher("MedicineList.jsp");
				rd.forward(request, response);
				
			}
			else if(key!=null && key.equals("update"))
			{
				medicineId=Integer.parseInt(request.getParameter("medid"));
				medicineName=request.getParameter("medname");
				medicineType=request.getParameter("medtype");
				medicineBrand=request.getParameter("medbrand");
				medicineDescription=request.getParameter("meddescription");
				medicineQty=Integer.parseInt(request.getParameter("medqty"));
				mfgDate=request.getParameter("mfgdate");
				expiryDate=request.getParameter("expirydate");
				medicinePrice=Double.parseDouble(request.getParameter("medprice"));
				
				part = request.getPart("medimage");
				
				if(part.getSize()!=0)
				{
					medicineImage = part.getInputStream();
				}
				else
				{
					medicine = mdao.searchMedicineById(medicineId);
					medicineImage = medicine.getMedicineImage();
				}
					
				medicine=new Medicine(medicineName, medicineType, medicineBrand, medicineDescription, medicineQty, mfgDate, expiryDate, medicinePrice);
				medicine.setMedicineImage(medicineImage);
				medicine.setMedicineId(medicineId);
				
				flag=mdao.updateMedicine(medicine);
				
				if(flag)
				{
					medicinelist = mdao.showAllMedicine();
					session.setAttribute("medlist", medicinelist);//medlist is name of attribute ,and medicinelist is the refernce of List
					
					request.setAttribute("status", " Your Item has been Updated");
					
					//response.sendRedirect("MedicineList.jsp");
				}
				else
				{
					request.setAttribute("status", " Your Item has not been Updated");
				}
				RequestDispatcher rd=request.getRequestDispatcher("MedicineList.jsp");
				rd.forward(request, response);
				
			}
			
		}
}
