package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import model.NewsPaperDetails;

public class AddNewsPaperDao {
public static void newsInsert(NewsPaperDetails news) throws Exception
{
	{
		Connection connection;
		PreparedStatement statement;
		Date date=Date.valueOf(LocalDate.now());
		connection=ConnectionUtilDao.sqlConnection();
		String query="insert into  Daily_News_Papers (News_Date,Indian_Express,Hindu,Dinamalar)values(?,?,?,?)";
		statement = connection.prepareStatement(query);
		statement.setDate(1,date );
		statement.setString(2,news.getIndianExpressNewsPaper());
		statement.setString(3,news.getHinduNewsPaper());

		statement.setString(4, news.getDinamalarNewsPaper());

		
		
		statement.executeUpdate();
		//System.out.println("No of rows inserted:"+rows);
		
		}
}
}
