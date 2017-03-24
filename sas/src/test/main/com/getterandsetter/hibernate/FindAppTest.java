package com.getterandsetter.hibernate;

import org.junit.Test;

public class FindAppTest {
	@Test
	public void get(){
		System.out.println(new ApplicantDAOImpl().findOne(1350));
	}
}
