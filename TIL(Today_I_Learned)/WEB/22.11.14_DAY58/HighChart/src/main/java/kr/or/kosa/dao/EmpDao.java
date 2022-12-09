package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.dto.Emp;
import kr.or.kosa.utils.SingletonHelper;
public class EmpDao {
	Connection conn = null;
	public EmpDao() {
		conn = SingletonHelper.getConnection("oracle");
	}
	
	public List<Emp> salRank(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//Point
		List<Emp> emplist = new ArrayList<Emp>();
	    
		try {
	           String sql="select ename, sal from emp where empno < 7700";
	           pstmt = conn.prepareStatement(sql);
	           rs = pstmt.executeQuery();
	            
	           if (rs.next()) { //최소 1건
	        	   do {
	            	Emp emp = new Emp();
	            	
	            	emp.setEname(rs.getString("ename"));
					emp.setSal(rs.getInt("sal"));

					emplist.add(emp);
					} while (rs.next());
	        	   
	         }else { System.out.println("조회된 데이터가 없습니다."); }

	         } catch (Exception e) {
	            
	         }finally {
	            SingletonHelper.close(rs);
	            SingletonHelper.close(pstmt);
	         }

	       return emplist;
	}
	
}
