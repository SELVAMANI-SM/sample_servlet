package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.NewsPaperDetails;

public class AllNewsPaperDao {
public static List<NewsPaperDetails> newsPaper() throws Exception
{
	List<NewsPaperDetails> newspaper= new ArrayList<NewsPaperDetails>();
	Date date=Date.valueOf(LocalDate.now());
	Connection connection=ConnectionUtilDao.sqlConnection();
	PreparedStatement statement=null;
	ResultSet result=null;
	String query="select * from Daily_News_Papers where News_Date=?";
	
	statement=connection.prepareStatement(query);
	statement.setDate(1,date);
	result=statement.executeQuery();
	NewsPaperDetails paper=null;
	while(result.next())
	{
		//System.out.println("hii dao");
		paper=new NewsPaperDetails();
		String dinamalarNews=result.getString("Dinamalar");
		String hinduNews=result.getString("Hindu");
		String indianExpressNews=result.getString("Indian_Express");
		
		
		paper.setDinamalarNewsPaper(dinamalarNews);
		paper.setHinduNewsPaper(hinduNews);
		paper.setIndianExpressNewsPaper(indianExpressNews);
		
		newspaper.add(paper);
		
		
	}
	return newspaper;
}
	

}
