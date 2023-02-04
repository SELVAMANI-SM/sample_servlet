package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookVideoLinkDao {
public static String  referenceVideo(String id) throws Exception {
		
		Connection connection;
		PreparedStatement statement;
		connection=ConnectionUtilDao.sqlConnection();
		ResultSet rs = null;
		String query = "SELECT reference_Video FROM books_library WHERE Book_id= ?";
		statement = connection.prepareStatement(query);
		statement.setString(1,id);
		
		rs = statement.executeQuery();
		String result=null;
		while(rs.next())
		{
	
		result=rs.getString("reference_Video");
		
		
		}
		return result;
	}

}
