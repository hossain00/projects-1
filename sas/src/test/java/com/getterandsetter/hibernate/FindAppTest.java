package com.getterandsetter.hibernate;

import org.junit.Test;

import com.getterandsetter.dao.ApplicantDAOImpl;

public class FindAppTest {
	@Test
	public void get(){
		System.out.println(new ApplicantDAOImpl().findOne(1350));
	}
}
