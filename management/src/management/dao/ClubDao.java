package management.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import management.entity.Club;
import management.util.DBUtil;
import management.util.DateUtil;

/**
 * 	private Integer cid;   //社团编号
	private String cname;   //社团名称
	private Integer chairman;    //会长的uid
	private Integer vicechairman;   //副会长的Uid
	private String cintro;     //社团简介
	private Date bulidTime;   //成立时间
 * @author zoey
 *
 */
public class ClubDao {
	
	/**
	 * 添加club信息到数据库
	 * 参数:club.class
	 * @param c
	 */
	public void add(Club c) {
		String sql = "insert into Club(cname,chairman,vicechairman,cintro,buildTime) values(?,?,?,?,?);";
		try {
			DBUtil.update(sql, c.getCname(),c.getChairman(),c.getVicechairman(),c.getCintro(),DateUtil.dtot(c.getBulidTime()));
			System.out.println("Dao.ClubDao.add 成功添加");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据cid删除此社团
	 * 参数: cid
	 * @param cid
	 */
	public void delete(int cid) {
		String sql = "delete from Club where cid = ?;";
		try {
			DBUtil.update(sql, cid);
			System.out.println("Dao.ClubDao.delete  删除成功");
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * 修改社团名称
	 * 参数: cid, cname
	 * @param cid
	 * @param cname
	 */
	public void changeCname(int cid, String cname) {
		String sql = "update Club set cname=? where cid=?;";
		try {
			DBUtil.update(sql, cname, cid);
			System.out.println("Dao.ClubDao.changeCname 修改名字成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 修改社团的社长
	 * 参数: cid, chairman's uid
	 * @param cid
	 * @param chairman
	 */
	public void changeChairman(int cid, String chairman) {
		String sql = "update Club set chairman=? where cid=?;";
		try {
			DBUtil.update(sql, chairman, cid);
			System.out.println("Dao.ClubDao.changeChairman 修改会长成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改社团的副社长
	 * 参数: cid, vicechairman's uid
	 * @param cid
	 * @param vicechairman
	 */
	public void changeVicechairman(int cid, String vicechairman) {
		String sql = "update Club set vicechairman=? where cid=?;";
		try {
			DBUtil.update(sql, vicechairman, cid);
			System.out.println("Dao.ClubDao.changeChairman 修改副会长成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改社团的简介
	 * 参数: cid, cintro
	 * @param cid
	 * @param cintro
	 */
	public void changeCintro(int cid, String cintro) {
		String sql = "update Club set cintro=? where cid=?;";
		try {
			DBUtil.update(sql, cintro, cid);
			System.out.println("Dao.ClubDao.changeCitro 修改社团简介成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据cid查找整个社团的信息
	 * 参数: cid
	 * 返回: Club.class
	 * @param cid
	 * @return
	 */
	public Club selectByCid(int cid) {
		String sql = "select * from Club where cid = ?;";
		Club club = new Club();
		try {
			club = DBUtil.select(sql, new BeanHandler<Club>(Club.class), cid);
			System.out.println("Dao.ClubDao.selectBycid 根据cid查找社团的信息陈成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return club;
	}
	

	
	
	
	
	
}
