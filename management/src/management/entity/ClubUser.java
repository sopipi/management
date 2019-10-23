package management.entity;

import java.util.Date;

/**
 * 成员信息
 * @author 再几何
 *uid                  varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci not null ,
   cid                  int not null, 
   did                  int not null,
   position             varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   joinTime             datetime,
 */
public class ClubUser {
	private String uid;  //个人编号
	private Integer cid;   //所在社团编号
	private Integer did;	//所在部门编号
	private String position;   //职位
	private Date joinTime;    //加入时间
	public ClubUser(String uid, Integer cid, Integer did, String position, Date joinTime) {
		super();
		this.uid = uid;
		this.cid = cid;
		this.did = did;
		this.position = position;
		this.joinTime = joinTime;
	}
	public ClubUser() {
		super();
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((did == null) ? 0 : did.hashCode());
		result = prime * result + ((joinTime == null) ? 0 : joinTime.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
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
		ClubUser other = (ClubUser) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (did == null) {
			if (other.did != null)
				return false;
		} else if (!did.equals(other.did))
			return false;
		if (joinTime == null) {
			if (other.joinTime != null)
				return false;
		} else if (!joinTime.equals(other.joinTime))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ClubUser [uid=" + uid + ", cid=" + cid + ", did=" + did + ", position=" + position + ", joinTime="
				+ joinTime + "]";
	}
	
	

}
