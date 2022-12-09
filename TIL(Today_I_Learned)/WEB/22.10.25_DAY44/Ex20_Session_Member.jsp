<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	//이 페이지는 회원 전용
	//로그인 하지 않는 사용자는 올 수 없음
	//sesson >> memberid 유무 >> 성공(id ... )
	String memberid = (String)session.getAttribute("memberid");
	boolean loginstate = (memberid == null) ? false : true;
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(loginstate == true) { 
			out.print(memberid + "님 로그인 상태입니다<br>");
			out.print("당신은 이 페이지를 볼 수 있습니다<br>");
			//로그아웃
		} else {
			out.print("<script>location.href='Ex20_Session_Login.jsp'</script>");
		}	
	%>
</body>
</html>