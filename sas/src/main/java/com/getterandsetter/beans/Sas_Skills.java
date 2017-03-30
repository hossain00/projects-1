package com.getterandsetter.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Skill")
public class Sas_Skills 
{
	@Id
	@Column(name = "Sas_Skill_id")
	@SequenceGenerator(name = "Sas_Skill_id_gen", sequenceName = "Sas_Skill_id_seq" , initialValue=1, allocationSize=1)
	@GeneratedValue(generator = "Sas_Skill_id_gen", strategy = GenerationType.SEQUENCE)
	private int skill_ID;
	
	@Column(name = "Sas_Skill_Name")
	private String skillName;

	public int getSkill_ID() {
		return skill_ID;
	}

	public void setSkill_ID(int skill_ID) {
		this.skill_ID = skill_ID;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Sas_Skills(int skill_ID, String skillName) {
		super();
		this.skill_ID = skill_ID;
		this.skillName = skillName;
	}

	public Sas_Skills()
	{
		super();
	}
	
	
}
 