# 2022.12.16.THU 📅
----------------
<br>

# 1.PlSql -  Procedure(프로시저) ✔
- 지금까지 만들었는 작업이 영속적으로 저장 되지 않았다
crerate table , create view
내가 위에서 만든 [커서]를 영속적으로 저장 (객체)
객체 형태로 저장 해놓으면 그 다음번에 코딩하지 않고 [불러 사용]
- 회사 팀 BY 팀 자바에서 해결하던지 sql로 해결하는 방향중 이건
sql로 해결하는 방법이다
- Oracle : subprogram(procedure)
Ms-sql : procedure

```java
자주 사용되는 쿼리를 모듈화 시켜서 객체로 저장하고
필요한 시점에 불러(호출) 해서 사용하겠다
```
<br>

### 💡 장점

기존 : APP(emp.java > select .... 구문) ->네트워크 > DB연결 > selet... > DB에
지금 : APP(emp.java > usp_emplist 구문) ->네트워크 > DB연결 > usp_emplist > DB에

1. 장점 : 네트워크 트래픽 감소(시간 단축)
2. 장점 : 보안 (네트워크 상에서 ...보안 요소)해결

## 결국 프로시저는 SQL 덩어리를 뜻한다

### procedure 는 parameter 종류 2가지

1.  input paramter : 사용시 반드시 입력 (IN : 생략하는 default)
2.  output parmater : 사용시 입력값을 받지 않아요 (OUT)

```sql
create or replace procedure app_get_emplist
(
  vempno IN emp.empno%TYPE,
  vename OUT emp.ename%TYPE,
  vsal   OUT emp.sal%TYPE
)
is
  BEGIN
    select ename, sal
      into vename , vsal
    from emp
    where empno=vempno;
  END;
```

```sql
--오라클 실행 테스트
DECLARE
  out_ename emp.ename%TYPE;
  out_sal   emp.sal%TYPE;
BEGIN
   app_get_emplist(7902,out_ename,out_sal);
   DBMS_OUTPUT.put_line('출력값 : ' || out_ename || '-' || out_sal);
END;
```

예시)

```sql
CREATE OR REPLACE PROCEDURE usp_EmpList
(
  p_sal IN number,
  p_cursor OUT SYS_REFCURSOR --APP 사용하기 위한 타입 (한건이상의 데이터 select 내부적으로 cursor 사용
)
IS
 BEGIN
     OPEN p_cursor
     FOR  SELECT empno, ename, sal FROM EMP WHERE sal > p_sal;
  END;

create table usp_emp
as
    select * from emp;

alter table usp_emp
add constraint pk_usp_emp_empno primary key(empno);

select * from SYS.USER_CONSTRAINTS where table_name='USP_EMP';
```

```sql
CREATE OR REPLACE PROCEDURE usp_insert_emp
(
 vempno IN emp.empno%TYPE,
 vename IN emp.ename%TYPE,
 vjob   IN emp.job%TYPE,
 p_outmsg OUT VARCHAR2
 )
 IS
   BEGIN
      INSERT INTO USP_EMP(empno , ename, job) VALUES(vempno ,vename , vjob);
      COMMIT;
        p_outmsg := 'success';
        EXCEPTION WHEN OTHERS THEN
        p_outmsg := SQLERRM;
        ROLLBACK;
    END;

DECLARE
  out_msg varchar2(200);
BEGIN
   usp_insert_emp(9998,'홍길동','IT',out_msg);
   DBMS_OUTPUT.put_line('출력값 : ' || out_msg);
END;
```
<br>

# 2.PlSql - 사용자 정의함수 ✔
가 직접 필요한 함수를 만들어 사용가능
- 사용방법은 다른 함수사용법과 동일
- 사용자 정의 함수 paramter 정의 , return 값

예시)

```sql
create or replace function f_max_sal
(s_deptno emp.deptno%TYPE)
return number   -- public int f_max_sal(int deptno) {  return 10}
is
  max_sal emp.sal%TYPE;
BEGIN
      select max(sal)
          into max_sal
      from emp
      where deptno = s_deptno;
      return max_sal;
END;
```

