package management.dao;

import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import management.entity.Department;
import management.util.DBUtil;

public class DepartmentDao {
	
	/**
	 * 根据dname的名称获得did
	 * @param dname
	 * @return
	 */
	public int getDid(String dname) {
		String sql = "select did from Department where dname=? ;";
		int did = 0;
		try {
			DBUtil.select(sql, dname);
			System.out.println("dao.Department.getDid 获得did成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return did;
	}
	
	/**
	 * 添加部门
	 * 参数: department.class
	 * @param d
	 */
	public void add(Department d) {
		String sql = "insert into Department(did,dname,cid,dintro) values(?,?,?,?); ";
		try {
			DBUtil.update(sql, d.getDid(),d.getDname(),d.getCid(),d.getDid());
			System.out.println("dao.Department.add 添加部门成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 展示某社团的全部部门
	 * 参数: cid
	 * @param cid
	 * @return
	 */
	public List<Department> showDepartments(int cid) {
		String sql = "select * from Department where cid=?;";
		ResultSetHandler<List<Department>> rsh = new BeanListHandler<Department>(Department.class);
		List<Department> list = null;
		try { 
			list = DBUtil.select(sql, rsh, cid);
			System.out.println("Dao.DepartmentsDao.showDepartments 根据cid获取此社团的全部部门成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 修改部门信息
	 * 参数: did, dname, dintros
	 * @param did
	 * @param dname
	 * @param dintro
	 */
	public void changeInfo(int did, String dname, String dintro) {
		String sql = "update Department set dname=? and dintro=? where did=?; ";
		try {
			DBUtil.update(sql, dname, dintro, did);
			System.out.println("Dao.DepartmentDao.changeInfo 修改部门信息成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
