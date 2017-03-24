package com.getterandsetter.dao;

import com.getterandsetter.beans.Sas_Application_Status;
import com.getterandsetter.beans.Sas_Application_Type;

public interface CreateDAO 
{
	public void createStatus(Sas_Application_Status status);
	public void createAppType(Sas_Application_Type type);
}
