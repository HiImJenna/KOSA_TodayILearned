import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

import kr.or.kosa.SingletonHelper;
import oracle.sql.CharacterWalker;

/*
 * PreparedStatement (준비된 Statement )*
(1) 설명 
미리 SQL문이 셋팅된 Statement 가 DB가 전송되어져서 컴파일되어지고, SQL문의 ?만 나중에 추가 셋팅해서 실행 
이 되어지는 준비된 Statement 

(2) 장점
<1> Statement 에 비해서 반복적인 SQL문을 사용할 경우에 더 빠르다. ( 특히, 검색문 )
<2> DB컬럼타입과 상관없이 ?하나로 표시하면 되므로 개발자가 헷깔리지 않고 쉽다. ( 특히, INSERT문 )

(이유: ?를 제외한 SQL문이 DB에서 미리 컴파일되어져서 대기)

(3) 단점

SQL문마다 PreparedStatement 객체를 각각 생성해야 하므로 재사용불가
(but, Statement 객체는 SQL문이 달라지더라도 한 개만 생성해서 재사용이 가능하다. )

(4) 특징

<1> Statement stmt = con.createStatement(); //생성 stmt.execute(sql);//실행
<2> PreparedStatement pstmt = con.prepareStatement(sql); //생성 pstmt.execute(); //실행

(5) 주의

DB 객체들(table, ..)의 뼈대( 테이블명 or 컬럼명 or 시퀀스명 등의 객체나 속성명)은
?로 표시할 수 없다.
즉, data 자리에만 ?로 표시할 수 있다.
cf) 그래서, DDL문에서는 PreparedStatement를 사용하지 않는다.

장점 : 보안 (전체 문장을 DB에 보내지 않아요) 나누어서 ... SQL문 보내서 컴파일 ... 그 다음에는 parameter만
	  미리 쿼리문 컴파일 (쿼리문은 DB 서버에서 보관) >> 그 이후 전송 >> parameter 값만 >> 네트워크 트래픽 감소
	  
단점 : 쿼리문이 바뀌면 다시 컴파일 ... 

 */

public class Ex05_Oracle_PrepareStatement {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection(("oracle"));
			String sql = "select empno, ename from emp where deptno = ?";
			//where id =? and name =? and job =?
			// ? parameter
			pstmt = conn.prepareStatement(sql); //미리 컴파일 (쿼리를 DB가 가지고 있어요)
			
			//이후에는 parameter 설정해서 DB 보내면 됨
			pstmt.setInt(1, 30); //where deptno = 30
			
			//ResultSet rs = stmt.executeQuery(sql);
			rs = pstmt.executeQuery();
			
			//공식같은 로직
			//데이터 1건 or 1건 이상 or 없는 경우
			if (rs.next()) { //최소 1건
				do {
					System.out.println(rs.getInt(1) + " / " + rs.getString(2));
				} while (rs.next());
			}else { System.out.println("조회된 데이터가 없습니다."); }

		} catch (Exception e) {
		
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			//singleton은 close 하지 않음 (App이 존속하는 한)
		}

	}

}




























