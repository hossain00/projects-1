package com.getterandsetter.hibernate;
import org.junit.Test;

import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_Application_Status;
import com.getterandsetter.beans.Sas_Application_Type;
import com.getterandsetter.beans.Sas_SkillSet;
import com.getterandsetter.beans.Sas_User_Roles;
import com.getterandsetter.beans.Sas_Users;
import com.getterandsetter.dao.HiringManagerDAOImpl;
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
		/**
		 * Hendy is working here
		 * 1) Goal make sure create application works
		 * 2) pay attention as I leave notes
		 * 3)I tested it and it works...adds application and new skillset
		 * 
		 * whats new: now wen we add and application we have to add the skillset
		 */
		
		/*Need this to bring in key thing to create an application*/
		HiringManagerDAOImpl hmDao = new HiringManagerDAOImpl();
		
		/*lets get the applicant who is going to create the application*/
		Sas_Users applicant = hmDao.findManager(7);//we're getting robert
		
		/*zGeth the job weir applying for*/
		Sas_Application_Type job =hmDao.returnJob(1);
		/*create a skill set that relates to robert*/
		Sas_SkillSet skillset = new Sas_SkillSet(25, applicant, false, false, false, false, false);
		/*put the skillset in the skill set table*/
		dao.setSkills(skillset);
		/*Now we have everthing we need lets set up the applications and save it*/
		Sas_Application app = new Sas_Application(3, "time submitted 3/31", "time resolved 3/31", skillset,
				null, new Sas_Application_Status(1, "Applied"), applicant, job);
		
		/*Then finally save the app object*/
		dao.createSas_Application(app);

		System.out.println("Success!");
	}

}