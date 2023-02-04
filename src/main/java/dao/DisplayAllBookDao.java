package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.BooksDetails;

public class DisplayAllBookDao {
	public static List<BooksDetails> book() throws Exception{
	
		List<BooksDetails> booklist= new ArrayList<BooksDetails>();
		Connection connection=ConnectionUtilDao.sqlConnection();
		PreparedStatement statement=null;
		ResultSet result=null;
		String query="select * from books_library";
		statement=connection.prepareStatement(query);
		result=statement.executeQuery();
		BooksDetails book=null;
		while(result.next())
		{
			book=new BooksDetails();
			String bookId=result.getString("Book_id");
			String bookName=result.getString("Books_Name");
			String dept=result.getString("Dept");
			String author=result.getString("Author");
			String statusBook=result.getString("Status_Book");
			String referenceWebsite=result.getString("reference_Website");
			String referenceVideo =result.getString("reference_Video");
			String bookImage=result.getString("image_Book");
			
			book.setBookId(bookId);
			book.setBookName(bookName);
			book.setBookAuthor(author);
			book.setBookDepartment(dept);
			book.setBookStatus(statusBook);
			book.seteBookLink(referenceWebsite);
			book.setBookVideoLink(referenceVideo);
			book.setBookImageLink(bookImage);
		
			
			booklist.add(book);
			
			
		}
		return booklist;
	}
}
