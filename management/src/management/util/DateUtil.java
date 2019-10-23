package management.util;
/**
 * 
 * @author 再几何
 *
 *将数据库中的datetime和java中的date进行转换
 */
public class DateUtil {
	public static java.sql.Timestamp dtot(java.util.Date d) {
		if (null == d)
			return null;
		return new java.sql.Timestamp(d.getTime());
	}

	public static java.util.Date ttod(java.sql.Timestamp t) {
		if (null == t)
			return null;
		return new java.util.Date(t.getTime());
	}
}
