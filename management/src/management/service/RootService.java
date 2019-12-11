package management.service;

import java.util.Date;
import java.util.List;

import management.dao.ActionDao;
import management.dao.ArticleDao;
import management.dao.ClubDao;
import management.entity.Action;
import management.entity.Article;
import management.entity.Club;

public class RootService {
	
	//申请社团加入
	public void addClub(Club c) {
		c.setBulidTime(new Date());
		new ClubDao().add(c);
	}
	
	//展示所有社团信息
	public List<Club> showClubs() {
		List<Club> list = new ClubDao().showClubs();
		return list;
	}
	
	//展示所有社团审核通过的文章
	public List<Article> showArticles() {
		List<Article> list = new ArticleDao().showArticles();
		return list;
	}
	
	//展示所有社团审核通过文章的前 num 个
	public List<Article> showNumArticles(int num) {
		List<Article> list = new ArticleDao().showNumArticles(num);
		return list;
	}
	
	//展示所有社团审核通过的活动
	public List<Action> showActions() {
		List<Action> list = new ActionDao().showActions();
		return list;
	}
	
	//展示所有社团审核通过前 num 个活动
	public List<Action> showNumActions(int num) {
		List<Action> list = new ActionDao().showNumActions(num);
		return list;
	}
	
	// 展示创建社团的全部申请表
	public List<Club> showClubVerify() {
		List<Club> list = new ClubDao().showClubVerify();
		return list;
	}
	
	// 同意创建
	public void agreeCreateClub(Club c) {
		new ClubDao().agreeClubVerify(c);
	}
	
	// 不同意创建
	public void disagreeCreateClub(Club c) {
		new ClubDao().disagreeClubVerify(c);
	}
	
	
	
	
}
