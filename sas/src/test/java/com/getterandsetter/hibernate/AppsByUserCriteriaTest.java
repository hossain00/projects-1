package com.getterandsetter.hibernate;

import java.util.List;
import org.junit.Test;
import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_User_Roles;
import com.getterandsetter.beans.Sas_Users;
import com.getterandsetter.obsolete.ApplicantDAOImpl;
public class AppsByUserCriteriaTest {
    @Test
    public void test(){     
        List<Sas_Application> apps = new ApplicantDAOImpl().getAppsByUserCriteria(new Sas_Users(7, "welcome1", "Robert", "robertr@gmail.com",
                new Sas_User_Roles(2, "Applicant"), "Red", "rred55"));
        for(Sas_Application h : apps){
            System.out.println(h);
        }
    }
}
