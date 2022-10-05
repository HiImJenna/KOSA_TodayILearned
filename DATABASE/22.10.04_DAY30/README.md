# 2022.10.04. TUE 📅
----------------
<br>

## 1. MAX ✔
```sql
insert into board(boardid, title)
values((select nvl(max(boardid, 0) + 1 from board), '1');

insert into board(boardid, title)
values((select nvl(max(boardid, 0) + 1 from board), '2');

insert into board(boardid, title)
values((select nvl(max(boardid, 0) + 1 from board), '3');
```
<br>

## 2. Sequence ✔
- 글 번호 고민 (순번)
- 중복값이 없고 순차적인 값을 제공하는 객체
![image](https://user-images.githubusercontent.com/111114507/193710038-b43e75d6-dcac-48d5-9250-fcb5ba965959.png)
<br>

```sql
select board_num.nextval from dual;
```
[출력값]   
![image](https://user-images.githubusercontent.com/111114507/193710318-7fcae75c-0975-4655-bfc2-94152eb4bd9b.png)
<br>

```sql
create sequence kboard_num;

insert into kboard(num, title) 
values(kboard_num.nextval, '처음');

insert into kboard(num, title) 
values(kboard_num.nextval, '둘');

insert into kboard(num, title) 
values(kboard_num.nextval, '셋');

select * from kboard;
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/193710691-f5031be0-780e-43e8-a42b-63208563712e.png)
<br>

```sql
delete from kboard where num = 1;

insert into kboard(num, title) 
values(kboard_num.nextval, '넷');
```
[출력값]   
![image](https://user-images.githubusercontent.com/111114507/193710891-d0ad3b75-20f0-4427-a2e6-71836b8298e4.png)
▶ 데이터 삭제 후에도 오류 발생하지 않음!  
<br>

### 🔔 게시판을 만들때!
#### 1) 게시판을 구분하지 않고 게시글 순번을 표시하고 싶다면
- sequence 하나 생성해서 여러 게시판에서 사용 가능
- sequence 객체는 공유객체-> 테이블에 종속되지 않는다
- 하나의 sequence는 여러곳에서 자유롭게 사용가능
<br>

#### 2) 게시판을 구분하여 게시글 순번을 표시하고 싶다면
- 10개의 sequence를 만들어서 각각 사용하면 됨

#### 🔔 TIP
- MS-SQL : create table board(boardnum int identity(1,1)....
- insert into (title) values('방가'); 자동으로 (1,2,3 ...)
- mysql : create table board(boardnum int auto_increment, ... title)
- insert into board (title) values('방가');-> 자동(1,2,3,4,,,)
- mysql 만든 사람들이 open source >> mariadb

## 3. rownum & Top-n query ✔
### < rownum >
- 실제 물리적으로 존재하는 컬럼이 아니고 논리적인 존재
- 실제로 테이블에 컬럼으로 존재하지 않지만 내부적으로 행 번호를 부여하는 컬럼
![image](https://user-images.githubusercontent.com/111114507/193716087-798cf77b-59fa-46af-9c4a-62704ca091a0.png)
<br>

#### 🔔 예제1
#### 1단계 (sal이 높은 순으로 정렬)
```sql
select *
from (
        select * 
        from emp
        order by sal desc
      ) e;
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/193716974-865e059b-810a-42cf-9bb3-1a4099d74176.png)
<br>

#### 2단계 (rownum)
```sql
select rownum as num, e.*
from (
        select * 
        from emp
        order by sal desc
      ) e;
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/193717055-6e0f3aac-8047-4bc6-99b1-23e3e849137f.png)
<br>

#### 3단계 (급여를 많이 받는 사원 5명)
```sql
select * 
from (
    select rownum as num, e.*
    from (
            select * 
            from emp
            order by sal desc
          ) e
) n where num <= 5;     
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/193717168-6c498efb-0e5b-4b00-a42f-e6f4d47f715a.png)
<br>

#### 🔔 예제2
#### 1단계 (기준 데이터 만들기-사번이 낮은 순으로 정렬)
```sql
select * from employees order by employee_id asc;
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/193718446-e355f4e7-2a37-4cd8-b850-d04deb39d21a.png)
<br>

#### 2단계(기준데이터에 순번 부여
```sql
select rownum as num, e.*
from (
    select * from employees order by employee_id asc
    ) e
where rownum <= 50; --정렬된 데이터에 내부적으로 생성된 rownum
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/193718488-7e53afa2-ce3d-429c-a9d7-ac0ee2e20a58.png)
<br>

