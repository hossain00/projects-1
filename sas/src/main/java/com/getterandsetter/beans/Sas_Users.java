package com.getterandsetter.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sas_Users")
public class Sas_Users {
	@Id
	@Column(name = "Sas_users_id")
	private int Sas_users_id;
	@Column(name = "Sas_password")
	private String Sas_password;
	@Column(name = "User_first_name")
	private String User_first_name;
	@Column(name = "User_email", unique = true)
	private String User_email;

	// if @OneToMany(mapped="clearance")
	// private Set<Employee> members;
	// foreign key many to one which is in the Sas_User_Roles table(SAS_ROLE_ID)
	@ManyToOne
	@JoinColumn(name = "User_role_id") // this is just the name
														// of the column we
														// create
	private Sas_User_Roles User_role_id;

	@Column(name = "User_last_name")
	private String User_last_name;

	@Column(name = "Sas_username", unique = true)
	private String Sas_username;

	public int getSas_users_id() {
		return Sas_users_id;
	}

	public void setSas_users_id(int sas_users_id) {
		Sas_users_id = sas_users_id;
	}

	public String getSas_password() {
		return Sas_password;
	}

	public void setSas_password(String sas_password) {
		Sas_password = sas_password;
	}

	public String getUser_first_name() {
		return User_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		User_first_name = user_first_name;
	}

	public String getUser_email() {
		return User_email;
	}

	public void setUser_email(String user_email) {
		User_email = user_email;
	}

	public Sas_User_Roles getUser_role_id() {
		return User_role_id;
	}

	public void setUser_role_id(Sas_User_Roles user_role_id) {
		User_role_id = user_role_id;
	}

	public String getUser_last_name() {
		return User_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		User_last_name = user_last_name;
	}

	public String getSas_username() {
		return Sas_username;
	}

	public void setSas_username(String sas_username) {
		Sas_username = sas_username;
	}

	public Sas_Users(int sas_users_id, String sas_password, String user_first_name, String user_email,
			Sas_User_Roles user_role_id, String user_last_name, String sas_username) {
		super();
		Sas_users_id = sas_users_id;
		Sas_password = sas_password;
		User_first_name = user_first_name;
		User_email = user_email;
		User_role_id = user_role_id;
		User_last_name = user_last_name;
		Sas_username = sas_username;
	}

	public Sas_Users() {
		super();
	}

	@Override
	public String toString() {
		return "Sas_Users [Sas_users_id=" + Sas_users_id + ", Sas_password=" + Sas_password + ", User_first_name="
				+ User_first_name + ", User_email=" + User_email + ", User_role_id=" + User_role_id
				+ ", User_last_name=" + User_last_name + ", Sas_username=" + Sas_username + "]";
	}

}
