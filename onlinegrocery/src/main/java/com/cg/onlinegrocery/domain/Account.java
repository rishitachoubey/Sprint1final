//package com.cg.onlinegrocery.domain;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
///**
// * This Account class will store all the details of the account
// * 
// * @author
// */
//
//@Entity
//public class Account {
//	@Id
//	@GeneratedValue
//
//	private int userID;
//	private String FirstName;
//	private String lastName;
//	private String email;
//	private String address;
//	public Integer accountType = 0; // 1 as admin 0 as user
//	private String password;
//
//	
//	public Account(int userID, String firstName, String lastName, String email, String address, Integer accountType,
//			String password) {
//		super();
//		this.userID = userID;
//		FirstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.address = address;
//		this.accountType = accountType;
//		this.password = password;
//	}
//	// Generating Getter Setters
//	public int getUserID() {
//		return userID;
//	}
//	public void setUserID(int userID) {
//		this.userID = userID;
//	}
//	public String getFirstName() {
//		return FirstName;
//	}
//	public void setFirstName(String firstName) {
//		FirstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public Integer getAccountType() {
//		return accountType;
//	}
//	public void setAccountType(Integer accountType) {
//		this.accountType = accountType;
//	}
//
//
//
//
//}