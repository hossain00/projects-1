package com.getterandsetter.hibernate;

import java.util.List;

import org.junit.Test;
/**
 * 
 * @author Hendy
 *
 */
public class HiringMangerTest 
{
	@Test
	public void test()
	{
		HiringManagerDAOImpl dao= new HiringManagerDAOImpl();
		List list = dao.getAllApplicants();
		System.out.println(list);
	}
}

