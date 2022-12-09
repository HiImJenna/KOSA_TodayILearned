<%@page import="java.util.HashMap"%>
<%@page import="kr.or.kosa.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
   Emp e = new Emp(2000,"kosauser");

   HashMap<String,String> hp = new HashMap<>();
   hp.put("data","1004");
   
   request.setAttribute("emp", e);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>기존방식</h3>
   <%=e %><br>
   <%=e.getEname()%><br>
   <%=e.getEmpno()%><br>
   
   <h3>EL출력방식</h3>
   EL: ${e }<br> <!-- 출력안됨 -->
   EL: ${e.getEmpno() }<br> <!-- 출력안됨 -->
   
   <h3>해결사</h3>
   1. request 객체 또는 session 객체에 담는다 <br>
   EL:${requestScope.emp }<br>
   EL:${requestScope.emp.empno }<br>
   
   2. JSTL 사용해서 처리 <br>
   
   <h3>JSTL(core): 변수생성, 제어문 (자바코드 도움없이) : 서버에서 해석 실행</h3>
   <c:set var="m" value="<%=e%>"/>
   
   JSTL사용해서 변수 m을 생성 (EL 사용해서 접근 가능) : ${m}<br>
   getter 함수(권장 방법x) : ${m.getEmpno()}<br>
   
   EL 출력 (m.memberfield 명 : 자동으로 getter 호출) : ${m.empno }<br>
   EL 출력 (m.memberfield 명 : 자동으로 getter 호출) : ${m.ename }<br>
   
   <!-- 
   EL : 출력목적 >> 변수, 제어구조 없어요
   JSTL : EL을 도와서 변수, 제어구조 출력 도와주어요 ^^
    -->
    <c:set var="username" value="${m.ename }]"></c:set>
    변수값 출력: ${username }<br>
    
    <hr>
    <h3>JSTL 변수 만들고 Scope정의하기</h3>
    <c:set var="job" value="농구선수" scope="request" />
    당신의 직업은: ${job }<br>
    만약에 당신이 include, forward 통해서 페이지를 제어하면 그 페이지에서 EL 통해서 job변수 출력
    
    <hr>
    <c:set var="job2" value="야구선수"/>
    값출력: ${job2 }<br>
    
    만든 변수를 삭제 기능(잘쓰지 않아요)<br>
    <c:remove var="job2"/>
    값출력(삭제: 결과 안나올뿐 예외 안나요) :${job2}<br>
    
    <hr>
    자바 API가 제공하는 객체(직접) : ${hp}<br>
    1. request or session 담는다 -> 권장사항<br>
    2. JSTL 사용<br>
    
    <c:set var="vhp" value="<%=hp %>"/>
    hp 객체 : ${vhp}<br>
    hp 객체 : ${vhp.data}<br>\
    <hr>
    값을 write (hp.put("color","red")) : 그냥 구경만 ... 
    <c:set target="${vhp}" property = "color" value="red"></c:set>
    hp 객체 : ${vhp}<br>
</body> 
</html>























