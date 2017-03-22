package ers.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("Destroy");

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		boolean authen = false;
		String page = request.getRequestURI();
		int userRole = ((Integer) request.getSession().getAttribute("UserRole"));
		System.out.println(request.getRequestURI());
		String mangDo = "/ers/secure/Manager.do";
		String mangJsp = "/ers/secure/reimbmanager.jsp";
		String empDo = "/ers/secure/Emp.do";
		String empJsp = "/ers/secure/reimbemp.jsp";
		String empAdd = "/ers/secure/addReimb.jsp";

		if (request.getSession().getAttribute("UserRole") != null) {
			System.out.println(userRole);
			if ((userRole == 1) && (!page.equals(mangJsp) && !page.equals(mangDo))) {
				authen = true;
			} else if (userRole == 2 && (!page.equals(empDo) && !page.equals(empJsp) && !page.equals(empAdd))) {

				authen = true;
			}
		}

		if (authen) {
			System.out.println("Authen");
			fChain.doFilter(req, resp);
		} else {
			System.out.println("NOT Authen");
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/index.jsp");

		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init");

	}

}
