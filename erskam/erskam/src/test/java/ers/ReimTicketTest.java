package ers;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import beans.Users;
import ers.facade.ReimbFacade;

public class ReimTicketTest {


	
	@Test
	public void test() {
		try{
		String usernam ="MaxMiller";
		String password = "Miller123";
		
		ReimbFacade df = new ReimbFacade();
	

	if (df.checkUserpw(usernam, password)){
		
		System.out.println("match");
		
	}else{
		System.out.println("Not");
	}
	
	
			//System.out.println(all.getErsUserId()+u.getErsUsername());
		}catch (Exception e){
			e.printStackTrace();
			
			fail("EmpID not Found");	
			
		}
	}
	
}