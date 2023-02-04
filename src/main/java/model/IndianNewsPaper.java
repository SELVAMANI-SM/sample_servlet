package model;

import java.util.List;

import dao.AllNewsPaperDao;

public class IndianNewsPaper {
	public static String indianNews() throws Exception
	{
		String result=null;
		List<NewsPaperDetails> news =AllNewsPaperDao.newsPaper();
		for(NewsPaperDetails paper:news)
		{
			result=paper.getIndianExpressNewsPaper();
		}
		return result;
	}
}

