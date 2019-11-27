package management.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import management.entity.Action;
import management.entity.Article;
import management.entity.Department;
import management.entity.User;
import management.service.DepartmentService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@WebServlet("/DepartmentServlet")
public class DepartmentServlet extends BaseServlet {

	/**
	 * 修改部门信息
	 * 参数: did, dname, dintro
	 * @param request
	 * @param response
	 */
	public void changeInfo(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map =  (Map)getJSONParameter(request);
		Integer did = (Integer)map.get("did");
		String dname = (String) map.get("dname");
		String dintro = (String) map.get("dintro");
		new DepartmentService().changeInfo(did, dname, dintro);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("flag", "true");
		write(response, json.toString());
	}
	
	/**
	 * 显示部门的所有成员
	 * 参数: did
	 * @param request
	 * @param response
	 */
	public void showDepartmentUser(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map) getJSONParameter(request);
		Integer did = (Integer) map.get("did");
		List<User> list = new DepartmentService().showUser(did);
		//将全部用户信息返回给前端
		JSONArray jsonArray = new JSONArray();
		for(User u : list) {
			JSONObject json = new JSONObject();
			json.put("DepartmentUser", u);
			jsonArray.add(json);
		}
		write(response, jsonArray.toString());
	}
	
	/**
	 * 展示部门信息
	 * 参数: did
	 * @param request
	 * @param response
	 */
	public void showDepartmentInfo(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map) getJSONParameter(request);
		Integer did = (Integer) map.get("did");
		Department department = new DepartmentService().showDepartmentInfo(did);
		//将部门信息返回给前端
		JSONObject json = new JSONObject();
		json.put("DepartmentInfo", department);
		write(response, json.toString());
	}
	
	
	/**
	 * 添加审核文章
	 * 参数: Article.class
	 * @param request
	 * @param response
	 */
	public void addVerifyArticle(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map) getJSONParameter(request);
		Article article = (Article)getBean(map, "Article");
		new DepartmentService().addVerifyArticle(article);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("flag", "true");
		write(response, json.toString());
	}
	
	/**
	 * 添加审核活动 
	 * 参数: Action.class
	 * @param request
	 * @param response
	 */
	public void addVerifyAction(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map) getJSONParameter(request);
		Action action = (Action) getBean(map,"Action");
		new DepartmentService().addVerifyAction(action);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("flag", "true");
		write(response, json.toString());
	}
	
}
