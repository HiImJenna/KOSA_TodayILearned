<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   String id = request.getParameter("ID");
   if(id.equals("hong")){
%>
   <%=id%><img src="images/1.jpg" style="width: 100px; height: 100px">
<%
   }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>EL과 JSTL 사용하기</h3>
   <!-- 
   ${param.ID} >> request.getParameter("ID")
    -->
    <c:if test="${param.ID == 'hong'}"> <!--    if(id.equals("hong")){      -->
       ${param.ID}<img src="images/1.jpg" style="width: 100px; height: 100px">
    </c:if>
    
    <h3>JSTL IF문</h3>
    <!-- 
    http://192.168.0.65:8090/WebJSP_EL_JSTL/Ex04_EL_JSTL.jsp?ID=hong&age=100
     -->
     <c:if test="${param.age > 20}">
        param.value : ${param.age}<br>
     </c:if>
     <hr>
     if 문에 var 변수를 만들면 : ${result}
</body>
</html>