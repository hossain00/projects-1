package com.getterandsetter.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Hendy
 *You need to have a skill set for each job
 */
@Entity
@Table(name="Sas_Application_Type")
public class Sas_Application_Type {
	
	@Id
	@Column(name="Sas_job_type_id")
	private int Sas_job_type_id;
	@Column(name="Sas_job_type")
	private String Sas_job_type;
	
	
	
	/**
	 * Hendy Additions
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "Sas_Skill_Set_id")
	private Sas_SkillSet sas_Skill_Set_id;
	@Column(name="location")
	private String location;
	@Column(name="description")
	private String description;
	@Column(name="Industry_Position" , nullable = true)
	private String industryPosition;
	public Sas_SkillSet getSas_Skill_Set_id() {
		return sas_Skill_Set_id;
	}
	public void setSas_Skill_Set_id(Sas_SkillSet sas_Skill_Set_id) {
		this.sas_Skill_Set_id = sas_Skill_Set_id;
	}
	
	
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
	
	/*********************************/
	public Sas_SkillSet getJobSkillSet() {
		return sas_Skill_Set_id;
	}
	public void setJobSkillSet(Sas_SkillSet jobSkillSet) {
		this.sas_Skill_Set_id = jobSkillSet;
	}
	//**************//
	
	
	//constructor
	public Sas_Application_Type(int sas_job_type_id, String sas_job_type) {
		super();
		Sas_job_type_id = sas_job_type_id;
		Sas_job_type = sas_job_type;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIndustryPosition() {
		return industryPosition;
	}
	public void setIndustryPosition(String industryPosition) {
		this.industryPosition = industryPosition;
	}
	public Sas_Application_Type(int sas_job_type_id, String sas_job_type, Sas_SkillSet jobSkillSet) {
		super();
		Sas_job_type_id = sas_job_type_id;
		Sas_job_type = sas_job_type;
		this.sas_Skill_Set_id = jobSkillSet;
	}

	
	
	
	
	
	public Sas_Application_Type(int sas_job_type_id, String sas_job_type, Sas_SkillSet sas_Skill_Set_id,
			String location, String description, String industryPosition) {
		super();
		Sas_job_type_id = sas_job_type_id;
		Sas_job_type = sas_job_type;
		this.sas_Skill_Set_id = sas_Skill_Set_id;
		this.location = location;
		this.description = description;
		this.industryPosition = industryPosition;
	}
	//no arg constructor
	public Sas_Application_Type() {
		super();
	}
		
	
	
	
	
}