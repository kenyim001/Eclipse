package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 *数据库连接管理
 *
 */
public class DBUtil {
	//数据库连接池
	private static BasicDataSource ds;
	
	static{
		try {
			//加载config.properties文件
			Properties prop=new Properties();
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("config.properties"));
			
			//获取信息初始化属性
			String driverName=prop.getProperty("drivername");
			String url=prop.getProperty("url");
			String username=prop.getProperty("username");
			String password=prop.getProperty("password");
			int maxActive=Integer.parseInt(prop.getProperty("maxactive"));
			int maxWait=Integer.parseInt(prop.getProperty("maxwait"));
//			System.out.println(driverName);
//			System.out.println(url);
//			System.out.println(username);
//			System.out.println(password);
			
			//初始化连接池
			ds=new BasicDataSource();
			
			//Class.forName()
			ds.setDriverClassName(driverName);
			
			//DriverManager.getConnection()
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			
			//最大连接数
			ds.setMaxActive(maxActive);
			
			//最大等待时间
			ds.setMaxWait(maxWait);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	
	/**
	 * @throws Exception 
	 * 
	 */
	public static Connection getConnection() throws Exception{
		try {
			/*
			 * 连接池提供了获取连接的方法
			 * Connection getConnection()
			 * 该方法会将连接池中的空闲连接返回，
			 * 若当前连接池中没有可用空闲连接，那么
			 * 该方法会阻塞，阻塞时间由maxWait指定的值决定。
			 * 在阻塞期间若有空闲连接可用会立刻返回该连接，若超时后仍没有可用连接，那么该方法会抛出超时异常。
			 * 
			 */
			return ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
}
