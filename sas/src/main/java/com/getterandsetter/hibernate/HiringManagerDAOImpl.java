package com.getterandsetter.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/** * 
 * @author Hendy
 *needs to be finished
 *getRecommendedApps()
 *approveDeny()
 */

public class HiringManagerDAOImpl implements HiringManagerDAO
{
	private SessionFactory sf = HibernateUtils.getSessionFactory();
	private Session session;
	
	public HiringManagerDAOImpl() 
	{
		session = sf.openSession();
	}
	
	/*
	 * @see com.getterandsetter.hibernate.HiringManagerDAO#getAllApplicants()
	 * 
	 * gets all applicants
	 */
	@SuppressWarnings("unchecked")
	public List<HiringManager> getAllApplicants() 
	{
		Query query = session.createQuery("from Sas_Users where USER_ROLE_ID = 1");
		
		return (ArrayList<HiringManager>) query.list();
	}
	
	public void setNeededSkills(HiringManager manager, ArrayList<String>desiredSkills) 
	{
		manager.setDesiredSkills(desiredSkills);
	}

	public void getRecommendedApps() 
	{
		/*
		 * Should match applicant skills(should be a list within applicant object)
		 * and return those applicants which at least 50% of the desired skills
		 * 
		 * couldnt be implented because i need to find out off Mike createat a list of skills for applicants
		 */
	}

	public void approveDeny(Sas_Users user, int statusChange, int appID) 
	{
		//check if right
		Query query;
		if(statusChange == 2)
		{
			query = session.createQuery("update SAS_APPLICATION set SAS_STATUS_ID = 2 where SAS_ID = appID");
		}
		
		else if(statusChange == 3)
		{
			
		}
	}

	public void create(Sas_Users manager) {
		Transaction tx = session.beginTransaction();
		try{
			session.save(manager);
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
		}
	}
}
