package com.getterandsetter.hibernate;


import java.util.ArrayList;

/**
 * 
 * @author Hendy
 *
 */

public class HiringManager extends Sas_Users
{
	private ArrayList<String> desiredSkills;

	public ArrayList<String> getDesiredSkills() {
		return desiredSkills;
	}

	public void setDesiredSkills(ArrayList<String> desiredSkills) {
		this.desiredSkills = desiredSkills;
	}
}
