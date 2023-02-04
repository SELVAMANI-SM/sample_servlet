package serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.SerachByBookAuthorDao;
import model.BooksDetails;

/**
 * Servlet implementation class SerachBYBookAuthor
 */
@WebServlet("/SerachBYBookAuthor")
public class SerachByBookAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerachByBookAuthor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String bookAuthor=request.getParameter("bookAuthor");
		PrintWriter out =response.getWriter();
		List<BooksDetails> booksdetails=null;
		try {
			booksdetails=SerachByBookAuthorDao.bookAuthor(bookAuthor);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		Gson gson = new Gson();
		String json=gson.toJson(booksdetails);
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
