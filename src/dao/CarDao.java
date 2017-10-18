package dao;

//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


/**
 * 数据处理类
 * @author user
 *
 */
public class CarDao {
	
	   private static ConnectionFactory connectionFactory;
	   private static Connection con;
	
	 /**
	  * 加载数据库连接
	  */
	static{
		  connectionFactory = ConnectionFactory.getConncetionFactory();
		  con = connectionFactory.getMySqlConnection();
	 }
	
	
	/**
	 * 获取汽车整体信息
	 */
	public void getCarInfo(){
		
		  String sql = "select * from car";
		
		try {
			Statement st = (Statement) con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			
			System.out.println("\n汽车类型\t汽车价格");
			
			while(rs.next()){
				
				System.out.println(rs.getString(2) + "\t\t" + rs.getString(3));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally{
			/**
			 * 关闭数据库连接
			 */
			connectionFactory.closeConnection();
		}
		
	}
	
		/**
		 * 增加Car信息
		 * 
		 */
		public void saveCarInfo(){
			
			  String sql = "insert into car values('5','BMW','200000')";
			
			try{
				Statement st = (Statement) con.createStatement();
				
				int count = st.executeUpdate(sql);
				
				if(count != 0){
					
					System.out.println("增加成功！");
				}
				
			}catch (SQLException e) {
				System.out.println("增加失败！");
				System.out.println(e.getMessage());
				e.printStackTrace();
				
			}finally{
				/**
				 * 关闭数据库连接
				 */
				connectionFactory.closeConnection();
			}
			
		}
		
		public void deleteCarInfo(){
			
			  String sql = "delete from car where id = '1'";
			
			try{
				Statement st = (Statement) con.createStatement();
				
				int count = st.executeUpdate(sql);
				
				if(count != 0){
					
					System.out.println("删除成功！");
				}
				
			}catch (SQLException e) {
				System.out.println("删除失败！");
				System.out.println(e.getMessage());
				e.printStackTrace();
				
			}finally{
				/**
				 * 关闭数据库连接
				 */
				connectionFactory.closeConnection();
			}
			
		}
		
		/**
		 * 修改汽車信息
		 */
		public void updateCarInfo(){
			

			
		  String sql = "update  car set carType = 'BYD' where id = '3'";
			
			try{
				Statement st = (Statement) con.createStatement();
				
				int count = st.executeUpdate(sql);
				
				if(count != 0){
					
					System.out.println("修改成功！");
				}
				
			}catch (SQLException e) {
				System.out.println("修改失败！");
				System.out.println(e.getMessage());
				e.printStackTrace();
				
			}finally{
				/**
				 * 关闭数据库连接
				 */
				connectionFactory.closeConnection();
			}
			
		}
		
		public void testOrcl(){
			
			
		}
	

}
