package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TakeBookLinkDao {
	public static String  ReferenceWebsite(String id) throws Exception {
		
		Connection connection;
		PreparedStatement statement;
		connection=ConnectionUtilDao.sqlConnection();
		ResultSet rs = null;
		String query = "SELECT reference_Website FROM books_library WHERE Book_id= ?";
		statement = connection.prepareStatement(query);
		statement.setString(1,id);
		
		rs = statement.executeQuery();
		String result=null;
		while(rs.next())
		{
	
		result=rs.getString("reference_Website");
		
		
		}
		return result;
	}

}
