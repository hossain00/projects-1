package com.getterandsetter.hibernate;

import org.junit.Test;

public class AppDeleteTest {
	@Test
	public void get(){
		new ApplicantDAOImpl().delete(new Sas_Application(2050,
				new Sas_Application_Status(1, "Pending"), 
				new Sas_Users(7, "welcome1", "Robert", "robertr@gmail.com",
				new Sas_User_Roles(2, "Applicant"), "Red", "rred55"),
				new Sas_Application_Type(1, "Full Stack Developer")));
	}
}
