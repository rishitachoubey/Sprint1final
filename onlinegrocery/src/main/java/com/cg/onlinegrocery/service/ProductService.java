package com.cg.onlinegrocery.service;

import java.util.List;
import com.cg.onlinegrocery.domain.Product;

public interface ProductService {
	public void addProduct(Product product);
	public void deleteProduct(int productId, String productName);
	public void searchProduct(String productName, int productId);
	public void updateProduct(Product product1, int productId);
	public List<Product> viewAllProducts(Product products);
	

}
