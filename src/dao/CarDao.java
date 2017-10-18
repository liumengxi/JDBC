package dao;

//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


/**
 * ���ݴ�����
 * @author user
 *
 */
public class CarDao {
	
	   private static ConnectionFactory connectionFactory;
	   private static Connection con;
	
	 /**
	  * �������ݿ�����
	  */
	static{
		  connectionFactory = ConnectionFactory.getConncetionFactory();
		  con = connectionFactory.getMySqlConnection();
	 }
	
	
	/**
	 * ��ȡ����������Ϣ
	 */
	public void getCarInfo(){
		
		  String sql = "select * from car";
		
		try {
			Statement st = (Statement) con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			
			System.out.println("\n��������\t�����۸�");
			
			while(rs.next()){
				
				System.out.println(rs.getString(2) + "\t\t" + rs.getString(3));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally{
			/**
			 * �ر����ݿ�����
			 */
			connectionFactory.closeConnection();
		}
		
	}
	
		/**
		 * ����Car��Ϣ
		 * 
		 */
		public void saveCarInfo(){
			
			  String sql = "insert into car values('5','BMW','200000')";
			
			try{
				Statement st = (Statement) con.createStatement();
				
				int count = st.executeUpdate(sql);
				
				if(count != 0){
					
					System.out.println("���ӳɹ���");
				}
				
			}catch (SQLException e) {
				System.out.println("����ʧ�ܣ�");
				System.out.println(e.getMessage());
				e.printStackTrace();
				
			}finally{
				/**
				 * �ر����ݿ�����
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
					
					System.out.println("ɾ���ɹ���");
				}
				
			}catch (SQLException e) {
				System.out.println("ɾ��ʧ�ܣ�");
				System.out.println(e.getMessage());
				e.printStackTrace();
				
			}finally{
				/**
				 * �ر����ݿ�����
				 */
				connectionFactory.closeConnection();
			}
			
		}
		
		/**
		 * �޸���܇��Ϣ
		 */
		public void updateCarInfo(){
			

			
		  String sql = "update  car set carType = 'BYD' where id = '3'";
			
			try{
				Statement st = (Statement) con.createStatement();
				
				int count = st.executeUpdate(sql);
				
				if(count != 0){
					
					System.out.println("�޸ĳɹ���");
				}
				
			}catch (SQLException e) {
				System.out.println("�޸�ʧ�ܣ�");
				System.out.println(e.getMessage());
				e.printStackTrace();
				
			}finally{
				/**
				 * �ر����ݿ�����
				 */
				connectionFactory.closeConnection();
			}
			
		}
		
		public void testOrcl(){
			
			
		}
	

}
