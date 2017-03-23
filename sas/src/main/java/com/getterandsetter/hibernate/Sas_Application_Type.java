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
	@Column(name="Sas_job_industry")
	private String Sas_job_industry;
	@Column(name="Sas_job_location")
	private String Sas_job_location;
	@Column(name="Sas_job_description")
	private String Sas_job_description;
	
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
	
	
	
	public String getSas_job_industry() {
		return Sas_job_industry;
	}
	public void setSas_job_industry(String sas_job_industry) {
		Sas_job_industry = sas_job_industry;
	}
	public String getSas_job_location() {
		return Sas_job_location;
	}
	public void setSas_job_location(String sas_job_location) {
		Sas_job_location = sas_job_location;
	}
	public String getSas_job_description() {
		return Sas_job_description;
	}
	public void setSas_job_description(String sas_job_description) {
		Sas_job_description = sas_job_description;
	}
	//constructor
/*	
	public Sas_Application_Type(int sas_job_type_id, String sas_job_type) {
		super();
		Sas_job_type_id = sas_job_type_id;
		Sas_job_type = sas_job_type;
	} */
	
	public Sas_Application_Type(int sas_job_type_id, String sas_job_type, String sas_job_industry,
			String sas_job_location, String sas_job_description) {
		super();
		Sas_job_type_id = sas_job_type_id;
		Sas_job_type = sas_job_type;
		Sas_job_industry = sas_job_industry;
		Sas_job_location = sas_job_location;
		Sas_job_description = sas_job_description;
	}
	//no arg constructor
	public Sas_Application_Type() {
		super();
	}
	
	
	
	
	
}
