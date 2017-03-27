package com.getterandsetter.hibernate;

import org.junit.Test;

import com.getterandsetter.obsolete.ApplicantDAOImpl;

public class FindAppTest {
	@Test
	public void get(){
		System.out.println(new ApplicantDAOImpl().findOne(1350));
	}
}
