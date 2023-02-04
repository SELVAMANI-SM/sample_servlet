package model;

import java.util.List;

import dao.AllNewsPaperDao;

public class HinduNewsPaper {
	public static String hinduNews() throws Exception
	{
		String result=null;
		List<NewsPaperDetails> news =AllNewsPaperDao.newsPaper();
		for(NewsPaperDetails paper:news)
		{
				result=paper.getHinduNewsPaper();
		}
		return result;
		
	}
	
}

