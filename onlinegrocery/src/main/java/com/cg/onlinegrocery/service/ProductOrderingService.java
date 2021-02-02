package com.cg.onlinegrocery.service;

import com.cg.onlinegrocery.domain.Customer;

public interface ProductOrderingService {
	

		public void searchOrder(int orderId, Customer customerId);
		public void updateOrder(int orderId, Customer customerId);
		public void cancelOrder(int orderId, Customer customerId);
		

}
