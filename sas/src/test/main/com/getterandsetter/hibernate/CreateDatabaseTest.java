package com.getterandsetter.hibernate;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Hendy
 *
 */

public class CreateDatabaseTest {
	
	/**
	 * If this information is not created on the database,
	 * then we will have integrity constrains when putting in our first users
	 */
	@Test
	public void test() 
	{
		CreateDAOImpl dao = new CreateDAOImpl();
		
		/**
		 * Create or three different Statuses
		 */
		dao.createStatus(new Sas_Application_Status(1, "Pending"));
		dao.createStatus(new Sas_Application_Status(2, "Approved"));
		dao.createStatus(new Sas_Application_Status(3, "Denied"));
		
		
		/**
		 * Create an application type
		 * 
		 * if we are not going to hardcode all of it at one time then we should generate a sequence
		 */
		dao.createAppType(new Sas_Application_Type(1, "Full Stack Developer"));
		
		System.out.println("Success!");
	}

}