예시) 이름 뒤에 ~~님 붙히기

```sql
create or replace function f_callname
(vempno emp.empno%TYPE)
return varchar2 -- public String f_callname() {  String  v_name; return "홍길동"}
is
  v_name emp.ename%TYPE;
BEGIN
    select ename || '님'
      into v_name
    from emp
    where empno=vempno;
    return v_name;
END;
```

```sql
select empno, ename , f_callname(empno) , sal
from emp
where empno=7788;
```

예시)  parmater 사번을 입력받아서 사번에 해당되는 부서이름을 리턴하는 함수

```sql
create or replace function f_get_dname
(vempno emp.empno%TYPE)
return varchar2
is
    v_dname dept.dname%TYPE;
  BEGIN
    select dname
      into v_dname
    from dept
    where deptno = (select deptno from emp where empno=vempno);
    return v_dname;
  END;
```

```sql
select empno , ename ,deptno, f_get_dname(empno)
from emp 
where empno=7788;
```

![https://user-images.githubusercontent.com/92353613/208003321-7e921791-8c8a-4d21-8bbd-a63a7c7ab15d.png](https://user-images.githubusercontent.com/92353613/208003321-7e921791-8c8a-4d21-8bbd-a63a7c7ab15d.png)
<br>

# 3. PlSql - 트리거 (Trigger) ✔
 [재고] [출고]       ← 가장 트리거 많이 만드는 예시

- 입고 INSERT (내부적으로 [트랜잭션]이 동작)
- 재고 INSERT
- 위험부담 : lock

- PL/SQL에서의 트리거 역시 방아쇠가 당겨지면 자동으로 총알이 발사되듯이
- 어떠한 이벤트가 발생하면 그에 따라 다른 작업이 자동으로 처리되는 것을 의미한다.

```sql
트리거란 특정 테이블의 데이터에 변경이 가해졌을 때 자동으로 수행되는
[저장 프로시저]라고 할 수 있다.
앞서 배운 저장 프로시저는 필요할 때마다 사용자가 직접
 EXECUTE 명령어로 호출해야 했다.
하지만 트리거는 이와 달리 테이블의
데이터가 INSERT, UPDATE, DELETE 문에 의해 변경되어질 때
[ 자동으로 수행되므로 이 기능을 이용하며 여러 가지 작업 ] 을 할 수 있다.
이런 이유로 트리거를 사용자가 직접 실행시킬 수는 없다.
 
 --자동(insert, update ,delete)이벤트가 발생하면  자동으로  실행되는 procedure ...
```

- BEFORE : 테이블에서 DML 실행되기 전에 트리거가 동작
주로 검사할때 많이 쓰임
- AFTER : 테이블에서 DML 실행후에 트리거 동작
[입고] [재고] [출고] 와 같이 이어지는 동작에 많이 쓰임

### FOR EACH ROW

- 행 레벨 트리거가 되어 triggering 문장에 의해 영향받은 행에 대해 각각 한번씩 실행하고 사용하지 않으면 문장 레벨 트리거가 되어 DML 문장 당 한번만 실행된다.

예시) insert 트리거

```sql
create table tri_emp
as
  select empno , ename from emp where 1=2;

select * from tri_emp;
```

```sql
create or replace trigger tri_01
after insert on tri_emp
BEGIN -- 자동 동작할 내용
    DBMS_OUTPUT.PUT_LINE('신입사원 입사');
END;

insert into tri_emp(empno,ename) values(100,'홍길동');
select * from tri_emp;
```

예시) update 트리거

```sql
create or replace trigger tri_02
after update on tri_emp
BEGIN
  DBMS_OUTPUT.PUT_LINE('신입사원 수정');
END;

select * from user_jobs;

--테이블에 trigger 정보
select * from user_triggers where table_name='TRI_EMP';

insert into tri_emp values(100,'김유신');

update tri_emp
set ename='아하'
where empno=100;
```

예시 delete 트리거

