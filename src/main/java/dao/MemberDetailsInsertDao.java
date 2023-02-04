package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.MemberDetails;

public class MemberDetailsInsertDao {
	public static void membershipInsert( MemberDetails member) throws Exception {
		Connection connection;
		PreparedStatement statement;
		connection=ConnectionUtilDao.sqlConnection();
		String query="insert into  Library_Membership_Details(name,Email,PASSWORD,Mobile,member_Id)values(?,?,?,?,?)";
		statement = connection.prepareStatement(query);
		statement.setString(1, member.getMemberName());
		statement.setString(2, member.getMemberEmail());

		statement.setString(3, member.getMemberpassword());

		statement.setString(4, member.getMembermobile());
		statement.setInt(5, member.getMemberId());
		
		int rows = statement.executeUpdate();
		System.out.println("No of rows inserted:"+rows);
		
		
		}
}
