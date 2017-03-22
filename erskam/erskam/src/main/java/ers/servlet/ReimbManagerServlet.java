package ers.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Reimbursement;
import ers.facade.ReimbFacade;

public class ReimbManagerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ReimbFacade df = new ReimbFacade();
		// Get all reimb tickets from the database
		List<Reimbursement> tickets;

		tickets = df.alltickets();

		req.getSession().setAttribute("reimbslist", tickets);

		req.getRequestDispatcher("/secure/reimbmanager.jsp").forward(req, resp);

		try {
			df.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}