package com.getterandsetter.hibernate;

import java.util.List;

import org.junit.Test;

import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_Application_Type;
import com.getterandsetter.beans.Sas_SkillSet;
import com.getterandsetter.beans.Sas_User_Roles;
import com.getterandsetter.beans.Sas_Users;
import com.getterandsetter.dao.HiringManagerDAOImpl;
/**
 * 
 * @author Hendy
 *
 */
public class HiringMangerTest 
{
	@Test
	public void test()
	{
		HiringManagerDAOImpl dao= new HiringManagerDAOImpl();
		
		/*dao.create(new Sas_Users(1,//primary Manager 
				"password",//hashing will be done later 
				"Hendy",//user firstname 
				"hvalcin@revature.com",
				new Sas_User_Roles
				(
					1, //userrole Id, this is the only we should need
					"HiringManager"	
				) , 
				"Valcin", //User last name
				"hvalcin"));//username
*/		
		/*List list = dao.getAllApplicants();
		System.out.println(list);*/	
		Sas_Users manger = dao.findManager(7);
		
		/*Sas_SkillSet desiredSkills = new Sas_SkillSet(12, null, true, true, false, false, false);
		Sas_Application_Type job = new Sas_Application_Type(3, "test for new Job");*/
		List<Sas_Application> list = dao.getAppsByUserCriteria(manger);
		System.out.println(list);
		
		/*Sas_Users manger = dao.findManager(7);
		dao.postJob(manger, desiredSkills, job)*/;
		/*Sas_Application app = dao.findApp(9450);
		dao.approveDeny(manger, 2, app);*/
		System.out.println("success!!");
	}
}

