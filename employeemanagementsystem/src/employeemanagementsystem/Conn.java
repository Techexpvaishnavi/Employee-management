package employeemanagementsystem;

import java.sql.*;
public class Conn 
{

	Connection connection;
	Statement statement;
	public Conn()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem ","root","12345678");
			statement = connection.createStatement();
		}
		catch (Exception e)
		{
			e.printStackTrace();		}
		}

}