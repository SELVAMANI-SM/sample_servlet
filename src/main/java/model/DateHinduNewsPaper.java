package model;

import java.util.List;

import dao.AllNewsPaperByDateDao;

public class DateHinduNewsPaper {
	public static String  DisplayHindu(String name ) throws Exception {
		List<NewsPaperDetails> news=AllNewsPaperByDateDao.DateNewsPaper(name);
		String result=null;
		for(NewsPaperDetails paper:news)
		{
			result=paper.getHinduNewsPaper();
		}
		return result;
	}
}
