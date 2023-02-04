package serverlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import dao.LoginUserDao;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		
		String password = request.getParameter("password");
		String message = null;
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String json = null;
		String number = null;
		try {
			number=LoginUserDao.loginValidator(email, password);
			if(number.equals("First You Register") || number.equals("invalid credentials")) {
				message = number;
				json=gson.toJson(message);
				
			}
			else {
				//int id = Integer.parseInt(number);
				json = gson.toJson(number);
			}
		}
		catch(Exception e)
		{
			json = e.getMessage();
			e.printStackTrace();
		}
		
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
