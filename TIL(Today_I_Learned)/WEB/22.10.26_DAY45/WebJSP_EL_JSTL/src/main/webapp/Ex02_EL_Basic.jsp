<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //EL은 <%=>를 대체
    //EL 사용한다고 해서 EL JAVA API 사용 못해요
    
    Date today = new Date();
    request.setAttribute("day", today);
    session.setAttribute("day2", today);

    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL 화면 출력(서버쪽 자원을 ,,, )</h3>
	EL : $(requestScope.day)<br>
	EL : ${day}<br> <!-- requestScope 객체명을 생략해도 출력은 되지만 가독성이 떨어짐 -->
	EL : ${sessionScope.day2}<br>
</body>
</html>