package com.getterandsetter.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Set up my Hibernate
 *
 */
public class HibernateUtils {

	// very very heavy weight---use a Singleton
	private static SessionFactory sessionFactory;
	
	public synchronized static SessionFactory getSessionFactory(){
		if(sessionFactory == null){
			createSessionFactory();
		}
		return sessionFactory;
	}

	private static void createSessionFactory() {
		sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
	}
}