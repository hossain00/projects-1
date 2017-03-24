package com.getterandsetter.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="Sas_User_Roles")
public class Sas_User_Roles {
	@Id
	private int Sas_user_role_id;
	@Column(name="User_role")
	private String User_role;
	
	//getters and setters
	public int getSas_user_role_id() {
		return Sas_user_role_id;
	}
	public void setSas_user_role_id(int sas_user_role_id) {
		Sas_user_role_id = sas_user_role_id;
	}
	public String getUser_role() {
		return User_role;
	}
	public void setUser_role(String user_role) {
		User_role = user_role;
	}
	
	//constructor
	public Sas_User_Roles(int sas_user_role_id, String user_role) {
		super();
		Sas_user_role_id = sas_user_role_id;
		User_role = user_role;
	}
	
	//no arg constructor for bean
	public Sas_User_Roles() {
		super();
	}
	
	//toString
	@Override
	public String toString() {
		return "Sas_User_Roles [Sas_user_role_id=" + Sas_user_role_id + ", User_role=" + User_role + "]";
	}
	
	
	
	
	
	
	
}
