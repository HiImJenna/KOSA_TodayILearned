# 2022.10.26. WED 📅
----------------
<br>

## 1. EL 출력식 ✔
- JSP 페이지에서 사용되는 전용 스크립트 언어(화면에 출력) > 서버에서 해석되는 스크립트
- 이유 : 스파게티 코드 (% 영역과 UI영역 혼재) > 유지보수어려움 > 코드의 가독성 떨어짐
- 문제해결 : html 과도 잘 놀고 서버자원도 잘 출력하고script >> EL >> JSP 페이지에서만 사용 가능
- tomcat 서버가 내장하고 있는 자원 >> 별도의 참조 없이 사용 가능

#### 🔔 < EL 가지고 있는 객체> 
- param
- paramValues
- requestScope
- sessionScope
- applicationScope
<br>

#### 🔔 JSTL
- EL 도와서 변수, 제어구조 출력 도와줌 
```jsp
EL: ${e }<br> <!-- 출력안됨 -->
EL: ${e.getEmpno() }<br> <!-- 출력안됨 -->
```
- EL은 자바 객체를 바로 받아서 출력할 수 없음! 그렇기에 JSTL을 사용해야함
```jsp
1. request 객체 또는 session 객체에 담는다 <br>
EL : ${requestScope.emp}<br>
2. JSTL 사용해서 처리 <br>

<h3>JSTL(core) : 변수생성, 제어문(자바코드 도움 없이 : 서버에서 해석 실행)</h3>
<c:set var="m" value="<%=e %>"/>
JSTL 사용해서 변수 m을 생성 (EL 사용해서 접근 가능) : ${m}<br>
getter 함수(권장 방법은 아님 : ${m.getEmpno() }<br>

EL 출력 (m.memberfield명 : 자동으로 getter 호출) : ${m.empno}<br>
EL 출력 (m.memberfield명 : 자동으로 getter 호출) : ${m.ename}<br>

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
```
### 🔔 <c:if
```jsp
<c:if test="${param.ID == 'hong'}"> <!--    if(id.equals("hong")){      -->
    ${param.ID}<img src="images/1.jpg" style="width: 100px; height: 100px">
</c:if>
```
```jsp
<c:if test="${!empty userpwd}"><!-- 비번이 존재한다면 -->
    <h3>not empty userpwd</h3>
    <c:if test="${userpwd == '1004'}">
        <h3>welcome admin page</h3>
    </c:if>
</c:if>
```
### 🔔 <c:forEach
#### <구구단 5단 출력>
```jsp
<c:forEach var="i" begin="1" end="9">
    <li>5*${i}=${5*i}</li>
</c:forEach>
```
#### <EL & JSTL 구구단 출력하기 (중첩 forEach)>
```jsp
    <table border="1">
    <c:forEach var="i" begin="2" end="9">
        <c:forEach var="j" begin="0" end="9">
            <c:choose>
                <c:when test="${j == 0}">
                    <tr bgcolor="gold"><th>${i}단</th></tr>
                </c:when>
                <c:otherwise>
                    <tr><td>${i}*${j}=${i*j}</td></tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </c:forEach>
    </table>
```
#### <JSTL forEach 사용하기>
```jsp
<%
int[] arr = new int[]{10,20,30,40,50};
for(int i : arr){
out.print("출력값 : <b><i>" + i + "</i></b><br>");
}
%>
```
#### <forEach  속성 활용하기(옵션)>
```jsp
<c:forEach var="i" items="${intarr}" varStatus="status">
    index: ${status.index}&nbsp;&nbsp;&nbsp;
    count: ${status.count}&nbsp;&nbsp;&nbsp;
    value: ${i}<br>
</c:forEach>
```
- value : 값
- index : 위치
- count : forEach문이 돌아간 횟수
<br>

### 🔔 Today's Point
<details>
<summary>코드</summary>
<div>


