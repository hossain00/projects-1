package com.getterandsetter.obsolete;
import java.util.List;
import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_User_Roles;
import com.getterandsetter.beans.Sas_Users;
public interface ApplicantDAO {
    public void createSas_User_Roles(Sas_User_Roles user_role);
    public void createSas_User(Sas_Users sas_Users);
    public Sas_Application createSas_Application(Sas_Application app);
    public List<Sas_Application> getAppsByUserCriteria(Sas_Users user);
    public List<Sas_Application> findJobTypes();
}