```sql
--delete 트리거 : tri_emp
--사원테이블 삭제 (화면 출력)
create or replace trigger tri_03
after delete on tri_emp
BEGIN
  DBMS_OUTPUT.PUT_LINE('신입사원 삭제');
END;

insert into tri_emp values(200,'홍길동');
update tri_emp set ename='변경' where empno= 200;
delete from tri_emp where empno=200;
```

### 트리거 예제 1) 트리거를 이용한 로그 추적 작업 만들기

- 테이블에 INSERT, UPDATE, DELETE 를 할 때 user, 구분(I,U,D), sysdate 를 기록하는
- 테이블(emp_audit)에 내용을 저장한다.
- FOR EACH ROW 이 옵션을 사용하면
- 행 레벨 트리거가 되어 triggering 문장
- 에 의해 영향받은 행에 대해 각각 한번씩 실행하고 사용하지
- 않으면 문장 레벨 트리거가 되어 DML 문장 당 한번만 실행된다.

초기작업)

```sql
drop sequence emp_audit_tr;
drop table emp_audit;

create sequence emp_audit_tr
 increment by 1
 start with 1
 maxvalue 999999
 minvalue 1
 nocycle
 nocache;

create table emp_audit(
 e_id number(6) constraint emp_audit_pk primary key,
 e_name varchar2(30),
 e_gubun varchar2(10),
 e_date date);

drop table emp2;
create table emp2
as
    select * from emp;
```

트리거 설정)

```sql
create or replace trigger emp_audit_tr
 after insert or update or delete on emp2
 --for each row
begin
 if inserting then
      insert into emp_audit
      values(emp_audit_tr.nextval, user, 'inserting', sysdate);
 elsif updating then
      insert into emp_audit
      values(emp_audit_tr.nextval, user, 'updating', sysdate);
 elsif deleting then
      insert into emp_audit
      values(emp_audit_tr.nextval, user, 'deleting', sysdate);
 end if;
end;
```

실행)

```sql
-- for each row 선언 안했을 때 (명령어 한 번에 대하여 한 건으로 기록된다.)
select * from emp2;

update emp2 
set deptno = 20
where deptno = 10;

select * from emp_audit;

delete from emp2 where deptno = 20;

select * from emp_audit;
```

![https://user-images.githubusercontent.com/92353613/208007798-f52ef3a4-d8ff-40cc-962c-365eb35c6517.png](https://user-images.githubusercontent.com/92353613/208007798-f52ef3a4-d8ff-40cc-962c-365eb35c6517.png)

---

for each row 선언 했을 때(명령어 한 번에 변경된 행만큼 기록된다.)

```sql
create or replace trigger emp_audit_tr
 after insert or update or delete on emp2
 for each row
begin
 if inserting then
      insert into emp_audit
      values(emp_audit_tr.nextval, user, 'inserting', sysdate);
 elsif updating then
      insert into emp_audit
      values(emp_audit_tr.nextval, user, 'updating', sysdate);
 elsif deleting then
      insert into emp_audit
      values(emp_audit_tr.nextval, user, 'deleting', sysdate);
 end if;
end;

select * from emp2;
update emp2 set deptno = 20 where deptno = 10;

select * from emp_audit;
```

![https://user-images.githubusercontent.com/92353613/208008016-700221c0-38ca-4cb0-ba4d-d323151ac35e.png](https://user-images.githubusercontent.com/92353613/208008016-700221c0-38ca-4cb0-ba4d-d323151ac35e.png)

---

### 트리거 예제 2)
INSERT, UPDATE, DELETE로 변경되는 내용에 대하여 전/후 데이터를 기록한다.

초기설정)

```sql
create table emp_audit (
 id number(6) constraint emp_audit_pk primary key,
 name varchar2(30),
 gubun varchar2(10),
 wdate date,
 etc1 varchar2(20),  -- old
 etc2 varchar2(20)   -- new
);
```

트리거 설정)

```sql
create or replace trigger emp_audit_tr
 after insert or update or delete on emp2
 for each row
begin
 if inserting then
      insert into emp_audit
      values(emp_audit_tr.nextval, user, 'inserting', sysdate, :old.deptno, :new.deptno);
 elsif updating then
    insert into emp_audit
    values(emp_audit_tr.nextval, user, 'updating', sysdate, :old.deptno, :new.deptno);
 elsif deleting then
    insert into emp_audit
    values(emp_audit_tr.nextval, user, 'deleting', sysdate, :old.deptno, :new.deptno);
 end if;
end;
```

