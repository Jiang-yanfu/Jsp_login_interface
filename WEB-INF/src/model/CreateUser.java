package model;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.security.*;
public class CreateUser extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		//first get all of the information from the form
		String name = request.getParameter("name").trim();
		String password = request.getParameter("password").trim() + name.substring(0, 2);
		String email = request.getParameter("email").trim();
		DBConnection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = new DBConnection();
			//then check if the username already exist
			MessageDigest m = MessageDigest.getInstance("SHA-1");
			m.reset();
			m.update(password.getBytes());
			String encrypt_pass = byteArrayToHexString(m.digest());
			String SQL = "INSERT INTO users (name, pass, email) VALUES (? , ? , ?)";
			ps = conn.getPS(SQL);
			ps.setString(1, name);
			ps.setString(2, encrypt_pass);
			ps.setString(3, email);
			if(!userExists(name, conn))
			{
				int rows = ps.executeUpdate();
				conn.getConnection().commit();
				System.out.println("The user created Successfully!");
				System.out.println("The number of rows affected is : " + rows);
				HttpSession session = request.getSession(false);
				session.setAttribute("name", name);
				Cookie cookie = new Cookie("name", name);
				response.addCookie(cookie);
				response.sendRedirect("http://localhost:8080/jsp/pages/login.jsp");
				return;

			}
			else
			{

				System.out.println("The user " + name + " has already existed. Creation failed");
				String message = "The user " + name + " has already existed. Creation failed";
				request.setAttribute("error_message", message);
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/pages/register.jsp");
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
	public static String byteArrayToHexString(byte[] b) {
		String result = "";
		for (int i=0; i < b.length; i++) {
			result +=
				Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
		}
		return result;
	}
	private static boolean userExists(String name, DBConnection conn) throws Exception
	{
		String SQL = "SELECT * FROM users WHERE name = ?";
		PreparedStatement ps = conn.getPS(SQL);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
