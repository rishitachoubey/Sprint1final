//package com.cg.onlinegrocery.daoimpl;
//
//import java.util.List;
//
//import javax.persistence.*;
//
//import com.cg.onlinegrocery.dao.AccountDAO;
//import com.cg.onlinegrocery.domain.Account;
//import com.cg.onlinegrocery.domain.Admin;
//import com.cg.onlinegrocery.domain.Customer;
//import com.cg.onlinegrocery.domain.StoreIncharge;
//import com.cg.onlinegrocery.service.AccountService;
//import com.cg.onlinegrocery.util.DBUtils;
//
//public class AccountDAOImpl extends DBUtils implements AccountDAO {
//	private EntityManager entityManager; 
//
//	
//	@Override
//	public void findAccount(int userid) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	
//	@Override
//	public void UserDetails(Account account) {
//		account.setUserID(1);
//		account.setFirstName("pratyusha");
//		account.setLastName("aaa");
//		account.setEmail("ypratyu@gmail.com");
//		account.setPassword("1234");
//		account.setAddress("chennai");
//		account.setAccountType(0);
//		entityManager.getTransaction().begin();
//		entityManager.persist(account);
//		entityManager.getTransaction().commit();	
//		entityManager.close();
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void deleteAccount(Account account) {
//		// TODO Auto-generated method stub
//		
//	}
//	public void createAccount(Account account) {
//		
//			 
//			 int accountType=account.accountType;
//			if(accountType==AccountService.ACCOUNT_TYPE_ADMIN) {
//				int adminId;
//				String adminName;
//				Admin admin=new Admin( adminId,adminName);
//			}
//			else if(accountType==AccountService.ACCOUNT_TYPE_STORE_INCHARGE) {
//				int storeInchargeId;
//				String storeInchargeName;
//				StoreIncharge storeIncharge =  new StoreIncharge(storeInchargeId,storeInchargeName);
//			}
//			else if(accountType==AccountService.ACCOUNT_TYPE_GENERAL_USER) {
//				int customerId;
//				String  customerName;				
//				Customer customer =  new Customer( customerId, customerName);
//			}
//			
//			accountRepository.add(newAccountType);
//	}
//	
//	@Override
//	public void updateAccount(Account account) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<Account> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	
//
//}
