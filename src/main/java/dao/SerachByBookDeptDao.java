package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BooksDetails;

public class SerachByBookDeptDao {

	public static List<BooksDetails> bookDept( String name) throws Exception
	{
		List<BooksDetails> booksdetails=  new ArrayList<BooksDetails>();
		Connection connection=ConnectionUtilDao.sqlConnection();
		Statement statement=null;
		ResultSet result=null;
		//System.out.println(name);
		String query="SELECT * FROM books_library WHERE Dept LIKE '%"+name+"%'";
		statement=connection.createStatement();
		result=statement.executeQuery(query);
		BooksDetails book=null;
		while(result.next())
		{
			book=new BooksDetails();
			String bookId=result.getString("Book_id");
			String bookName=result.getString("Books_Name");
			String dept=result.getString("Dept");
			//String author=result.getString("Author");
			String statusBook=result.getString("Status_Book");
			//String referenceWebsite=result.getString("reference_Website");
		//	String referenceVideo =result.getString("reference_Video");
			
			book.setBookId(bookId);
			book.setBookName(bookName);
			//book.setBookAuthor(author);
			book.setBookDepartment(dept);
			book.setBookStatus(statusBook);
		//	book.seteBookLink(referenceWebsite);
		//	book.setBookVideoLink(referenceVideo);
		
			
			booksdetails.add(book);
			
			
		}
		return booksdetails;
	}
}
