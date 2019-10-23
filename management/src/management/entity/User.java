package management.entity;
/**
 * 普通用户
 * @author 再几何
 * uid                  varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci not null ,
   phone               varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   uname                varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   IDCard               varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   faculty              varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   className            varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   heardImg             varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   password             varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   sex                  varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
 */
public class User {
	private String uid;       //学号
	private String phone;
	private String uname;
	private String IDCard;     //身份证号
 	private String faculty;   //学院
	private String className;   //班级
	private String heardImg; 
	private String password;
	private String sex;
	
	
	public User() {
		super();
	}

	public User(String uid, String phone, String uname, String iDCard, String faculty, String className,
			String heardImg, String password, String sex) {
		super();
		this.uid = uid;
		this.phone = phone;
		this.uname = uname;
		IDCard = iDCard;
		this.faculty = faculty;
		this.className = className;
		this.heardImg = heardImg;
		this.password = password;
		this.sex = sex;
	}


	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getHeardImg() {
		return heardImg;
	}

	public void setHeardImg(String heardImg) {
		this.heardImg = heardImg;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IDCard == null) ? 0 : IDCard.hashCode());
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((heardImg == null) ? 0 : heardImg.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
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
		User other = (User) obj;
		if (IDCard == null) {
			if (other.IDCard != null)
				return false;
		} else if (!IDCard.equals(other.IDCard))
			return false;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (faculty == null) {
			if (other.faculty != null)
				return false;
		} else if (!faculty.equals(other.faculty))
			return false;
		if (heardImg == null) {
			if (other.heardImg != null)
				return false;
		} else if (!heardImg.equals(other.heardImg))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", phone=" + phone + ", uname=" + uname + ", IDCard=" + IDCard + ", faculty="
				+ faculty + ", className=" + className + ", heardImg=" + heardImg + ", password=" + password + ", sex="
				+ sex + "]";
	}
	
	
}
