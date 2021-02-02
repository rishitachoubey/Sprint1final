
package com.cg.onlinegrocery.daoimpl;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;

import com.cg.onlinegrocery.dao.OrderDAO;
import com.cg.onlinegrocery.domain.Customer;
import com.cg.onlinegrocery.domain.Order;
import com.cg.onlinegrocery.domain.OrderItems;
import com.cg.onlinegrocery.model.ItemInfo;
import com.cg.onlinegrocery.model.ShoppingCart;
import com.cg.onlinegrocery.util.DBUtils;

public class OrderDAOImpl implements OrderDAO {

	DBUtils dbutil;
	EntityManager entitymanager;

	public OrderDAOImpl() {
		dbutil = new DBUtils();
	}

	@Override
	public void saveOrder(ShoppingCart cart) {
		entitymanager = dbutil.createEntityManager();
		entitymanager.getTransaction().begin();

		Customer customer = null;
		
		/**
		 * will be replaced by the registration class object
		 */

		if (this.getCustomer(cart.getCustomer().getEmailId()) == null) {
			customer = new Customer();
			customer.setfName(cart.getCustomer().getfName());
			customer.setlName(cart.getCustomer().getlName());
			customer.setEmailId(cart.getCustomer().getEmailId());
			customer.setPhone(cart.getCustomer().getPhone());
			customer.setAddress(cart.getCustomer().getAddress());
			entitymanager.persist(customer);

		} else {
			customer = this.getCustomer(cart.getCustomer().getEmailId());
		}

		Order order = new Order(customer);
		order.setOrderId(this.getMaxOrderNum() + 1);
		order.setPrice(cart.getTotalPrice());
		order.setDate(new Timestamp(System.currentTimeMillis()));

		entitymanager.persist(order);

		for (ItemInfo info : cart.getCartItem()) {
			OrderItems items = new OrderItems(order);
			items.setQuantity(info.getQuantity());
			items.setName(info.getProductInfo().getProductName());
			entitymanager.persist(items);
		}

		entitymanager.getTransaction().commit();
		entitymanager.close();

		cart.setOrderNumber(order.getOrderId());

	}

	private Customer getCustomer(String emailId) {
		entitymanager = dbutil.createEntityManager();
		entitymanager.getTransaction().begin();

		String sql = "from User where emailId=:emailId";
		Query query = entitymanager.createQuery(sql);
		query.setParameter("emailId", emailId);
		Object val = (Object) query.getSingleResult();

		entitymanager.close();

		return (Customer) val;

	}

	private int getMaxOrderNum() {
		String sql = "Select max(o.orderId) from " + Order.class.getName() + " o ";
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery(sql);
		Integer value = (Integer) query.getSingleResult();
		if (value == null) {
			return 0;
		}
		entitymanager.close();
		return value;
	}

	@Override

	public List<Order> showAllOrders() {
		entitymanager = dbutil.createEntityManager();
		Query query = entitymanager.createQuery("from Order");

		entitymanager.getTransaction().begin();
		List<Order> orders = query.getResultList();
		for (Order order : orders) {
			System.out.println("Order Id: " + order.getOrderId());
			System.out.println("Customer ID: " + order.getCustomerId());
			System.out.println("Order Date: " + order.getDate());
			System.out.println("Price: " + order.getPrice());
			System.out.println("Order Items: " + order.getItems());
			System.out.println("-----------------------------");
		}

		return null;
	}

	@Override
	public Order getOrderDetails(int orderId) {
		String sql = "from Order where orderId=:orderId";
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery(sql);
		query.setParameter("orderId", orderId);

		Order order = (Order) query.getSingleResult();
		entitymanager.close();
		return order;
	}

}