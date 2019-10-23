package management.entity;

import java.util.Date;

/**
 * 社团详细信息
 * @author 再几何
 * cid                  int not null auto_increment,
   cname                varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   chairman             varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   vicechairman         varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   cintro                varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   buildTime            datetime,
 */
public class Club {
	private Integer cid;   //社团编号
	private String cname;   //社团名称
	private String chairman;    //会长的uid
	private String vicechairman;   //副会长的uid
	private String cintro;     //社团简介
	private Date bulidTime;   //成立时间
	public Club() {
		super();
	}
	public Club(Integer cid, String cname, String chairman, String vicechairman, String cintro, Date bulidTime) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.chairman = chairman;
		this.vicechairman = vicechairman;
		this.cintro = cintro;
		this.bulidTime = bulidTime;
	}
	public Club(String cname, String chairman, String vicechairman, String cintro, Date bulidTime) {
		super();
		this.cname = cname;
		this.chairman = chairman;
		this.vicechairman = vicechairman;
		this.cintro = cintro;
		this.bulidTime = bulidTime;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getChairman() {
		return chairman;
	}
	public void setChairman(String chairman) {
		this.chairman = chairman;
	}
	public String getVicechairman() {
		return vicechairman;
	}
	public void setVicechairman(String vicechairman) {
		this.vicechairman = vicechairman;
	}
	public String getCintro() {
		return cintro;
	}
	public void setCintro(String cintro) {
		this.cintro = cintro;
	}
	public Date getBulidTime() {
		return bulidTime;
	}
	public void setBulidTime(Date bulidTime) {
		this.bulidTime = bulidTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bulidTime == null) ? 0 : bulidTime.hashCode());
		result = prime * result + ((chairman == null) ? 0 : chairman.hashCode());
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((cintro == null) ? 0 : cintro.hashCode());
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + ((vicechairman == null) ? 0 : vicechairman.hashCode());
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
		Club other = (Club) obj;
		if (bulidTime == null) {
			if (other.bulidTime != null)
				return false;
		} else if (!bulidTime.equals(other.bulidTime))
			return false;
		if (chairman == null) {
			if (other.chairman != null)
				return false;
		} else if (!chairman.equals(other.chairman))
			return false;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (cintro == null) {
			if (other.cintro != null)
				return false;
		} else if (!cintro.equals(other.cintro))
			return false;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (vicechairman == null) {
			if (other.vicechairman != null)
				return false;
		} else if (!vicechairman.equals(other.vicechairman))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Club [cid=" + cid + ", cname=" + cname + ", chairman=" + chairman + ", vicechairman=" + vicechairman
				+ ", cintro=" + cintro + ", bulidTime=" + bulidTime + "]";
	}

	
	
}
