package ers.servlet;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Type;
import beans.Users;
import beans.Reimbursement;
import ers.facade.ReimbFacade;

/**
 * Servlet implementation class AddReimbServlet
 */

public class AddReimbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddReimbServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ReimbFacade df = new ReimbFacade();
		Reimbursement reimb = new Reimbursement();
		Users user = new Users();
		Type type= new Type();
		
		double amount = Double.parseDouble((req.getParameter("reimb_amount")));
		reimb.setReimbAmount(amount);
		String descript = req.getParameter("reimb_descript");
		reimb.setReimbDescrip(descript);
		int typid = Integer.parseInt(req.getParameter("reimb_typeid"));
		type.setTypeId(typid);
		reimb.setReimbTypeId(type);
		
		req.getSession().getAttribute("UserId");
		System.out.println("AddServlet 2 test: " + req.getSession().getAttribute("UserId"));
		
		int UserId=((Integer)req.getSession().getAttribute("UserId"));
		System.out.println("AddServlet 1 test: " + UserId);
		user.setUsersId(UserId);
		reimb.setReimbAuthor(user);
		
		
		
		if(df.empinsert(reimb)){
			
			resp.sendRedirect(req.getContextPath() +"/secure/Emp.do");
		}else{
			req.getRequestDispatcher("/secure/addReimb.jsp").forward(req, resp);
		}
		
		try {
			df.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
