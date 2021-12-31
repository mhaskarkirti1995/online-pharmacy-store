package com.pharmacy.pojo;

public class Order
{
	private int orderId;
	private String customerEmailId,orderStatus;
	private double totalBill;
	private String orderdate;
	
	public Order()
	{
		
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public Order(int orderId, String customerEmailId, String orderdate, String orderStatus, double totalBill) {
		super();
		this.orderId = orderId;
		this.customerEmailId = customerEmailId;
		this.orderdate = orderdate;
		this.orderStatus = orderStatus;
		this.totalBill = totalBill;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerEmailId=" + customerEmailId + ", orderdate=" + orderdate
				+ ", orderStatus=" + orderStatus + ", totalBill=" + totalBill + "]";
	}
	
	
	
	
}
