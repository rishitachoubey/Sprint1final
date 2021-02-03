
package com.cg.onlinegrocery.daoimpl;

import java.util.List;
import javax.persistence.*;

import com.cg.onlinegrocery.dao.OrderDAO;
import com.cg.onlinegrocery.domain.Order;
import com.cg.onlinegrocery.domain.OrderItems;
import com.cg.onlinegrocery.domain.Product;
import com.cg.onlinegrocery.exception.InsufficientItemsException;
import com.cg.onlinegrocery.exception.InvalidProductException;
import com.cg.onlinegrocery.util.DBUtils;

public class OrderDAOImpl implements OrderDAO {

	DBUtils dbutil;
	Product product;
	EntityManager entitymanager;
	OrderItems orderItems;

	public OrderDAOImpl() {
		dbutil = new DBUtils();
		product = new Product();
		orderItems = new OrderItems();
	}

	@Override
	public void placeOrder(Order order, int orderId) throws InsufficientItemsException, InvalidProductException {

		entitymanager = dbutil.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("from Product");
		List<Product> products = query.getResultList();
		for (Product product1 : products) {
			if (product1.getProductName().contains(orderItems.getName())) {
				if (product.getProductAmount() > orderItems.getQuantity()) {
					entitymanager.persist(order);
				} else {
					throw new InsufficientItemsException("Items out of Stock!!");
				}

			} else {
				throw new InvalidProductException("Product not Available");
			}
		}

	}

	@Override
	public Order getOrderDetails(int orderId) {
		// Order order= new Order();
		entitymanager = dbutil.createEntityManager();
		entitymanager.getTransaction().begin();
		Order order = entitymanager.find(Order.class, orderId);
		System.out.println("Order Id: " + order.getOrderId());
		System.out.println("Customer Id: " + order.getCustomerId());
		System.out.println("Customer Name:" + order.getCustName());
		System.out.println("Total Price: " + ((order.getPrice()) * (orderItems.getQuantity())));
		System.out.println("Order Date: " + order.getDate());
		System.out.println("Order Items: " + order.getItems());
		System.out.println("-----------------------------");

		entitymanager.persist(order);

		entitymanager.getTransaction().commit();

		entitymanager.close();
		return null;
	}

	@Override
	public List<Order> showAllOrders() {
		entitymanager = dbutil.createEntityManager();
		Query query = entitymanager.createQuery("from Order");

		entitymanager.getTransaction().begin();
		List<Order> orders = query.getResultList();
		for (Order order : orders) {
			System.out.println("Order Id: " + order.getOrderId());
			System.out.println("Customer Id: " + order.getCustomerId());
			System.out.println("Customer Name:" + order.getCustName());
			System.out.println("Total Price: " + ((order.getPrice()) * (orderItems.getQuantity())));
			System.out.println("Order Date: " + order.getDate());
			System.out.println("Order Items: " + order.getItems());
			System.out.println("-----------------------------");
		}
		return null;
	}

}
