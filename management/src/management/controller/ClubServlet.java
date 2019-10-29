package management.controller;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import management.entity.ClubUser;
import management.entity.Department;
import management.service.ClubService;
import net.sf.json.JSONObject;

@WebServlet("/ClubServlet")
public class ClubServlet extends BaseServlet {
	
	
	/**
	 * 添加成员
	 * 参数:ClubUser.class
	 * @param request
	 * @param response
	 */
	public void addUser(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		ClubUser cu = (ClubUser)getBean(map, "ClubUser");
		new ClubService().addUser(cu);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("flag", "true");
		write(response, json.toString());
	}
	
	
	/**
	 * 修改职位
	 * 参数:String uid, int cid, int did, String position
	 * @param request
	 * @param response
	 */
	public void changePosition(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		String uid = (String) map.get("uid");
		int cid = (int) map.get("cid");
		int did = (int) map.get("did");
		String position = (String) map.get("position");
		new ClubService().changePosition(uid, cid, did, position);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("flag", "true");
		write(response, json.toString());
	}
	
	/**
	 * 修改社团简介
	 * 参数:cid,cintro
	 * @param request
	 * @param response
	 */
	public void changeCintro(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String,Object> map = (Map)getJSONParameter(request);
		int cid = (int)map.get("cid");
		String cintro = (String)map.get("cintro");
		new ClubService().changeCintro(cid, cintro);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("flag", "true");
		write(response, json.toString());
	}
	
	/**
	 * 添加部门
	 * @param request
	 * @param response
	 */
	public void addDepartment(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map) getJSONParameter(request);
		Department d = (Department)getBean(map, "Department");
		new ClubService().addDepartment(d);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("flag", "true");
		write(response, json.toString());
	}
	
	/**
	 * 显示此社团的全部部门
	 * 参数: cid
	 * @param request
	 * @param response
	
	public void showDepartments(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		System.out.println("xixix*****************");
		Map<String, Object> map = (Map) getJSONParameter(request);
		Integer cid = (Integer) getBean(map,"cid");
		System.out.println("***********clubServlet cid: " + cid.intValue());
		
		
		List<Department> list = new ClubService().showDepartments(cid.intValue());
		//返回给前端
		JSONArray jsonArray = new JSONArray();
		for(Department d : list) {
			JSONObject json = new JSONObject();
			json.put("Department", d);
			jsonArray.add(json);
		}
		write(response, jsonArray.toString());
	} */

	
}
