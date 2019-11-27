package management.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import management.entity.Action;
import management.entity.Article;
import management.entity.Club;
import management.entity.ClubUser;
import management.entity.Department;
import management.entity.User;
import management.service.ClubService;
import net.sf.json.JSONArray;
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
	 * 参数: Department.class
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
	 */
	public void showDepartments(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map) getJSONParameter(request);
		Integer cid = (Integer) map.get("cid");
	
		List<Department> list = new ClubService().showDepartments(cid.intValue());
		//返回给前端
		JSONArray jsonArray = new JSONArray();
		for(Department d : list) {
			JSONObject json = new JSONObject();
			json.put("Department", d);
			jsonArray.add(json);
		}
		write(response, jsonArray.toString());
	} 

	/**
	 * 显示此社团的全部成员
	 * 参数: cid
	 * @param request
	 * @param response
	 */
	public void showClubUser(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map) getJSONParameter(request);
		Integer cid = (Integer) map.get("cid");
		List<User> list = new ClubService().showClubUser(cid);
		//将全部用户信息返回给前端
		JSONArray jsonArray = new JSONArray();
		for(User u : list) {
			JSONObject json = new JSONObject();
			json.put("ClubUser", u);
			jsonArray.add(json);
		}
		write(response, jsonArray.toString());
	}
	
	/**
	 * 显示社团信息
	 * 参数: cid
	 * @param request
	 * @param response
	 */
	public void showClubInfo(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map) getJSONParameter(request);
		Integer cid = (Integer) map.get("cid");
		Club club = new ClubService().showClubInfo(cid);
		//将社团信息返回给前端
		JSONObject json = new JSONObject();
		json.put("clubInfo", club);
		write(response, json.toString());
	}
	
	
	
	/**
	 * 展示所有审核的活动
	 * @param request
	 * @param response
	 */
	public void showVerifyActions(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map) getJSONParameter(request);
		Integer cid = (Integer) map.get("cid");
		List<Action> list = new ClubService().showVerifyAction(cid);
		
		//返回前端
		JSONArray jsonArray = new JSONArray();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("size", list.size());
		jsonArray.add(jsonObject);
		
		for(Action a : list) {
			JSONObject json = new JSONObject();
			json.put("action", a);
			jsonArray.add(json);
		}
		write(response, jsonArray.toString());
	}
	
	
	/**
	 * 展示所有审核文章
	 * @param request
	 * @param response
	 */
	public void showVerifyArticles(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map) getJSONParameter(request);
		Integer cid = (Integer) map.get("cid");
		List<Article> list = new ClubService().showVerifyArticle(cid);
		//返回前端
		JSONArray jsonArray = new JSONArray();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("size", list.size());
		jsonArray.add(jsonObject);
		
		for(Article a : list) {
			JSONObject json = new JSONObject();
			json.put("article", a);
			jsonArray.add(json);
		}
		write(response, jsonArray.toString());
	}

	/**
	 * 添加活动到活动列表
	 * 参数:Action.class
	 * @param request
	 * @param response
	 */
	public void agreeAction(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map) getJSONParameter(request);
		Action action = (Action) getBean(map,"Action");
		new ClubService().agreeAction(action);
		
		//返回前端
		JSONObject json = new JSONObject();
		json.put("falg", "true");
		write(response, json.toString());
		
	}
	
	/**
	 * 审核活动被拒绝
	 * 参数: Action.class
	 * @param request
	 * @param response
	 */

	
	/**
	 * 同意添加文章
	 * @param request
	 * @param response
	 */
	public void agreeArticle(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map) getJSONParameter(request);
		Article article = (Article) getBean(map,"Article");
		new ClubService().agreeArticle(article);
		
		//返回前端
		JSONObject json = new JSONObject();
		json.put("falg", "true");
		write(response, json.toString());
	}
	
	/**
	 * 审核文章被据
	 */
	
	
	public void showRandClub(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map) getJSONParameter(request);
		int a = (int)map.get("flag");
		List<Club> list = new ArrayList<>();
		
		list = new ClubService().getRandClub(a);
		//将全部用户信息返回给前端
				JSONArray jsonArray = new JSONArray();
				for(Club u : list) {
					JSONObject json = new JSONObject();
					json.put("Club", u);
					jsonArray.add(json);
				}
		write(response, jsonArray.toString());
	}
	
}
