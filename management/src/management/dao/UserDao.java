package management.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import management.entity.User;
import management.util.DBUtil;

public class UserDao {
	
	/**
	 * 添加Uesr
	 * 参数: User.class
	 * @param u
	 */
	public void add(User u) {
		String sql = "insert into User(uid,phone,uname,IDCard,faculty,className,heardImg,password,sex) values(?,?,?,?,?,?,?,?,?);";
		try {
			DBUtil.update(sql, u.getUid(),u.getPhone(),u.getUname(),u.getIDCard(),u.getFaculty(),u.getClassName(),u.getHeardImg(),u.getPassword(),u.getSex());
			System.out.println("Dao.UserDao.add  添加成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改电话号码
	 * 参数: uid, phone
	 * @param uid
	 * @param phone
	 */
	public void changePhone(String uid, String phone) {
		String sql = "update User set phone=? where uid=?;";
		try {
			DBUtil.update(sql, phone, uid);
			System.out.println("Dao.UserDao.changePhone 修改电话成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改学院
	 * 参数: uid, faculty'name
	 * @param uid
	 * @param faculty
	 */
	public void changeFaculty(String uid, String faculty) {
		String sql = "update User set faculty=? where uid=?;";
		try {
			DBUtil.update(sql, faculty, uid);
			System.out.println("Dao.UserDao.changeFaculty 修改学院成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改班级
	 * 参数: uid, classname
	 * @param uid
	 * @param className
	 */
	public void changeClassName(String uid, String className) {
		String sql = "update User set className=? where uid=?;";
		try {
			DBUtil.update(sql, className, uid);
			System.out.println("Dao.UserDao.changeClassName 修改班级成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改新头像
	 * 参数: uid, heardImg
	 * @param uid
	 * @param heardImg
	 */
	public void changeHeardImg(String uid, String heardImg) {
		String sql = "update User set heardImg=? where uid=?;";
		try {
			DBUtil.update(sql, heardImg, uid);
			System.out.println("Dao.UserDao.changeHeardImg 修改头像成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改密码
	 * 参数: uid, password
	 * @param uid
	 * @param password
	 */
	public void changePassword(String uid, String password) {
		String sql = "update User set password=? where uid=?;";
		try {
			DBUtil.update(sql, password, uid);
			System.out.println("Dao.UserDao.changePassword 修改密码成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据Uid返沪此人的全部信息
	 * @param uid
	 * @return
	 */
	public User selectByUid(String uid) {
		String sql = "select * from User where uid = ?;";
		User user = new User();
		try {
			user = DBUtil.select(sql, new BeanHandler<User>(User.class), uid);
			System.out.println("Dao.UserDao.selectByuid 根据uid查找此人全部信息陈成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	
}
