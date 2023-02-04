package model;

import java.util.List;

import dao.AllNewsPaperByDateDao;

public class DateDinamalarNewsPaper {
	public static String  DisplayDinamalar(String name ) throws Exception {
		List<NewsPaperDetails> news=AllNewsPaperByDateDao.DateNewsPaper(name);
		String result=null;
		for(NewsPaperDetails paper:news)
		{
			result=paper.getDinamalarNewsPaper();
		}
		return result;
	}

}
