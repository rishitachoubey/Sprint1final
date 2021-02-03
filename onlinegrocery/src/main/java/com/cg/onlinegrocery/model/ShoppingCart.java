package com.cg.onlinegrocery.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cg.onlinegrocery.domain.Customer;

public class ShoppingCart {

	/**
	 * 
	 */
	// private static final long serialVersionUID = 2110487200031034011L;

	Logger logger = Logger.getLogger(ShoppingCart.class.getName());

	private int orderNumber;

	private List<ItemInfo> cartItem;
	private double subTotal;
	private double totalPrice;

	private Customer customer;

	public ShoppingCart() {

		this.cartItem = new ArrayList<ItemInfo>();
	}

	public void addItemToCart(ProductInfo productInfo, int quantity) {

		logger.log(Level.FINE, "Adding item to cart");

		ItemInfo item = this.findItemInCart(productInfo.getProductCode());

		if (item == null) {
			item = new ItemInfo();
			item.setQuantity(0);
			item.setProductInfo(productInfo);
			this.cartItem.add(item);

		}

		int newQuantity = item.getQuantity() + quantity;
		if (newQuantity <= 0) {
			this.cartItem.remove(item);
		} else {
			item.setQuantity(newQuantity);
			item.setSubTotal(item.getQuantity() * item.getProductInfo().getPrice());
		}

		this.rePrice();
	}

	public void rePrice() {
		this.subTotal = this.calculatePrice();

		this.totalPrice = Double.valueOf(this.subTotal);
	}

	public double calculatePrice() {
		double amount = 0;

		for (ItemInfo info : this.cartItem) {

			amount = amount + info.getProductInfo().getPrice() * info.getQuantity();
		}

		return Double.valueOf((amount));
	}

	public ItemInfo findItemInCart(String productCode) {
		for (ItemInfo info2 : this.cartItem) {
			if (info2.getProductInfo().getProductCode().equalsIgnoreCase(productCode)) {
				return info2;
			}
		}
		return null;
	}

//		public void removeItemFromCart(String productCode) {
//			ItemInfo itemInfo = this.findItemInCart(productCode);
//
//			if (itemInfo != null) {
//				this.cartItem.remove(itemInfo);
//				this.rePrice();
//			}
//		}
//		
	public boolean isEmpty() {
		if (this.cartItem == null) {
			return true;
		}
		return this.cartItem.isEmpty();
	}

	public List<ItemInfo> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<ItemInfo> cartItem) {
		this.cartItem = cartItem;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

}