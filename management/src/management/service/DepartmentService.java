package management.service;
import management.dao.DepartmentDao;

/**
 * 1. 显示部门所有成员
 * 2. 修改部门信息
 * @author zoey
 *
 */
public class DepartmentService {
	
	
	//修改部门信息
	public void changeInfo(int did, String dname, String dintro) {
		new DepartmentDao().changeInfo(did, dname, dintro);
	}
}
