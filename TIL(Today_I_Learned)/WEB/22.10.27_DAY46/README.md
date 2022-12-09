# 2022.10.27. THU 📅
----------------
<br>

## 1. JSTL ✔
### 🔔 fmt
```jsp
<body>
 <h3>숫자관련</h3>
 변수선언 : <c:set var="price" value="1000000"></c:set><br>
 변수값 출력:${price}<br>
 
 <fmt:formatNumber value="${price}" type="number" /><br>
 <fmt:formatNumber value="50000000" type="currency" currencySymbol="$" /><br>
 <fmt:formatNumber value="0.13"     type="percent"/>
 변수에 설정 <br>
 <fmt:formatNumber value="123456789" pattern="###,###,###" var="pdata" />
 변수에 설정한 값 : ${pdata}<br>
 
 <hr>
 <h3>날짜 관련 format</h3>
 변수선언 : <c:set var="now" value="<%= new Date() %>" /><br>
 변수값 : ${now}<br>
 Basic Date : <fmt:formatDate value="${now}" type="date" /><br>
 DateStyle(full) : <fmt:formatDate value="${now}" type="date" dateStyle="full" /><br>
 DateStyle(short) : <fmt:formatDate value="${now}" type="date" dateStyle="short" /><br>
 시간:<fmt:formatDate value="${now}" type="time"/><br>
 날짜 + 시간:<fmt:formatDate value="${now}" type="both"/><br>
 혼합:<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br>
    혼합2:<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short" /><br>
</body>

```
<br>

### 🔔 function
```jsp
<body>
<!--  
https://www.hscripts.com/tutorials/jsp/jstltags/function-tag.php
-->
<c:set var="str" value="oracle" />
변수값 출력: ${str}<br>

<h3>함수 적용({안에서})</h3>
대문자 : ${fn:toUpperCase(str)}<br>
문자열길이 : ${fn:length(str)}<br>
치환 : ${fn:replace(str,'a','AAAA')}<br>
</body>
```
## 2. 비동기 ✔
- Read data from a web server - after the page has loaded
- Update a web page without reloading the page
- Send data to a web server - in the background
