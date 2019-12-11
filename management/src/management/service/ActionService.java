package management.service;
import java.util.List;

import management.dao.ActionDao;
import management.entity.Action;

/**
 * 有关Action的service
 * @author zoey
 *
 */
public class ActionService {

	/**
	 * 查看某个活动的具体信息
	 * 参数:aid
	 * @param aid
	 * @return
	 */
	public Action showActioByAid(int aid) {
		Action a = new ActionDao().selectByAid(aid);
		return a;
	}
	
	/**
	 * 展示活动页面:返回最新的几个页面
	 * @param num
	 * @return
	 */
	public List<Action> showActions(int num) {
		List<Action> list = new ActionDao().showNumActions(num);
		return list;
	}
	
	
	/**
	 * 返回分类活动
	 * @param num
	 * @return
	 */
	public List<Action> selectByCategory(String category) {
		List<Action> list = new ActionDao().selectByCategory(category);
		return list;
	}

}
