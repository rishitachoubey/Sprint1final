package com.cg.onlinegrocery.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This Product class will store all the details of the product
 * 
 * @author 
 */
@Entity

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int productId;
	
	private String productName;
	private Integer productAmount;
	private Double price;
	private String description;
	
//	public Product(String productName, Integer productAmount, Double price, String description) {
//		super();
//		//this.productId = productId;
//		this.productName = productName;
//		this.productAmount = productAmount;
//		this.price = price;
//		this.description = description;
//	}
	
	
	//Generate Getters and setters
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}