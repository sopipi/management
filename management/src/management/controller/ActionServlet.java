package management.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import management.entity.Action;
import management.service.ActionService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@WebServlet("/ActionServlet")
public class ActionServlet extends BaseServlet{

	/**
	 * 查看活动具体信息
	 * 参数: aid
	 * @param request
	 * @param response
	 */
	public void showActionByAid(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		int aid = (int)map.get("aid");
		Action a = new ActionService().showActioByAid(aid);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("Action", a);
		write(response, json.toString());
	}
	
	/**
	 * 返回最新的几个活动
	 * @param request
	 * @param response
	 */
	public void showActions(HttpServletRequest request, HttpServletResponse response) {
		List<Action> list = new ActionService().showActions(2);
		//返回前端
		JSONArray  jsonArray = new JSONArray();
		for(Action a : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Action", a);
			jsonArray.add(jsonObject);
		}
		write(response, jsonArray.toString());
	}
}
