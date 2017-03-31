package com.getterandsetter.recommendations;

public class skilltemplate 
{
	private String skillname;
	private boolean value;
	
	
	public skilltemplate(String skillname, boolean value) 
	{
		super();
		this.skillname = skillname;
		this.value = value;
	}


	public String getSkillname() {
		return skillname;
	}


	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}


	public boolean isValue() {
		return value;
	}


	public void setValue(boolean value) {
		this.value = value;
	} 
	
	
	
	
}
