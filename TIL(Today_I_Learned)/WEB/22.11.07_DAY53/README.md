# 2022.11.07. MON 📅
----------------
<br>

## 1. Model2 MVC 패턴 작업 ✓

- Model
    1. DTO 생성 > Db 테이블과 같은 구조 클래스 생성 > getter, setter 구현
    2. DB 연결(POOL) > DAO > CRUD > 전체조회, 조건조회, 삽입, 삭제, 수정 + 알파(LIKE)
    3. Servic단..추후
    
- View
    1. html or jsp > 구분점은? : UI 데이터 출력 유무 > Boot > include > 모든페이지 > JSP
    2. EL & JSTL > server에서 데이터 담아서 (request) > forward > 그 request 객체 ...
    ex) ${requestScope.list) or ${[sessionScope.id](http://sessionscope.id/)} >> 출력(JSTL)
    3. JSP 보안적 처리 > WEB-INF > view > member or admin or board > jsp 관리
    4. 비동기처리(ajax) > xmlHttpRequest
    
- Controller
    1. 요청마다 Controller 생성하기 (servlet 생성)
    1-1. write > /write > ServletWrite
    1-2. list > /list > ServletList
    
    2. 요청마다 Controller 생성하지 말고 1개 (servlet 생성)
    2-1. FrontController >> servet 1개 (모든요청판단) > 판단근거
    
    1)판단의 근거
    - command 방식 : 글쓰기([servlet.do?cmd=write](http://servlet.do/?cmd=write)), 글목록보기([servlet.do?cmd=list](http://servlet.do/?cmd=list))
    if{cmd.equals("write")(글쓰기 작업 수행)}
    - url 방식     : 글쓰기([wrtie.do?id=hihi&pwd=1004](http://wrtie.do/?id=hihi&pwd=1004)), 글목록보기([list.do](http://list.do/)) >> url 주소로 요청을 판단
    주의) url패턴 >> * do

![https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fm1.daumcdn.net%2Fcfile234%2FR400x0%2F13705949504C57EB0E1B72%22&type=cafe_wa740](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fm1.daumcdn.net%2Fcfile234%2FR400x0%2F13705949504C57EB0E1B72%22&type=cafe_wa740)

MVC패턴의 장점)

- 서로에 관심을 두지 않는다. (DB는 DB만… Front는 Front만…)
- 각자 잘하는것만 해!

### 🔔 제일 기본적인 MVC 패턴 폴더

![https://user-images.githubusercontent.com/92353613/200305250-2d8781dd-d107-40f1-ada1-892e769f6d27.png](https://user-images.githubusercontent.com/92353613/200305250-2d8781dd-d107-40f1-ada1-892e769f6d27.png)

## 2. Action ✓

기존 dao 다음 controller로 이루어지는 패턴은 controller에 많은 과부하가 걸리기 쉽상이다.

그렇기 때문에 Action파트를 만들어주어  service에서 기능을 구현해 controller에서 불러오기만 하면 되는 방식이다.

## 🔔 기본 Action 파일들

### [Action.java]

```jsx
package kr.or.kosa.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//생성하는 모든 서비스는 Action 인터페이스를 구현했으면 좋겠다.

public interface Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response);
	
}
```

### [ActionForward.java]

```jsx
package kr.or.kosa.action;

/*
 servlet(front) 요청 받음
 1. 화면 출력
 2. 로직 처리
 
 화면아니면 로직
 
 */

public class ActionForward {
	private boolean isRedirect = false; //view 전환 여부 .. redirect or forward
	private String path = null; //이동 경로 (뷰의 주소)
	
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
```

## 2.2 적용방법

### [Controller에 Action 적용방법]

```jsx
Action action = null;
    	ActionForward forward=null;
    	
    	if(urlcommand.equals("/register.do")) {
    		//UI 제공 (서비스 객체가 필요없다)
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/views/register/register.jsp");
// 기본 view단 공식
    		
    	}else if(urlcommand.equals("/registerok.do")) {
    		//UI 제공 + 서비스 필요
    		action = new RegisterOkServiceAction();
    		forward = action.execute(request, request); //request 클라이언트가 요청한 페이지당 1개씩 만들어지는 request 객체
    	}
// 기능이 있을경우 이런식으로
```

 

## 3. Filter ✓

filter란 http의 요청과 응답을 변경할 수 있는 재사용 가능한 객체이다. 클라이언트의 특정or 공통의 요청 정보를 점검하거나 알맞게 변경하는등 다음과 같은 것들을 할 수 있다.

- 인증
- 로깅
- 요청url처리
- 데이터 변환
- 암호화
- 체크

필터는 서블릿이 service()메서드를 이용해서 요청을 처리하듯 필터는 doFilter()메서드를 이용하여 요청을 필터링한다.

1. **public void init(FilterConfig filterConfig)**
    
    필터를 웹 콘테이너내에 생성한 후 초기화할 때 호출한다.
    
2.  **public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)**
    
    체인을 따라 다음에 존재하는 필터로 이동한다. 체인의 가장 마지막에는 클라이언트가 요청한 최종 자원이 위치한다.
    
3. **public void destroy()**
    
    필터가 웹 콘테이너에서 삭제될 때 호출된다.
    

![https://dthumb-phinf.pstatic.net/?src=%22https%3A%2F%2Fdthumb-phinf.pstatic.net%2F%3Fsrc%3D%2522https%253A%252F%252Fdthumb-phinf.pstatic.net%252F%253Fsrc%253D%252522http%25253A%25252F%25252Fcafeptthumb3.phinf.naver.net%25252F20130909_298%25252Fzeroday7_1378703968186yiYWO_GIF%25252Ffilter.gif%25253Ftype%25253Dw740%252522%2526amp%253Btype%253Dcafe_wa740%2522%26amp%3Btype%3Dcafe_wa740%22&type=cafe_wa800](https://dthumb-phinf.pstatic.net/?src=%22https%3A%2F%2Fdthumb-phinf.pstatic.net%2F%3Fsrc%3D%2522https%253A%252F%252Fdthumb-phinf.pstatic.net%252F%253Fsrc%253D%252522http%25253A%25252F%25252Fcafeptthumb3.phinf.naver.net%25252F20130909_298%25252Fzeroday7_1378703968186yiYWO_GIF%25252Ffilter.gif%25253Ftype%25253Dw740%252522%2526amp%253Btype%253Dcafe_wa740%2522%26amp%3Btype%3Dcafe_wa740%22&type=cafe_wa800)

### 🔔 Filter 적용방법

### [Filter 적용코드]

```jsx
@WebFilter(
        description = "어노테이션 활용해 필터 적용",
        urlPatterns = {"/*"},
        initParams = {@WebInitParam(name="encoding", value="UTF-8")}
        )
public class Encoding extends HttpFilter implements Filter {
       
	//member field 생성
	private String encoding;
 
    public Encoding() {
        super();
    }
    
	public void init(FilterConfig fConfig) throws ServletException {
		//최조요청 시 컴파일되고 한번만 실행
		//web.xml 설정되어 있는 초기값을 read해서 사용 FilterConfig 통해서
		this.encoding = fConfig.getInitParameter("encoding");
		System.out.println("filter init 함수 실행 : " + this.encoding);
	}

	public void destroy() {
		
	}

	//함수를 통해 요청&응답 시 필터링 제어
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//request 요청에 대한 필터 실행 코드 영역
		if(request.getCharacterEncoding() == null) {
			System.out.println("before : " + request.getCharacterEncoding());
			//함줄 코드 (공통관심, 보조관심 AOP)
			request.setCharacterEncoding(this.encoding);
			System.out.println("after : " + request.getCharacterEncoding());
		}
		
		chain.doFilter(request, response);
	
		//response 응답에 대한 필터 실행 코드 영역
		System.out.println("응답처리 실행");
	}
	
}
```

- 앞으로 위 방식을 가져다 쓰세용