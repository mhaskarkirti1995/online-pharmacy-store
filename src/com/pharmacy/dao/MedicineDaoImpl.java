package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pharmacy.dbutility.DBUtility;
import com.pharmacy.pojo.Medicine;

public class MedicineDaoImpl implements MedicineDao 
{
	Connection con=DBUtility.getConnection();
	int row;
	Medicine medicine;
	String addMed="insert into medicine_22063(medicine_name,medicine_type,medicine_brand,medicine_description ,medicine_qty,mfg_date,expiry_date,medicine_price,medicine_image) values(?,?,?,?,?,?,?,?,?)";
	String updateMed="update medicine_22063 set medicine_name=?,medicine_type=?,medicine_brand=?,medicine_description=? ,medicine_qty=?,mfg_date=?,expiry_date=?,medicine_price=?,medicine_image=? where medicine_id=?";
	String deleteMed="delete from medicine_22063 where medicine_id=? ";
	String searchMedById="select * from medicine_22063 where medicine_id=? ";
	String searchMedByName="select * from medicine_22063 where medicine_name=? ";
	String searchMedByBrand="select * from medicine_22063 where medicine_brand=? ";
	String showAllMed="select * from medicine_22063";
	String sortMedicine = "select * from medicine_22063 order by medicine_name asc" ;
	
	@Override
	public boolean addMedicine(Medicine medicine) 
	{
		try
		{
			PreparedStatement ps=con.prepareStatement(addMed);
			ps.setString(1, medicine.getMedicineName());
			ps.setString(2, medicine.getMedicineType());
			ps.setString(3, medicine.getMedicineBrand());
			ps.setString(4, medicine.getMedicineDescription());
			ps.setInt(5, medicine.getMedicineQty());
			ps.setString(6, medicine.getMfgDate());
			ps.setString(7, medicine.getExpiryDate());
			ps.setDouble(8, medicine.getMedicinePrice());
			ps.setBinaryStream(9, medicine.getMedicineImage());
			
			row=ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateMedicine(Medicine medicine) 
	{
		try
		{
			PreparedStatement ps=con.prepareStatement(updateMed);
			ps.setString(1, medicine.getMedicineName());
			ps.setString(2, medicine.getMedicineType());
			ps.setString(3, medicine.getMedicineBrand());
			ps.setString(4, medicine.getMedicineDescription());
			ps.setInt(5, medicine.getMedicineQty());
			ps.setString(6, medicine.getMfgDate());
			ps.setString(7, medicine.getExpiryDate());
			ps.setDouble(8, medicine.getMedicinePrice());
			ps.setBinaryStream(9, medicine.getMedicineImage());
			ps.setInt(10,medicine.getMedicineId());
			
			row=ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;

	}

	@Override
	public boolean deleteMedicine(int medicineId) 
	{
		try
		{
		PreparedStatement ps=con.prepareStatement(deleteMed);
		ps.setInt(1, medicineId);
		row=ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public Medicine searchMedicineById(int medicineId) 
	{
		try
		{
			PreparedStatement ps=con.prepareStatement(searchMedById);
			ps.setInt(1, medicineId);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				medicine=new Medicine
					(
						rs.getString("medicine_name"),
						rs.getString("medicine_type"),
						rs.getString("medicine_brand"),
						rs.getString("medicine_description"),
						rs.getInt("medicine_qty"),
						rs.getString("mfg_date"),
						rs.getString("expiry_date"),
						rs.getDouble("medicine_price")
					);
				medicine.setMedicineId(rs.getInt("medicine_id"));
				medicine.setMedicineImage(rs.getBinaryStream("medicine_image"));
				return medicine;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Medicine> searchMedicineByMedicineName(String medicineName) 
	{
		List<Medicine> medlist=new ArrayList<Medicine>();
		try
		{
			PreparedStatement ps = con.prepareStatement("select * from medicine_22063 where medicine_name like ? or medicine_brand like ?");
			ps.setString(1,"%"+medicineName+"%");
			ps.setString(2,"%"+medicineName+"%");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				medicine = new Medicine(
						rs.getString("medicine_name"),
						rs.getString("medicine_type"),
						rs.getString("medicine_brand"),
						rs.getString("medicine_description"),
						rs.getInt("medicine_qty"),
						rs.getString("mfg_date"),
						rs.getString("expiry_date"),
						rs.getDouble("medicine_price")
					);
				medicine.setMedicineId(rs.getInt("medicine_id"));
				medicine.setMedicineImage(rs.getBinaryStream("medicine_image"));
				medlist.add(medicine);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return medlist;
	}

	@Override
	public List<Medicine> searchMedicineByBrand(String medicineBrand) 
	{
		List<Medicine> medlist=new ArrayList<Medicine>();
		try
		{
			PreparedStatement ps=con.prepareStatement(searchMedByBrand);
			ps.setString(1, medicineBrand);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				medicine=new Medicine(
						rs.getString("medicine_name"),
						rs.getString("medicine_type"),
						rs.getString("medicine_brand"),
						rs.getString("medicine_description"),
						rs.getInt("medicine_qty"),
						rs.getString("mfg_date"),
						rs.getString("expiry_date"),
						rs.getDouble("medicine_price")
					);
				medicine.setMedicineId(rs.getInt("medicine_id"));
				medlist.add(medicine);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return medlist;
		
	}

	@Override
	public List<Medicine> showAllMedicine() 
	{
		List<Medicine> medlist=new ArrayList<Medicine>();
		try
		{
			PreparedStatement ps=con.prepareStatement(showAllMed);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				medicine=new Medicine(
						rs.getString("medicine_name"),
						rs.getString("medicine_type"),
						rs.getString("medicine_brand"),
						rs.getString("medicine_description"),
						rs.getInt("medicine_qty"),
						rs.getString("mfg_date"),
						rs.getString("expiry_date"),
						rs.getDouble("medicine_price")
					);
				medicine.setMedicineId(rs.getInt("medicine_id"));
				medicine.setMedicineImage(rs.getBinaryStream("medicine_image"));
				medlist.add(medicine);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return medlist;
	}

	@Override
	public List<Medicine> sortMedicineByMedicineName(String medicineName)
	{
		List<Medicine> medlist=new ArrayList<Medicine>();
		try
		{
			PreparedStatement ps=con.prepareStatement(sortMedicine);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				medicine=new Medicine(
						rs.getString("medicine_name"),
						rs.getString("medicine_type"),
						rs.getString("medicine_brand"),
						rs.getString("medicine_description"),
						rs.getInt("medicine_qty"),
						rs.getString("mfg_date"),
						rs.getString("expiry_date"),
						rs.getDouble("medicine_price")
					);
				medicine.setMedicineId(rs.getInt("medicine_id"));
				medicine.setMedicineImage(rs.getBinaryStream("medicine_image"));
				medlist.add(medicine);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return medlist;
	}

}
