package com.cg.onlinegrocery.serviceimpl;

import javax.persistence.EntityManager;
import com.cg.onlinegrocery.daoimpl.OrderDAOImpl;
import com.cg.onlinegrocery.domain.Customer;
import com.cg.onlinegrocery.domain.Order;
import com.cg.onlinegrocery.service.ProductOrderingService;
import com.cg.onlinegrocery.util.DBUtils;

public class ProductOrderingServiceImpl implements ProductOrderingService {
	
	public ProductOrderingServiceImpl()
	{
		new OrderDAOImpl();
	}

	@Override
	public void searchOrder(int orderId, Customer customerId) {
		DBUtils dbutil=new DBUtils();
		EntityManager entityManager=dbutil.createEntityManager();
		entityManager.getTransaction().begin();
		Order order = entityManager.find(Order.class, orderId);
		System.out.println("Order Id: "+ order.getOrderId());
		System.out.println("Customer ID: "+ order.getCustomerId());
		System.out.println("Order Date: "+ order.getDate());
		System.out.println("Order Price: "+ order.getPrice());
		System.out.println("Product Amount: "+ order.getItems());
		}
		
	

	@Override
	public void updateOrder(int orderId, Customer customerId) {
		DBUtils dbutil=new DBUtils();
		EntityManager entityManager=dbutil.createEntityManager();
		entityManager.getTransaction().begin();	
			Order order = entityManager.find(Order.class, orderId);
			order.setOrderId(order.getOrderId());
			order.setCustomerId(order.getCustomerId());
			order.setPrice(order.getPrice());
			order.setItems(order.getItems());
			entityManager.getTransaction().commit();
		
	}

	@Override
	public void cancelOrder(int orderId, Customer customerId) {
		
		DBUtils dbutil=new DBUtils();
		EntityManager entityManager=dbutil.createEntityManager();
		entityManager=dbutil.createEntityManager();
		entityManager.getTransaction().begin();
		Order order = entityManager.find(Order.class, orderId);
		entityManager.remove(order);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}


}
