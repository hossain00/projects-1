package com.getterandsetter.hibernate;

public interface ApplicantDAO {

	public void create(Sas_User_Roles sas_User_Roles);

	public void createSas_User(Sas_Users sas_Users);

	public void createSas_Application(Sas_Application app);
	
	public void update(Sas_Application app);
	
	public void delete(Sas_Application app);
	
	public Sas_Application findOne(int appid);
}
