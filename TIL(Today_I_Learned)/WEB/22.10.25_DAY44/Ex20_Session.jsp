<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 UI</title>
</head>
<body>
<!-- 
순수한 JSP 사이트 제작
Model1 방식 개발 (JSP 요청받고 처리 ...)
UI + 처리 (2개 설계)
login.jsp -> loginok.jsp

action="Ex20_Session_ok.jsp"
 -->
    <form action="Ex20_Session_ok.jsp" method = "post">
       <input type="text" name="uid"><br>
       <input type="password" name="pwd"><br>
       
       <input type="submit" value="로그인"> 
       <input type="reset" value="취소">
    </form>
    <hr>
    <h3>회원 정용 페이지</h3>
    <a href=""></a>
</body>
</html>