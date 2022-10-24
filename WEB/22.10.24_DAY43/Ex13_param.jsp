<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>request 객체(include) 페이지에 공유 가능</h3>
<%= request.getParameter("type")%><br>
<%= request.getParameter("userid")%><br>

<h3>Ex13_include_param.jsp 액션태그로 전달된 값</h3>

<%
	String hobby =  request.getParameter("hobby");
	out.print("당신의 취미는 <br>");
	
	if(hobby.equals("baseball")){
		out.print("<i>" + hobby + "</i>");
	} else {
		out.print("<i>" + 취미가없네요 + "</i>");
	}
%>