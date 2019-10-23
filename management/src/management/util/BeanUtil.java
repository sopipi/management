package management.util;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class BeanUtil {
	/**
	 * 传递Map参数返回实体类
	 * @param data
	 * @param clzName
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static <T> T getBean(Map<String, Object> data, String clzName) throws Exception{
		
		Class clz = Class.forName(clzName);
		Object bean = clz.newInstance();
		
		//获取所有的方法，添加到Map里
		Map map = new HashMap();
		Method[] methods = clz.getMethods();
		for(Method method : methods) {
			if(Modifier.isPublic(method.getModifiers())) {
				map.put(method.getName(), method.getReturnType().getName());
			}
		}
		data.entrySet().forEach(entry -> {//创建函数名称setName
			String setter = String.format("set%s%s", 
					entry.getKey().substring(0, 1).toUpperCase(),//首字母大写，例如Name
					entry.getKey().substring(1));
			System.out.println(setter);
			if(map.containsKey(setter)) { 
			try {
				//根据方法名称与参数类型取得Method实例
				Method method = clz.getMethod(setter, entry.getValue().getClass());
				//必须是公开方法
				if(Modifier.isPublic(method.getModifiers())) {
					//指定实例与参数值调用方法
					method.invoke(bean, entry.getValue());
				}
			}catch(IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});		
		
		return (T) bean;
	}
}
