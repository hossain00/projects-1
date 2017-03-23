package com.getterandsetter.hibernate;

import java.util.ArrayList;
import java.util.List;

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
	public List<HiringManager> getAllApplicants();
	
	/**
	 * We should allow the HM's to say what skills they are looking for
	 */
	public void setNeededSkills(HiringManager manager, ArrayList<String>desiredSkills);
	
	/**
	 * We should get recommended applicants
	 * 1) Get by tallying up all the skills that applicant has that the Hiring manager is looking for
	 * 2) sort by applicants with the most skills that meat the criteria
	 */
	public void getRecommendedApps();
	
	public void approveDeny(Sas_Users user, int statusChange, int appID);
	
	
	
}

