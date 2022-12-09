<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--
 TODAY POINT
 개념 이해 (서버자원 활용하기)
 session 객체 가지고 놀기
 
 1. session 객체(사용자마다 부여되는 고유한 객체)
    >> 접속하는 브라우저마다 (sessionID)을 가지고 객체 관리
    >> 접속한 사용자 마다 고유한 변수 만들기 .....
    >> session.setAttribute("id",request.getParameter("userid")); 
    
    접속자 3명
    
    김유신 : 서버객체 생성(session) : 식별값 : A1 : 생성된 session 객체(변수, 값)
    -session객체 (id,kim)
    
    이순신 : 식별값 : A2
    -session 객체 (id,Lee)
    
    .. 등등 .....
  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>세션정보</h3>
   sessionID : <%= session.getId()%>
   <br>
   
   <h3>세션변수(set)</h3>
   <%
      String userid = request.getParameter("userid");
      //POINT
      session.setAttribute("id", userid); //*** 클라이언트에 저장

   %>
   
   <h3>내가 필요시(세션변수... get)</h3>
   
   
   <%
   	String id=(String)session.getAttribute("id");
   	out.print("당신의 ID는 <b>" + id + "</b>");
   %>
   
   <!-- 
   
   	session 객체의 유효 Scope : webApp전체 ... 어떤 페이지든 저장한 session 객체 사용 가능
   
    -->
   
</body>
</html>