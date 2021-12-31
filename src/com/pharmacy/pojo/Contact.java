package com.pharmacy.pojo;

public class Contact
{
	private int contactId;
	private String firstName,lastName,emailId,subject,message;
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Contact(String firstName, String lastName, String emailId, String subject, String message) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.subject = subject;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", subject=" + subject + ", message=" + message + "]";
	}
	
	
	
}
