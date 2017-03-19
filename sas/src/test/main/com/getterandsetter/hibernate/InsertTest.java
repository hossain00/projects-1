package com.getterandsetter.hibernate;

import org.junit.Test;

import com.getterandsetter.hibernate.ApplicantDAO;
import com.getterandsetter.hibernate.ApplicantDAOImpl;
import com.getterandsetter.hibernate.Sas_User_Roles;

public class InsertTest {

	@Test
	public void insert() {
		ApplicantDAO dao = new ApplicantDAOImpl(); // no arg constructor calls
													// to open a new session

		/*
		 * dao.createSas_User(new
		 * Sas_Users(7,"welcome1","Robert","robertr@gmail.com", new
		 * Sas_User_Roles(22,"HiringManager"),"Red","rred55"));
		 */
		// Sas_User_Roles userrole= new Sas_User_Roles(22,"HiringManager");
		dao.createSas_Application(new Sas_Application(
				new Sas_Application_Status(1, "Pending"), 
				new Sas_Users(7, "welcome1", "Robert", "robertr@gmail.com",
				new Sas_User_Roles(22, "HiringManager"), "Red", "rred55"),
				new Sas_Application_Type(1, "Full Stack Developer")));

		System.out.println("Success!");
	}

}
