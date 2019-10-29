package management.controller;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import management.entity.User;
import management.service.UserService;
import net.sf.json.JSONObject;


@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 注册
	 * 参数: User.class
	 * @param request
	 * @param response
	 */
	public void register(HttpServletRequest request, HttpServletResponse response) {
		//解析上传参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		User user = (User)getBean(map, "User");
		new UserService().register(user);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("flag", "true");
		write(response, json.toString());
		
	}
	
	/**
	 * 登陆
	 * 参数:uid, password
	 * @param request
	 * @param response
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		String uid = (String) map.get("uid");
		String password = (String) map.get("password");
		//查看密码是否正确
		boolean flag = new UserService().login(uid, password);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("flag", flag);
		write(response, json.toString());
	}
	
	/**
	 * 修改密码
	 * 需要参数:uid, oldPwd, newPwd
	 * @param request
	 * @param response
	 */
	public void changePwd(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		String uid = (String) map.get("uid");
		String oldPwd = (String) map.get("oldPwd");
		String newPwd = (String) map.get("newPwd");
		boolean flag = new UserService().changePassword(uid, oldPwd, newPwd);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("flag", flag);
		write(response, json.toString());
	}
	
	/**
	 * 显示个人信息
	 * 需要参数:uid
	 * 返回参数:User.class
	 * @param request
	 * @param response
	 */
	public void showInfo(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		String uid = (String)map.get("uid");
		User u = new UserService().showInfo(uid);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("User", u);
		write(response, json.toString());
	}
	
	/**
	 * 修改头像
	 * 参数:uid, img
	 * @param request
	 * @param response
	 */
	public void changeImg(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		String uid = (String)map.get("uid");
		String img = (String)map.get("img");
		new UserService().changeHeardImg(uid, img);
		//返回给前端
		JSONObject json = new JSONObject();
		json.put("flag", "true");
		write(response, json.toString());
	}

}
