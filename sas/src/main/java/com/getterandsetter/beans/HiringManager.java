package com.getterandsetter.beans;


import java.util.ArrayList;

/**
 * 
 * @author Hendy
 *
 */

public class HiringManager extends Sas_Users
{
	
	public HiringManager() {
		super();
		
	}

	public HiringManager(int sas_users_id, String sas_password, String user_first_name, String user_email,
			Sas_User_Roles user_role_id, String user_last_name, String sas_username) 
	{
		super(sas_users_id, sas_password, user_first_name, user_email, user_role_id, user_last_name, sas_username);
		
	}

	private ArrayList<String> desiredSkills;

	public ArrayList<String> getDesiredSkills() {
		return desiredSkills;
	}

	public void setDesiredSkills(ArrayList<String> desiredSkills) {
		this.desiredSkills = desiredSkills;
	}
}
