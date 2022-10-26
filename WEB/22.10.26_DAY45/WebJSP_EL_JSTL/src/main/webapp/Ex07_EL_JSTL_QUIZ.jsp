<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
/*
	String name = request.getParameter("name");
	if(name.equals("kglim")){
		out.print("<b>" + name + "</b>");
	}else if(name.equals("hong")){
		out.print("<i>" + name + "</i>");
	}else{
		out.print("<h3>" + name + "</h3>");
	}
	out.print("<hr>");
*/
%>        

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  
위 코드를 EL 과 JSTL 변환 하세요
-->

<c:choose>
	<c:when test = ${param.name} == "kglim">
	<b>${param.name}</b>
	</c:when>
	
	<c:when test = ${param.name} == "hong">
	<i>${param.name}</i>
	</c:when>
	
	<c:otherwise>
		<h3>${param.name}</h3>
	</c:otherwise>

</c:choose>
<hr>
</body>
</html>