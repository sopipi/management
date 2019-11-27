package management.util;

import java.lang.reflect.Field;

public class zoey {
	//查看Object是否是空的, 返回true则为空, 返回false则不为空
	public static boolean isAllFieldNull(Object obj) throws Exception {
		//得到类对象
		Class beanClass = obj.getClass();
		//得到类全部属性集合
		Field[] fields = beanClass.getDeclaredFields();
		
		for(Field f : fields) {
			//设置属性的访问权限
			f.setAccessible(true);
			//得到属性的值
			Object val = f.get(obj);
			//查看是否为空
			if(val != null && !"".equals(val)) {
				return false;
			}
		}
		return true;
	}
	
	
}
