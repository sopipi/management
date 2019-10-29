package management.service;
import java.util.List;

import management.dao.ClubDao;
import management.dao.ClubUserDao;
import management.dao.DepartmentDao;
import management.entity.ClubUser;
import management.entity.Department;



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
	
	

}
