package com.getterandsetter.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_User_Roles;
import com.getterandsetter.beans.Sas_Users;
import com.getterandsetter.hibernate.HibernateUtils;



public class ApplicantDAOImpl implements ApplicantDAO {

	private SessionFactory sf = HibernateUtils.getSessionFactory();
	private Session session;
	
	public ApplicantDAOImpl(){
		session = sf.openSession(); // session per request
	}
	
	
	//Creates new user roles?
	public void create(Sas_User_Roles user_role) {
		Transaction tx = session.beginTransaction();
		try{
			session.save(user_role); 
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}
	}
	
	//Create User?
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
	
	
	//only using this to create or add application
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
	
	//use this to update application
	public void update(Sas_Application app) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(app);
		tx.commit();
	}
	
	//delete application which we won't do
	public void delete(Sas_Application app) {
		Transaction tx = session.beginTransaction();
		session.delete(app);
		tx.commit();
	}
	
	//this finds the application by its ID
	public Sas_Application findOne(int appid) {
		Sas_Application application = (Sas_Application) session.load(Sas_Application.class, appid); //generate SELECT
		return application;
	}
	
	//get all the applications in a list

    @SuppressWarnings("unchecked")

    public List<Sas_Application> findAllApps() {

        //return session.createQuery("from Sas_Application").list();

        return session.createCriteria(Sas_Application.class).list();

    }
}