package management.entity;

import java.util.Date;

/**
 * 活动信息
 * @author 再几何
 *   aid                  int not null auto_increment,
   aname                varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   cid                  int,
   dintro               varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   aimg                 varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   startTime           datetime,
   endTime             datetime,
   category
 */
public class Action {
	private Integer aid;     //活动编号
	private String aname;   //活动名称
	private Integer cid;   //社团编号
	private String aintro;   //活动简介
	private String aImg;    //活动图片
	private String category;//活动类别
	private Date startTime;   //开始时间
	private Date endTime;     //结束时间
	public Action(Integer aid, String aname, Integer cid, String aintro,  String category,String aImg, Date startTime, Date endTime) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.cid = cid;
		this.aintro = aintro;
		this.aImg = aImg;
		this.category = category;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Action(String aname, Integer cid, String aintro, String aImg, Date startTime, Date endTime) {
		super();
		this.aname = aname;
		this.cid = cid;
		this.aintro = aintro;
		this.aImg = aImg;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Action() {
		super();
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getAintro() {
		return aintro;
	}
	public void setAintro(String aintro) {
		this.aintro = aintro;
	}
	public String getaImg() {
		return aImg;
	}
	public void setaImg(String aImg) {
		this.aImg = aImg;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aImg == null) ? 0 : aImg.hashCode());
		result = prime * result + ((aid == null) ? 0 : aid.hashCode());
		result = prime * result + ((aname == null) ? 0 : aname.hashCode());
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((aintro == null) ? 0 : aintro.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Action other = (Action) obj;
		if (aImg == null) {
			if (other.aImg != null)
				return false;
		} else if (!aImg.equals(other.aImg))
			return false;
		if (aid == null) {
			if (other.aid != null)
				return false;
		} else if (!aid.equals(other.aid))
			return false;
		if (aname == null) {
			if (other.aname != null)
				return false;
		} else if (!aname.equals(other.aname))
			return false;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (aintro == null) {
			if (other.aintro != null)
				return false;
		} else if (!aintro.equals(other.aintro))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Action [aid=" + aid + ", aname=" + aname + ", cid=" + cid + ", aintro=" + aintro + ", aImg=" + aImg
				+ ", category=" + category + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	
	
}
