package com.cg.onlinegrocery.dao;

import java.util.List;

import com.cg.onlinegrocery.exception.*;
import com.cg.onlinegrocery.domain.Order;

public interface OrderDAO {


		public void placeOrder(Order order, int orderId) throws InsufficientItemsException, InvalidProductException;
		
		public List<Order> showAllOrders();
		
		public Order getOrderDetails(int orderId);
	}

