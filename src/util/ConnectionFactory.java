package util;

//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * JDBC�������ݿ⹤����
 * ����
 * @author user
 *
 */
public class ConnectionFactory {
	
	private static ConnectionFactory connectionFactory = null;
	
	private static Connection con = null;
	
//	private static Connection con = null;   oracle���ݿ�����ʵ��
	
	private ConnectionFactory(){
		
	}
	
	
	public static ConnectionFactory getConncetionFactory(){
		if(connectionFactory == null){
			
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
	
	
	/**
	 * ����mysql
	 * @return
	 */
	public Connection getMySqlConnection(){
		
		/** �������ַmysql  **/
		String url = "jdbc:mysql://10.196.21.32:3306/test";
		/** �������ַorcle **/
//		String url = "jdbc:oracle:thin:@10.196.21.32:1521:test";
		
		try {
			/**
			 * �@ȡorcle�������B��
			 */
			//Class.forName("oracle.jdbc.driver.OracleDriver");  //oracle���ݿ�����
			//con = (Connection) DriverManager.getConnection(url, "root", "yao");
			
			/**
			 * ���dmysql����
			 */
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�ɹ����dmysql��.....");
			//�@ȡmysql�������B��
			con = (Connection) DriverManager.getConnection(url, "root", "yao");
			System.out.println("�ɹ�����mysql���ݿ�");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	/**
	 * �ر�mysql����
	 */
	public void closeConnection(){
		
		try {
			con.close();
			System.out.println("�ر����ݿ�����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