```jsp
	 <%
	 //우리가 다루는 데이터는 1건 이상
	 //select ... 여러건
	 //public List<Emp> getEmpList(){ .... }
	 //JSP 출력 목적 (게시판 처리)
	 List<Emp> emplist = new ArrayList<>();
	 emplist.add(new Emp(100,"A"));
	 emplist.add(new Emp(200,"B"));
	 emplist.add(new Emp(300,"C"));
	 //3건의 데이터가 ArrayList안에 .... 출력 목적
	 
	 
	 
	 //자바라면
	 for(Emp e : emplist){
		 out.print(e.getEmpno() + " / " + e.getEname() + "<br>");
	 }
	 
	 //UI JSP (EL 하고 JSTL)
	 //1. request 담는다 ... servlet 할 거예요
	 request.setAttribute("list",emplist);
	 
	 //forward 가정하고 
	 //jsp 페이지에서
	 %>
	 <h3>회원데이터 출력하기(EL&JSTL)**********************</h3>
	 <c:set var="elist" value="<%=emplist%>" />
	 <!-- 이미 위에서 request.set 처리했다면 위 코드는 안해도 되요 -->
	 
	 <table border="1">
	 	<tr><td>사번**</td><td>이름**</td></tr>
	 	<c:forEach var="emp" items="${requestScope.list}">
	 		<tr><td>${emp.empno}</td><td>${emp.ename}</td></tr>
	 	</c:forEach>
	 </table>
	 <hr>
	  <table border="1">
	 	<tr><td>사번</td><td>이름</td></tr>
	 	<c:forEach var="emp" items="<%=emplist%>">
	 		<tr><td>${emp.empno}</td><td>${emp.ename}</td></tr>
	 	</c:forEach>
	 </table>
	 
	 <h3>JAVA Map 객체 EL & JSTL 사용해서 출력</h3>
	 <%
	 	Map<String,Object> hm = new HashMap<>();
	 	hm.put("name", "hong");
	 	hm.put("pwd","1004");
	 	hm.put("date",new Date());
	 	
	 	//view
	 	request.setAttribute("hmobj", hm);
	 %>
	 <c:set var="hm" value="<%=hm%>" />
	 <c:forEach var="obj" items="${hm}">
	 	 ${obj.key} -> ${obj.value}<br>
	 </c:forEach>
	 
	 key:name > ${hm.name}<br>
	 key:pwd > ${hm.pwd}<br>
	 key:date > ${hm.date}<br>
	 <hr>
	 
	 <h3>기타 옵션</h3>
	 <h3>JSTL 구분자 기준 처리</h3>
	 <c:forTokens var="token"  items="A.B.C.D" delims=".">
	 	${token}<br>
	 </c:forTokens>
	 
	 
	 <h3>JSTL 복합구분자 기준 처리</h3>
	 <c:forTokens var="token"  items="A.B/C-D" delims="./-">
	 	${token}<br>
	 </c:forTokens>
	 
	 <!--
	 	forEach step = -1
	 	편법
	 	기타
	   -->
	   <c:set var="nownum" value="10" />
	   <c:forEach var="i" begin="0"  end="${nownum}" step="1">
	   		${nownum - i}<br>
	   </c:forEach>
</body>
</html>

```
</div>

# 3. 조별 과제 ✔

### 🔔 [문제1]  
```jsp
String name = request.getParameter("name");
if(name.equals("kglim")){
    out.print("<b>" + name + "</b>");
}else if(name.equals("hong")){
    out.print("<i>" + name + "</i>");
}else{
    out.print("<h3>" + name + "</h3>");
}
out.print("<hr>");

위 코드를 EL 과 JSTL 변환 하세요
```
[내 풀이]    
```jsp
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
```
<br>

### 🔔 [문제2]  
```jsp
subject 다중값을 받아서 choose 구문을 사용하여 값이 하나도 선택되지 않았다면
"선택을 하세요" 라는 문자를 출력하고 
값이 하나라도 넘어 왔다면 ... <ul><li>java-0-1</li><li>jsp-1-2</li></ul> 과 같은 형식으로
출력하도록  forEach 를 작성하세요
추가사항) 출력시  값-index-count 형식으로 나오게 출력하세요
```
```jsp
<form action="Ex08_EL_JSTL_QUIZ.jsp" method="post">
    JAVA:  <input type="checkbox" name="subject" value="java"><br>
    JSP:   <input type="checkbox" name="subject" value="jsp"><br>
    ORACLE:<input type="checkbox" name="subject" value="oracle"><br>
    MYSQL: <input type="checkbox" name="subject" value="mysql"><br>
    <input type="submit" value="전송하기">
</form>

```
[내 풀이]  
```jsp
	 <c:set var="subject" value="${paramValues.subject}"/>
  	 
   	 <c:choose>
	  <c:when test="${subject != null}">
	    <ul>
		  <c:forEach var="i" items="${subject}" varStatus="status">
		     <li>${i}-${status.index}-${status.count}</li>
		  </c:forEach>
	 	</ul>
	  </c:when>
	  <c:otherwise> <p>선택 하세요</p> </c:otherwise>
	 </c:choose>
```
<br>

### 🔔 [문제3]
```jsp
EMP 테이블에서 사원전체 데이터를 출력하는 DTO , DAO 를 작성하세요 (JDBC 참고)
그리고 그 데이터 14건을 
EL & JSTL 을 사용해서 출력하세요
단)부트템플릿 사용하세요]
```
[내 풀이]    
```jsp
<c:set var="e" value="${requestScope.e}"></c:set>
<c:forEach var="emp" items="${emplist} ">
    ${e}
</c:forEach>
```


