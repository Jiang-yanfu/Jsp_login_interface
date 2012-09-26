package model;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Logout extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String username = "";
		//clean the current session first
		HttpSession session = request.getSession(false);
		if(session != null)
		{
			if(session.getAttribute("admin_name") != null)
			{
				username = session.getAttribute("admin_name").toString();
			}
			else if(session.getAttribute("name") != null)
			{
				username = session.getAttribute("name").toString();
			}
			System.out.println("Current session username: " + username);
			session.invalidate();
			System.out.println("Session deleted!");
		}
		//clean the associated cookie with the username
		Cookie[] cookies = request.getCookies();
		for(Cookie each : cookies)
		{
			if(each.getValue().equals(username))
			{
				each.setMaxAge(0);
				response.addCookie(each);
				System.out.println("cookie for " + username + " is deleted successfully!");
				response.sendRedirect("http://localhost:8080/jsp/pages/login.jsp");
				return;
			}
		}
		System.out.println("cookie is not delelted! Redirect any way");
		response.sendRedirect("http://localhost:8080/jsp/pages/login.jsp");
	}
}
