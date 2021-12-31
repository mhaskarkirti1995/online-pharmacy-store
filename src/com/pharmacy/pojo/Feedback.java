package com.pharmacy.pojo;

public class Feedback
{
	private int feedbackId,rateMedicine;
	private String customerEmailId,suggestion;
	
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
		
	
	public int getRateMedicine() {
		return rateMedicine;
	}
	public void setRateMedicine(int rateMedicine) {
		this.rateMedicine = rateMedicine;
	}
	public Feedback( String customerEmailId, int rateMedicine, String suggestion) {
		super();
	//	this.feedbackId = feedbackId;
		this.customerEmailId = customerEmailId;
		this.rateMedicine = rateMedicine;
		this.suggestion = suggestion;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", customerEmailId=" + customerEmailId + ", rateMedicine=" + rateMedicine + ", suggestion=" + suggestion
				+ "]";
	}

		
	
}
