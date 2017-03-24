package com.getterandsetter.hibernate;

import org.junit.BeforeClass;
import org.junit.Test;

import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.dao.ApplicantDAOImpl;

public class UpdateApplicationTest {

	private static Sas_Application toTest;
	private static ApplicantDAOImpl dao = new ApplicantDAOImpl(); 
	
	@BeforeClass
	public static void setup(){
		toTest = dao.findOne(3050);
	}
	
	@Test
	public void test(){
		System.out.println("Before modification: " + toTest);
		toTest.setSas_skills("Hibernate");
		dao.update(toTest);
		System.out.println("Updated!");
		/*dao.delete(toTest);
		System.out.println("Deleted!");*/
	}
	
}
