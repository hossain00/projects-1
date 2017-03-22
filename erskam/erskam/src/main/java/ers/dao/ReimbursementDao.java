package ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Reimbursement;
import beans.Status;
import beans.Type;
import beans.UserRoles;
import beans.Users;

public class ReimbursementDao {

	private Connection conn;

	public ReimbursementDao(Connection conn) {
		this.conn = conn;
	}

	// Used Fetch Employee's old Reim Tickets
	public List<Reimbursement> oldTickets(int id) throws Exception {

		String sql = "SELECT * FROM REIMBURSEMENT_VIEW WHERE AUTH_ID = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();

		List<Reimbursement> result = new ArrayList<Reimbursement>();

		while (rs.next()) {
			Reimbursement ot = new Reimbursement();
			ot.setReimbId(rs.getInt("R_ID"));
			ot.setReimbAmount(rs.getDouble("AMOUNT"));
			ot.setReimbSubmit(rs.getTimestamp("SUB"));
			ot.setReimbResolved(rs.getTimestamp("RESLD"));
			ot.setReimbDescrip(rs.getString("DSCRIP"));
			ot.setReimbAuthor(new Users(rs.getInt("AUTH_ID"), rs.getString("AUTH_USERNAME"), rs.getString("AUTH_FNAME"),
					rs.getString("AUTH_LNAME"), rs.getString("AUTH_EMAIL"),
					new UserRoles(rs.getInt("AUTH_ROLE_ID"), rs.getString("AUTH_ROLE"))));
			ot.setReimbResolver(new Users(rs.getInt("RESLR_ID"), rs.getString("RESLR_USERNAME"),
					rs.getString("RESLR_FNAME"), rs.getString("RESLR_LNAME"), rs.getString("AUTH_EMAIL"),
					new UserRoles(rs.getInt("AUTH_ROLE_ID"), rs.getString("AUTH_ROLE"))));
			ot.setReimbStatusId(new Status(rs.getInt("STATUS_ID"), rs.getString("STATUS")));
			ot.setReimbTypeId(new Type(rs.getInt("TYPE_ID"), rs.getString("R_TYPE")));

			result.add(ot);
		}

		return result;

	}

	// used Create new Reimbursement ticket from emp
	public boolean empinsert(Reimbursement reimb) throws Exception {
		// sql to insert new ticket in to Reimbursement
		String sql = "INSERT INTO " + "ERS_REIMBURSEMENT(REIMB_AMOUNT," + "REIMB_SUBMITTED,REIMB_DESCRIPTION,"
				+ "REIMB_AUTHOR,REIMB_TYPE_ID) " + "VALUES(?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
		stmt.setDouble(1, reimb.getReimbAmount());
		stmt.setTimestamp(2, sqlDate);
		stmt.setString(3, reimb.getReimbDescrip());
		stmt.setInt(4, reimb.getReimbAuthor().getUsersId());
		stmt.setInt(5, reimb.getReimbTypeId().getTypeId());
		System.out.println("ReimbDao 1 test " + reimb.getReimbAmount());
		System.out.println("ReimbDao 2 test " + reimb.getReimbDescrip());
		System.out.println("ReimbDao 3 test " + reimb.getReimbAuthor().getUsersId());
		System.out.println("ReimbDao 4 test " + reimb.getReimbTypeId().getTypeId());

		if (stmt.executeUpdate() != 0) {

			return true;
		} else
			return false;
	}

	// used this function returns all tickets from reimbursement table
	public List<Reimbursement> alltickets() throws Exception {

		String sql = "SELECT * FROM REIMBURSEMENT_VIEW";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Reimbursement> result = new ArrayList<Reimbursement>();
		while (rs.next()) {
			Reimbursement reimb = new Reimbursement();
			reimb.setReimbId(rs.getInt("R_ID"));
			reimb.setReimbAmount(rs.getDouble("AMOUNT"));
			reimb.setReimbSubmit(rs.getTimestamp("SUB"));
			reimb.setReimbResolved(rs.getTimestamp("RESLD"));
			reimb.setReimbDescrip(rs.getString("DSCRIP"));
			reimb.setReimbAuthor(new Users(rs.getInt("AUTH_ID"), rs.getString("AUTH_USERNAME"),
					rs.getString("AUTH_FNAME"), rs.getString("AUTH_LNAME"), rs.getString("AUTH_EMAIL"),
					new UserRoles(rs.getInt("AUTH_ROLE_ID"), rs.getString("AUTH_ROLE"))));
			reimb.setReimbResolver(new Users(rs.getInt("RESLR_ID"), rs.getString("RESLR_USERNAME"),
					rs.getString("RESLR_FNAME"), rs.getString("RESLR_LNAME"), rs.getString("AUTH_EMAIL"),
					new UserRoles(rs.getInt("AUTH_ROLE_ID"), rs.getString("AUTH_ROLE"))));
			reimb.setReimbStatusId(new Status(rs.getInt("STATUS_ID"), rs.getString("STATUS")));
			reimb.setReimbTypeId(new Type(rs.getInt("TYPE_ID"), rs.getString("R_TYPE")));

			result.add(reimb);
		}
		return result;

	}
	//Used Change the approved or Denied status of a ticket
	public boolean appovedAndDenied(Reimbursement reimb) throws Exception {

		String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID=?,REIMB_RESOLVED=?,REIMB_RESOLVER=? WHERE REIMB_ID=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());

		stmt.setInt(1, reimb.getReimbStatusId().getStatusId());
		stmt.setTimestamp(2, sqlDate);
		stmt.setInt(3, reimb.getReimbResolver().getUsersId());
		stmt.setInt(4, reimb.getReimbId());
		System.out.println("ReimbDao 5 test " + reimb.getReimbStatusId().getStatusId());
		System.out.println("ReimbDao 6 test " + reimb.getReimbResolver().getUsersId());
		System.out.println("ReimbDao 7 test " + reimb.getReimbId());
		

		if (stmt.executeUpdate() != 0) {

			return true;
		} else
			return false;
	}

}
