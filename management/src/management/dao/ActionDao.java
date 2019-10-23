package management.dao;

import java.util.Date;

import org.apache.commons.dbutils.handlers.BeanHandler;

import management.entity.Action;
import management.util.DBUtil;
import management.util.DateUtil;

public class ActionDao {
	
	/**
	 * 添加活动信息到数据库
	 * 参数:Action.class
	 * @param a
	 */
	public void add(Action a) {
		String sql = "insert into Action(aname,cid,aintro,aImg,startTime,endTime) values(?,?,?,?,?,?);";
		try {
			DBUtil.update(sql,a.getAname(),a.getCid(),a.getAintro(),a.getaImg(),DateUtil.dtot(a.getStartTime()),DateUtil.dtot(a.getEndTime()));
			System.out.println("Dao.ActionDao.add 添加成功活动");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从数据库删除活动信息
	 * 参数: aid
	 * @param aid
	 */
	public void delete(int aid) {
		String sql = "delete from Action where aid = ?;";
		try {
			DBUtil.update(sql, aid);
			System.out.println("Dao.ActionDao.delete  删除成功");
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * 修改活动名称
	 * 参数:aid,aname
	 * @param aid
	 * @param aname
	 */
	public void changeAname(int aid, String aname) {
		String sql = "update Action set aname=? where aid=?;";
		try {
			DBUtil.update(sql, aname, aid);
			System.out.println("Dao.ActionDao.changeAname 修改名字成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 修改活动简介
	 * 参数:aid, aintro
	 * @param aid
	 * @param aintro
	 */
	public void changeAintro(int aid, String aintro) {
		String sql = "update Action set aintro=? where aid=?;";
		try {
			DBUtil.update(sql, aintro, aid);
			System.out.println("Dao.ActionDao.changeAintro  修改活动简介成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改活动图片
	 * 参数:aid, aImg
	 * @param aid
	 * @param aImg
	 */
	public void changeAImg(int aid, String aImg) {
		String sql = "update Action set aImg=? where aid=?;";
		try {
			DBUtil.update(sql, aImg, aid);
			System.out.println("Dao.ActionDao.changeAImg 修改活动图片成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改活动的时间
	 * 参数:aid, startTime, endTime
	 * @param aid
	 * @param startTime
	 * @param endTime
	 */
	public void changeTime(int aid, Date startTime, Date endTime) {
		String sql = "update Action set startTime=?, endTime=? where aid=?;";
		try {
			DBUtil.update(sql, DateUtil.dtot(startTime),DateUtil.dtot(endTime),aid);
			System.out.println("Dap.ActionDao.changeTime 修改活动时间成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据aid查找整个活动的信息
	 * 参数: aid
	 * 返回: Aciton
	 * @param aid
	 * @return
	 */
	public Action selectByAid(int aid) {
		String sql = "select * from Action where aid = ?;";
		Action action = new Action();
		try {
			action = DBUtil.select(sql, new BeanHandler<Action>(Action.class), aid);
			System.out.println("Dao.ActionDao.selectByaid 根据aid查找整个活动的信息陈成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return action;
	}
	
	/**
	 * 根据uid查找此人的写的全部文章
	 * 参数: uid
	 * 返回: List<Aciton>
	 * @param uid
	 * @return
	public List<Action> selectByUid(int uid) {
		String sql = "select * from Action where uid = ?;";
		ResultSetHandler<List<Action>> rsh = new BeanListHandler<Action>(Action.class);
		List<Action> list = null;
		try { 
			list = DBUtil.select(sql, rsh, uid);
			System.out.println("Dao.ActionDao.selectByUid 根据uid获取此人的全部文章成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		 */
	
	
	
}