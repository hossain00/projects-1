package com.getterandsetter.dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.getterandsetter.beans.HiringManager;
import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_Application_Status;
import com.getterandsetter.beans.Sas_Application_Type;
import com.getterandsetter.beans.Sas_SkillSet;
import com.getterandsetter.beans.Sas_Skills;
import com.getterandsetter.beans.Sas_Users;
import com.getterandsetter.hibernate.HibernateUtils;
import com.getterandsetter.recommendations.Recommended;

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
	
	 @SuppressWarnings("unchecked")
		public List<Sas_Skills> allSkills()
		 {
			 return session.createCriteria(Sas_Skills.class).list();
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

	@SuppressWarnings("unchecked")
	public List<Sas_Application> getRecommendedApps(Sas_Application_Type jobType) 
	{
		List<Sas_Application> list = session.createCriteria(Sas_Application.class).list();
		
		List<Sas_Application> returningList = new ArrayList<Sas_Application>();
		
		for(int i = 1; i < list.size(); i++)
		{
			if(list.get(i).getSas_Skill_Set_id()!= null)
			{
				Recommended rec = new Recommended(
						list.get(i).getSas_Skill_Set_id(), 
						jobType.getJobSkillSet(), 
						list.get(i));
				
				if (rec.score() > 5)
				{
					System.out.println(list.get(i));
					System.out.println("Rec Score: " + rec.score());
					returningList.add(list.get(i));
				}
			}
			/*System.out.println(list.get(i));
			System.out.println("Rec Score: " + rec.score());*/
		}
		
		return returningList;
	}
	

	public Sas_Application approveDeny(Sas_Users mgr,  Sas_Application application) 
	{
		
		Transaction tx = session.beginTransaction();
		/*if(statusChange == 2)
		{*/
			application.setSas_approver(mgr);
			application.setSas_resolved("SYSDATE");
			application.setSas_status_id(new Sas_Application_Status(2, "Approved"));
			
			session.saveOrUpdate(application);
			tx.commit();
		/*}*/
			return application;
		
		/*else if(statusChange == 3)
		{
			application.setSas_approver(mgr);
			application.setSas_resolved("SYSDATE");
			application.setSas_status_id(new Sas_Application_Status(3, "Denied"));
			
			session.saveOrUpdate(application);
			tx.commit();
		}*/
		
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
	
	public void postJob(Sas_Users manager, Sas_SkillSet desiredSkills, Sas_Application_Type job)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			desiredSkills.setUser(manager);
			job.setJobSkillSet(desiredSkills);
			session.save(job);
			tx.commit();
			
			/*job = new Sas_Application_Type(1, "Job Type", desiredSkills,
					"location", "decription", "industry position");*/
		}
		catch(Exception e)
		{
			tx.rollback();
		}
	}
	
	
	@SuppressWarnings("unchecked")
    public List<Sas_Application> getAppsByUserCriteria(Sas_Users user)
	{
         return (List<Sas_Application>) session.createCriteria(Sas_Application.class).add(Restrictions.eq("Sas_author.Sas_users_id", user.getSas_users_id())).list();     
    }
    
    public Sas_Application_Type returnJob(int Sas_job_type_id)
    {
    	return (Sas_Application_Type) session.load(Sas_Application_Type.class, Sas_job_type_id);
    }
	
}