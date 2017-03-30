package com.getterandsetter.dao;

import java.util.ArrayList;
import java.util.List;

import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_SkillSet;
import com.getterandsetter.beans.Sas_Users;

/**
 * 
 * @author Hendy
 *
 */

public interface HiringManagerDAO
{
	/**
	 * We should be able to get all applicants for the Hiring Manager
	 */
	public List<Sas_Users> getAllApplicants();
	
	/**
	 * We should allow the HM's to say what skills they are looking for
	 */
	public void setNeededSkills(Sas_Users manager, Sas_SkillSet desiredSkills);
	
	/**
	 * We should get recommended applicants
	 * 1) Get by tallying up all the skills that applicant has that the Hiring manager is looking for
	 * 2) sort by applicants with the most skills that meat the criteria
	 */
	public List<Sas_Application> getRecommendedApps();
	
	public void approveDeny(Sas_Users mgr, int statusChange, Sas_Application application);
	public Sas_Application findApp(int Sas_status_id);
	public void update(Sas_Application app);
	
	
	
}