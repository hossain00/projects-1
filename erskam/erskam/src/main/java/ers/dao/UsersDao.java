package ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
import beans.UserRoles;
import beans.Users;

public class UsersDao {

	private Connection conn;

	public UsersDao(Connection conn) {
		this.conn = conn;
	}
	
// check to see if the user's password is correct
	
	public boolean checkUserpw(String username, String password) throws SQLException {
		String sql = "select ERS_PASSWORD from ERS_USERS where ERS_USERNAME = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		String pw = null;
		while (rs.next()) {
			pw = rs.getString("ERS_PASSWORD");
		}System.out.println(pw);
		
		return (BCrypt.checkpw(password, pw ));
	}
	

	// Used Determine to see if the person logging in is and employee or a manager

	public Users getUserbyUsername(String username) throws Exception {

		String sql = "SELECT * FROM ERS_USERS LEFT JOIN ERS_USER_ROLES"
				+ " ON ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID WHERE ERS_USERNAME = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		Users user = new Users();
		while (rs.next()) {
			user.setUserName(rs.getString("ERS_USERNAME"));
			user.setUsersId(rs.getInt("ERS_USER_ID"));
			user.setuEmail(rs.getString("USER_EMAIL"));
			user.setUfirstName(rs.getString("USER_FIRST_NAME"));
			user.setUlastName(rs.getString("USER_LAST_NAME"));
			user.setuRoleId(new UserRoles(rs.getInt("USER_ROLE_ID"), rs.getString("USER_ROLE")));

		}

		return user;

	}

}
