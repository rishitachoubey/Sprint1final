package com.cg.onlinegrocery.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This OrderItems class will store all the details of Items ordered
 * 
 * @author RC 
 */

@Entity
@Table(name = "order_items")
public class OrderItems {

	/**
	 * Id of the item to be ordered
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int orderItemId;

	/**
	 * Name of the item to be ordered
	 */

	@Column(name = "name")
	private String name;

	/**
	 * No. of the items to be ordered
	 */

	@Column(name = "product_quantity")
	private int quantity;

	/**
	 * Id of the order placed
	 */

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order orderId;

	/**
	 * Default Constructor of OrderItems class
	 */

	public OrderItems() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized Constructor of OrderItems class
	 * 
	 * Setting the object of the Order class to the order id of the Order items
	 * class
	 */

	public OrderItems(Order order) {
		this.orderId = order;
	}

	// Generating Getters and Setters

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

}
