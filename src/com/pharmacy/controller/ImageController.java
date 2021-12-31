package com.pharmacy.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmacy.dao.MedicineDaoImpl;
import com.pharmacy.pojo.Medicine;


@WebServlet("/ImageController")
public class ImageController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
   		int medicineId = Integer.parseInt(request.getParameter("medid"));
   		
   		MedicineDaoImpl mdao = new MedicineDaoImpl();
   		
   		Medicine medicine = mdao.searchMedicineById(medicineId);
   		
   		InputStream medicineImage = medicine.getMedicineImage();
   		 
   		OutputStream out = response.getOutputStream();
   		
   		int i;
   		
   		while((i=medicineImage.read())!=-1 )
   		{
   			out.write(i);
   		}
   		
   		medicineImage.close();
   		out.close();
   		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
