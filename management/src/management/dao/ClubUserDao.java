package management.dao;

import management.entity.ClubUser;
import management.service.ClubService;
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
	
	/**
	 * 用户申请加入社团, 将此信息添加到社团申请表中
	 * @param cu
	 */
	public void addVerify(ClubUser cu) {
		String sql = "insert into VerifyClubUser(uid,cid,did,position,joinTime) values(?,?,?,?,?);";
		try {
			DBUtil.update(sql,cu.getUid(),cu.getCid(),cu.getDid(),cu.getPosition(),DateUtil.dtot(cu.getJoinTime()));
			System.out.println("Dao.ClubUserDao.addVerify 添加社团成员审核表成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 同意某用户加入社团的申请表
	 * @param uid
	 * @param cid
	 */
	public void agreeUserVerify(ClubUser cu) {
		//调用ClubService的添加成员功能
		new ClubService().addUser(cu);
		
		//从审核表中删除
		String sql = "delete from VerifyClubUser where uid=? and cid=?;";
		try {
			DBUtil.update(sql, cu.getUid(), cu.getCid());
			System.out.println("Dao.ClubUser.disagreeVerify 同意用户加入社团申请表");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 拒绝某用户加入社团的申请表
	 * @param uid
	 * @param cid
	 */
	public void disagreeUserVerify(ClubUser cu) {
		// 直接删除此请求
		String sql = "delete from VerifyClubUser where uid=? and cid=?;";
		try {
			DBUtil.update(sql, cu.getUid(), cu.getCid());
			System.out.println("Dao.ClubUser.disagreeVerify 拒绝用户加入社团申请表");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
