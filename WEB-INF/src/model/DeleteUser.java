package model;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteUser extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		//first get all of the information from the form
		String id = request.getParameter("id").trim();
		DBConnection conn = null;
		PreparedStatement ps = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{
			conn = new DBConnection();
			//then check if the username already exist
			if(userExists(id, conn))
			{
				conn.getConnection().commit();
				System.out.println("The user deleted Successfully!");
			    out.println("success");
			}
			else
			{
				out.println("fail");
			}
			out.close();
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
	private static boolean userExists(String id, DBConnection conn) throws Exception
	{
		String SQL = "DELETE FROM users WHERE id = ?";
		PreparedStatement ps = conn.getPS(SQL);
		ps.setString(1, id);
		int rs = ps.executeUpdate();
		if (rs == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
