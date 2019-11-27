package management.dao;

import management.entity.ClubUser;
import management.util.DBUtil;
import management.util.DateUtil;

public class ClubUserDao {
	

	/**
	 * 添加社团成员
	 * 参数: ClubUser.class
	 * @param cu
	 */
	public void add(ClubUser cu) {
		String sql = "insert into ClubUser(uid,cid,did,position,joinTime) values(?,?,?,?,?);";
		try {
			DBUtil.update(sql,cu.getUid(),cu.getCid(),cu.getDid(),cu.getPosition(),DateUtil.dtot(cu.getJoinTime()));
			System.out.println("Dao.ClubUserDao.add 添加社团成员成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除社团成员
	 * 参数: uid, cid
	 * @param uid
	 * @param cid
	 */
	public void delete(String uid, int cid) {
		String sql = "delete from ClubUser where uid=? and cid=?;";
		try {
			DBUtil.update(sql, uid, cid);
			System.out.println("Dao.ClubUserDao.delete 删除社团成员成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改职位
	 * 参数: position,uid, cid, did
	 * @param uid
	 * @param cid
	 * @param position
	 */
	public void changePosition(String uid, int cid,int did, String position) {
		String sql = "update ClubUser set position=?, did=? where uid=? and cid=?;";
		try {
			DBUtil.update(sql, position,did, uid, cid);
			System.out.println("Dao.ClubUserDao.changePosition 修改社团职位成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 修改部门
	 * 参数: did, uid, cid
	 * @param uid
	 * @param cid
	 * @param did
	 */
	public void changeDepartment(String uid, int cid, int did) {
		String sql = "update ClubUser set did=? where uid=? and cid=?;";
		try {
			DBUtil.update(sql, did, uid, cid);
			System.out.println("Dao.ClubUserDao.changeDepartment 修改成员部门成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
