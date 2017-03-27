package com.getterandsetter.hibernate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_Application_Status;
import com.getterandsetter.beans.Sas_Application_Type;
import com.getterandsetter.beans.Sas_User_Roles;
import com.getterandsetter.beans.Sas_Users;
import com.getterandsetter.dao.ApplicantDAO;



public class CreateApplicationBeanTest {
	
	@Test
	public void go(){
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	context.getBean(ApplicantDAO.class).createSas_Application(new Sas_Application(
			new Sas_Application_Status(1, "Pending"), 
			new  Sas_Users(10,"welcome1","Robert","klkjdsf@gmail.com", 
			new Sas_User_Roles(2, "Applicant"),"Red","ooie"),
			new Sas_Application_Type(1, "Full Stack Developer")));
	
	
	
	
	
	}
}
