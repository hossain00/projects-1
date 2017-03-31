package com.getterandsetter.recommendations;

import java.util.List;

import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_SkillSet;

public class Recommended
{
	
	private Sas_SkillSet appSkills;
	private Sas_SkillSet desiredSkills;	
	private Sas_Application application;
	
	/**
	 * 
	 * @param appSkills : You need this for the applicants skills
	 * @param desiredSkills : you need this for the Job required skills
	 * @param application : you need this for relocation information from the applicant
	 */
	public Recommended(Sas_SkillSet appSkills, Sas_SkillSet desiredSkills, Sas_Application application) 
	{
		super();
		this.appSkills = appSkills;
		this.desiredSkills = desiredSkills;
		this.application = application;
	}
	
	

	@Override
	public String toString() {
		return "Recommended [appSkills=" + appSkills + ", desiredSkills=" + desiredSkills
				+ ", application=" + application + "]";
	}
	
	public int score()
	{
		/*amount of skills*/
		int skills;
		/*counter of matched skills*/
		int matchedSkills = 0;
		/*relocation score*/
		int relocationScore = 0;
		/**
		 * First get the skills to compare and throw them in a loop!!
		 */
		List<skilltemplate> desiredList = desiredSkills.getSkills();
		System.out.println(desiredList);
		System.out.println("Desired list finisheds");
		List<skilltemplate> applicantList = appSkills.getSkills();
		System.out.println(applicantList);
		
		skills = desiredList.size();
		
		for(int i = 0; i <1; i++)
		{
			if(desiredList.get(i).isValue() == applicantList.get(i).isValue())
			{
				matchedSkills++;
			}	
		}
		
		int skillScore = 10*(matchedSkills/skills);
		if (application.isRelocation())
		{
			relocationScore = 10;
		}
		
		return skillScore + relocationScore;
	}
}
