package model;
import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.security.*;
public class AuthUser extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String name = request.getParameter("name").trim();
		String password = request.getParameter("password").trim() + name.substring(0, 2);
		DBConnection conn = null;
		try
		{
			conn = new DBConnection();
			//then check if the username already exist
			MessageDigest m = MessageDigest.getInstance("SHA-1");
			m.reset();
			m.update(password.getBytes());
			String encrypt_pass = CreateUser.byteArrayToHexString(m.digest());
			if(accountExists(name, encrypt_pass, conn))
			{
				System.out.println("Found User!");
				HttpSession session = request.getSession(true);
				session.setAttribute("name", name);
				Cookie cookie_name = new Cookie("name", name);
				cookie_name.setMaxAge(60 * 20);
				response.addCookie(cookie_name);
				request.setAttribute("model", "yes");
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/pages/LoggedIn.jsp");
				reqDispatcher.forward(request,response);
			}
			else
			{
				System.out.println("The user " + name + " has not been already found. Authentication failed");
				String message = "The user " + name + " has not been already found. Authentication failed";
				request.setAttribute("error_message", message);
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/pages/login.jsp");
				reqDispatcher.forward(request,response);
			}
			//if the user is created successfully, then send the email to the user
		}catch(Exception e)
		{
			try
			{
				conn.getConnection().rollback();
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			try
			{
				conn.closeConn();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static boolean accountExists(String name, String encrypt_password, DBConnection conn) throws SQLException
	{
		String SQL = "SELECT * FROM users WHERE name = ? AND pass = ?";
		PreparedStatement ps = conn.getPS(SQL);
		ps.setString(1, name);
		ps.setString(2, encrypt_password);
		ResultSet r = ps.executeQuery();
		if (r.next())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
