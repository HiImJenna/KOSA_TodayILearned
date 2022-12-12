# 2022.12.12.MON 📅
----------------
<br>

## 1. Container ✔
- 자바 객체(Bean)를 관리해주는 역할
- Bean의 생성부터 소멸까지를 개발자 대신 관리해주는 곳
- BeanFactory와 ApplicationContextfh 두 종류
![image](https://user-images.githubusercontent.com/111114507/206942031-23ffb802-9537-490a-bcff-31774e513d3c.png)<br>
![image](https://user-images.githubusercontent.com/111114507/206942051-862e991a-3d88-47c9-ae06-f0742a91d420.png)<br>
![image](https://user-images.githubusercontent.com/111114507/206942069-945db992-64e9-4d6a-a79e-667fde4cc7b5.png)<br>
```
ContextLoaderListener 와 DispatcherServlet 은 각각 webapplicationcontext 를 생성하는데
ContextLoaderListener 가 생성한 컨텍스트가 root 컨텍스트가 되고 DispatcherServlet 이 생성한 인스턴스는 root 컨텍스트를 부모로 하는 자식 컨텍스트가 된다.
```
```
자식 컨텍스트들은 root 컨텍스트의 [설정 빈]을 사용 할 수 있다.
그러기에 ContextLoaderListener 을 이용 공통빈 설정 가능. (DB작업 , 공통사항)
```
<br>

### 🔔 상위 컨테이너
#### [web.xml]
```xml
  <listener>
  	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  <context-param>
  	<param-name>contextConfigLoacation</param-name>
  	<param-value>/WEB-INF/applicationContext.xml</param-value>
  </context-param>
```
- listenr : root Container 생성
- ContextLoaderListener 생성하고 /WEB-INF/applicationContext.xmlfh 파일 지정 해주면 그 파일이 root container를 담는 곳이 됨
<br>

### 🔔 상위 컨테이너```xml
  <servlet>
  	 <servlet-name>dispatcher</servlet-name>
  	 <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
 	 <!-- <init-param>
    	<param-name>contextConfigLocation</param-name>
    	<param-value>
     		classpath:/WEB-INF/servlet.xml
     		classpath:/WEB-INF/base2.xml
    	</param-value>
   	 </init-param> -->
  </servlet>
  <servlet-mapping>
  	<servlet-name>dispatcher</servlet-name>
  	<url-pattern>*.do</url-pattern>
  </servlet-mapping>
```
- 하위 Container 생성
<br>

### 🔔 하위컨테이너에서 한글필터 생성
```xml
  	<filter-name>Encoding Filter</filter-name>
  	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
  	<init-param>
  		<param-name>encoding</param-name>
  		<param-value>UTF-8</param-value>
  	</init-param>
  </filter>
```
- 모든 요청을 거쳐가게 해서 ... 한글 적용!
<br>

### 🔔 상위 컨테이너 applicationContext.xml
```xml
<!-- 공통 DB작업  -->
  <bean id = "DriverManagerDataSource" class = "org.springframework.jdbc.datasource.DriverManagerDataSource">
  	<property name = "driverClassName" value = "oracle.jdbc.driver.OracleDriver"></property>
	<property name = "url" value = "jdbc:oracle:thin:@localhost:1521:xe"></property>
	<property name = "username" value = "springuser"></property>
	<property name = "password" value = "1004"></property>
  </bean>
```
```xml
<!-- JDBC Template -->
  <bean id ="" class = "org.springframework.jdbc.core.JdbcTemplate">
  	<property name = "dataSource" ref = "driverManagerDataSource"/>
  </bean>
```
```xml

```
