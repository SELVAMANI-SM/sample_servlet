package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;

public class MemberTakeBookDao {
public static String takeBook(String id,String name2) throws Exception {
		
		Connection connection;
		PreparedStatement statement;
		connection=ConnectionUtilDao.sqlConnection();
		String name="Unavailable";
		String name1="Available";
		
		String query = "UPDATE books_library SET Status_Book=? WHERE Book_id=? AND Status_Book=?";
		statement = connection.prepareStatement(query);
		statement.setString(1,name);
		statement.setString(2,id);
		statement.setString(3,name1);
		String result=null;
		int row =statement.executeUpdate();
		if(row==1)
		{
			result="Success Taken Book";
		}
		else
		{
			result="Book Not Available";
		}
		
		addId(id,name2);
		return result;
		
		
	}
   



public static void addId(String student, String name1) throws Exception {
	String name2 = "not return";
	LocalDate date = LocalDate.now();
	String query1 = "insert into book_register (member_id,book_id,book_taken_date,book_status)values('" + name1
			+ "','" + student + "','" + date + "','" + name2 + "')";
	Connection connection;
	connection = ConnectionUtilDao.sqlConnection();
	Statement stm = connection.createStatement();
	stm.executeUpdate(query1);

}
}
