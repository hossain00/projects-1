package com.getterandsetter.obsolete;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_Application_Type;
import com.getterandsetter.beans.Sas_User_Roles;
import com.getterandsetter.beans.Sas_Users;
import com.getterandsetter.hibernate.HibernateUtils;

public class ApplicantDAOImpl implements ApplicantDAO {

	private SessionFactory sf = HibernateUtils.getSessionFactory();
	private Session session;

	public ApplicantDAOImpl() {
		session = sf.openSession(); // session per request
	}

	// Creates new user roles just for testing do not use
	public void createSas_User_Roles(Sas_User_Roles user_role) {
		Transaction tx = session.beginTransaction();
		try {
			session.save(user_role);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	// Create User just for testing do not use
	public void createSas_User(Sas_Users user) {
		Transaction tx = session.beginTransaction();
		try {
			// session.save(user_role);
			// user.setUser_role_id(user_role);
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	// only using this to add application to database
	public Sas_Application createSas_Application(Sas_Application app) {
		Transaction tx = session.beginTransaction();
		try {
			// session.save(user_role);
			// user.setUser_role_id(user_role);
			session.save(app);
			System.out.println(app);
			tx.commit();
			System.out.println("<[YOOO!]> COMMITED from ApplicantDAOImpl");
		} catch (Exception e) {
			tx.rollback();
			System.out.println("<[YOOO!]> ROLLED BACK! ");

		}
		return app;
	}

	// use this to update application
	public void update(Sas_Application app) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(app);
		tx.commit();
	}

	// delete application which we won't do
	public void delete(Sas_Application app) {
		Transaction tx = session.beginTransaction();
		session.delete(app);
		tx.commit();
		System.out.println("Entry Deleted");
	}

	// this finds the application by its ID
	public Sas_Application findOne(int appid) {
		Sas_Application application = (Sas_Application) session.load(Sas_Application.class, appid); // generate
																									// SELECT
		return application;
	}

	// get all the applications in a list

	@SuppressWarnings("unchecked")

	public List<Sas_Application> findAllApps() {

		// return session.createQuery("from Sas_Application").list();

		return session.createCriteria(Sas_Application.class).list();

	}

	@SuppressWarnings("unchecked")

	public List<Sas_Application_Type> findAllJobs() {

		// return session.createQuery("from Sas_Application").list();

		return session.createCriteria(Sas_Application_Type.class).list();

	}
	
	@SuppressWarnings("unchecked")
	public List<Sas_Application> getAppsByUserCriteria(Sas_Users user)
	{

        return (List<Sas_Application>) session.createCriteria(Sas_Application.class).add(Restrictions.eq("Sas_author.Sas_users_id", user.getSas_users_id())).list();
  
   }
}