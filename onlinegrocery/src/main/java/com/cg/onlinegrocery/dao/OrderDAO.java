package com.cg.onlinegrocery.dao;

import java.util.List;

import com.cg.onlinegrocery.domain.Order;
import com.cg.onlinegrocery.model.ShoppingCart;

public interface OrderDAO {


		public void saveOrder(ShoppingCart shoppingcart);
		
		public List<Order> showAllOrders();
		
		public Order getOrderDetails(int orderId);
	}

