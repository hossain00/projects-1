package com.getterandsetter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.getterandsetter.beans.Sas_Application_Status;
import com.getterandsetter.beans.Sas_Application_Type;
import com.getterandsetter.beans.Sas_SkillSet;
import com.getterandsetter.beans.Sas_Skills;
import com.getterandsetter.beans.Sas_User_Roles;
import com.getterandsetter.hibernate.HibernateUtils;

public class CreateDAOImpl implements CreateDAO
{
	private SessionFactory sf = HibernateUtils.getSessionFactory();
	private Session session;
	
	public CreateDAOImpl()
	{
		session = sf.openSession();
	}
	

	public void createStatus(Sas_Application_Status status) 
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(status);
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
	}

	public void createAppType(Sas_Application_Type type) 
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session.saveOrUpdate(type);
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
		}
	}
	
	public void createUserRoleType(Sas_User_Roles role) 
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(role);
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
		}
	}


	@Override
	public void createSkill(Sas_Skills skills) 
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(skills);
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
		}
	}


	@Override
	public void createSkillSet(Sas_SkillSet skillset) 
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(skillset);
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
		}
	}


}