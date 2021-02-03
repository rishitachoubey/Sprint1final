package com.cg.onlinegrocery.util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * This class provides jpa connection to the database
 * @author RC
 *
 */

public class DBUtils {
	

	public EntityManager createEntityManager()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		return entityManager;
		
	}
	
	}

