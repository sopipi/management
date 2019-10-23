package management.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;


public class DBUtil {
	static String ip = "localhost";
	static String database = "management";
	static String encoding = "utf8";
	static String user = "root";
	static String password = "root";
	static String port = "3306";
	private static final String driverClassName = "com.mysql.jdbc.Driver";
	
	private static boolean TESTMODE = false;//测试模式
	
	public static void enableTestMode() {//开启测试模式
		TESTMODE = true;
	}
	
	private static ThreadLocal<Connection> TL = new ThreadLocal<Connection>();//本地线程
	static {//运用静态代码块初始化加载驱动
		try {
			Class.forName(driverClassName);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {//获取连接
		Connection conn = null;
		
		//从本地获取
		conn = TL.get();
		
		//拼接URL地址
		String url = String.format("jdbc:mysql://%s:%s/%s?userUnicode=true&characterEncoding=%s", ip, port, database, encoding)+"&serverTimezone=GMT%2B8&useSSL=false";
		System.out.println(url);
		
		//如果拿不到，或连接不可用
		if(conn==null || conn.isClosed()) {
			conn =  DriverManager.getConnection(url, user, password);
			//存到ThreadLocal中
			TL.set(conn);
		}
		
		return conn;
	}
	
	public static void startTransaction() {//关闭自动提交
		try {
			Connection conn = getConnection(); 
			if(conn != null) {
				conn.setAutoCommit(false);//设置自动提交失效
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void commit() {//提交事务
		try {
			Connection conn = getConnection();
		if(TESTMODE) {
			return;//如果是测试模式，不进行提交
		}
		
		if(conn != null) {
			conn.commit();//提交
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//关闭资源
	public static void close(ResultSet rs) {//关闭结果集
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {  
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn) {//关闭连接
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {//关闭线程连接
		try {
			close(getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 
	 * @param sql sql语句
	 * @param params  插入的参数
	 */
	public static void update(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// 建立连接
			conn = getConnection();
			// 预编译SQL命令，防止sql注入
			stmt = conn.prepareStatement(sql);
			// 设置参数
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i + 1, params[i]);
				}
			}
			// 执行SQL
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			// 释放资源
			close(stmt);
		}
	}

	
	/***
	 * 
	 * @param sql sql语句
	 * @param h  解析结果集，反射为对象
	 * @param params sql参数
	 * @return
	 */
	public static <T> T select(String sql, ResultSetHandler<T> h, Object... params) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 建立连接
			conn = getConnection();
			// 预编译SQL命令
			stmt = conn.prepareStatement(sql);
			// 设置参数
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i + 1, params[i]);
				}
			}
			// 执行SQL
			rs = stmt.executeQuery();
			// 解析结果集
			T obj = h.handle(rs);
			return obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 释放资源
			close(rs);
			close(stmt);
		}
	}
	
	
	/**
	 * 根据信息查新数据
	 * @param sql
	 * @param params  查询参数
 	 * @return  返回数据
	 */
	public static String select(String sql,Object... params) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 建立连接
			conn = getConnection();
			// 预编译SQL命令
			stmt = conn.prepareStatement(sql);
			// 设置参数
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i + 1, params[i]);
				}
			}
			// 执行SQL
			rs = stmt.executeQuery();
			if(rs.next()) {
			return rs.getString(1);
			}else return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 释放资源
			close(rs);
			close(stmt);
		}
	}
	
	/**
	 * 返回多个数据
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List<String> selectList(String sql,Object... params) {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<String> list = new ArrayList<>();
 		ResultSet rs = null;
		try {
			// 建立连接
			conn = getConnection();
			// 预编译SQL命令
			stmt = conn.prepareStatement(sql);
			// 设置参数
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i + 1, params[i]);
				}
			}
			// 执行SQL
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 释放资源
			close(rs);
			close(stmt);
		}
	}
}