출력)

```sql
--insert
insert into emp2(empno,ename,deptno) values (9999,'홍길동',100);
select * from emp_audit;

--update
update emp2 set deptno=200
where empno=9999;
select * from emp_audit;

--delete
delete from emp2 where empno=9999;
select * from emp_audit;
```

---

### 트리거 예제 3) 시간에 따른 트리거 작동

초기설정)

```sql
create table tri_order
(
  no number,
  ord_code varchar2(10),
  ord_date date
);
```

실행)

```sql
--before 트리거의 동작시점이 실제 tri_order 테이블 insert 되기 전에
--트리거 먼저 동작 그 이후 insert 작업
create or replace trigger trigger_order
before insert on tri_order
BEGIN
  IF(to_char(sysdate,'HH24:MM') not between '11:00' and '16:00') THEN
     RAISE_APPLICATION_ERROR(-20002, '허용시간 오류 쉬세요');
  END IF;
END;

insert into tri_order values(2,'notebook',sysdate);
select * from tri_order;
commit;
rollback;
--트리거 삭제
drop trigger trigger_order;
```

---

### 트리거 예제 4) 코드 못넣게 하기

- POINT
- PL_SQL 두개의 가상데이터(테이블) 제공
- :OLD > 트리거가 처리한 레코드의 원래 값을 저장 (ms-sql (deleted)
- :NEW > 새값을 포함 (ms-sql (inserted)

초기설정)

```sql
create or replace trigger tri_order2
before insert on tri_order
for each row
BEGIN
  IF(:NEW.ord_code) not in('desktop') THEN
     RAISE_APPLICATION_ERROR(-20002, '제품코드 오류');
  END IF;
END;
```

실행)

```sql
select * from tri_order;

--오류 (desktop)
insert into tri_order values(200,'notebook',sysdate);

insert into tri_order values(200,'desktop',sysdate);

select * from tri_order;
commit;
```

---

### 트리거 예제 5) 입고, 재고

초기설정)

```sql
--입고 , 재고

create table t_01 --입고
(
  no number,
  pname varchar2(20)
);

create table t_02 --재고
(
  no number,
  pname varchar2(20)
);

--입고 데이터 들어오면 같은 데이터를 재고 입력
create or replace trigger insert_t_01
after insert on t_01
for each row
BEGIN
  insert into t_02(no, pname)
  values(:NEW.no ,:NEW.pname);
END;
```

실행)

```sql
--입고
insert into t_01 values(1,'notebook');

select * from t_01;
select * from t_02;

-- 입고 제품이 변경 (재고 변경)
create or replace trigger update_t_01
after update on t_01
for each row
BEGIN
  update t_02
  set pname = :NEW.pname
  where no = :OLD.no;
END;

update t_01
set pname = 'notebook2'
where no = 1;

select * from t_01;

select * from t_02;
```

실행)

```sql
--delete 트리거 만들어 보세요 
--입고 데이터 delete from t_01 where no =1 삭제 되면 재고 삭제
create or replace trigger delete_tri_01
after delete on t_01
for each row
BEGIN
  delete from t_02
  where no=:OLD.no;
END;

delete from t_01 where no=1;

select* from t_01;
select* from t_02;
```
<br>

