package ers.servlet;

import java.io.IOException;
import beans.Users;
import ers.facade.ReimbFacade;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReimbFacade df = new ReimbFacade();
		// check to see if it got the input
		System.out.println("loginServlet 1 " + req.getParameter("Username"));

		Users user = df.getbyname(req.getParameter("Username"));

		req.getSession().setAttribute("User", user);

		// check to see if the input name

		System.out.println("loginServlet 2 " + user.getUserName());
		System.out.println("loginServlet 4  " + req.getParameter("Password"));
		String message = "Invalid: Username or Password";

		// check to see if the Username input is in the database or not
		if (user.getUserName() != null) {
			// if the user name is in the database, it will check to see if the
			// password matches
			if (df.checkUserpw(req.getParameter("Username"), req.getParameter("Password"))) {
				// if the first two is true, then it will check to see if the
				// user is 1 an employee if true, redirect to empServlet
				if (user.getuRoleId().getRoleId() == 1) {
					// if it is employee, will direct to emp site
					req.getSession().setAttribute("UserRole", 1);
					req.getSession().setAttribute("UserId", user.getUsersId());
					System.out.println("Logintest ID  " + req.getSession().getAttribute("UserId"));
					resp.sendRedirect(req.getContextPath() +"/secure/Emp.do");
					// if te user is not 1 employe then it check to see if it is
					// 2 Manager, redirect to manger
				} else if (user.getuRoleId().getRoleId() == 2) {
					// if it is manager, will direct to manager site
					req.getSession().setAttribute("UserRole", 2);
					req.getSession().setAttribute("UserId", user.getUsersId());
					resp.sendRedirect(req.getContextPath() +"/secure/Manager.do");
				}
			} else {
				req.getSession().setAttribute("Incorrect", message);
				resp.sendRedirect("index.jsp");
			}
		} else {
			req.getSession().setAttribute("Incorrect", message);
			resp.sendRedirect("index.jsp");
		}
		try {
			df.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
