import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/*
DML (insert, update, delete)
JDBC API통해서 작업
1. 결과 집합이 없다 (resultSet 필요 없다)
2. 반영결과 (return 행의 수) >> update 5건 >> return 5

java코드
update emp set sal=0 > 실행 > update 14건 >> return 14
update emp set sal=100 where empno=4444> update 0건 >> return 0

결과를 가지고 java코드로 로직처리
KET POINT
1. Oracle DML(developer, Cmd(sqlplus), tool) 하면 commit or rollback강제
2. JDBC API 사용해서 java 코드를 통해서 DML >> default >> autocommit; >> 실반영
3. JDBC API 통해서 delete from emp >> 실행 >> 자동 commit> 실반영
4. 필요에 따라 commit(), rollback 처리 코드...

begin
   A계좌 인출 (update ...
   ....
   B계좌 입급 (update ....
end
>> 하나의 논리적인 단위 업무(transaction)
>> 전체 commit 이거나 전체 rollback
>> 둘다 성공 이거나 둘다 실패

>> 업무 처리 >> JDBC >> autocomit 옵션을 >> false전환
>> 반드시 java



--KOSA계정에서
create table dmlemp
as
    select * from emp;

--제약정보는 복사가 안돼요
select * from dmlemp;

alter table dmlemp
add constraint pk_dmlemp_empno primary key (empno);

select * from user_constraints where table_name='DMLEMP';

 */


public class Ex02_Oracle_DML_delete {
   public static void main(String[] args) {
      Connection conn = null;
      Statement stmt = null;
      
      try {
         //드라이버 로딩
         //ClassforName("oracle.jdbc.OracleDriver"); 생략가능
         
         //Connection 인터페이스를 구현하고 있는 객체의 주소가 리턴 ...
         //다형성을 통해서 Connection 타입의 conn 변수가 주소값을 받는다
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
         stmt = conn.createStatement(); //Statement 구현하고 있는 객체의 주소 리
         
         //DELETE
         //delete from dmlemp where deptno = 부서번호
         
           Scanner scan = new Scanner(System.in);
           int deptno = 0;
            
           System.out.print("부서입력 : ");
           deptno = Integer.parseInt(scan.nextLine());
            
           //
           String sql="delete from dmlemp where deptno=" + deptno;
           System.out.println(sql);
         
         
         //현재
         //values(?,?,?)      >> ? parameter 별도 설정
         //executeUpdate()   >> insert, update, delete 모두 수행
         int resultrow = stmt.executeUpdate(sql);
         
         if(resultrow > 0) {
            System.out.println("반영된 행의 수: " + resultrow);
         }else {
            System.out.println("예외가 발생된 것이 아니고 : 반영된 행이 없다 ");
         }
         
      } catch (Exception e) {
         //중복데이터 insert 해서 문제가 생기면 executeUpdate() 예외 발생
         //코드 처리
         System.out.println("SQL 예외발생: " + e.getMessage());
      } finally {
         //강제 수행 블럭
         //자원해제
         try {
            stmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
}