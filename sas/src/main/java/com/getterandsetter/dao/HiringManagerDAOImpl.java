package com.getterandsetter.dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.getterandsetter.beans.HiringManager;
import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_Application_Status;
import com.getterandsetter.beans.Sas_SkillSet;
import com.getterandsetter.beans.Sas_Users;
import com.getterandsetter.hibernate.HibernateUtils;

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
	
	 @SuppressWarnings("unchecked")
	public List<Sas_Application> allApps()
	 {
		 return session.createCriteria(Sas_Application.class).list();
	 }
	
	public Sas_Application findApp(int Sas_id)
	{
		Sas_Application app = (Sas_Application) session.load(Sas_Application.class, Sas_id); //generate SELECT
		return app;
	}
	
	public Sas_Users findManager(int Sas_users_id)
	{
		Sas_Users user = (Sas_Users) session.load(Sas_Users.class, Sas_users_id); //generate SELECT
		return user;
	}
	/*
	 * @see com.getterandsetter.hibernate.HiringManagerDAO#getAllApplicants()
	 * 
	 * gets all applicants
	 */
	@SuppressWarnings("unchecked")
	public List<Sas_Users> getAllApplicants() 
	{
		Query query = session.createQuery("from Sas_Users where USER_ROLE_ID = 2");
		
		return (ArrayList<Sas_Users>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Sas_Users> getAllManagers() 
	{
		Query query = session.createQuery("from Sas_Users where USER_ROLE_ID = 1");
		
		return (ArrayList<Sas_Users>) query.list();
	}
	
	
	/**
	 * re-purpose with skill set 
	 */
	public void setNeededSkills(Sas_Users manager, Sas_SkillSet desiredSkills) 
	{
		Transaction tx = session.beginTransaction();
		try
		{
			desiredSkills.setUser(manager);
			session.saveOrUpdate(desiredSkills);
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
		}
	}

	public List<Sas_Application> getRecommendedApps() 
	{
		/*
		 * Should match applicant skills(should be a list within applicant object)
		 * and return those applicants which at least 50% of the desired skills
		 * 
		 * couldnt be implented because i need to find out off Mike createat a list of skills for applicants
		 */
		
		return session.createCriteria(Sas_Application.class).list();
	}

	public void approveDeny(Sas_Users mgr, int statusChange, Sas_Application application) 
	{
		
		Transaction tx = session.beginTransaction();
		if(statusChange == 2)
		{
			application.setSas_approver(mgr);
			application.setSas_resolved("SYSDATE");
			application.setSas_status_id(new Sas_Application_Status(2, "Approved"));
			
			session.saveOrUpdate(application);
			tx.commit();
		}
		
		else if(statusChange == 3)
		{
			application.setSas_approver(mgr);
			application.setSas_resolved("SYSDATE");
			application.setSas_status_id(new Sas_Application_Status(3, "Denied"));
			
			session.saveOrUpdate(application);
			tx.commit();
		}
		
	}

	
	public void update(Sas_Application app) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(app);
		tx.commit();
	}


	public void create(Sas_Users manager) 
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(manager);
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
		}
	}
}