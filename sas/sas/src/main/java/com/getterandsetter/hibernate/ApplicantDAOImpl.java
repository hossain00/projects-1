package com.getterandsetter.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.getterandsetter.hibernate.HibernateUtils;

public class ApplicantDAOImpl implements ApplicantDAO {

	private SessionFactory sf = HibernateUtils.getSessionFactory();
	private Session session;
	
	public ApplicantDAOImpl(){
		session = sf.openSession(); // session per request
	}
	
	public void create(Sas_User_Roles user_role) {
		Transaction tx = session.beginTransaction();
		try{
			session.save(user_role); 
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}
	}
	
	public void createSas_User(Sas_Users user) {
		Transaction tx = session.beginTransaction();
		try{
			//session.save(user_role);
			//user.setUser_role_id(user_role);
			session.save(user);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}
	}
	
	public void createSas_Application(Sas_Application app) {
		Transaction tx = session.beginTransaction();
		try{
			//session.save(user_role);
			//user.setUser_role_id(user_role);
			session.save(app);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}
	}
}
