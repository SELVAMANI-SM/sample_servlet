package model;

import java.util.List;

import dao.AllNewsPaperDao;

public class DinamalarNewsPaper {
	public static String dinamalarNews() throws Exception
	{
		String result=null;
		List<NewsPaperDetails> news =AllNewsPaperDao.newsPaper();
		//System.out.println("model");
		for(NewsPaperDetails paper:news)
		{
			result=paper.getDinamalarNewsPaper();
		}
		return result;
	}
	}


