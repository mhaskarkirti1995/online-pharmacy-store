package com.pharmacy.pojo;

public class Customer
{
	private int customerId;
	private long contactNumber;
	private String customerName,customerEmailId,customerPassword,customerAddress;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
		
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public Customer(String customerName, String customerEmailId, String customerPassword, long contactNumber,
			String customerAddress) {
		super();
		this.customerName = customerName;
		this.customerEmailId = customerEmailId;
		this.customerPassword = customerPassword;
		this.contactNumber = contactNumber;
		this.customerAddress = customerAddress;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmailId="
				+ customerEmailId + ", customerPassword=" + customerPassword + ", contactNumber=" + contactNumber
				+ ", customerAddress=" + customerAddress + "]";
	}
	
	
}
