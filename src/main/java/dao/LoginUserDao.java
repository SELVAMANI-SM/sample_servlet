package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginUserDao {
		
		public static  String loginValidator(String email,String password) throws Exception
		{
			
		Connection connection;
		PreparedStatement statement;
		connection=ConnectionUtilDao.sqlConnection();
		ResultSet rs = null;
		String query = "SELECT email,password,user_Id FROM library_User_Details WHERE email= ? or user_Id=?";
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
		id=rs.getString("user_Id");
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
