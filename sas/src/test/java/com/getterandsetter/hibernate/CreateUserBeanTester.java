package com.getterandsetter.hibernate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.getterandsetter.beans.Sas_User_Roles;
import com.getterandsetter.beans.Sas_Users;
import com.getterandsetter.dao.ApplicantDAO;



public class CreateUserBeanTester {
	
	@Test
	public void go(){
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	context.getBean(ApplicantDAO.class).createSas_User(new
		 Sas_Users(9,"welcome1","Robert","Roboo@gmail.com", new
		 Sas_User_Roles(2, "Applicant"),"Red","adsad"));
	
	
	
	
	
	}
}
