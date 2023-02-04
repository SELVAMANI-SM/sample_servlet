package validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.ConnectionUtilDao;
import model.UserDetails;

public class userValidation {
	
	public static int  register(UserDetails user) throws Exception
	{
		
		int number1=NameCheck(user.getUserName());
		int number2=GmailCheck(user.getUserEmail());
		int number3=PasswordCheck(user.getUserpassword());
		int number4=MobileCheck(user.getUsermobile());
		int number5=IdCheck(user.getUserId());
		if(number1+number2+number3+number4+number5==5)
		{
			int number6=loginValidatorEmail(user.getUserEmail());
			int number7=loginValidatorMobile(user.getUsermobile());
			return number6+number7;
		}
		else
		{
			return 3;
		}
		
	}
	public static int NameCheck(String userName)throws Exception
	{
		//System.out.println(userName);
		if(userName==null|| userName.isBlank())
		{
			throw new Exception("Enter vaild Name");
		}
		else
			return 1;
		
	}
	public static int GmailCheck(String userGmail) throws Exception
	{
		if(!userGmail.contains("@")|| !userGmail.contains("."))
		{
			throw new Exception("Enter valid Gmail");
		}
		else
		{
			return 1;
		}
		
	}
	public static  int PasswordCheck(String userPassword) throws Exception
	{
		if(userPassword.length() < 8 && userPassword.length() > 16)
		{
			throw new Exception("Enter valid password it must contain 8 to 16 character");
		}
		else
			return 1;
	}
	public static int MobileCheck(String userMobile) throws Exception
	{
		int count1=0;
		char[] mobile=userMobile.toCharArray();
		if(userMobile.length()>10||userMobile.length()<10)
		{
			
		throw new Exception("Enter valid Number ");
		
		}
		else
			count1++;
		for(char i:mobile)
		{
			if(Character.isAlphabetic(i))
			{
			
				throw new Exception("Enter Only Numeric Value");
				
				
			}
			else
				count1++;
		
		}
		if(count1==11)
		{
			return 1;
		}
		else
		{
			return 0;
		}
		
		
	}
	public static int IdCheck(int i) throws Exception
	{
		if(i==0)
		{
			throw new Exception("Enter your correct Id");
		}
		else
			return 1;
	
	

 
}
	public static  int  loginValidatorEmail(String email) throws Exception
	{
	Connection connection;
	PreparedStatement statement;
	connection=ConnectionUtilDao.sqlConnection();
	ResultSet rs = null;
	String query = "SELECT email FROM library_User_Details WHERE email= ? ";
	statement = connection.prepareStatement(query);
	statement.setString(1,email);
	
	rs = statement.executeQuery();
	String mail = null;
	
	while(rs.next())
	{
	mail=rs.getString("email");

	}
	if(mail==null)
	{
	return 0;
	}
	

	else
	{
		return 1;
	}
}
	public static  int  loginValidatorMobile(String mobile) throws Exception
	{
	Connection connection;
	PreparedStatement statement;
	connection=ConnectionUtilDao.sqlConnection();
	ResultSet rs = null;
	String query = "SELECT mobile FROM library_User_Details WHERE mobile= ? ";
	statement = connection.prepareStatement(query);
	statement.setString(1,mobile);
	
	rs = statement.executeQuery();
	String number = null;
	
	while(rs.next())
	{
	number=rs.getString("mobile");

	}
	if(number==null)
	{
	return 0;
	}
	else
	{
		return 1;
	}
}
}
