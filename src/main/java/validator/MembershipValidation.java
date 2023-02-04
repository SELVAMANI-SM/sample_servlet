package validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.ConnectionUtilDao;
import model.MemberDetails;

public class MembershipValidation {
	static int count=0;
	public static int  member( MemberDetails member) throws Exception
	{
		
		int number1=NameChecks(member.getMemberName());
		int number2=GmailChecks(member.getMemberEmail());
		int number3=PasswordChecks(member.getMemberpassword());
		int number4=MobileChecks(member.getMembermobile());
		int number5=IdChecks(member.getMemberId());
		if(number1+number2+number3+number4+number5==5)
		{
			int number6=loginValidatorEmail(member.getMemberEmail());
			int number7=loginValidatorMobile(member.getMembermobile());
			return number6+number7;
		}
		else
		{
			return 3;
		}
		
	}
	public static int NameChecks(String memberName)throws Exception
	{
		//System.out.println(userName);
		if(memberName==null|| memberName.isBlank())
		{
			throw new Exception("Enter vaild Name");
		}
		else
			return 1;
		
	}
	public static int GmailChecks(String userGmail) throws Exception
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
	public static  int PasswordChecks(String userPassword) throws Exception
	{
		if(userPassword.length() < 8 && userPassword.length() > 16)
		{
			throw new Exception("Enter valid password it must contain 8 to 16 character");
		}
		else
			return 1;
	}
	public static int MobileChecks(String userMobile) throws Exception
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
			return 0;
		
		
	}
	public static int IdChecks(int i) throws Exception
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
	String query = "SELECT Email FROM Library_Membership_Details WHERE Email= ? ";
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
	String query = "SELECT Mobile FROM Library_Membership_Details WHERE Mobile= ? ";
	statement = connection.prepareStatement(query);
	statement.setString(1,mobile);
	
	rs = statement.executeQuery();
	String number = null;
	
	while(rs.next())
	{
	number=rs.getString("Mobile");

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
