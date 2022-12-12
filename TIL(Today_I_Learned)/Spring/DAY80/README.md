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

### 🔔 상위 컨테이너
```xml
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
  	<property name = "driverClassName" value = "oracle.jdbc.driver.OrWWWacleDriver"></property>
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
<br>

## 2. JDBC API ✔
```
기존 : Model2 기반의 MVC 패턴 : JDBC API 사용 (Connection , Statement , PrepareStatement ,ResultSet..)
함수 사용 실행 : ResultSet rs = st.executeQuery();
함수 사용 실행 : int result = st.executeUpdate();
select a, b, c, d, e, f, g from data;
dto 담아라 ...
class data {private int a, b, c, d, e, f, .....}
while(rs.next()){ data d = new data(); d.setA(rs.getInt("a"))}
단순한 작업을 안했으면 좋겠어요.....
- Spring 제공하는 > JDBCTemplate(틀) > [코드량 감소] , [일원화된 코드 작업 가능] (유지보수)
문제점) 인터페이스 기반 (설계) > 익명클래스 > 코드 생략 > 추상화 > 개발자 입장에서 가독성
```
```java
public class MemberDAOImpl implements MemberDAO{

   /*
   JdbcTemplate template = new JdbcTemplate();
   public void m() { template.execute("select...");}
   IOC 컨테이너 안에 Bean 으로 생성 되어 있어요
   
   
   MemberDAOImpl 객체 JdbcTemplate 객체에 의존한다
   */
   private JdbcTemplate jdbctemplate;
   
   @Autowired //by type
   public void setJdbctemplate(JdbcTemplate jdbctemplate) {
      this.jdbctemplate = jdbctemplate;
   }
```
- MemberDAOImpl 객체는 JdbcTemplate 객체에 의존하기때문에 @Autowired 혹은 @Resource로 주입을 해줘야함

<br>


## 3. JDBC Template ✔
![image](https://user-images.githubusercontent.com/111114507/207038949-214e1458-3f48-43bf-b819-83c039b4e3ab.png)<br>

### 🔔 기본 Template 사용법!
#### [web.xml]
```xml
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
  </welcome-file-list>
  
  <!--  
  	Root Container(ApplicationContext)
  	listener 를 통해서 web.xml 실행시 가장 먼저 실행
  	applicationContext.xml > IOC DI 구성 파일로 (공통빈 : 다른 IOC 컨테이너 참조하는 Bean 구성)
  	org.springframework.web.context.ContextLoaderListener
  -->
  
  <listener>
  	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  <context-param>
  	<param-name>contextConfigLocation</param-name>
  	<param-value>/WEB-INF/applicationContext.xml</param-value>
  </context-param>
  
  
  <servlet>
  	 <servlet-name>dispatcher</servlet-name>
  	 <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
 	<!--  <init-param>
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
  <!-- DI 구성하는 xml 파일 : [servlet이름]-servlet.xml  -->
  
