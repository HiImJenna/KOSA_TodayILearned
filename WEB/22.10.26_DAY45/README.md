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
