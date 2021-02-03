package com.cg.onlinegrocery.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;

import com.cg.onlinegrocery.daoimpl.ProductDAOImpl;
import com.cg.onlinegrocery.domain.Product;
import com.cg.onlinegrocery.service.ProductService;
import com.cg.onlinegrocery.util.DBUtils;

public class ProductServiceImpl extends DBUtils implements ProductService {
	
	ProductDAOImpl productdao=new ProductDAOImpl();
	
	@Override
	public List<Product> viewAllProducts(Product product) {
		return null;
	}

	@Override
	//public Product addProduct() {
		public void addProduct(Product product) {
			DBUtils dbutil=new DBUtils();
			EntityManager entityManager=dbutil.createEntityManager();
			entityManager.getTransaction().begin();
			Product Product = entityManager.find(Product.class, product);
			System.out.println("Product Id: "+ product.getProductId());
			System.out.println("Product Name: "+ product.getProductName());
			System.out.println("Product Amount: "+ product.getProductAmount());
			System.out.println("Price: "+ product.getPrice());
			System.out.println("Description: "+ product.getDescription());
			}
	
	public void searchProduct(String productName, int productId) {
		DBUtils dbutil=new DBUtils();
		EntityManager entityManager=dbutil.createEntityManager();
		entityManager.getTransaction().begin();
		Product product = entityManager.find(Product.class, productId);
		System.out.println("Product Id: "+ product.getProductId());
		System.out.println("Product Name: "+ product.getProductName());
		System.out.println("Product Amount: "+ product.getProductAmount());
		System.out.println("Price: "+ product.getPrice());
		System.out.println("Product Amount: "+ product.getDescription());
		}
		
	@Override
		public void deleteProduct(int productId, String productName) {
		DBUtils dbutil=new DBUtils();
		EntityManager entityManager=dbutil.createEntityManager();
		entityManager.getTransaction().begin();	
		Product product = entityManager.find(Product.class, productId);
		entityManager.remove(product);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
		

	@Override
	public void updateProduct(Product product1, int productId) {
		DBUtils dbutil=new DBUtils();
		EntityManager entityManager=dbutil.createEntityManager();
		entityManager.getTransaction().begin();	
			Product product = entityManager.find(Product.class, productId);
			product1.setProductId(product.getProductId());
			product1.setProductName(product1.getProductName());
			product1.setProductAmount(product1.getProductAmount());
			product1.setPrice(product1.getPrice());
			product1.setDescription(product1.getDescription());
			entityManager.getTransaction().commit();
		
	}
		
}
