package management.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import management.entity.Department;
import management.util.DBUtil;

/**
 * 部门dao层
 * @author 再几何
 *
 */
public class DepartmentDao {
	/**
	 * 添加部门信息
	 * @param d
	 */
	public void add(Department d) {
		String sql = "insert into Department (did,dname,cid,dintro) values(?,?,?,?)";
		try {
			DBUtil.update(sql, d.getDid(),d.getDname(),d.getCid(),d.getDintro());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据cid返回所有的部门信息
	 * @param cid
	 * @return
	 */
	public List<Department> getAllDepartment(Integer cid) {
		String sql = "Select * from Department where cid = ?";
		List<Department> list = new ArrayList<>();
		try {
			list = DBUtil.select(sql,new BeanListHandler<Department>(Department.class),cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据部门id返回部门的详细信息
	 * @param did
	 * @return
	 */
	public Department getDepartment(Integer did) {
		String sql = "select * from Department where did = ?";
		Department d = null;
		try {
			d = DBUtil.select(sql, new BeanHandler<Department>(Department.class),did);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * 根据did删除部门信息
	 * @param did
	 */
	public void delete(Integer did) {
		String sql = "delete from Department where did = ?";
		try {
			DBUtil.update(sql, did);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据did修改部门的名称
	 * @param did
	 * @param dname
	 */
	public void resetDepartmentName(Integer did, String dname) {
		String sql = "update Department set dname =? where did = ?;";
		try {
			DBUtil.update(sql, dname,did);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据did修改部门的介绍
	 * @param did
	 * @param dintro
	 */
	public void resetDepartmentIntro(Integer did, String dintro) {
		String sql = "update Department set dintro =? where did = ?;";
		try {
			DBUtil.update(sql, dintro,did);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
