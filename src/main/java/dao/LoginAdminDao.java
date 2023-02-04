package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginAdminDao {
	public static  String loginValidator(String email,String password) throws Exception
	{
	Connection connection;
	PreparedStatement statement;
	connection=ConnectionUtilDao.sqlConnection();
	ResultSet rs = null;
	String query = "SELECT email,password,admin_id FROM Admin_Login WHERE email= ? or admin_id=?";
	statement = connection.prepareStatement(query);
	statement.setString(1,email);
	statement.setString(2,email);
	
	rs = statement.executeQuery();
	String mail = null;
	String Password=null;
	String  id=null;
	while(rs.next())
	{
	mail=rs.getString("email");
	Password=rs.getString("password");
	id=rs.getString("admin_id");
	
	}
	if(mail==null&&id==null)
	{
	return "First You Register";
	}
	
	else if(Password.equals(password))
	{
		return  "Logged In";
	}
	else
	{
		return "invalid credentials";
	}
}
}
