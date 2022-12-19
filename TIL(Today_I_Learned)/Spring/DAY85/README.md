# 2022.12.19.MON 📅
----------------
<br> 

# 1. Security 개념 ✔
- http://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte:fdl:server_security:architecture
#### [웹어플리케이션 인증절차]
![image](https://user-images.githubusercontent.com/111114507/208329504-7e769fe2-3075-4115-b9b0-9505e70e14f2.png)
<br>

#### 주요테이블 - 사용자 인증과 관련된 테이블은 사용자테이블과 사용자권한테이블이며 사용자권한관련 테이블은 역할, 자원, 역할계층 등의 테이블이 있다.
![image](https://user-images.githubusercontent.com/111114507/208329905-a575a8a9-e8ba-4729-88ba-e29a6c97bd13.png)
- Enabled : 필수!!
- 사용자와 역할은 다대다 관계
- Security 적용 시 사용자, 역할, 사용자-권한 매핑 테이블 설계는 필수
<BR>

### 💡 사이트 간 스크립팅(XSS; Cross-Site Scripting)
- 웹 애플리케이션에서 많이 나타나는 취약점의 하나로, 웹사이트 관리자가 아닌 이가 웹 페이지에 악성 스크립트를 삽입할 수 있는 취약점이다.
- 이 취약점은 웹 애플리케이션이 사용자로부터 입력 받은 값을 제대로 검사하지 않고 사용할 경우 나타난다. 주로 여러 사용자가 보게 되는 전자 게시판에 악성 스크립트가 담긴 글을 올리는 형태로 이루어진다.
- 이 취약점으로 해커가 사용자의 정보(쿠키, 세션 등)를 탈취하거나, 자동으로 비정상적인 기능을 수행하게 하거나 할 수 있다. 주로 다른 웹사이트와 정보를 교환하는 식으로 작동한다.
- 대상 : Client
<BR>

### 💡 사이트 간 요청 위조(CSRF; Cross-Site Request Forgery)
- 웹사이트 취약점 공격의 하나로, 사용자가 자신의 의지와는 무관하게 공격자가 의도한 행위(수정, 삭제, 등록 등)를 특정 웹사이트에 요청하게 하는 공격을 말한다.
- XSS를 이용한 공격이 사용자가 특정 웹사이트를 신용하는 점을 노린 것이라면, 사이트간 요청 위조는 특정 웹사이트가 사용자의 웹 브라우저를 신용하는 상태를 노린 것이다.
- 일단 사용자가 웹사이트에 로그인한 상태에서 사이트간 요청 위조 공격 코드가 삽입된 페이지를 열면, 공격 대상이 되는 웹사이트는 위조된 공격 명령이 믿을 수 있는 사용자로부터 발송된 것으로 판단하게 되어 공격에 노출된다.
- 대상 : Server
<br>

### 💡 XSS와 CSRF의 차이요약
- 간단하게, XSS는 공격대상이 Client이고, CSRF는 Server이다.
- XSS는 사이트변조나 백도어를 통해 클라이언트에 대한 악성공격을 한다.
- CSRF는 요청을 위조하여 사용자의 권한을 이용해 서버에 대한 악성공격을 한다.

​<br>

# 2. Security 설정 ✔
### 1) Security 관련 jar ..... (Maven -> dependency 제공)
```xml
 <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-web</artifactId>
        <version>4.0.1.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-config</artifactId>
        <version>4.0.1.RELEASE</version>
    </dependency>
    <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-taglibs</artifactId>
         <version>4.0.1.RELEASE</version>
    </dependency>
```
- pom.xml에 추가하기

### 2) 보안관련(Security 설정 xml 만들기)
![image](https://user-images.githubusercontent.com/111114507/208332898-8bf87696-d093-4457-bcdb-23db2d3fdc0d.png)
- security-context.xml 생성
<br>

![image](https://user-images.githubusercontent.com/111114507/208332931-1a62ecca-bab4-4dc5-abfe-b666e1a75f86.png)
- Namespace에서 security 체크하기
#### [securyty-context.xml]
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xmlns:security="http://www.springframework.org/schema/security"
 xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
  http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security.xsd">
</beans>

 <security:http auto-config="true">
		<security:csrf disabled="true" />
		<security:form-login 
		                     login-page="/joinus/login.htm" 
		                     default-target-url="/index.htm"  
		                     authentication-failure-url="/joinus/login.htm?error" />
		<security:logout 
		                     logout-success-url="/index.htm" />
		<security:intercept-url pattern="/customer/noticeDetail.htm" access="hasRole('ROLE_USER')"  />
		<security:intercept-url pattern="/customer/noticeReg.htm"  access="hasRole('ROLE_ADMIN')" />
		<!-- <security:access-denied-handler error-page="/login/accessDenied.do"/> -->
	</security:http>
	<security:authentication-manager>
		<security:authentication-provider>
			<security:user-service>
					<security:user name="hong"  password="1004" authorities="ROLE_USER"/>
					<security:user name="admin" password="1004" authorities="ROLE_USER,ROLE_ADMIN"/>
			</security:user-service>
			
		</security:authentication-provider>
		
	</security:authentication-manager>

</beans>
```
- login-page : login 요청 시
- default-target-url : login 성공 시
- authentication-failure-url : login 실패 시
<br>

### 3) web.xml에 필터 추가
```xml
 <!-- 인증권한 관련 Filter -->
   <filter>
     <filter-name>springSecurityFilterChain</filter-name>
     <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
   </filter>
   <filter-mapping>
     <filter-name>springSecurityFilterChain</filter-name>
     <url-pattern>/*</url-pattern>
   </filter-mapping>
```
```xml
<!-- The definition of the Root Spring Container shared by all Servlets and Filters -->
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>
    /WEB-INF/spring/root-context.xml
   ******* /WEB-INF/spring/appServlet/security-context.xml  ****** >> 이거 추가해줌!!
    </param-value>
</context-param>
```
<br>

# 3. Security 예제 ✔
```jsp
<se:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')" ><!-- if문 -->
    <li>
        <a href="${pageContext.request.contextPath}/logout">${loginuser}:로그아웃</a>
        </li>
</se:authorize>
```
- se:authorize : if문이라고 생각하면 됨
<br>

```java
    //글 쓰기 Service
   public String noticeReg(Notice n , HttpServletRequest request, Principal principal) {
```
- Principal : Session과 비슷...? 내일 추가 학습 필요!