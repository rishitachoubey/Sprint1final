package com.cg.onlinegrocery.domain;
import java.util.List;

import javax.persistence.*;
/**
 * This Customer class will store all the details of Customer
 * 
 * @author RC 
 */

@Entity
	@Table(name = "customers")
	public class Customer{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "customer_id")
		private int customerId;

		@Column(name = "fname")
		private String fName;

		@Column(name = "lName")
		private String lName;

		@Column(name = "email_id")
		private String emailId;

		@Column(name = "phone")
		private String phone;
		
		@Column(name="address")
		private String address;

		@OneToMany(mappedBy = "customerId")
		private List<Order> orders;

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		
		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public List<Order> getOrders() {
			return orders;
		}

		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}

		public String getfName() {
			return fName;
		}

		public void setfName(String fName) {
			this.fName = fName;
		}

		public String getlName() {
			return lName;
		}

		public void setlName(String lName) {
			this.lName = lName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		
	}

