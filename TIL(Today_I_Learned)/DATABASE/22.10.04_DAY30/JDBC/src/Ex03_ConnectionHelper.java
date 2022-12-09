import java.sql.Connection;
import java.sql.SQLException;

import kr.or.kosa.ConnectionHelper;

public class Ex03_ConnectionHelper {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		conn = ConnectionHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		System.out.println(conn.isClosed());
		//////////////////////////////////////////////////////////////////
		conn = ConnectionHelper.getConnection("oracle");
		System.out.println(conn.toString());
		
		//그렇다면 하나의 객체가 생성되어 공유할 수는 없을까? -> singletone pattern
	
		/////////////////////////////////////////////////////////////////
	    Connection conn2 = null;
	    conn2 = ConnectionHelper.getConnection("oracle", "HR", "1004");
	    System.out.println(conn2.toString());
		
	}
	

}