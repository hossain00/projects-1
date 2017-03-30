package com.getterandsetter.hibernate;
import org.junit.Test;

import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_Application_Status;
import com.getterandsetter.beans.Sas_Application_Type;
import com.getterandsetter.beans.Sas_SkillSet;
import com.getterandsetter.beans.Sas_User_Roles;
import com.getterandsetter.beans.Sas_Users;
import com.getterandsetter.obsolete.ApplicantDAO;
import com.getterandsetter.obsolete.ApplicantDAOImpl;

public class InsertTest {

	@Test
	public void insert() {
		ApplicantDAO dao = new ApplicantDAOImpl(); // no arg constructor calls
													// to open a new session

		/*
		 dao.createSas_User(new
		 Sas_Users(7,"welcome1","Robert","robertr@gmail.com", new
		 Sas_User_Roles(2, "Applicant"),"Red","rred55"));*/
		 
		// Sas_User_Roles userrole= new Sas_User_Roles(22,"HiringManager");
		//Mikes new stuff
		
		//NOTE TO MYSELF CHANGE BACK HIBERNATE CONFIG TO SADATRDS
		dao.createSas_Application(new Sas_Application(
				new Sas_Application_Status(1, "Pending"), 
				new Sas_Users(7, "welcome1", "Robert", "robertr@gmail.com",
				new Sas_User_Roles(2, "Applicant"), "Red", "rred55"),
				new Sas_Application_Type(1, "Full Stack Developer",new Sas_SkillSet(7, new Sas_Users(1,//primary Manager 
						"password",//hashing will be done later 
						"Hendy",//user firstname 
						"hvalcin@revature.com",
						new Sas_User_Roles
						(
							9, //userrole Id, this is the only we should need
							"HiringManager"	
						) , 
						"Valcin", //User last name
						"hvalcin"), true, true, true, true, true))));
		
		

		System.out.println("Success!");
	}

}