# 4.MVC & MyBatis 기본 설정 및 구조 이해하기 ✔
![image](https://user-images.githubusercontent.com/111114507/208111949-e20b6be2-07ed-43d8-ae27-8d53a64b28a8.png)
by 노현중 
## 1) xml
### 💡 [web.xml]
```xml
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/spring/root-context.xml</param-value>
	</context-param>
	
	<!-- Creates the Spring Container shared by all Servlets and Filters -->
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>

	<!-- Processes application requests -->
	<servlet>
		<servlet-name>appServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
		
	<servlet-mapping>
		<servlet-name>appServlet</servlet-name>
		<url-pattern>*.htm</url-pattern>
	</servlet-mapping>
	
	<filter>
	  	<filter-name>EncodingFilter</filter-name>
	  	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	  	<init-param>
	  		<param-name>encoding</param-name>
	  		<param-value>UTF-8</param-value>
	  	</init-param>
  	</filter>
  	<filter-mapping>
  		<filter-name>EncodingFilter</filter-name>
  		<url-pattern>/*</url-pattern>
  	</filter-mapping>
```
- 가장 먼저 실행하며 각 컨테이너박스를 생성해 사용할 준비를 한다!
<br>

### 💡 [pom.xml]
- MAVEN 모델 사용 시 직접 파일 추가하지 않고 의존성에 기반해 자동으로 추가되게 ... 
<br>

### 💡 [log4j.xml]
- 레거시 프로젝트 생성 시 자동으로 생성됨 (src/main/resources)
- 기본 세팅이니 교수님과 함께 한 코드로 덮어쓰기
<br>

### 💡 [log4jdbc.log4j2.properties]
- 레거시 프로젝트 생성 시 자동으로 생성 X -> 직접 만들어주기
- src/main/resources
```xml
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator
```
- 특별한 기능을 하는 것이 아니고 그냥 DB에서 가져온 값을 예쁘게 콘솔창에 띄워줌
<br>

### 💡 [servlet-context.xml]
```xml
<!-- 모든 컨트롤러가 공통 사용 DAO 빈 객체  참조-->
<context:annotation-config />
<context:component-scan base-package="ncontroller"  />
<context:component-scan base-package="dao"  />
<context:component-scan base-package="service"  />

<!-- 파일 업로드 보조(반드시)  -->
<bean  id="multipartResolver"    class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<property name="maxUploadSize"    value="10485760"></property>
		<property name="defaultEncoding"  value="UTF-8"></property>
</bean>	

```
- base-package = "패키지명" : 이 패키지 안에 있는 파일들에 접근하겠다 -> 주입!
- 공통된 기능들을 모아두는 공간이라고 생각합시당 
<br>

### 💡 [root-context.xml]
```xml
 <bean id="driverManagerDataSource"  class="org.springframework.jdbc.datasource.DriverManagerDataSource">
 	<property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy" />
 	<property name="url" value="jdbc:log4jdbc:oracle:thin:@localhost:1521:XE" />
 	<property name="username"        value="springuser"></property>
 	<property name="password"        value="1004"></property>
 </bean> 
  
 <!-- JDBC Template -->
 <bean id=""  class="org.springframework.jdbc.core.JdbcTemplate">
 	<property name="dataSource"  ref="driverManagerDataSource" />
 </bean> 

  <!-- 공통 UI  -->
 <!-- 나중에 추가 형태 -->
  <bean id="internalResourceViewResolver"  class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 		<property name="prefix">
	 			<value>/WEB-INF/views/</value>
	 		</property>
	 		<property name="suffix">
	 			<value>.jsp</value>
	 		</property>
  </bean>

```
- 한 세트로서 DB 연결을 해줌 
- 두 bean의 id 가 무조건 같아야함!!!
```xml
 <!-- MyBatis 설정 START  -->
 <bean id="sqlSessionFactoryBean"  class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="driverManagerDataSource"></property>
    <property name="mapperLocations" value="classpath*:mapper/*xml" />
</bean>

 <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
  	<constructor-arg index="0" ref="sqlSessionFactoryBean"/>
 </bean> 
 <!-- MyBatis 설정  END  -->
```
- MyBatis를 사용하기 위해서
- 마찬가지로 두 bean의 id 가 무조건 같아야함!!!<br>

## 2) 실행 흐름
#### index.htm 실행 시, IndexController.java 에서 .htm을 찾음
### 💡 [IndexController.java]
```java
@Controller
public class IndexController {
	
	@RequestMapping("/index.htm")
	public String index() {
		return "index";
		//return "/WEB-INF/views/index.jsp";
	}
}
```
- return한 index가 ... 
```xml
 <!-- 공통 UI  -->
 <!-- 나중에 추가 형태 -->
  <bean id="internalResourceViewResolver"  class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 		<property name="prefix">
	 			<value>/WEB-INF/views/</value>
	 		</property>
	 		<property name="suffix">
	 			<value>.jsp</value>
	 		</property>
  </bean>
```
- root-context.xml의 view로 넘어와 index +.jsp = index.jsp가 돼서 index.jsp로 넘어가서 뷰단 실행!
- 이렇게 한번 꼬아서 가는 이유는 보안상의 이유와 화면 크기에 맞춰서 조절이 되게 하기 위해서 
<br>

### 💡 [header.jsp]
```jsp
<li>
    <a href="${pageContext.request.contextPath}/customer/notice.htm"><img src="${pageContext.request.contextPath}/images/menuCustomer.png" alt="고객센터" /></a>
</li>
```
- notice.htm을 찾아 CustomerController로
<br>

### 💡 [CustomerController.java]
```java
@Controller
@RequestMapping("/customer/")
public class CustomerController {
	
	private CustomerService customerservice;
	
	@Autowired
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}

	@RequestMapping("notice.htm")  
	public String notices(String pg , String f , String q , Model model) {
		
		List<Notice> list = customerservice.notices(pg, f, q);		
		model.addAttribute("list", list);  
		return "customer/notice";
	}
```
- private CustomerService customerservice; : service에서 DB와 DAO작업을 해주고 값을 넘겨줄 것이기 때문에, 이를 받아오기 위해서는 변수로 만들어줘야 함 
- service의 notices함수를 실행해 나온 값들을 list에 담고, 이를 다시 list에 Attribute 해줌 
<br>

### 💡 [CustomerService.java]
```java
@Service
public class CustomerService {

	//Mybatis 작업
	private SqlSession sqlsession;

	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	//글목록보기 서비스 (DB)
	public List<Notice> notices(String pg , String f , String q) {
		
		//default 값 설정
		int page = 1;
		String field="TITLE";
		String query = "%%";
		
		if(pg != null   && ! pg.equals("")) {
			page  = Integer.parseInt(pg);
		}
		
		if(f != null   && ! f.equals("")) {
			field = f;
		}

		if(q != null   && ! q.equals("")) {
			query = q;
		}
		
		//DAO 작업
		List<Notice> list = null;
		try {
				//동기화/////////////////////////////////////////////////////
			 	NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
				///////////////////////////////////////////////////////////
			 	list = noticedao.getNotices(page, field, query);
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		return list;
	}

```
- SqlSession : MyBatis 작업
- NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class); : 공식으로 생각하면 됨, NoticeDao.xml을 찾아 감
<br>

