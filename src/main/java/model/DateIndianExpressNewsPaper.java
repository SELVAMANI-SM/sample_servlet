package model;

import java.util.List;

import dao.AllNewsPaperByDateDao;

public class DateIndianExpressNewsPaper {
	public static String  DisplayIndianExpress(String name ) throws Exception {
		List<NewsPaperDetails> news=AllNewsPaperByDateDao.DateNewsPaper(name);
		String result=null;
		for(NewsPaperDetails paper:news)
		{
			result=paper.getIndianExpressNewsPaper();
		}
		return result;
	}
}
