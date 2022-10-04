package kr.or.kosa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
전체 프로젝트 (회원 : 전체조회 , 조건조회 , 삭제 , 수정 , 변경)
각각의 페이지  5개
1. 드라이버 로딩
2. 연결객체 생성 , 명령 , 자원해제 ....
3. 반복적인 코드 ... 제거 ....

제거되는 코드 ..공통사항 .... >> ConnectionHelper 만들어 보세요
생략 하고 ....
DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004"); 
  

기능 (함수) >> 자주 static >> overloading >> 다형성 ....
*/
public class ConnectionHelper {
	public static Connection getConnection(String dsn) {
		Connection conn = null;
		try {
			if(dsn.equals("oracle")) {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
			}//else if(dsn.equals("mysql")) {
			//	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true","kosa","1004");
			//}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public static Connection getConnection(String dsn, String id, String pwd) {
		Connection conn = null;
		try {
			if(dsn.equals("oracle")) {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",id,pwd);
			}//else if(dsn.equals("mysql")) {
			//	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true","kosa","1004");
			//}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}


    public static void close(Connection conn) {
    	if(conn != null) {
    		try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
    	}
    }
    
    public static void close(ResultSet rs) {
    	if(rs != null) {
    		try {
				rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
    	}
    }
    
    public static void close(Statement stmt) {
    	if(stmt != null) {
    		try {
    			stmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
    	}
    }
    
    public static void close(PreparedStatement pstmt) {
    	if(pstmt != null) {
    		try {
    			pstmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
    	}
    }
}
