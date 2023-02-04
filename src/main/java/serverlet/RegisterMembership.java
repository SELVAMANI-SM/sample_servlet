package serverlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.MemberDetailsInsertDao;
import model.MemberDetails;
import validator.MembershipValidation;

/**
 * Servlet implementation class RegisterMembership
 */
@WebServlet("/RegisterMembership")
public class RegisterMembership extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterMembership() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mobile=request.getParameter("mobile");
		int id = (int) (Math.random() * (50000 - 80000 + 1) + 50000);
		PrintWriter out=response.getWriter();
		MemberDetails member=new MemberDetails();
		member.setMemberName(name);
		member.setMemberEmail(email);
		member.setMemberpassword(password);
		member.setMembermobile(mobile);
		member.setMemberId(id);
		String result=null;
		int a=0;
		try {
			a=MembershipValidation.member(member);
		}
		catch(Exception e)
		{
			e.getMessage();
			
			
		}
		int count1=0;
		if(a==0) {
		
				try {
					count1++;
					MemberDetailsInsertDao.membershipInsert(member);
				
				} catch (Exception e) {
					count1=count1+1;
					e.getMessage();
					
				}
				if(count1==1)
				{
					result="Success Register Your Id =>"+id;
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
