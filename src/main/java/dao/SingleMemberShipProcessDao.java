package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.UserProcessDetails;

public class SingleMemberShipProcessDao {
	public static List<UserProcessDetails> memberShipProcessDeatails(String name) throws Exception{
		List<UserProcessDetails> user=new ArrayList<UserProcessDetails>();
		Connection connection=ConnectionUtilDao.sqlConnection();
		PreparedStatement statement=null;
		ResultSet result=null;
		

		String query="select member_id,book_id,book_taken_date,book_return_date,book_status from book_register where member_id=?";
		

		statement=connection.prepareStatement(query);
		statement.setString(1,name );
		result=statement.executeQuery();

		UserProcessDetails process=null;
		while(result.next())
		{
			
			process=new UserProcessDetails();
			String memberId=result.getString("member_id");
			
			String bookId=result.getString("book_id");
			String bookTaken=result.getString("book_taken_date");
			String bookReturn=result.getString("book_return_date");
			String bookStatus=result.getString("book_status");
			
			
		    process.setMemberId(memberId);
			process.setBookId(bookId);
			process.setBookTakenDate(bookTaken);
			process.setBookReturnDate(bookReturn);
			process.setBookStatus(bookStatus);
			user.add(process);
			
			
		}
		return user;
	}
}
