package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.BooksDetails;

public class AddBookDao {
	public static void bookinsert( BooksDetails book) throws Exception
	{
	
	Connection connection;
	PreparedStatement statement;
	connection = ConnectionUtilDao.sqlConnection();
	String query = "insert into books_library (Book_id,Books_Name,Dept,Author,Status_Book,reference_Website,Reference_Video,image_Book) values (?,?,?,?,?,?,?,?)";
	
	statement = connection.prepareStatement(query);
	statement.setString(1, book.getBookId());
	statement.setString(2, book.getBookName());
	statement.setString(3, book.getBookDepartment());
	statement.setString(4, book.getBookAuthor() );
	
	statement.setString(5, book.getBookStatus());
	statement.setString(6, book.geteBookLink());
	statement.setString(7, book.getBookVideoLink());
	statement.setString(8, book.getBookImageLink());

	 int row=statement.executeUpdate();
	 System.out.println(row);
	}
}
