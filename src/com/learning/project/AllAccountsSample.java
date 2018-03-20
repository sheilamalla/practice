package com.learning.project;

public class AllAccountsSample {
	
	private String userName;
	private long accountNumber;
	private String accountType;
	private String path;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return String.format("AllAccountsSample [userName=%s, accountNumber=%s, accountType=%s, path=%s]", userName,
				accountNumber, accountType, path);
	}
	

}
