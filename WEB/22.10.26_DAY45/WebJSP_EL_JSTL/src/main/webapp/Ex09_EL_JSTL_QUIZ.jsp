<%@page import="DTO.Emp"%>
<%@page import="java.util.List"%>
<%@page import="DAO.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
	EmpDAO ed = new EmpDAO();    
	List<Emp> emp = ed.getEmpAllList();
	request.setAttribute("e",emp);
%>
<!--  
종합 퀴즈 (조별 퀴즈)

EMP 테이블에서 사원전체 데이터를 출력하는 DTO , DAO 를 작성하세요 (JDBC 참고)
그리고 그 데이터 14건을 
EL & JSTL 을 사용해서 출력하세요
단)부트템플릿 사용하세요]
-->    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <c:set var="e" value="${requestScope.e}"></c:set>
    <c:forEach var="emp" items="${emplist} ">
      ${e}
    </c:forEach>
    
</body>
</html>