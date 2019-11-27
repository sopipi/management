package management.service;

import java.util.Date;

import management.dao.ClubDao;
import management.entity.Club;

public class RootService {
	
	//申请社团加入
	public void addClub(Club c) {
		c.setBulidTime(new Date());
		new ClubDao().add(c);
	}
}
