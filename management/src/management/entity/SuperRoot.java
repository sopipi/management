package management.entity;
/**
 * superid                  varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci not null ,
   superpassword            varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
 */
public class SuperRoot {
	private String superid;
	private String superpassword;
	
	
	public SuperRoot() {
		super();
	}
	private SuperRoot(String superid, String superpassword) {
		super();
		this.superid = superid;
		this.superpassword = superpassword;
	}
	public String getSuperid() {
		return superid;
	}
	public void setSuperid(String superid) {
		this.superid = superid;
	}
	public String getSuperpassword() {
		return superpassword;
	}
	public void setSuperpassword(String superpassword) {
		this.superpassword = superpassword;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((superid == null) ? 0 : superid.hashCode());
		result = prime * result + ((superpassword == null) ? 0 : superpassword.hashCode());
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
		SuperRoot other = (SuperRoot) obj;
		if (superid == null) {
			if (other.superid != null)
				return false;
		} else if (!superid.equals(other.superid))
			return false;
		if (superpassword == null) {
			if (other.superpassword != null)
				return false;
		} else if (!superpassword.equals(other.superpassword))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SuperRoot [superid=" + superid + ", superpassword=" + superpassword + "]";
	}
	
	
	
}
