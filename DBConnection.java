package p1;
import java.sql.*;
import static p1.DBInfo.*;
public class DBConnection 
{
	private static Connection con;
	private DBConnection()
	{
		
	}
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(dburl,uname,pword);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getcon()
	{
		return con;
	}

}
