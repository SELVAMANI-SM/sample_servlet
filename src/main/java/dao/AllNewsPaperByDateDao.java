package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.NewsPaperDetails;

public class AllNewsPaperByDateDao {
	public static List<NewsPaperDetails> DateNewsPaper(String date) throws Exception
	{
		List<NewsPaperDetails> dates= new ArrayList<NewsPaperDetails>();
		

		
		Connection connection=ConnectionUtilDao.sqlConnection();
		PreparedStatement statement=null;
		LocalDate localdate=LocalDate.parse(date); // string to LocalDate
		Date sqlDate =Date.valueOf(localdate); // LocalDate to mysql Date
		ResultSet result=null;
		String query="select * from Daily_News_Papers where News_Date=?";
		
		statement=connection.prepareStatement(query);
		statement.setDate(1,sqlDate );
		result=statement.executeQuery();

		
		
		
		
		NewsPaperDetails paper=null;
		while(result.next())
		{
			
			paper= new NewsPaperDetails();
			String indian=result.getString("Indian_Express");
			String hindu=result.getString("Hindu");
			String dinamalar=result.getString("Dinamalar");
			paper.setIndianExpressNewsPaper(indian);
			paper.setHinduNewsPaper(hindu);
			paper.setDinamalarNewsPaper(dinamalar);
			dates.add(paper);
			
			
		}
		return dates;
	}
}