#### 3단계\
```sql
select *
    from(
        select rownum as num, e.*
        from (
            select * from employees order by employee_id asc
            ) e
        where rownum <= 50
        ) n where num >= 41;
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/193718754-f22baa7e-a113-4aac-ab52-228f65e11213.png)
<br>

## 4. JDBC ✔
<JDBC 기본구조> 

![image](https://user-images.githubusercontent.com/92353613/193723288-3f5460fe-41af-4c51-b9cd-72c35cba7969.png)

#### JDBC란?
- 자바에서 데이터베이스에 접속할 수 있도록 하는 자바 API
- Java 언어(APP)를 통해서 Oracle(소프트웨어) 연결해서 CRUD작업
- Java App : Oracle , My-sql , MS-sql 등등 연결하고 작업(CRUD)
 -> 각각의 제품에 맞는 드라이버를 가지고 있어야 한다.
- 작업순서 :  DB연결 -> 명령생성 -> 명령실행 -> 처리 -> 자원해제
- 명령 : DDL (create , alter , drop), CRUD (insert , select , update , delete)
 - 실행 : 쿼리문을  DB서버에게 전달 
 - 처리 : 결과를 받아서 화면 출력 , 또는 다른 프로그램에 전달 등등
 - 자원해제 : 연결해제 
 <br>


### 🔔 PreparedStatement
- 미리 SQL문이 셋팅된 Statement 가 DB가 전송되어져서 컴파일되어지고, SQL문의 ?만 나중에 추가 셋팅해서 실행이 되어지는 준비된 Statement 
<br>

#### 1. 장점
- Statement 에 비해서 반복적인 SQL문을 사용할 경우에 더 빠르다. (특히, 검색문)
- DB컬럼타입과 상관없이 ?하나로 표시하면 되므로 개발자가 헷갈리지 않고 쉽다. (특히, INSERT문)
- -> 이유 : ?를 제외한 SQL문이 DB에서 미리 컴파일되어져서 대기
<br>

#### 2. 단점
- SQL문마다 PreparedStatement 객체를 각각 생성해야 하므로 재사용불가
<br>

#### Connection
```java
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
```
- String sql : 쿼리문으로써, 적은 대로 sqldeveloper에 들어간다고 생각하면 된다!
- pstmt.setInt(1, 30); : '1'번째 ?에 '30'을 넣겠다.
- rs : 값을 읽어오겠음. 
- rs = pstmt.executeQuery(); : execute(실행하다) -> query를 실행하기 위해!
- rs.getInt(1) / rs.getString(2) : data type에 맞게 int, string... 적고 ( )안 값은 몇번째 index 인지
<br>

### 🔔 PreparedStatement로 데이터 실습
![image](https://user-images.githubusercontent.com/111114507/193801736-cad497fd-f424-41d6-94f6-8dc28931a516.png)

#### (1) 전체조회하기
```java
public static void totalSearch() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		 try {
	        conn = SingletonHelper.getConnection("oracle");
	        String sql="select * from sdept";
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	         
	        if (rs.next()) {
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
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/193802083-2e1444fc-6cbf-4ceb-a19d-7c622f0c20e5.png)
<br>

#### (2) 부분조회하기
```java
public static void partSearch() {
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
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/193802251-4c1fadaf-92e7-4d9c-8ae4-e16dea068982.png)
<br>

#### (3) insert
```java
public static void insert() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		 try {
	        conn = SingletonHelper.getConnection("oracle");
	        String sql="insert into sdept(deptno,dname,loc) values(?,?,?)";
	        
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setInt(1, 5000);
	        pstmt.setString(2, "Education");
	        pstmt.setString(3, "Vietnam");
	        
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
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/193802703-dd5b2b07-b45a-46b6-b545-5df8f4cbffee.png)
<br>

#### (4) delete
```java
public static void delete() {
        Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		 try {
	        conn = SingletonHelper.getConnection("oracle");
	        String sql="delete from sdept where deptno = ?";
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setInt(1, 12345);
	        
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
```
[출력값]   
![image](https://user-images.githubusercontent.com/111114507/193803153-2beccbc1-5f03-4356-b09c-6a6876e380d2.png)
<br>

#### (5) update
```java
public static void update() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		 try {
	        conn = SingletonHelper.getConnection("oracle");
	        String sql="update sdept set deptno=?, dname=?, loc=? where deptno = ?";
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setInt(1, 40);
	        pstmt.setString(2, "MANAGER");
	        pstmt.setString(3, "NEW YORK");
	        pstmt.setInt(4, 5000);
	        
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
```
[출력값]   
![image](https://user-images.githubusercontent.com/111114507/193803542-4332496d-a689-4d47-ab80-bdd37017ec85.png)

#### 💥  
DML 작업을 하고 Commit 을 하지 않은 경우 
하나의 DB 서버를 사용할 경우
한명의 사용자가 DML 작업을 한 경우 반드시   Commit , rollback  을 통해서 작업을 완료하자
그렇지 않으면 다른 사용자는  DML 작업 불가 ....