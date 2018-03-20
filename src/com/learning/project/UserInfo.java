package com.learning.project;

public class UserInfo {
	RegisteredUserSample registeredUser;
	String firstName;
	String lastName;
	String email;
	String address;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	public RegisteredUserSample getRegisteredUser()
	{
		return registeredUser;
	}
	
	public RegisteredUserSample setRegisteredUser(RegisteredUserSample registeredUser)
	{
		return this.registeredUser=registeredUser;
	}

}
