<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type = "text/javascript">
	let httpReq=null;
	
	function getInstance(){
		  if(window.XMLHttpRequest){
			  httpReq = new XMLHttpRequest(); //현재 브라우져 XMLHttpRequest 내장
		  }else if(window.ActiveXObject){ //IE6 이하   //지금 필요없어요
			  httpReq = new ActiveXObject("Msxml2.XMLHTTP");
		  }else{
			 throw new Error("AJAX 지원하지 않습니다"); 
		  }
		return httpReq;  
	}
	
	function handlerStateChange(){
		 if(httpReq.readyState == 4){ //1. 서버에서 응답이 왔다면
			 if(httpReq.status >= 200 && httpReq.status < 300){
				 //개발자 마음 (가공)
				 //서버가 비동기로 클라이언트 줄 수 있는  Data
				 //1. Text (text, html , script , css , json)  >> responseText
				 //2. xml                                      >> responseXML
				 
				  console.log(httpReq.responseText);
				 
				  document.getElementById(" ").innerHTML = printdata;
				  
				 
			 }else{
				 alert("status Text : " + httpReq.status);
			 }
		 }
	}
	
	function sendData(){
		httpReq = getInstance();
		httpReq.onreadystatechange = handlerStateChange;  // x >> ()
		
		let empno = document.getElementById("").selectedIndex;
		
		httpReq.open("POST","Ex06_EmpSearch.jsp?empno="+empno); //form 태그 구성
	
		httpReq.send(); 
	}

</script>
</head>
	<body>
	   <h3>사원 검색 (비동기식)</h3>
	   <select name="emp" id="emp" onchange="sendData()">
	      <option value="0000">SELECT EMPNO</option>
	      <option value="7788">SCOTT</option>
	      <option value="7902">FORD</option>
	      <option value="7521">WORD</option>
	   </select>
	   <hr>
	   <div id="txtdata">EMP DATA LOAD</div>
	
	</body>
</html>