  <!-- Filter 사용한 한글 처리 
  org.springframework.web.filter.CharacterEncodingFilter
  -->
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
- 실행 순서 : web.xml -> index.html -> applicationContext.xml(상위컨테이너) -> *.do 찾아서..
<br>

#### [index]
```html
<fieldset style="width:250px">
    <legend>MAIN SITE</legend>
    <a href="login.do">로그인 하기</a>
    <hr>
    <a href="join.do">회원가입하기</a>
    <hr>
    <a href="check.do">회원유무판단</a>
</fieldset>
```
<br>

#### [applicationContext.xml]
```xml
<!-- 공통 DB작업  -->
  <bean id="driverManagerDataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
  	<property name="driverClassName" 	value="oracle.jdbc.driver.OracleDriver"></property> <!-- ojdbc6.jar 파일 불러오는거 -->
  	<property name="url" 				value="jdbc:oracle:thin:@Localhost:1521:xe"></property>
  	<property name="username" 			value="springuser"></property>
  	<property name="password"			value="1004"></property>
  </bean>
 
 <!-- JDBC Template -->
 <bean id="" class="org.springframework.jdbc.core.JdbcTemplate">
 	<property name="dataSource" ref="driverManagerDataSource"/>
 </bean>
 
 
 <!-- 공통 UI  -->
 <bean id="internalResourceViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
 		<property name="prefix">
 			<value>/WEB-INF/view/</value>
 		</property>
 		<property name="suffix">
 			<value>.jsp</value>
 		</property>
 </bean>	
```
<br>

#### [dispatcher-servlet]
```xml
<bean id="" class="com.controller.JoinController"></bean>
<bean id="" class="com.controller.LoginController"></bean>
<bean id="" class="com.controller.LogoutController"></bean>
<bean id="" class="com.controller.MemberSearchController"></bean>
```
- bean으로 controller 생성. 하지만 이마저도 안할거임!!
<br>

```java
@Controller
@RequestMapping("/login.do")
public class LoginController {
   
	@Autowired   //memberfield 주입 가능 >> 그런데 일반적으로 setter 주입을 선호 합니다.
	private MemberDAO memberdao;

	//@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public String form() {
		return "loginForm";
	}
	
	//@RequestMapping(method=RequestMethod.POST)
	@PostMapping
	public String submit(
			              @RequestParam(value="id") String id,
			              @RequestParam(value="pwd") String pwd,
			              HttpSession session	//HttpSession 객체 얻어오기
			             ) throws SQLException 
	{
		String view = null;
		boolean isMember = memberdao.memberCheck(id, pwd);
		if(isMember) {
			session.setAttribute("USERID",id); //
			view = "loginSuccess";
		}else {
			view = "loginForm";
		}
		return view;
	}
}
```
- @Controller : 컨트롤러로 사용하겠다고 명명
- @RequestMapping("/login.do") : login.do 모두 받겠다
- @Autowired : memberfield 주입 가능 
- 이 부분을 다 읽으면 다시 IOC로 돌아가서 Controller 찾고 ...!
<br>

#### [LogoutController.java]
```java
@Controller
public class JoinController {

	//DB작업
	//DAO ...
	//member field 
	//인터페이스 타입 : 객체의 생성과 조립 (어떠한 부품도 ... 표준화 ... 다형성 ... interface

	private MemberDAO memberdao;

	@Autowired  //by type
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}
	@GetMapping("/join.do")
	public String form() {
		return "joinForm";
	}
	@PostMapping("/join.do")
	public String sumbit(@RequestParam(value="id", required = true) String id,
						 @RequestParam(value="name") String name,
						 @RequestParam(value="pwd")  String pwd,
						 @RequestParam(value="email" ,defaultValue = "1@1") String email,
						 @RequestParam(value="age" , defaultValue = "1") Integer age) {

	
		System.out.println(id + "." + name + "." + pwd + "." + email + "." + age);
		String view = null;
		boolean joinresult = memberdao.memberInsert(id, name, pwd, email, age);
		
		if(joinresult) {
			view = "joinSuccess";
		}else {
			view = "joinForm";
		}
		
		return view;

	}
}
 ```
- @RequestParam : RequestParam(가져올 변수의 이름) 데이터 타입, 가져온 데이터를 담을 변수
```java	
    private MemberDAO memberdao;

	@Autowired  //by type
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}
```
- 세트로 쓰이며 자바에서의 new와 같다고 이해하면 편함
- Impl하는 DAO가 있을땐 interface DAO만 적어줘도 됨 -> MemberDAOImpl을 선언해줄 시 MemberDAO을 Impl하는 모든 클래스들을 선언해줘야하는 번거로움 발생
<br>

#### [MemberDAOImpl.java]
```java
public class MemberDAOImpl implements MemberDAO{

   /*
   JdbcTemplate template = new JdbcTemplate();
   public void m() { template.execute("select...");}
   IOC 컨테이너 안에 Bean 으로 생성 되어 있어요
   
   
   MemberDAOImpl 객체 JdbcTemplate 객체에 의존한다
   */

   private JdbcTemplate jdbctemplate;
   
   @Autowired //by type
   public void setJdbctemplate(JdbcTemplate jdbctemplate) {
      this.jdbctemplate = jdbctemplate;
   }
```
- jdbctemplate 이라는 내장 객체를 불러와서 사용함
- DB와의 연결을 도와주는..?!!
```java
   @Override
   public boolean memberInsert(String id, String name, String pwd, String email, int age) {
      String sql="insert into usermember(id,name,pwd,email,age) values(?,?,?,?,?)";
      boolean result = false;
             
      Object[] params = {id,name,pwd,email,age};
      //[hong][홍길동][1004][hong@naver.com][100]
      (this.jdbctemplate.update(sql,params) > 0)
      {
         result = true;
      }
      return result;
   }
```
- Object[] params = {id,name,pwd,email,age} : Spring에서는 Parameter에 적은 값과 Query문에 적은 값이 같다면 별도의 과정 없이 알아서 읽고 처리함

```java
   @Override
   public MemberVO selectMemberById(String id) throws SQLException {
      String sql="select id,name,pwd,email,age from usermember where id=?";
      //Query 문 실행 -> resultset 결과 담아서 >[ VO 객체 생성 > rs 에서 vo setter 사용 데이터 넣고 ]> VO 객체 리턴
      return this.jdbctemplate.queryForObject(sql,
                                           new BeanPropertyRowMapper<MemberVO>(MemberVO.class),
                                           id);
   }
}
```
- new BeanPropertyRowMapper< MemberVO>(MemberVO.class) : 위의 예시(Object[] params = {id,name,pwd,email,age})처럼 하나씩 적어줘도 되지만 테이블의 한 줄을 통채로 가져올 경우에는 VO를 통채로 가져오는 것도 가능!!
<br>


