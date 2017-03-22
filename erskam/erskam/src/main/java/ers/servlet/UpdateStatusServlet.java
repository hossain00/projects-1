package ers.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Reimbursement;
import beans.Status;
import beans.Users;
import ers.facade.ReimbFacade;

/**
 * Servlet implementation class UpdateStatusServlet
 */

public class UpdateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateStatusServlet() {
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ReimbFacade df = new ReimbFacade();
		Reimbursement reimb = new Reimbursement();
		Users user = new Users();
		Status changestatId = new Status();
		
		//set the ReimbId to the row that needs to be updated
		int ReimbId = Integer.parseInt(req.getParameter("reimb_id"));
		reimb.setReimbId(ReimbId);
		System.out.println("UpdateServlet 0 test: " + ReimbId);
		
		//set the UserID from session to auther id
		req.getSession().getAttribute("UserId");
		System.out.println("UpdateServlet 1 test: " + req.getSession().getAttribute("UserId"));
		int UserId=((Integer)req.getSession().getAttribute("UserId"));
		System.out.println("UpdateServlet 2 test: " + UserId);
		
		user.setUsersId(UserId);
		reimb.setReimbResolver(user);
		
		int statuschangeid = Integer.parseInt(req.getParameter("Update_Statis"));
		System.out.println("UpdateServlet 3 test: " + req.getParameter("Update_Statis"));
		changestatId.setStatusId(statuschangeid);
		reimb.setReimbStatusId(changestatId);
		
		boolean UpdateAoD = false;
		UpdateAoD =df.appordeni(reimb);
		
		if(UpdateAoD){
			
			resp.sendRedirect(req.getContextPath() + "/secure/Manager.do");
		}else{
			resp.sendRedirect("/secure/reimbmanager.jsp");
		}
		try {
			df.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
