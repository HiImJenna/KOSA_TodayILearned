# 2022.12.20.TUE 📅
----------------
<br> 

# 1. 암호화 ✔
![image](https://user-images.githubusercontent.com/111114507/208563884-b62edd28-1e9d-41ac-8424-2f6b4de440aa.png)
- 회원가입 시 비밀번호를 1으로 입력했는데 DB 저장시 이렇게 암호화가 되어서 저장된다.
<br>

### 💡 설정
#### [root-context.xml]
```xml
  <bean id="bCryptPasswordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder">
  </bean>
```
<br>

#### [security-context.xml]
```xml
<security:authentication-manager>
    <security:authentication-provider><!-- 인증에 대한 제공자 -->
        <security:jdbc-user-service
        data-source-ref="driverManagerDataSource"
        users-by-username-query="SELECT USERID, pwd AS PASSWORD, 1 enabled FROM member where userid=?"

        authorities-by-username-query="select m.USERID , r.ROLE_NAME  
                                            from member m join roll r 
                                            on m.userid = r.userid 
                                            where m.userid=?" />
  ***  <security:password-encoder ref="bCryptPasswordEncoder"/>
    </security:authentication-provider> *** >> 추가해주기
</security:authentication-manager>
```
- 이 부분이 로그인 로직을 대신 해준다고 생각하면 될 듯
<br>

#### [패키지 구조]
![image](https://user-images.githubusercontent.com/111114507/208645731-7364e3ea-f5a8-4ec4-bd6e-39355e9593c2.png)
- 기존 NewMemberController를 지우고 MemberController & MemberDao.xml 생성 -> MyBatis 적용을 위해서
<br>

### 💡 회원가입
#### [header.jsp]
```jsp
<se:authorize access="!hasRole('ROLE_USER')">		
    <li>
        <a href="${pageContext.request.contextPath}/joinus/join.htm">회원가입</a>
    </li>
</se:authorize>
```
- se:authorize로 로그인 된 회원에게는 회원가입 버튼이 보이지 않도록 처리
<br>

#### [JoinController.java]
```java
@Controller
@RequestMapping("/joinus/")
public class JoinController {
	private MemberDao memberdao;

	@Autowired
	private MemberSerivce memberservice;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("join.htm")
	public String join() {
		return "joinus/join";		
	}

	@PostMapping("join.htm")
	public String join(Member member) {
		System.out.println(member.toString());
		try {
			member.setPwd(this.bCryptPasswordEncoder.encode(member.getPwd()));
			memberservice.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/index.htm";
    }
}
```
- BCryptPasswordEncoder : 비밀번호 암호화하기 위해선 추가해줘야 함
- Controller에 있는 메소드는 Dao나 Service에 있는 메소드와 같을 필요 X, 그냥 보기 편한대로 하기
- Parameter 값에는 그 메소드를 실행할 때 어떤 값이 넘어오냐에 따라 달림, 위와 같은 상황에서는 회원가입 시 회원 정보가 넘어올 것이니 회원정보를 가지고 있는 Dto를 Parameter로 받아줘야 한다.
- member.setPwd(this.bCryptPasswordEncoder.encode(member.getPwd())) : 공식이라 생각하기~
<br>

#### [MemberDao.xml]
```xml
<insert id="insertMember" parameterType="vo.Member">
    insert into member(userid, pwd, name,regdate)
    values(#{userid}, #{pwd}, #{name},sysdate)
</insert>
```
<br>

#### [MemberService.java]
```java
public void insertMember(Member member) {
    MemberDao dao = sqlsession.getMapper(MemberDao.class);
    dao.insertMember(member);
}
```
<br>

### 💡 로그인
#### [header.jsp]
```jsp
<se:authorize access="!hasRole('ROLE_USER')"> 
        <li><a href="${pageContext.request.contextPath}/joinus/login.htm">로그인</a></li>
</se:authorize>
```
- se:authorize : 로그인 되어있는 유저에게는 로그인 버튼이 보이지 않도록
<br>

#### [JoinController.java]
```java
//로그인 요청
@GetMapping(value="login.htm")
public String login() {
    return "joinus/login";
}
```
<br>

#### [login.jsp]
```jsp
<form action="${pageContext.request.contextPath}/login" method="post">                            
<fieldset>
        <legend class="hidden">로그인 폼</legend>
        <h3><img src="images/txtTitle.png" /></h3>
        <ul id="loginBox">
            <li><label for="uid">아이디</label>
                        <input type="text"        name="username" class="text" /></li>
            <li><label for="pwd">비밀번호</label>
                        <input type="password" name="password" class="text" /></li>
        </ul>
        <p><input type="submit" id="btnLogin" value="" /></p>
        <ul id="loginOption">
            <li><span>아이디 또는 비밀번호를 분실하셨나요?</span><a href="/Member/FindID"><img alt="ID/PWD 찾기" src="images/btnFind.png" /></a></li>
            <li><span>아이디가 없으신 분은 회원가입을 해주세요.</span><a href="/Member/Agree"><img alt="회원가입" src="images/btnJoin.png" /></a></li>
        </ul>
    </fieldset>
</form>
```
- form에서 /login으로 넘기면 자동으로 security-context.xml에서 login 로직을 처리함!
<br>

### 💡 마이페이지 - 회원정보 수정
#### [header.jsp]
```jsp
<se:authorize access="hasRole('ROLE_USER')">
    <li>
        <a href="${pageContext.request.contextPath}/customer/mypage.htm"><img src="${pageContext.request.contextPath}/images/menuMyPage.png" alt="마이페이지" /></a>
    </li>
</se:authorize>
```
<br>

#### [MypageController.java]
#### 1) 비밀번호 확인 
```java
@Controller
@RequestMapping("/customer/")
public class MypageController {	
	
	private MemberSerivce memberservice;
	
	@Autowired
	public void setMemberservice(MemberSerivce memberservice) {
		this.memberservice = memberservice;
	}
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("mypage.htm")
	public String memberConfirm() {
		return "customer/memberConfirm";
	}
	
	@PostMapping("mypage.htm")
	public String memberConfirm(@RequestParam("password") String rawPassword, Principal principal){
		String viewpage="";
		
		//회원정보
		Member member = memberservice.getMember(principal.getName());
		
		//DB에서 가져온 암호화된 문자열
		String encodedPassword = member.getPwd();
		boolean result = bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
		
		if(result){
			viewpage="redirect:memberupdate.htm";
		}else{
			viewpage="redirect:mypage.htm";
		}
		return viewpage;
	}
```
- PostMapping 부분은 공식이라 생각하고 사용하기
- 대략, 암호화되어서 DB에 저장되어있는 비밀번호와, 입력한 비밀번호를 대조하여 동일하면 수정 페이지로, 동일하지 않으면 페이지가 넘어가지 않게
<br>

#### 2) 회원정보 수정
```java
@GetMapping("memberupdate.htm") 
public String memberUpdate(Model model, Principal principal) {
    Member member = memberservice.getMember(principal.getName());
    model.addAttribute("member", member);
    return "customer/memberUpdate";
}

@PostMapping("memberupdate.htm")
public String memberUpdate(Model model, Member member, Principal principal) {
    Member updatemember = memberservice.getMember(principal.getName());
    updatemember.setName(member.getName());
    updatemember.setCphone(member.getCphone());
    updatemember.setEmail(member.getEmail());
    updatemember.setPwd(bCryptPasswordEncoder.encode(member.getPwd()));
    memberservice.updateMember(updatemember);
    return "redirect:/index.htm";
}
}
```
- GetMapping 부분 : 마이페이지로 이동할 때 Session값에 있는 정보랑 비교 해서 마이페이지로 보낼지 결정..
```
Principal 객체는 구현체의 최상위 인터페이스이기 때문에 이 타입으로 받으면 사용할만한 메소드가 
getName() 정도밖에 없습니다. 
그냥 ID 정보만 가져다 사용할 수 있다고 보면 됩니다.
```
- 하지만 애초에 se:authorize 로 걸러버리면 사용할 필요가 없지 않을까..?🤔
<br>

#### [MemberDao.xml]
```xml
<update id="update" parameterType="vo.Notice">
    update notices
    set   title=#{title},
        content=#{content},
        filesrc=#{fileSrc, jdbcType = VARCHAR},
        filesrc2=#{fileSrc2,jdbcType=VARCHAR}
    where seq=#{seq}
</update>
```
<br>

#### [MemberService.java]
```java
public void updateMember(Member member){
    MemberDao dao = sqlsession.getMapper(MemberDao.class);
    int result = dao.updateMember(member);
}
```
