package management.util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public class JSONUtil {
	/**
	 * 将请求转换为字符串
	 * @param request
	 * @return
	 */
	public static String changeJson(HttpServletRequest request) {//将请求转换为字符串
		StringBuilder buff = new StringBuilder();
		try(BufferedReader reader = request.getReader()){
			String str = null;
			while((str = reader.readLine())!= null) {
				buff.append(str);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
//		System.out.println(buff.toString());
		return buff.toString();
	}
	
	/**
	 * 获取参数列表
	 * @param request
	 * @return
	 */
	public static JSONObject getJSONParameter(HttpServletRequest request) {//获取request请求参数
		String str = changeJson(request);
		if(str == ""  || str ==null) {
			System.out.println("It is empty!");
			return null;
		} else {
		JSONObject json = JSONObject.fromObject(str);
		return json;
		}		
	}
}
