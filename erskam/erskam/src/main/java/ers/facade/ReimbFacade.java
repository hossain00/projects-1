package ers.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Reimbursement;
import beans.Users;
import ers.dao.ReimbursementDao;
import ers.dao.UsersDao;
import ers.utilities.ConnectionFactory;

public class ReimbFacade implements AutoCloseable {

	private UsersDao usersDao;
	private ReimbursementDao reimbursementDao;
	private Connection conn;

	public ReimbFacade() {
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			usersDao = new UsersDao(conn);
			reimbursementDao = new ReimbursementDao(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Reimbursement> alltickets() {
		List<Reimbursement> alltick = new ArrayList<Reimbursement>();
		try {
			alltick = reimbursementDao.alltickets();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return alltick;
	}

	public boolean empinsert(Reimbursement reimb) {
		boolean checkinsert = false;

		try {
			checkinsert = reimbursementDao.empinsert(reimb);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return checkinsert;
	}
	
	public boolean appordeni(Reimbursement reimb) {
		boolean updatecheck = false;

		try {
			updatecheck  = reimbursementDao.appovedAndDenied(reimb);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return updatecheck ;
	}
	
	
	

	public List<Reimbursement> getUserTicks(int id) {
		List<Reimbursement> oldtick = new ArrayList<Reimbursement>();
		try {
			oldtick = reimbursementDao.oldTickets(id);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return oldtick;
	}

	public boolean checkUserpw(String name, String password) {
		boolean checkpw = false;
		try {
			checkpw = usersDao.checkUserpw(name, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkpw;
	}

	public Users getbyname(String name) {

		Users getbn = new Users();
		try {
			getbn = usersDao.getUserbyUsername(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getbn;
	}

	@Override
	public void close() throws Exception {
		if (conn != null)
			conn.close();
	}

}
