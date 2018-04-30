package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	//���ӳض���-��DPCP�ṩ
	private static BasicDataSource ds;
	
	static{
		Properties p = new Properties();
		try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			//��ȡ����
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");
			String initsize = p.getProperty("initsize");
			String maxsize = p.getProperty("maxsize");
			
			//�������ӳ�
			ds = new BasicDataSource();
			//���ò���
			//ʹ���������ע������
			ds.setDriverClassName(driver);
			
			//ʹ����3��������������
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			//ʹ������������������
			ds.setInitialSize(new Integer(initsize));
			ds.setMaxActive(new Integer(maxsize));
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("����db.propertiesʧ��",e);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
		
	}
	
	/*
	 * �����ӳش��������ӣ����ӵ�close���������ӳ���д��
	 * ��Ϊ�黹���ӵ��߼���
	 * �������ӳػὫ���ӵ�״̬����Ϊ���У���������������������κ����ݡ�
	 */
	public static void close(Connection conn){
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�黹����ʧ��",e);
			}
		}
	}
	public static void rollback(Connection conn){
		if(conn != null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ع�ʧ��",e);
			}
		}
	}
	public static void main(String[] args) throws SQLException{
		Connection conn=DBUtil.getConnection();
		System.out.println(conn);
		DBUtil.close(conn);
	}
}
