package model;
import java.sql.*;
import java.util.*;
public class DBConnection {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/jsp_final_project";

	private static final String USER = "root";
	private static final String PASSWORD = "Liu123499";
	private Connection conn;
	private PreparedStatement ps;
	public DBConnection() throws ClassNotFoundException, SQLException
	{
		this.conn = register();
		this.conn.setAutoCommit(false);
	}
	public PreparedStatement getPS(String SQL) throws SQLException
	{
		this.ps = this.conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		return this.ps;
	}
	public void closeConn() throws SQLException
	{
		this.ps.close();
		this.conn.close();
	}
	public Connection getConnection()
	{
		return this.conn;
	}
	private Connection register() throws ClassNotFoundException,SQLException
	{

		 //STEP 2: Register JDBC driver
	      Class.forName(JDBC_DRIVER);

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
	      System.out.println("Connection succeed!");
	      return conn;
	}
}
