package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginMemberShipDao {
	public static  String loginValidator(String email,String password) throws Exception
	{
	Connection connection;
	PreparedStatement statement;
	connection=ConnectionUtilDao.sqlConnection();
	ResultSet rs = null;
	String query = "SELECT Email,password,member_Id FROM Library_Membership_Details WHERE Email= ? or member_Id=?";
	statement = connection.prepareStatement(query);
	statement.setString(1,email);
	statement.setString(2,email);
	
	rs = statement.executeQuery();
	String mail = null;
	String Password=null;
	String id=null;
	while(rs.next())
	{
	mail=rs.getString("Email");
	Password=rs.getString("password");
	id=rs.getString("member_Id");
	
	}
	if(mail==null&&id==null)
	{
	return "First You Register";
	}
	
	else if(Password.equals(password))
	{
		return  id;
	}
	else
	{
		return "invalid credentials";
	}
}
}