### 💡 [NoticeDao.xml]
```xml
	<select id="getNotices" resultType="vo.Notice">
		SELECT * FROM
		    ( SELECT ROWNUM NUM, N.* 
              FROM (
                     SELECT * 
                     FROM NOTICES 
                     WHERE ${param2} LIKE '%${param3}%' ORDER BY REGDATE DESC
                    ) N
             ) WHERE NUM BETWEEN 1 + (${param1}-1)*5 AND 5 + (${param1}-1)*5
	</select>
```
- param1 parm2와 같은 표현 사용하지 않기
- parameter 값 그대로 적어주기 #{page} -> 이런 식으로 
- DAO의 함수에게 쿼리문을 실행해서 전달해주는 역할
<br>

### 💡 [NoticeDao.java] - Interface
```java
//CRUD
public interface NoticeDao {
	//게시물 개수
	int getCount(String field, String query) throws ClassNotFoundException, SQLException;
	
	//전체 게시물
	List<Notice> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException;
	
	//게시물 삭제
	int delete(String seq) throws ClassNotFoundException, SQLException;
	
	//게시물 수정
	int update(Notice notice) throws ClassNotFoundException, SQLException;
	
	//게시물 상세
	Notice getNotice(String seq) throws ClassNotFoundException, SQLException;
	
	//게시물 입력
	int insert(Notice n) throws ClassNotFoundException, SQLException;
}
```
- xml의 select문 id & interface의 함수 이름이 같으면 자동으로 찾아서 실행 