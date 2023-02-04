package serverlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.AddBookDao;
import model.BooksDetails;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String bookId=request.getParameter("bookId");
		String bookName=request.getParameter("bookName");
		String bookAuthor=request.getParameter("bookAuthor");
		String bookDept=request.getParameter("bookDept");
		String bookStatus=request.getParameter("bookStatus");
		String eBookLink=request.getParameter("eBookLink");
		String bookLinkVideo=request.getParameter("bookVideoLink");
		String bookImageLink=request.getParameter("bookImageLink");	
		PrintWriter out =response.getWriter();
	
		BooksDetails book=new BooksDetails();
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setBookAuthor(bookAuthor);
		book.setBookDepartment(bookDept);
		book.setBookStatus(bookStatus);
		book.seteBookLink(eBookLink);
		book.setBookVideoLink(bookLinkVideo);
		book.setBookImageLink(bookImageLink);
		String result=null;
		int count=0;
		try {
			count++;
			AddBookDao.bookinsert(book);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			count++;
			e1.getMessage();
		}
		
		if(count==1)
		{
			result="Added Book";
		}
		else
		{
			result="fail";
		}
		//System.out.println(count);
		Gson gson=new Gson();
		String json=gson.toJson(result);
		out.println(json);
		out.flush();
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
