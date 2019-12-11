package management.service;
import java.util.List;

import management.dao.ArticleDao;
import management.entity.Article;

public class ArticleService {
	
	/**
	 * 展示某文章的全部内容
	 * 参数: artid
	 * @param artid
	 * @return
	 */
	public Article showArticleByArtid(int artid) {
		Article a = new ArticleDao().selectByArtid(artid);
		return a;
	}
	
	/**
	 * 展示文章页面
	 * 参数:num(展示几篇文章)
	 * @param num
	 * @return
	 */
	public List<Article> showArticles(int num) {
		List<Article> list = new ArticleDao().showNumArticles(num);
		return list;
	}
}
