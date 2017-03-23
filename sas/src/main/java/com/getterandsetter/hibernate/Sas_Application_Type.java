package com.getterandsetter.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sas_Application_Type")
public class Sas_Application_Type {
	
	@Id
	@Column(name="Sas_job_type_id")
	private int Sas_job_type_id;
	@Column(name="Sas_job_type")
	private String Sas_job_type;
	
	//getterssetters
	public int getSas_job_type_id() {
		return Sas_job_type_id;
	}
	public void setSas_job_type_id(int sas_job_type_id) {
		Sas_job_type_id = sas_job_type_id;
	}
	public String getSas_job_type() {
		return Sas_job_type;
	}
	public void setSas_job_type(String sas_job_type) {
		Sas_job_type = sas_job_type;
	}
	
	//constructor
	public Sas_Application_Type(int sas_job_type_id, String sas_job_type) {
		super();
		Sas_job_type_id = sas_job_type_id;
		Sas_job_type = sas_job_type;
	}
	
	//no arg constructor
	public Sas_Application_Type() {
		super();
	}
	
	
	
	
	
}
