package com.learning.project;

public class AccountSample {
	
	UserInfo userInfo;
	UserInfo jointUser;
	String accountType;
	String accountNumber;
	double balance;
	boolean approved;
	boolean deleted;
	boolean isJointAccount;
	
	
	public UserInfo getUser() {
		return userInfo;
	}
	public void setUser(UserInfo user) {
		this.userInfo = user;
	}
	public UserInfo getJointUser() {
		return jointUser;
	}
	public void setJointUser(UserInfo jointUser) {
		this.jointUser = jointUser;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public boolean isDelete() {
		return deleted;
	}
	public void setDelete(boolean delete) {
		this.deleted = delete;
	}
	public boolean isJointUser() {
		return isJointAccount;
	}
	public void setJointUser(boolean isJointUser) {
		this.isJointAccount = isJointUser;
	}
	@Override
	public String toString() {
		/*StringBuilder builder = new StringBuilder();
		builder.append("AccountSample [user=").append(user).append(", jointUser=").append(jointUser)
				.append(", accountType=").append(accountType).append(", accountNumber=").append(accountNumber)
				.append(", balance=").append(balance).append(", approved=").append(approved).append(", delete=")
				.append(delete).append(", isJointUser=").append(isJointUser).append("]");
		return builder.toString();*/
		
		return String.format(
				"Account [userInfo=%s, jointUser=%s, accountNumber=%s, accountType=%s, balance=%s, approved=%s, deleted=%s, isJointAccount=%s]",
				userInfo, jointUser, accountNumber, accountType, balance, approved, deleted, isJointAccount);
	}
	
	
	

}
