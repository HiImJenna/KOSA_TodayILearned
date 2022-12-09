import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.kosa.SingletonHelper;

public class sdept_quiz {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//totalSearch(); //전체조회
//partSearch();
		update();
//insert();
		//delete();
	}

	
	public static void totalSearch() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		 try {
	        conn = SingletonHelper.getConnection("oracle");
	        String sql="select * from sdept";
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	         
	        if (rs.next()) { //최소 1건
				do {
					System.out.println(rs.getInt(1) + " / " + rs.getString(2) + " / " + rs.getString(3));
				} while (rs.next());
			}else { System.out.println("조회된 데이터가 없습니다."); }

	      } catch (Exception e) {
	         
	      }finally {
	         SingletonHelper.close(rs);
	         SingletonHelper.close(pstmt);
	      }
	   }
	
	////////////////////////////////////////////////////////////////////////////////////
	
	public  static void partSearch() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		 try {
	        conn = SingletonHelper.getConnection("oracle");
	        String sql="select * from sdept where deptno = ?";
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setInt(1, 10);
	        
	        rs = pstmt.executeQuery();
	        
	        
	        if (rs.next()) { //최소 1건
				do {
					System.out.println(rs.getInt(1) + " / " + rs.getString(2) + " / " + rs.getString(3));
				} while (rs.next());
			}else { System.out.println("조회된 데이터가 없습니다."); }

	      } catch (Exception e) {
	         
	      } finally {
	         SingletonHelper.close(conn);
	      }
	   }
	   
	//////////////////////////////////////////////////////////////////
	
	public static void insert() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		 try {
	        conn = SingletonHelper.getConnection("oracle");
	        String sql="insert into sdept(deptno,dname,loc) values(?,?,?)";
	        
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setInt(1, 50);
	        pstmt.setString(2, "ACCOUNTING");
	        pstmt.setString(3, "LA");
	        
	        int row = pstmt.executeUpdate();
	        
	        if(row>0) {
	            System.out.println("update row count : " + row);
	         }
	 
	      } catch (Exception e) {
	         System.out.println("오류");
	         System.out.println(e.getMessage());
	         
	      } finally {
		      SingletonHelper.close(pstmt);
	      }
	}
	   
	////////////////////////////////////////////////////////////////////////////////////
	
	public static void delete() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		 try {
	        conn = SingletonHelper.getConnection("oracle");
	        String sql="delete from sdept where deptno = ?";
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setInt(1, 10);
	        
	        int row = pstmt.executeUpdate();
	        
	        if(row>0) {
	            System.out.println("update row count : " + row);
	         }
	 
	      } catch (Exception e) {
	         System.out.println("오류");
	         
	      } finally {
		      SingletonHelper.close(pstmt);
	      }
	}
		
	////////////////////////////////////////////////////////////////////////////////////
	
	public static void update() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		 try {
	        conn = SingletonHelper.getConnection("oracle");
	        String sql="update sdept set deptno=?, dname=?, loc=? where deptno = ?";
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setInt(1, 10);
	        pstmt.setString(2, "SALES");
	        pstmt.setString(3, "CHICAGO");
	        pstmt.setInt(4, 40);
	        
	        int row = pstmt.executeUpdate();
	        
	        if(row>0) {
	            System.out.println("update row count : " + row);
	         }
	 
	      } catch (Exception e) {
	         System.out.println("오류");
	         
	      } finally {
	    	  SingletonHelper.close(rs);
		      SingletonHelper.close(pstmt);
	      }
	}
	
}
