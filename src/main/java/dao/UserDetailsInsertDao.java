package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.UserDetails;

public class UserDetailsInsertDao {
	public static void Insert(UserDetails user) throws Exception {
		Connection connection;
		PreparedStatement statement;
		connection=ConnectionUtilDao.sqlConnection();
		String query="insert into  library_User_Details(NAME,email,PASSWORD,mobile,user_Id)values(?,?,?,?,?)";
		statement = connection.prepareStatement(query);
		statement.setString(1, user.getUserName());
		statement.setString(2, user.getUserEmail());

		statement.setString(3, user.getUserpassword());

		statement.setString(4, user.getUsermobile());
		statement.setInt(5, user.getUserId());
		
		int rows = statement.executeUpdate();
		System.out.println("No of rows inserted:"+rows);
		
		
		}
	public static UserDetails userDetails(String session) throws Exception{
		
		Connection connection = ConnectionUtilDao.sqlConnection();
		String name = null;
		String email = null;
		String number = null;
		int userid = 0;
		UserDetails user = new UserDetails();
		
		String query = "select * from  library_User_Details where user_Id=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, session);
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			name = rs.getString("name");
			email = rs.getString("email");
			number = rs.getString("mobile");
			userid = rs.getInt("user_Id");
		}
		user.setUserId(userid);
		user.setUserName(name);
		user.setUserEmail(email);
		user.setUsermobile(number);
		return user;
	}
}
