package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteByBookAuthorDao {
public static String deleteBooksAuthor(String id) throws Exception {
		
		Connection connection;
		PreparedStatement statement;
		connection=ConnectionUtilDao.sqlConnection();
		
		
		String query = "DELETE FROM books_library WHERE Author=?";
		statement = connection.prepareStatement(query);
		statement.setString(1,id);
	
		String result=null;
		int row =statement.executeUpdate();
		if(row==0)
		{
			result="Check Book Id";
		}
		else
		{
			result="Success Delete Book";
			
		}
		
		// addId(name, id);
		return result;
		
	}
}
