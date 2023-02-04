package serverlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.AddNewsPaperDao;
import model.NewsPaperDetails;

/**
 * Servlet implementation class AddNewsPaper
 */
@WebServlet("/AddNewsPaper")
public class AddNewsPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsPaper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String dinamalarNews=request.getParameter("dinamalarNews");
		String hinduNews=request.getParameter("hinduNews");
		String indianExpressNews=request.getParameter("indianExpressNews");
		PrintWriter out=response.getWriter();
		NewsPaperDetails news= new NewsPaperDetails();
		news.setDinamalarNewsPaper(dinamalarNews);
		news.setHinduNewsPaper(hinduNews);
		news.setIndianExpressNewsPaper(indianExpressNews);
		String result=null;
		int count=0;
		try {
			count++;
			
			AddNewsPaperDao.newsInsert(news);
		}
		catch(Exception e){
			e.getMessage();
			count++;
		}
		if(count==1)
		{
			result="success";
		}
		else
		{
			result="Failed";
		}
		Gson gson= new Gson();
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
