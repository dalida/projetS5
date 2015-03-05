/**
 * @Author :
 * Romy Ardianto (romy.ardianto@telecom-bretagne.eu)
 * Lisa Maliphol (lisa.maliphol@telecom-bretagne.eu)
 */

package s5;

import java.sql.*;

/**
 * Utility class for managing the connection to the database (MySQL).
 * 
 * @author Romy Ardianto
 */
public class DataBaseConnection {
	//-----------------------------------------------------------------------------
	// Connection parameters
	private static String username        = "user_s5";
	private static String password        = "s5";
	private static String host            = "localhost";
	private static String numPort         = "3306";
	private static String base            = "s5";
	private static String connectString   = "jdbc:mysql://" + host + ":" + numPort + "/" + base;
	//-----------------------------------------------------------------------------
	// Registration of the MySQL JDBC Driver.
	static
	{
		try
		{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	//-----------------------------------------------------------------------------
	/**
	 * Obtaining a connection to the database.
	 *  
	 * @return an instance of the Connection class.
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(connectString,username,password);
	}
	//-----------------------------------------------------------------------------
}
