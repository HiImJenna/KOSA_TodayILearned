# 2022.10.25. TUE 📅
----------------
<br>

## 1. Tomcat제공(WAS) ✔
### 🔔 기본적인 내장 객체
- request (요청: 클라이언트 정보)
- response (응답: 특정 페이지 이동 , 정보 출력 , 쿠키 쓰기)
- application(전역객체: web.xml 자원 접근 read , 전역변수)
- session(고유객체(접속한 사용자에게 부여되는): 고유한 변수)
- out (출력)
<br>

### 🔔 session객체
- 내부에 session변수 생성
- scope : a.jsp(session.setAtt.."member" 변수 생성) b.jsp(session.getAtt.. "member" 사용가능)
- session 변수는 (현재 Webapp 폴더 안에 있는 모든 페이지에서 사용 가능)
- Life-cycle : session변수는 session객체와 동일 / session 소멸 : 서버 리부팅 , Tomcat 재실행 , session.invaildate()
<br>

### 🔔 application 객체
- 내부에 application변수 생성
- 전역변수 >>모든 session (접속한 모든 사용자) 공유 scope : (현재 Webapp 폴더 안에 있는 모든 페이지에서 사용 가능) 
- java >> static Life-cycle : 소멸 (서버 리부팅) , Tomcat 재실행
<br>

### 🔔 request 객체
- [내부에 변수 생성] : request.setAttribute("type","A");
- scope: 요청 페이지(login.jsp >> 요청당 request 생성 >> scope >> page
- 예외적으로 login.jsp >> ok.jsp(include or forward) request 객체는 ok.jsp 공유된다
- 자바 웹을 다루는 기술 424p 12.6 예제 연습하면 좋음
```java
Emp emp = new Emp();
emp.setEmpno(2000);
emp.setEname("홍길동");

session.setAttribute("empobj", emp);
//(String name, Object value) -> 단점 downcasting 필요

//session (예를 들어 다른 페이지라고 가정)
Emp e = (Emp)session.getAttribute("empobj");
out.print(e.getEmpno() + "<br>");
out.print(e.getEname() + "<br>");

//request
request.setAttribute("who", "king");
//Scope (현재 페이지)

String who = (String)request.getAttribute("who");
out.print(who);

/*
예외적으로
<jsp:include page="b.jsp"></jsp:include>
1. b.jsp 에서 session변수 >> empobj >> 사용(O) >> session이니 include와 상관없이.
2. b.jsp 에서 request변수 >> who >> 사용(O) >> include 했으니까
+

EL & JSTL
```
<br>

## 2. Servlet ✔
### < JSP MVC model >
### 🔔 흐름 !! (매우중요)
- #### 1. 한글처리
```java
    request.setCharacterEncoding("UTF-8");
```
<br>

- #### 2. 데이터 받기
```java
    String type = request.getParameter("type");
```
<br>

- #### 3. 판단하기(요청) (로직처리)
```java
    Object resultobj = null;
        if(type == null || type.equals("greeting")) {
                resultobj = "hello world";
        }else if(type.equals("date")) {
                resultobj = new Date();
        }else {
                resultobj = "invalid String type";
        }
```
<br>

- #### 4. 데이터 저장
```java
    //MVC 패턴   >> JSP(화면) >> 서블릿 요청 파악 처리 >> View전달 (JSP)
    //결과를 저장 : application , session , request (include , forward)
    //내가 만든 자원이 모든 페이지이 필요하지 않다면 .... application , session 탈락
    //답안)  request
    request.setAttribute("result", resultobj);
```
<br>

- #### 5. view 페이지 설정
```java
    //forward 방식으로  JSP 까지
    //요청한 주소는 변하지 않고 다른 페이지 내용을 서비스 가능
    
    //getRequestDispatcher >> VIEW 페이지 주소 지정
    RequestDispatcher dis = request.getRequestDispatcher("/simpleview.jsp");
```
<br>

- #### 6. view 데이터 전달(forward)
```java
    dis.forward(request, response); //request 객체 주소를 같이 ...parameter로
    //servlet 가지고 있는 request 객체의 주소 와 response  객체의 주소를 전달
```
<br>

### < CMD 방식 >
```java
    private void doProcess(HttpServletRequest request, HttpServletResponse response , String method) throws ServletException, IOException {
		//GET 요청이나 POST 요청을 doProcess 함수가 처리
    	//method  parameter  요청 방식 파악
    	System.out.println("클라이언트 요청 방식 : " + method);
    	
    	request.setCharacterEncoding("UTF-8");
    	
    	String cmd = request.getParameter("cmd");
    	
    	String viewpage=null;
    	if(cmd == null) {
    		viewpage = "/error/Error.jsp";
    	}else if(cmd.equals("boardlist")) {
    		viewpage = "/board/boardlist.jsp";

    	}else if(cmd.equals("boardwrite")) {
    		
    		viewpage = "/board/boardwrite.jsp";
    		
    	}else if(cmd.equals("boarddelete")) {
    		
    		viewpage = "/board/boarddelete.jsp";
    		
    	}else if(cmd.equals("login")) {
    		viewpage = "/WEB-INF/views/login/login.jsp"; //실무적인 코드
    	}else {
    		
    		viewpage = "/error/error.jsp";
    	}
    	
    	//결과저장
    	//List<board> boardlist = dao.selectBoardList();
    	//request.setAttribute("list",boardlist);
    	
    	//view지정
    	RequestDispatcher dis = request.getRequestDispatcher(viewpage);
    	
    	//view에게 데이터 전달 (forward)
    	dis.forward(request, response);//request객체를 view 에게 통으로 전달
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//같은 로직
		doProcess(request, response, "GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//같은 로직
		doProcess(request, response, "POST");
	}

```
- -> 위와같이 cmd = ~~~ 하는 값을 받아와 각각의 jsp를 분류해주는 방식이다