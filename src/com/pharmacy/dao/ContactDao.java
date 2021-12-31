package com.pharmacy.dao;

import java.util.List;

import com.pharmacy.pojo.Contact;

public interface ContactDao 
{
	boolean addContactDetails(Contact contact);//customer
	List<Contact> showAllDetails();//admin
}
