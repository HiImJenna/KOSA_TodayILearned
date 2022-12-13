# 2022.12.13.TUE 📅
----------------
<br>

# 1. MAVEN ✔
- https://mvnrepository.com/
- 쿼리 기반 웹 애플리케이션을 개발할 때 가장 많이 사용되는 SQL 매퍼(Mapper) 프레임워크.
#### ✨ 쉬운 이해는 아래에서 코드 보면서!! 
<br>

### [기존]
![image](https://user-images.githubusercontent.com/111114507/207293799-0ca96d50-3bcb-493e-9ae7-7fb7faba7acc.png)
- 내가 하나하나 추가해줬어야함
- 의존성으로 인해서 관련된 모든것들을 추가해줘야 하기에 굉장히 귀찮고 불편함
<br>

### [pom.xml]
```xml
	<properties>
		<java-version>1.8</java-version>
		<org.springframework-version>5.3.6</org.springframework-version>
		<org.aspectj-version>1.6.10</org.aspectj-version>
		<org.slf4j-version>1.6.6</org.slf4j-version>
	</properties>
	<repositories>
		<repository>
			<id>oracle</id>
			<name>ORACLE JDBC Repository</name>
			<url>http://maven.jahia.org/maven2</url>
		</repository>
	</repositories>
	<dependencies>
		<!-- Spring -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${org.springframework-version}</version>
			<exclusions>
				<!-- Exclude Commons Logging in favor of SLF4j -->
				<exclusion>
					<groupId>commons-logging</groupId>
					<artifactId>commons-logging</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${org.springframework-version}</version>
		</dependency>

```
![image](https://user-images.githubusercontent.com/111114507/207293162-d0727b04-7938-440d-b5e0-2f2e19d7de60.png)
- Maven을 사용하면 알아서 의존성을 가진 친구들까지 추가해주기 때문에 (사진처럼) 편리함!
<br>

# 2. MyBatis ✔
- 학습사이트 : https://mybatis.org/mybatis-3/ko/index.html
- 마이바티스는 개발자가 지정한 SQL, 저장프로시저 그리고 몇가지 고급 매핑을 지원하는 퍼시스턴스 프레임워크
- 마이바티스는 JDBC로 처리하는 상당부분의 코드와 파라미터 설정및 결과 매핑을 대신해준다.
- 마이바티스는 데이터베이스 레코드에 원시타입과 Map 인터페이스 그리고 자바 POJO 를 설정해서 매핑하기 위해 XML과 애노테이션을 사용할 수 있다.
#### 내일 진도 나가요~!
<br>

# 3. IBatis ✔
## 1) 방법 1 : 한 xml 안에서 다 처리하기
### [SqlMapConfig.xml]
- 제일먼저 실행...
```xml
<sqlMapConfig>
	<transactionManager type="JDBC" commitRequired="true">
		<dataSource type="SIMPLE">
			<property name="JDBC.Driver" value="oracle.jdbc.driver.OracleDriver"/>
			<property name="JDBC.ConnectionURL" value="jdbc:oracle:thin:@localhost:1521:XE"/>
			<property name="JDBC.Username" value="bituser"/>
			<property name="JDBC.Password" value="1004"/>
		</dataSource>	
	</transactionManager>
	<sqlMap resource="Config/member.xml" />
</sqlMapConfig>
```
- DB와의 연결
<br>

## 2) 방법 2 : 두 xml으로 나누기
### [SqlMapConfig.xml]
```xml
<sqlMapConfig>
	<properties resource="kosta/ibatis/sqlmap/SqlMapConnection.properties" />
	
	<transactionManager type="JDBC">
		<dataSource type="SIMPLE">
			<property name="JDBC.Driver" value="${driver}"/>		
			<property name="JDBC.ConnectionURL" value="${url}"/>
			<property name="JDBC.Username" value="${username}" />
			<property name="JDBC.Password" value="${password}"/>
		</dataSource>
	</transactionManager>
	<sqlMap resource="kosta/ibatis/sqlmap/User.xml" />
	
</sqlMapConfig>
```
- value값을 parameter로 받아오기
<br>

### [SqlMapConnection.properties]
```xml
driver=oracle.jdbc.driver.OracleDriver
url=jdbc:oracle:thin:@localhost:1521:XE
username=springuser
password=1004
```
- parameter 값 제공함
#### 굳이 이렇게 하는 이유는❓
보안상의 이유로 사용자에게 숨기고 싶은 정보이기 때문! 깃에 올릴 때도 git ignore로 처리 가능<br>

### [쿼리문담는.xml]
```xml
<!-- ORM 객체 매핑  Framework
     input  parameter > java bean  void insert(Board board){}
     output parameter > java bean  Board select(){}
       기존의 SQL 구문은 Map 파일 구현

  select 실행 ->    Ibatis.dto.Emp  -> Emp 객체 생성 -> setter (자동 주입) -> Emp 객체 주소 리턴   
 -->
 <sqlMap>
  	<select id="selectEmp" parameterClass="java.lang.String" resultClass="Ibatis.dto.Emp">
 		select empno,ename,job,sal 
 		from emp
 		where ename=#ename# 
 	</select>
 	<insert id="insertEmp" parameterClass="Ibatis.dto.Emp">
 		insert into emp(empno,ename,job,sal)
 		values(#empno#,#ename#,#job#,#sal#)  
 	</insert>
 </sqlMap>
```
- id : DAO에서 불러올 메소드에서 지정해준 값과 같아야함
- parameterClass="java.lang.String" : 문자열화, 인트화 (java.lang.int)
- resultClass="Ibatis.dto.Emp" : 불러올 DTO의 경로
- '#' : Ibatis를 사용하겠음, '' 붙여주겠음
```xml
<!-- 가명칭을 부여해서 객체의 별칭을 부여  -->
<typeAlias alias="user" type="kosta.ibatis.dto.UserDto"/>
```
- 만약 DTO 이름이 너무 길 때는 위 코드처럼 겹치는 부분을 빼서 alias= " "으로 저장해 아래 친구들의 resultClass를 간단하게 적어줄 수 있음 (개발자는 귀찮다)
<br>

### [DAO.java]
```java
public void insertEmp(Emp e) throws SQLException {
    //values(?,?,?,?)
    //pstmt.setInt(e.getEmpno())
    //pstmt.setString(e.getEname()) ...
        sqlMap.insert("insertEmp",e);
}
public Emp SelectEmp(String ename) throws SQLException {
    
    return (Emp)sqlMap.queryForObject("selectEmp",ename);
    
    //Emp e = new Emp();
    //e.setEmpno(rs.getInt(1));
    //.....
}
```
- 원래는 DAO에서 query문을 적어주고 했다면, 이제는 query문을 '쿼리문을담는.xml'에 따로 빼서 관리한다고 생각하면 될 듯
- 대신 id 값과 column 명을 일치시켜주는 것이 중요함