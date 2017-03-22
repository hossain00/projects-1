package ers.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Reimbursement;
import ers.facade.ReimbFacade;

@WebServlet("/ReimbEmployeeServlet")
public class ReimbEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReimbEmployeeServlet() {

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ReimbFacade df = new ReimbFacade();

		int UserId = ((Integer) req.getSession().getAttribute("UserId"));

		List<Reimbursement> utickets;
		utickets = df.getUserTicks(UserId);

		req.getSession().setAttribute("emplist", utickets);

		req.getRequestDispatcher("/secure/reimbemp.jsp").forward(req, resp);

		try {
			df.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
