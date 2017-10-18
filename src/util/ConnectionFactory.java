package util;

//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * JDBC连接数据库工厂类
 * 单例
 * @author user
 *
 */
public class ConnectionFactory {
	
	private static ConnectionFactory connectionFactory = null;
	
	private static Connection con = null;
	
//	private static Connection con = null;   oracle数据库连接实例
	
	private ConnectionFactory(){
		
	}
	
	
	public static ConnectionFactory getConncetionFactory(){
		if(connectionFactory == null){
			
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
	
	
	/**
	 * 连接mysql
	 * @return
	 */
	public Connection getMySqlConnection(){
		
		/** 數據庫地址mysql  **/
		String url = "jdbc:mysql://10.196.21.32:3306/test";
		/** 數據庫地址orcle **/
//		String url = "jdbc:oracle:thin:@10.196.21.32:1521:test";
		
		try {
			/**
			 * 獲取orcle數據庫連接
			 */
			//Class.forName("oracle.jdbc.driver.OracleDriver");  //oracle数据库驱动
			//con = (Connection) DriverManager.getConnection(url, "root", "yao");
			
			/**
			 * 加載mysql驅動器
			 */
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加載mysql驅動.....");
			//獲取mysql數據庫連接
			con = (Connection) DriverManager.getConnection(url, "root", "yao");
			System.out.println("成功连接mysql数据库");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	/**
	 * 关闭mysql连接
	 */
	public void closeConnection(){
		
		try {
			con.close();
			System.out.println("关闭数据库连接");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
