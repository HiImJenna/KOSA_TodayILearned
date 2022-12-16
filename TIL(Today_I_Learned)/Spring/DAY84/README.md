# 2022.12.16.THU 📅
----------------
<br>

# 1.MVC & MyBatis 기본 설정 및 구조 이해하기 ✔
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