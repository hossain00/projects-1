package com.getterandsetter.hibernate;

import java.util.List;

import org.junit.Test;

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
		
		dao.create(new Sas_Users(1,//primary Manager 
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
		
		List list = dao.getAllApplicants();
		System.out.println(list);
		System.out.println("success!!");
	}
}