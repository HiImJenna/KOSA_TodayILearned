package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import UTILS.SingletonHelper;
import kr.or.kosa.dto.KoreaMember;
import kr.or.kosa.utils.ConnectionHelper;



public class KoreaMemberDao {
	   Connection conn = null;
	   
	   public KoreaMemberDao() {
		   conn = ConnectionHelper.getConnection("oracle");  
	   }
	
	   // 단건 조회 (로그인 시 입력한 정보와 회원정보 비교해서...)
	   public KoreaMember getMemberById(String Id) {

		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
			  KoreaMember km = null;
			  
		      try {
		         String sql = "select id, pwd from koreaMember where id = ?";
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, Id);
		         rs = pstmt.executeQuery();

		         while (rs.next()) {
		            km = new KoreaMember();
		            km.setId(rs.getString("id"));
		            km.setPwd(rs.getString("pwd"));
		         }
		         
		      } catch (Exception e) {
		         System.out.println(e.getMessage());
		         
		      } finally {
		         ConnectionHelper.close(rs);
		         ConnectionHelper.close(pstmt);
		      }
		     
		      return km;
	   	}
	   
	   //삭제
		public int deleteMember(int empno) {
			 PreparedStatement pstmt=null;
			 int rowcount = 0;
			 
			 try {
				 String sql="delete from koreamember where id=?";
				 pstmt = conn.prepareStatement(sql);
				 pstmt.setString(1, "id");
				 rowcount = pstmt.executeUpdate();
			 }catch (Exception e) {
				 e.printStackTrace();
				 System.out.println(e.getMessage());
			 }finally {
				 ConnectionHelper.close(pstmt);
			 }
			 
			 return rowcount;
			 
		}
		
		

}
