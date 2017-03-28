package com.getterandsetter.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_Users;

public class ApplicantDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//create a user
	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRES_NEW,
			isolation=Isolation.READ_COMMITTED)
	public void createSas_User(Sas_Users user){
		sessionFactory.getCurrentSession().save(user);
	}
	//create a application for a Applicant
	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRES_NEW,
			isolation=Isolation.READ_COMMITTED)
	public void createSas_Application(Sas_Application app){
		sessionFactory.getCurrentSession().save(app);
	}
	
	@Transactional
	public Sas_Application findApplication(int appId){
		return (Sas_Application) sessionFactory.getCurrentSession()
				.get(Sas_Application.class, appId);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Sas_Application> findAll(){
		return sessionFactory.getCurrentSession()
				.createCriteria(Sas_Application.class).list();
	}
	
	
	
}
