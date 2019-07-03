package com.art;

import java.util.List;

/**
 * 文章接口类
 * @author Administrator
 * @date
 */
public interface IArticleOperation {
   /**
    * 根据用户id查询该用户发表的文章
    * @param userID
    * @return
    */
	public List<Article> getUserArticles(int userID);
}
