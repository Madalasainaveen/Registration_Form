package p1;
import java.sql.*;
public class RegistrationDAO 
{
	public int k=0;
	public int register(RegistrationBean rb)
	{
		try 
		{
			Connection con = DBConnection.getcon();
			PreparedStatement ps =con.prepareStatement
			("insert into userdetails values(?,?,?,?,?,?,?)");
			ps.setString(1,rb.getUsername());
			ps.setString(2, rb.getPassword());
			ps.setString(3, rb.getFirstname());
			ps.setString(4, rb.getLastname());
			ps.setString(5, rb.getAddress());
			ps.setString(6, rb.getMailId());
			ps.setLong(7, rb.getPhno());
			k=ps.executeUpdate();
			

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return k;
	}

}
