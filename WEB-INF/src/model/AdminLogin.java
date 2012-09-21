package model;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AdminLogin extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String name = request.getParameter("name").trim();
		String password = request.getParameter("password").trim();
		DBConnection conn = null;
		try
		{
			conn = new DBConnection();
			//then check if the username already exist
			if(accountExists(name, password, conn))
			{
				System.out.println("Found User!");
				request.setAttribute("model", "yes");
				HttpSession session = request.getSession(true);
				session.setAttribute("admin_name", name);
				ArrayList<String> users = pullUser(conn);
				request.setAttribute("users", users);
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/pages/admin.jsp");
				reqDispatcher.forward(request,response);
			}
			else
			{
				System.out.println("The admin " + name + " has not been already found. Authentication failed");
				String message = "The admin " + name + " has not been already found. Authentication failed";
				request.setAttribute("error_message", message);
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/pages/admin_login.jsp");
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
		String SQL = "SELECT * FROM admin WHERE username = ? AND password = ?";
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
	public static ArrayList<String> pullUser(DBConnection conn) throws SQLException
	{
		String SQL = "SELECT * FROM users";
		PreparedStatement ps = conn.getPS(SQL);
		ResultSet rs = ps.executeQuery();
		ArrayList<String> users = new ArrayList<String>();
		while(rs.next())
		{
			String name = rs.getString("name");
			users.add(name);
		}
		return users;
	}
}
