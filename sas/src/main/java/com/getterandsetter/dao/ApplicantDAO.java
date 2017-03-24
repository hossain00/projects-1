package com.getterandsetter.dao;

import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_User_Roles;
import com.getterandsetter.beans.Sas_Users;

public interface ApplicantDAO {

	public void create(Sas_User_Roles sas_User_Roles);

	public void createSas_User(Sas_Users sas_Users);

	public void createSas_Application(Sas_Application app);
}
