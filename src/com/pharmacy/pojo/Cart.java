package com.pharmacy.pojo;

public class Cart 
{
	private int cartId,medicineId;
	private String medicineName,customerEmailId;
	private int medicineQty;
	private double medicinePrice;
	
	public Cart()
	{
		
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
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
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public int getMedicineQty() {
		return medicineQty;
	}
	public void setMedicineQty(int medicineQty) {
		this.medicineQty = medicineQty;
	}
	public double getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
		
	public Cart(int cartId,int medicineId, String medicineName, String customerEmailId, int medicineQty,
			double medicinePrice) 
	{
		super();
		this.cartId = cartId;
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.customerEmailId = customerEmailId;
		this.medicineQty = medicineQty;
		this.medicinePrice = medicinePrice;
	}

	
	public Cart(int medicineId, String customerEmailId, int medicineQty) {
		super();
		this.medicineId = medicineId;
		this.customerEmailId = customerEmailId;
		this.medicineQty = medicineQty;
	}
	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", medicineId=" + medicineId + ", medicineName=" + medicineName
				+ ", customerEmailId=" + customerEmailId + ", medicineQty=" + medicineQty + ", medicinePrice="
				+ medicinePrice + "]";
	}
	
	
}
