package com.pharmacy.dao;

public interface LoginDao 
{
	boolean userLogin(String userName,String oldPassword);
	boolean userChangePassword(String userName, String newPassword);
	boolean adminLogin(String userName,String password);
	boolean adminChangePassword(String userName,String newPassword);
}
