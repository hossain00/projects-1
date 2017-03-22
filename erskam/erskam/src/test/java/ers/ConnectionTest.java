package ers;

import org.junit.Test;

import ers.utilities.ConnectionFactory;

import static org.junit.Assert.*;

public class ConnectionTest {

	@Test
	public void test(){
		try {
			assertNotNull(ConnectionFactory.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}