package management.service;

import management.dao.UserDao;
import management.entity.User;

public class UserService {
	
	/**
	 * 注册
	 * @param u
	 */
	public void register(User u) {
		new UserDao().add(u);
	}
	
	/**
	 * 登陆
	 * @param uid
	 * @param pwd
	 * @return
	 */
	public boolean login(String uid, String pwd) {
		int flag = 0;
		User u = new UserDao().selectByUid(uid);
		if(u == null || !pwd.equals(u.getPassword())) { 
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * 改密码
	 * @param uid
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	public boolean changePassword(String uid, String oldPwd, String newPwd) {
		if(login(uid, oldPwd)) {
			new UserDao().changePassword(uid, newPwd);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 显示个人信息
	 * @param uid
	 * @return
	 */
	public User showInfo(String uid) {
		User u = new UserDao().selectByUid(uid);
		return u;
	}
	
	/**
	 * 修改头像
	 * @param uid
	 * @param AImg
	 * @return
	 */
	public boolean changeHeardImg(String uid, String AImg) {
		new UserDao().changeHeardImg(uid, AImg);
		return true;
	}
	


	
}
