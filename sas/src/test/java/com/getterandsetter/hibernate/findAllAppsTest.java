package com.getterandsetter.hibernate;

import java.util.List;

import org.junit.Test;

import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.obsolete.ApplicantDAOImpl;

public class findAllAppsTest {
	@Test
	public void test(){
		List<Sas_Application> apps = new ApplicantDAOImpl().findAllApps();
		for(Sas_Application h : apps){
			System.out.println(h);
		}
	}
}
