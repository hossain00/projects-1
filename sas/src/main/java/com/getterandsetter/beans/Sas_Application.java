package com.getterandsetter.beans;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Sas_Application")
public class Sas_Application {

	@Id
	@Column(name = "Sas_id")
	@SequenceGenerator(name = "Sas_id_gen", sequenceName = "Sas_id_seq")
	@GeneratedValue(generator = "Sas_id_gen", strategy = GenerationType.SEQUENCE)
	private int Sas_id;

	@Column(name = "Sas_submitted")
	private Timestamp Sas_submitted;

	@Column(name = "Sas_resolved")
	private Timestamp Sas_resolved;

	@Column(name = "Sas_skills")
	private String Sas_skills;

	@Column(name = "Resume")
	private byte[] Resume;

	@ManyToOne
	@JoinColumn(name = "Sas_approver")
	private Sas_Users Sas_approver;

	@ManyToOne
	@JoinColumn(name = "Sas_status_id")
	private Sas_Application_Status Sas_status_id;

	@ManyToOne
	@JoinColumn(name = "Sas_author")
	private Sas_Users Sas_author;
	@ManyToOne
	@JoinColumn(name = "Sas_job_type_id")
	private Sas_Application_Type Sas_job_type_id;
	
	
	//getters and setters
	public int getSas_id() {
		return Sas_id;
	}
	public void setSas_id(int sas_id) {
		Sas_id = sas_id;
	}
	public Timestamp getSas_submitted() {
		return Sas_submitted;
	}
	public void setSas_submitted(Timestamp sas_submitted) {
		Sas_submitted = sas_submitted;
	}
	public Timestamp getSas_resolved() {
		return Sas_resolved;
	}
	public void setSas_resolved(Timestamp sas_resolved) {
		Sas_resolved = sas_resolved;
	}
	public String getSas_skills() {
		return Sas_skills;
	}
	public void setSas_skills(String sas_skills) {
		Sas_skills = sas_skills;
	}
	public byte[] getResume() {
		return Resume;
	}
	public void setResume(byte[] resume) {
		Resume = resume;
	}
	public Sas_Users getSas_approver() {
		return Sas_approver;
	}
	public void setSas_approver(Sas_Users sas_approver) {
		Sas_approver = sas_approver;
	}
	public Sas_Application_Status getSas_status_id() {
		return Sas_status_id;
	}
	public void setSas_status_id(Sas_Application_Status sas_status_id) {
		Sas_status_id = sas_status_id;
	}
	public Sas_Users getSas_author() {
		return Sas_author;
	}
	public void setSas_author(Sas_Users sas_author) {
		Sas_author = sas_author;
	}
	public Sas_Application_Type getSas_job_type_id() {
		return Sas_job_type_id;
	}
	public void setSas_job_type_id(Sas_Application_Type sas_job_type_id) {
		Sas_job_type_id = sas_job_type_id;
	}
	
	//toString
	@Override
	public String toString() {
		return "Sas_Application [Sas_id=" + Sas_id + ", Sas_submitted=" + Sas_submitted + ", Sas_resolved="
				+ Sas_resolved + ", Sas_skills=" + Sas_skills + ", Sas_approver=" + Sas_approver + ", Sas_status_id="
				+ Sas_status_id + ", Sas_author=" + Sas_author + ", Sas_job_type_id=" + Sas_job_type_id + "]";
	}
	
	//no arg constructor
	public Sas_Application() {
		super();
	}
	
	//constructor without resume
	public Sas_Application(int sas_id, Timestamp sas_submitted, Timestamp sas_resolved, String sas_skills,
			Sas_Users sas_approver, Sas_Application_Status sas_status_id, Sas_Users sas_author,
			Sas_Application_Type sas_job_type_id) {
		super();
		Sas_id = sas_id;
		Sas_submitted = sas_submitted;
		Sas_resolved = sas_resolved;
		Sas_skills = sas_skills;
		Sas_approver = sas_approver;
		Sas_status_id = sas_status_id;
		Sas_author = sas_author;
		Sas_job_type_id = sas_job_type_id;
	}
	
	//constructor with not null args, no App Id is generated
	public Sas_Application(Sas_Application_Status sas_status_id, Sas_Users sas_author,
			Sas_Application_Type sas_job_type_id) {
		super();
		
		Sas_status_id = sas_status_id;
		Sas_author = sas_author;
		Sas_job_type_id = sas_job_type_id;
	}
	
	//constructor with id
	public Sas_Application(int sas_id, Sas_Application_Status sas_status_id, Sas_Users sas_author,
			Sas_Application_Type sas_job_type_id) {
		super();
		Sas_id = sas_id;
		Sas_status_id = sas_status_id;
		Sas_author = sas_author;
		Sas_job_type_id = sas_job_type_id;
	}
	
	
	
	
	
	
	
	
	
	

	
}
