package serverlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import dao.UserDetailsInsertDao;
import model.UserDetails;
import validator.userValidation;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mobile=request.getParameter("mobile");
		int id = (int) (Math.random() * (5000 - 8000 + 1) + 5000);
		//String sid=Integer.toString(id);
		PrintWriter out=response.getWriter();
		UserDetails user=new UserDetails();
		user.setUserName(name);
		user.setUserEmail(email);
		user.setUserpassword(password);
		user.setUsermobile(mobile);
		user.setUserId(id);
		String result=null;
		int a=0;
		try {
			a=userValidation.register(user);
		}
		catch(Exception e)
		{
			e.getMessage();
			
			
		}
		int count1=0;
		if(a==0) {
		
				try {
					count1++;
					UserDetailsInsertDao.Insert(user);
				
				} catch (Exception e) {
					count1=count1+1;
					e.getMessage();
					
				}
				if(count1==1)
				{
					result="Success resgister Your Id =>"+id;
				}
				else {
					result="Error While Insert";
				}
				
			
		}
		else if(a==1||a==2)
		{
			result="Your An Existing user";
		}
		else if(a==3)
		{
			result="Validation Error";
		}
		

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
