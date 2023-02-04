package serverlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.LoginMemberShipDao;

/**
 * Servlet implementation class LoginMembership
 */
@WebServlet("/LoginMembership")
public class LoginMembership extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMembership() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		
       String email=request.getParameter("gmail");
       String password=request.getParameter("password");
       PrintWriter out=response.getWriter();
       String number=null;
       String message=null;
       String json=null;
       Gson gson = new Gson();
       try {
    	   number=LoginMemberShipDao.loginValidator(email, password);
    	   if(number.equals("First You Register") || number.equals("invalid credentials")) {
				message = number;
				json=gson.toJson(message);
				
			}
			else {
				//int id = Integer.parseInt(number);
				json = gson.toJson(number);
			}
       }
       catch(Exception e){
    	  e.getMessage();
    	   
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
