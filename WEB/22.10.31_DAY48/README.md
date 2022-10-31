# 2022.10.31. THU 📅
----------------
<br>

## 1.  커넥션 풀 ✔
### 🔔 JNDI(Java Naming and Directory Interface)
- 데이터베이스와 연결된 커넥션을 미리 만들어서 풀(pool) 속에 저장해 두고 있다가 필요할 때 커넥션을 풀에서 쓰고 다시 풀에 반환하는 기법을 말한다.
- 웹 프로그램에서는 데이터베이스의 환경설정과 연결 관리 등을 따로 XML파일이나 속성 파일을 사용해서 관리하고, 이렇게 설정된 정보를 이름을 사용하여 획득하는 방법을 사용한다.
- JNDI의 정의를 보면 디렉터리 서비스에서 제공하는 데이터 및 객체를 발견하고 참고(lookup)하기 위한 자바 API라고 되어있다. 쉽게 말하면 외부에 있는 객체를 가져오기 위한 기술이다. Tomcat와 같은 WAS를 보면 특정 폴더에 필요한 데이터 소스(라이브러리)가 있는데 그것을 우리가 사용하기 위해 JNDI를 이용해서 가져오는 것이다.
![imgae](https://t1.daumcdn.net/cfile/tistory/2629B3375492CD3E10)
<br>

### 🔔 DBCP(Database Connection Pool, 커넥션 풀)
- 데이터베이스와 연결된 커넥션을 미리 만들어서 저장해두고 있다가 필요할 때 저장된 공간(pool)에서 가져다 쓰고 반환하는 기법을 말한다. 커넥션 풀을 이용하면 커넥션을 미리 만들어두고 사용하기 때문에 매번 사용자가 요청할 경우 드라이버를 로드하고, 커넥션 객체를 생성해 연결하고 종료하는 비효율적인 작업을 하지 않아도 된다.  즉 데이터베이스의 부하를 줄일 수 있고 자원을 효율적으로 관리할 수 있다.
<br>

![image](https://t1.daumcdn.net/cfile/tistory/224CD845582D373205)
1. 사용자가 요청을 한다.
2. 요청은 Control을 거쳐 Molel로 전달된다.
3. Molel로 넘어간 요청은 JNDI에 등록된 데이터베이스 객체(Type:DataSource)를 검색한다.
4. JNDI를 통해 찾은 객체로부터 커넥션을 획득한다.
5. 데이터베이스 작업이 끝난 후 획득한 커넥션을 반납한다.
<br>

## 2.  Model2 MVC 패턴 작업 ✔
### 🔔 회원테이블 생성
```sql
create table mvcregister(
    id number constraint pk_mvcregister_id primary key,
    pwd varchar2(20) not null,
    email varchar2(50) not null
);

desc mvcregister;
```
- 웹 프로젝트 생성
- 연결 테이스 (DBCP) >> ojdbc6.jar, context.xml, 연결.jsp >> Test End
<br>

### 🔔 Model2 MVC 패턴 작업
#### [ Model ]
-  DTO 생성 > Db 테이블과 같은 구조 클래스 생성 > getter, setter 구현
-  DB 연결(POOL) > DAO > CRUD > 전체조회, 조건조회, 삽입, 삭제, 수정 + 알파(LIKE)
- Servic단..추후

#### [ View ]
-  html or jsp > 구분점은? : UI 데이터 출력 유무 > Boot > include > 모든페이지 > JSP
-  EL & JSTL > server에서 데이터 담아서 (request) > forward > 그 equest 객체 ...
-  ex) 'el{requestScope.list}' or 'el{sessionScope.id}' >> 출력(JSTL)
-  JSP 보안적 처리 > WEB-INF > view > member or admin or board > sp 관리
-  비동기처리(ajax) > xmlHttpRequest

#### [ Controller ]
- 요청마다 Controller 생성하기 (servlet 생성)
-   1) write > /write > ServletWrite
-   2) list > /list > ServletList
- 요청마다 Controller 생성하지 말고 1개 (servlet 생성)
-   1) FrontController >> servet 1개 (모든요청판단) > 판단근거<br>
     ❕ 판단의 근거
      - command 방식 : 글쓰기(servlet.do?cmd=write), 글목록보기(servlet.do?cmd=list)
      				   if{cmd.equals("write")(글쓰기 작업 수행)}
      - url 방식     : 글쓰기(wrtie.do?id=hihi&pwd=1004), 글목록보기(list.do) >> url 주소로 요청을 판단
      주의) url패턴 >> * do				   