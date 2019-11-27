package management.dao;

import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import management.entity.ClubUser;
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
		String sql = "insert into Department(dname,cid,dintro) values(?,?,?); ";
		try {
			DBUtil.update(sql,d.getDname(),d.getCid(),d.getDintro());
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
		String sql = "update Department set dname=?, dintro=? where did=?; ";
		try {
			DBUtil.update(sql, dname, dintro, did);
			System.out.println("Dao.DepartmentDao.changeInfo 修改部门信息成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 展示部门成员
	 * 参数: did
	 * @param did
	 * @return
	 */
	public List<ClubUser> showDepartmentUser(int did) {
		String sql = "select * from ClubUser where did=?;";
		ResultSetHandler<List<ClubUser>> rsh = new BeanListHandler<ClubUser>(ClubUser.class);
		List<ClubUser> list = null;
		try {
			list = DBUtil.select(sql, rsh, did);
			System.out.println("Dao.Department.showDepartmentUser 展示部门成员ClubUser成功");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	/**
	 * 展示部门信息
	 * 参数: did
	 * @param did
	 * @return
	 */
	public Department selectByDid(int did) {
		String sql = "select * from Department where did=?;";
		Department d = null;
		try {
			d = DBUtil.select(sql, new BeanHandler<Department>(Department.class), did);
			System.out.println("Dao.DepartmentDao.selectByDid 成功: " + d.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return d;
	}

}
