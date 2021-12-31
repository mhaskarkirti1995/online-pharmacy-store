package com.pharmacy.dao;

import java.util.List;
import com.pharmacy.pojo.Medicine;

public interface MedicineDao 
{
	boolean addMedicine(Medicine medicine);
	boolean updateMedicine(Medicine medicine);
	boolean deleteMedicine(int medicineId);
	Medicine searchMedicineById(int medicineId);//admin
	List<Medicine> searchMedicineByMedicineName(String medicineName);//customer
	List<Medicine> searchMedicineByBrand(String medicineBrand);//customer
	List<Medicine> sortMedicineByMedicineName(String medicineName);//admin
	List<Medicine> showAllMedicine();
	
}
