package management.controller;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import management.entity.Club;
import management.service.RootService;
import net.sf.json.JSONObject;


@WebServlet("/RootServlet")
public class RootServlet extends BaseServlet {
	
	/**
	 * 添加club
	 * 参数:Club.class
	 * @param request
	 * @param response
	 */
	public void addClub(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		Club club = (Club)getBean(map, "Club");
		new RootService().addClub(club);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("flag", "true");
		write(response, json.toString());
	}
	
}
