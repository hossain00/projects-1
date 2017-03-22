package ers.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "Kam";
	private static final String password = "6390211";

	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");  		
		return DriverManager.getConnection(url, user, password);
	}
	
}