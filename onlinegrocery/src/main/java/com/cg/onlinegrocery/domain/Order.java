package com.cg.onlinegrocery.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

/**
 * This Order class will store all the details of the order
 * 
 * @author RC
 */

@Entity
@Table(name = "customer_orders")
public class Order {

	/**
	 * Id of the order placed
	 */

	@Id
	@Column(name = "order_id")
	private int orderId;
	

	/**
	 * Id of the customer who placed order
	 */

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customerId;
	
	/**
	 * Name of the Customer
	 */
	
	private Customer custName;

	/**
	 * List of the order items placed based on order ID
	 */

	@OneToMany(mappedBy = "orderId")
	private List<OrderItems> items;

	

	/**
	 * Price of the ordered items
	 */

	@Column(name = "price")
	private double price;

	/**
	 * Date of the order placed
	 */

	@Column(name = "order_date")
	private Timestamp date;

	// Default constructor of Order class

	public Order() {
		// TODO Auto-generated constructor stub
	}

	// Parameterized constructor of Order class where customer Id is assigned to Customer object

	public Order(Customer customer) {
		this.customerId = customer;
	}

	// Generating getters and setters
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public List<OrderItems> getItems() {
		return items;
	}

	public void setItems(List<OrderItems> items) {
		this.items = items;
	}
	public Customer getCustName() {
		return custName;
	}

	public void setCustName(Customer custName) {
		this.custName = custName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}