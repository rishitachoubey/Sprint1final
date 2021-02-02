package com.cg.onlinegrocery.util;

import java.util.Scanner;

import com.cg.onlinegrocery.dao.ProductDAO;
import com.cg.onlinegrocery.daoimpl.ProductDAOImpl;
import com.cg.onlinegrocery.domain.Product;

public class MenuUtil {
	private ProductDAO productDAO;

	public MenuUtil() {
		productDAO = new ProductDAOImpl();

	}

	public void start() {
		Scanner sc = new Scanner(System.in);
		int choice;
		String continueChoice;

		do {
			productManagement();
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:

			{
				Product product = new Product();
				System.out.println("Enter Product Name");
				product.setProductName(sc.next());
				System.out.println("Enter Product Description ");
				product.setDescription(sc.next());
				System.out.println("Enter Product Price ");
				product.setPrice(sc.nextDouble());
				System.out.println("Enter Product Amount");
				product.setProductAmount(sc.nextInt());

				productDAO.addProduct(product);
				System.out.println("--------------------Product Successfully Added--------------------------");
			}

				break;

			case 2:
				System.out.println("Enter Product ID");
				int productID = sc.nextInt();
				System.out.println("Enter Product Name");
				String productName = sc.next();
				productDAO.removeProduct(productID,productName);
				System.out.println("---------------Product Successfully Removed-------------------");

				break;
				
			case 3:
				//int flag=0;
				System.out.println("Enter Product Name");
				String prodName = sc.next();
				System.out.println("Enter Product ID");
				int prodID = sc.nextInt();
				
				productDAO.searchProduct(prodName,prodID);
//				flag=1;
//				if(flag==0)
//				{
//					System.out.println("Product not found");
//				}
//				else
//				{

				System.out.println("---------------Product Found------------------");
				
				break;

			case 4:
				
				Product product1 = new Product();
				System.out.println("Enter product id to be updated");
				int pID = sc.nextInt();
				System.out.println("Enter Updated Product Name");
				product1.setProductName(sc.next());
				System.out.println("Enter Updated Product Description ");
				product1.setDescription(sc.next());
				System.out.println("Enter Updated Product Price ");
				product1.setPrice(sc.nextDouble());
				System.out.println("Enter Updated Product Amount");
				product1.setProductAmount(sc.nextInt());
				productDAO.updateProduct(product1,pID);
				System.out.println("---------------Product Updated------------------");
				System.out.println("Product Id: "+ product1.getProductId());
				System.out.println("Product Name: "+product1.getProductName());
				System.out.println("Product Description: "+ product1.getDescription());
				System.out.println("Product Price: "+ product1.getPrice());
				System.out.println("Product Amount: "+ product1.getProductAmount());

				break;
				
			case 5:
				System.out.println("---------------List of All Products------------------");
				productDAO.findAllProducts();
				
				break;

			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
			System.out.println("Do you want to continue : [yes/no]");
			continueChoice = sc.next();
		} while (continueChoice.equalsIgnoreCase("yes"));
		sc.close();
	}

	public void productManagement() {
		System.out.println("**********GROCERY SHOP**********");
		System.out.println("1.ADD PRODUCT");
		System.out.println("2.REMOVE PRODUCT");
		System.out.println("3.SEARCH PRODUCT");
		System.out.println("4.UPDATE PRODUCT");
		System.out.println("5.SHOW ALL PRODUCTS");
		System.out.println("0.EXIT");
		System.out.println();

	}

}