package management.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import management.entity.Article;
import management.service.ArticleService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/ArticleServlet")
public class ArticleServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * 根据artid展示文章具体内容
	 * 参数:artid
	 * @param request
	 * @param response
	 */
	public void showArticleByArtid(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		int artid = (int)map.get("artid");
		Article a = new ArticleService().showArticleByArtid(artid);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("Article", a);
		write(response, json.toString());
	}
	
	/**
	 * 展示文章
	 * 参数:num(展示几篇文章)
	 * @param request
	 * @param response
	 */
	public void showArticles(HttpServletRequest request, HttpServletResponse response) {
		List<Article> list = new ArticleService().showArticles(2);
		//返回前端
		JSONArray  jsonArray = new JSONArray();
		for(Article a : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Article", a);
			jsonArray.add(jsonObject);
		}
		write(response, jsonArray.toString());
	}
  
}
