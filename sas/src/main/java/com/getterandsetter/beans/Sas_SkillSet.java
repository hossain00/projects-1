package com.getterandsetter.beans;

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
@Table(name = "Skill_Set")
public class Sas_SkillSet 
{
	/*variables for identification*/
	@Id
	@Column(name = "Sas_Skill_Set_id")
	@SequenceGenerator(name = "Sas_Skill_Set_id_gen", sequenceName = "Sas_Skill_Set_id_seq" , initialValue=1, allocationSize=1)
	@GeneratedValue(generator = "Sas_Skill_Set_id_gen", strategy = GenerationType.SEQUENCE)
	private int Sas_Skill_Set_id;
		
	@ManyToOne
	//@JoinColumn(name = "Sas_users_id")
	private Sas_Users user;
	
	/*skills that users have*/
	
	@Column(name = "java")
	private boolean java;
	@Column(name = "sql")
	private boolean sql;
	@Column(name = "python")
	private boolean python;
	@Column(name = "spring")
	private boolean spring;
	@Column(name = "hibernate")
	private boolean hibernate;
	
	
	public int getSas_Skill_Set_id() {
		return Sas_Skill_Set_id;
	}
	public void setSas_Skill_Set_id(int skillSet_ID) {
		this.Sas_Skill_Set_id = skillSet_ID;
	}
	public Sas_Users getUser() {
		return user;
	}
	public void setUser(Sas_Users sas_users_id) {
		user = sas_users_id;
	}
	public boolean isJava() {
		return java;
	}
	public void setJava(boolean java) {
		this.java = java;
	}
	public boolean isSql() {
		return sql;
	}
	public void setSql(boolean sql) {
		this.sql = sql;
	}
	public boolean isPython() {
		return python;
	}
	public void setPython(boolean python) {
		this.python = python;
	}
	public boolean isSpring() {
		return spring;
	}
	public void setSpring(boolean spring) {
		this.spring = spring;
	}
	public boolean isHibernate() {
		return hibernate;
	}
	public void setHibernate(boolean hibernate) {
		this.hibernate = hibernate;
	}
	
	
	public Sas_SkillSet() {
		super();
		
	}
	public Sas_SkillSet(int skillSet_ID, Sas_Users user, boolean java, boolean sql, boolean python, boolean spring,
			boolean hibernate) {
		super();
		this.Sas_Skill_Set_id = skillSet_ID;
		this.user = user;
		this.java = java;
		this.sql = sql;
		this.python = python;
		this.spring = spring;
		this.hibernate = hibernate;
	}
	
	
	
}