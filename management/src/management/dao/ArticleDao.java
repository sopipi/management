package management.dao;

import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import management.entity.Article;
import management.util.DBUtil;
import management.util.DateUtil;

public class ArticleDao {
	
	/**
	 * 添加文章
	 * 参数:Article.class
	 * @param a
	 */
	public void add(Article a) {
		String sql = "insert into Article(cid,uid,content,title,createTime) values(?,?,?,?,?);";
		try {
			DBUtil.update(sql,a.getCid(),a.getUid(),a.getContent(),a.getTitle(),DateUtil.dtot(a.getCreateTime()));
			System.out.println("Dao.ArticleDao.add 添加文章成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除文章
	 * 参数:artid
	 * @param artid
	 */
	public void delete(int artid) {
		String sql = "delete from Article where artid = ?;";
		try {
			DBUtil.update(sql, artid);
			System.out.println("Dao.Article.delete 删除文章成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改内容
	 * 参数: artid, content
	 * @param artid
	 * @param content
	 */
	public void changeContent(int artid, String content) {
		String sql = "update Article set content=? where artid=?;";
		try {
			DBUtil.update(sql, content, artid );
			System.out.println("Dao.ArticleDao.changeContent 修改文章内容成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改标题
	 * 参数: artid, title
	 * @param artid
	 * @param title
	 */
	public void changeTitle(int artid, String title) {
		String sql = "update Article set title=? where artid=?;";
		try {
			DBUtil.update(sql, title, artid );
			System.out.println("Dao.ArticleDao.changeTitle 修改文章标题成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 查找文章全部信息
	 * 参数: artid
	 * 返回: Aricle.class
	 * @param artid
	 * @return
	 */
	public Article selectByArtid(int artid) {
		String sql = "select * from Article where artid=?;";
		Article article = new Article();
		try { 
			article = DBUtil.select(sql, new BeanHandler<Article>(Article.class), artid);
			System.out.println("Dao.ArticleDao.selectByArtid 根据artid获取文章信息成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return article;
	}
	
	/**
	 * 根据uid查找此人的写的全部文章
	 * 参数: uid
	 * 返回: List<Aciton>
	 * @param uid
	 * @return
	*/
	public List<Article> selectByUid(String uid) {
		String sql = "select * from Article where uid = ?;";
		ResultSetHandler<List<Article>> rsh = new BeanListHandler<Article>(Article.class);
		List<Article> list = null;
		try { 
			list = DBUtil.select(sql, rsh, uid);
			System.out.println("Dao.ArticleDao.selectByUid 根据uid获取此人的全部文章成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		 
	
	
}
