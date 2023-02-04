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

import dao.SerachByBookDeptDao;
import dao.SerachByBookNameDao;
import model.BooksDetails;

/**
 * Servlet implementation class SerachByBookDept
 */
@WebServlet("/SerachByBookDept")
public class SerachByBookDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerachByBookDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		String bookDept=request.getParameter("dept");
		
		//System.out.println(bookName);
		List<BooksDetails> booksdetails=null;
		try {
			booksdetails=SerachByBookDeptDao.bookDept(bookDept);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		//System.out.println(booksdetails);
		Gson gson=new Gson();
		String json= gson.toJson(booksdetails);
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
