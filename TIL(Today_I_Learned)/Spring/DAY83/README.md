# 2022.12.15.THU 📅
----------------
<br>

# 1. Connection Pool ✔
![image](https://user-images.githubusercontent.com/111114507/207746306-1ad0d049-28e9-477a-a7b4-6a5db26d9cfd.png)
- 일정량의 Connection 객체(DB 연결 객체)를 미리 만들어서 pool에 저장해놓고, 요청이 왔을 때 객체를 사용할 수 있도록 빌려줬다가, 일이 끝나면 다시 돌려받아 pool에 저장하는 기법
```
일반적인 데이터 연동과정은 웹 어플리케이션이 필요할 때마다 데이터베이스에 연결하여 작업하는 방식입니다.
하지만 이런 식으로 필요할 때마다 연동해서 작업할 경우 데이터베이스 연결에 시간이 많이 걸리는 문제가 발생합니다.
예를들어 거래소의 경우, 동시에 몇천명이 동시에 거래 및 조회 기능을 사용하는데 매번 데이터베이스와 커넥션을 맺고 푸는 작업을 한다면 굉장히 비효율적일 것입니다.
이 문제를 해결하기 위해 현재는 웹 어플리케이션이 실행됨과 동시에 연동할 데이터베이스와의 연결을 미리 설정해 둡니다.
그리고 필요할 때마다 미리 연결해 놓은 상태를 이용해 빠르게 데이터베이스와 연동하여 작업을 합니다.
이렇게 미리 데이터베이스와 연결시킨 상태를 유지하는 기술을 커넥션 풀 (Connection Pool, CP)이라고 합니다.
```
<br>

### 💡 장점
- 보통 DB 접근의 경우 객체를 생성 후 사용하고 하나씩 다시 삭제를 해줘야 하는데, 커넥션 풀을 사용할 경우 객체를 미리 만들어놓고 사용하기 때문에 불필요한 생성과 삭제에 드는 메모리 차지를 줄일 수 있다.
- -> 불필요한 작업의 반복 (커넥션 생성, 삭제 반복)이 사라지기 때문에 성능과 속도 향상을 기대할 수 있다 <br>

### 💡 주의할 점
#### 커넥션은 적정량만 저장해 놓고 사용하기
- 커넥션을 많이 생성 : 커넥션 또한 객체이기 때문에 많은 메모리를 차지할 수 밖에 없다. 따라서 쓸데없이 많은 커넥션은 프로그램의 성능을 저하시키는 원인이 될 수 있다
- 커넥션을 적게 생성 : 한정된 커넥션 내에서 사용해야 하기 때문에 너무 많은 DB가 접근시 사용중인 커넥션이 반납될 때 까지 기다려야 한다. <br>

### 💡Pool Log 설정하기
#### [1. pom.xml]
```
<!-- SQL LOG  -->
    <dependency>
        <groupId>org.bgee.log4jdbc-log4j2</groupId>
        <artifactId>log4jdbc-log4j2-jdbc4</artifactId>
        <version>1.16</version>
    </dependency>
추가하기
```
![image](https://user-images.githubusercontent.com/111114507/207746853-b0513016-91cf-4f49-a5ed-157f1046437a.png) <br>

#### [2. DB연결 설정에서 DriverSpy 적용하기 (root-content.xml)]
```
<!-- <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" /> -->
 	 <property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy" />
 	 <property name="url" value="jdbc:log4jdbc:oracle:thin:@localhost:1521:XE" />
```
![image](https://user-images.githubusercontent.com/111114507/207747122-a138465e-41bc-4d8e-87f3-9032ec0c29ab.png) <br>

#### [3.설정파일 (log4j.xml과 같은 경로에)]
```
log4jdbc.log4j2.properties 파일 생성
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator

xml 추가 (log4j.xml)
<!-- SQL Logger -->

	<logger name="jdbc.sqltiming" additivity="false">
		<level value="warn" />
		<appender-ref ref="console"/> 
	</logger>


	<logger name="jdbc.sqlonly" additivity="false"> 
		<level value="info"/> 
		<appender-ref ref="console"/> 
	</logger>


	<logger name="jdbc.audit" additivity="false"> 
		<level value="warn"/>  
		<appender-ref ref="console"/> 
	</logger> 

 	<logger name="jdbc.resultset" additivity="false">
		<level value="warn" />
		<appender-ref ref="console"/> 
	</logger>


	<logger name="jdbc.resultsettable" additivity="false"> 
		<level value="info"/>  
		<appender-ref ref="console"/> 
	</logger> 
```
![image](https://user-images.githubusercontent.com/111114507/207746761-bf6beb99-0fcb-4922-bfe2-80a0f6554363.png) <br>

<br>

# 2. Hikari Pool ✔
- 가벼운 용량과 빠른 속도를 가지는 JDBC의 커넥션 풀 프레임워크
### 💡 설정하기
#### [1. POOL]
```
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>3.4.5</version>
</dependency>

<!-- SQL LOG  -->
<dependency>
    <groupId>org.bgee.log4jdbc-log4j2</groupId>
    <artifactId>log4jdbc-log4j2-jdbc4</artifactId>
    <version>1.16</version>
</dependency> 
``` 
<br>

#### [2. DB연결 설정에서 DriverSpy 적용하기 (root-content.xml)]
```
<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
 	<property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"></property>
 	<property name="jdbcUrl"         value="jdbc:log4jdbc:oracle:thin:@localhost:1521:XE"></property>
 	<property name="username"        value="springuser"></property>
 	<property name="password"        value="1004"></property>
 </bean> 
 <bean id="driverManagerDataSource" class="com.zaxxer.hikari.HikariDataSource" destroy-method="close">
		<constructor-arg ref="hikariConfig"></constructor-arg>
 </bean>
<bean id="sqlSessionFactoryBean"  class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="driverManagerDataSource"></property>
    <property name="mapperLocations" value="classpath*:mapper/*xml" />
</bean>
```

#### [3.설정파일 (log4j.xml과 같은 경로에)]
```
log4j.xml 같은 경로에
log4jdbc.log4j2.properties 파일 생성

log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator


xml 추가
<!-- SQL Logger -->

	<logger name="jdbc.sqltiming" additivity="false">
		<level value="warn" />
		<appender-ref ref="console"/> 
	</logger>

	<logger name="jdbc.sqlonly" additivity="false"> 
		<level value="info"/> 
		<appender-ref ref="console"/> 
	</logger>

	<logger name="jdbc.audit" additivity="false"> 
		<level value="warn"/>  
		<appender-ref ref="console"/> 
	</logger> 

	<logger name="jdbc.resultset" additivity="false">
		<level value="warn" />
		<appender-ref ref="console"/> 
	</logger>

	<logger name="jdbc.resultsettable" additivity="false"> 
		<level value="info"/>  
		<appender-ref ref="console"/> 
	</logger> 
```
<br>

# 3. Transaction ✔