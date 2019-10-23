package management.entity;
/**
 * 部门信息
 * @author 再几何
 *did                  int not null auto_increment,
   dname                varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   cid                  int,
   dintro               varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
 */
public class Department {
	private Integer did;   //部门编号
	private String dname;   //部门名称
	private Integer cid;    //社团编号
	private String dintro;   //部门简介
	public Department(Integer did, String dname, Integer cid, String dintro) {
		super();
		this.did = did;
		this.dname = dname;
		this.cid = cid;
		this.dintro = dintro;
	}
	public Department() {
		super();
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getDintro() {
		return dintro;
	}
	public void setDintro(String dintro) {
		this.dintro = dintro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((did == null) ? 0 : did.hashCode());
		result = prime * result + ((dintro == null) ? 0 : dintro.hashCode());
		result = prime * result + ((dname == null) ? 0 : dname.hashCode());
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
		Department other = (Department) obj;
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
		if (dintro == null) {
			if (other.dintro != null)
				return false;
		} else if (!dintro.equals(other.dintro))
			return false;
		if (dname == null) {
			if (other.dname != null)
				return false;
		} else if (!dname.equals(other.dname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", cid=" + cid + ", dintro=" + dintro + "]";
	}
	
	
}
