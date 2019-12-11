package management.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import management.dao.ActionDao;
import management.dao.ArticleDao;
import management.dao.ClubDao;
import management.dao.ClubUserDao;
import management.dao.DepartmentDao;
import management.dao.UserDao;
import management.entity.Action;
import management.entity.Article;
import management.entity.Club;
import management.entity.ClubUser;
import management.entity.Department;
import management.entity.User;

/**
 * 1. 添加部门
 * 2. 社团成员加入 申请
 * 3. 社团成员任命
 * 4. 社团信息修改
 * @author zoey
 *
 */
public class ClubService {
	
	//申请成员加入
	public void addUser(ClubUser cu) {
		new ClubUserDao().add(cu);
	}
	
	//修改职位
	public void changePosition(String uid, int cid, int did, String position) {
		new ClubUserDao().changePosition(uid, cid, did, position);
	}
	
	//修改社团简介
	public void changeCintro(int cid, String cintro) {
		new ClubDao().changeCintro(cid, cintro);
	}
	
	//添加部门
	public void addDepartment(Department d) {
		new DepartmentDao().add(d);
	}
	
	//展示此社团的全部部门
	public List<Department> showDepartments(int cid) {
		List<Department> list = new DepartmentDao().showDepartments(cid);
		return list;
	}
	
	//展示此社团的全部成员
	public List<User> showClubUser(int cid) {
		//查询此社团成员的ClubUser.class
		List<ClubUser> clubUserList = new ClubDao().showClubUser(cid);
		for(ClubUser cu : clubUserList) {
			System.out.println(cu.toString());
		}
		//遍历ClubUser根据uid找出User信息并添加到userList列表中
		List<User> userList = new ArrayList();
		UserDao dao = new UserDao();
		for(ClubUser cu : clubUserList) {
			User u = dao.selectByUid(cu.getUid());
			userList.add(u);
		}
		return userList;
	}
	
	//显示社团信息
	public Club showClubInfo(int cid) {
		Club club = new ClubDao().selectByCid(cid);
		return club;
	}
	
	// 展示该社团的所有审核文章
	public List<Article> showVerifyArticle(int cid) {
		List<Article> list = new ArticleDao().selectVerifyByCid(cid);
		return list;
	}
	
	//展示所有审核活动
	public List<Action> showVerifyAction(int cid) {
		List<Action> list = new ActionDao().selectVerifyByCid(cid);
		return list;
	}
	
	
	//活动发布同意
	public void agreeAction(Action a) {
		// 添加到活动列表
		new ActionDao().add(a);
		// 从活动审核列表删除
		new ActionDao().deleteVerify(a.getAid());
	}
	
	//活动发布拒绝
	public void disagreeAction(Action a) {
		//从活动审核列表删除
		new ActionDao().deleteVerify(a.getAid());
	}
	
	
	//**文章发布同意
	public void agreeArticle(Article a) {
		System.out.println(a.toString());
		new ArticleDao().add(a);
		new ArticleDao().deleteVerify(a.getArtid());
	}
	
	//**文章发布拒绝
	public void disagreeArticle(Article a) {
		new ArticleDao().deleteVerify(a.getArtid());
	}

	//同意加入某社团
	public void agreeJoinClub(ClubUser cu) {
		Date d = new Date();
		cu.setJoinTime(d);
		new ClubUserDao().agreeUserVerify(cu);
	}
	
	//拒绝加入某社团
	public void disagreeJoinClub(ClubUser cu) {
		new ClubUserDao().disagreeUserVerify(cu);
	}
	
	//展示社团审核表
	public List<ClubUser> showUserVerify(int cid) {
		List<ClubUser> list = new ClubDao().showUserVerify(cid);
		return list;
	}
//随机生成优秀社团
	public List<Club> getRandClub(int cid) {
		return new ClubDao().getRandClub(cid);
	}

	public Club getCidByName(String cname) {
		Club club = new ClubDao().getCidByName(cname);
		return club;
	}
}
