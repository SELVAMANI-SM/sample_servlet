package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;


public class ReturnBooKDao {
public static String returnBook(String id,String name2) throws Exception {
		
		Connection connection;
		PreparedStatement statement;
		connection=ConnectionUtilDao.sqlConnection();
		String name="Available";
		String name1="Unavailable";
		
		String query = "UPDATE books_library SET Status_Book=? WHERE Book_id=? and Status_Book=? ";
		statement = connection.prepareStatement(query);
		statement.setString(1,name);
		statement.setString(2,id);
		statement.setString(3,name1);
		String result="Success Return Book";
		int row=statement.executeUpdate();
		if(row==1)
		{
			result="Success Return Book";
		}
		else
		{
			result="Check Book Id";
		}
		
		 ReturnBook(id, name2);
		return result;
		
	}
public static void ReturnBook(String name1,String id) throws Exception {
	Connection connection;
	connection = ConnectionUtilDao.sqlConnection();
	String name2 = "return";
	LocalDate date = LocalDate.now();
	String query1 = "update book_register set book_status='" + name2 + "' , book_return_date ='" + date
			+ "' where user_id='" + id + "'and book_id='"+ name1+"' " ;

	Statement stm = connection.createStatement();
	stm.executeUpdate(query1);

}
   
}
