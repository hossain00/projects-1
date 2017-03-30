package com.getterandsetter.dao;

import com.getterandsetter.beans.Sas_Application_Status;
import com.getterandsetter.beans.Sas_Application_Type;
import com.getterandsetter.beans.Sas_SkillSet;
import com.getterandsetter.beans.Sas_Skills;

public interface CreateDAO 
{
	public void createStatus(Sas_Application_Status status);
	public void createAppType(Sas_Application_Type type);
	public void createSkill(Sas_Skills skills);
	public void createSkillSet(Sas_SkillSet skillset);
}