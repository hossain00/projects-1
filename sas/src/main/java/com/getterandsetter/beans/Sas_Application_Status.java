package com.getterandsetter.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sas_Application_Status")
public class Sas_Application_Status {
	@Id
	@Column(name="Sas_status_id")
	private int Sas_status_id;
	@Column(name="Sas_status")
	private String Sas_status;
	
	//getterssetter
	public int getSas_status_id() {
		return Sas_status_id;
	}
	public void setSas_status_id(int sas_status_id) {
		Sas_status_id = sas_status_id;
	}
	public String getSas_status() {
		return Sas_status;
	}
	public void setSas_status(String sas_status) {
		Sas_status = sas_status;
	}
	//constructor
	public Sas_Application_Status(int sas_status_id, String sas_status) {
		super();
		Sas_status_id = sas_status_id;
		Sas_status = sas_status;
	}
	//no arg constructor
	public Sas_Application_Status() {
		super();
		Sas_status_id = 1;
		Sas_status = "Pending";
	}
	
	
	
}
