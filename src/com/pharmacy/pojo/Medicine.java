package com.pharmacy.pojo;

import java.io.InputStream;
import java.sql.Date;

public class Medicine 
{
	private int medicineId;
	private String medicineName,medicineType,medicineBrand,medicineDescription;
	private int medicineQty;
	private String mfgDate , expiryDate;
	private double medicinePrice ;
	private InputStream medicineImage;
	
	
	public InputStream getMedicineImage() {
		return medicineImage;
	}
	public void setMedicineImage(InputStream medicineImage) {
		this.medicineImage = medicineImage;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getMedicineType() {
		return medicineType;
	}
	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}
	public String getMedicineBrand() {
		return medicineBrand;
	}
	public void setMedicineBrand(String medicineBrand) {
		this.medicineBrand = medicineBrand;
	}
	public String getMedicineDescription() {
		return medicineDescription;
	}
	public void setMedicineDescription(String medicineDescription) {
		this.medicineDescription = medicineDescription;
	}
	public int getMedicineQty() {
		return medicineQty;
	}
	public void setMedicineQty(int medicineQty) {
		this.medicineQty = medicineQty;
	}
	public String getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public double getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
	
	public Medicine(String medicineName, String medicineType, String medicineBrand, String medicineDescription,
			int medicineQty, String mfgDate, String expiryDate, double medicinePrice) {
		super();
		this.medicineName = medicineName;
		this.medicineType = medicineType;
		this.medicineBrand = medicineBrand;
		this.medicineDescription = medicineDescription;
		this.medicineQty = medicineQty;
		this.mfgDate = mfgDate;
		this.expiryDate = expiryDate;
		this.medicinePrice = medicinePrice;
	}
	
	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineType="
				+ medicineType + ", medicineBrand=" + medicineBrand + ", medicineDescription=" + medicineDescription
				+ ", medicineQty=" + medicineQty + ", mfgDate=" + mfgDate + ", expiryDate=" + expiryDate
				+ ", medicinePrice=" + medicinePrice + "]";
	}
	
	
	
}
