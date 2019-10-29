//package managementTest.daoTest;
//
//import java.util.List;
//
//import org.junit.Test;
//
//import management.dao.DepartmentDao;
//import management.entity.Department;
//
//public class DepartmentDaoTest {
//	private DepartmentDao dao = new DepartmentDao();
//	@Test
//	public void add() {
//		Department d1 = new Department(1,"测试名字",1,"测试部门介绍");
//		dao.add(d1);
//		Department d2 = new Department(2,"测试名字2",1,"测试部门介绍2");
//		dao.add(d2);
//	}
//	
//	@Test
//	public void delete() {
//		dao.delete(1);
//	}
//	
//	@Test
//	public void select() {
//		int cid = 1;
//		List<Department> list = dao.getAllDepartment(cid);
//		for(Department d : list) {
//			System.out.println(d.toString());
//		}
//	}
//	
//	@Test
//	public void selectd() {
//		int did = 1;
//		System.out.println(dao.getDepartment(did));
//	}
//	@Test 
//	public void reset() {
//		int did = 1;
//		String dname = "测试修改";
//		dao.resetDepartmentName(did, dname);
//	}
//	
//	@Test 
//	public void resetIntro() {
//		int did = 2;
//		String dintro = "测试修改内容";
//		dao.resetDepartmentIntro(did, dintro);
//	}
//}
