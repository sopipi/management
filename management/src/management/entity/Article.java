package management.entity;

import java.util.Date;

/**
 * 发布文章信息
 * @author 再几何
 * artid                int not null auto_increment,
   cid                  int,
   uid                  varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci not null ,
   content              text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   title                varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   createTime           datetime,
 */
public class Article {
	private Integer artid;  //文章id
	private Integer cid;    //社团编号
	private String uid;     //作者的个人编号
	private String content;    //文章内容 
	private String title;       //文章民称
	private Date createTime;    //发布时间
	public Article(Integer artid, Integer cid, String uid, String content, String title, Date createTime) {
		super();
		this.artid = artid;
		this.cid = cid;
		this.uid = uid;
		this.content = content;
		this.title = title;
		this.createTime = createTime;
	}
	public Article(Integer cid, String uid, String content, String title, Date createTime) {
		super();
		this.cid = cid;
		this.uid = uid;
		this.content = content;
		this.title = title;
		this.createTime = createTime;
	}
	public Article() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artid == null) ? 0 : artid.hashCode());
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Article other = (Article) obj;
		if (artid == null) {
			if (other.artid != null)
				return false;
		} else if (!artid.equals(other.artid))
			return false;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
	public Integer getArtid() {
		return artid;
	}
	public void setArtid(Integer artid) {
		this.artid = artid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Article [artid=" + artid + ", cid=" + cid + ", uid=" + uid + ", content=" + content + ", title=" + title
				+ ", createTime=" + createTime + "]";
	}
	
}
