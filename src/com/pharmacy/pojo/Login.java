package com.pharmacy.pojo;

public class Login
{
	private String userName,newPassword,password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Login(String userName, String password, String newPassword) {
		super();
		this.userName = userName;
		this.password = password;
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", Password=" + password + ", newPassword=" + newPassword + "]";
	}
	
	
}
