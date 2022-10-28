# 2022.10.27. THU 📅
----------------
<br>

## 1. EMP 과제  ✔
### [문제]  
```
ajax : Ex06_Emp_Search를 통해서 사번을 제공해서 비동기 UI 디자인된 페이지를 받아서 화면에 출력

1. EmpSearch.jsp(비동기로 요청 보냄) -> servlet -> forward(ui.jsp) -> 비동기 responseText -> EmpSea
```
### [결과]  
- 조회 전!
![image](https://user-images.githubusercontent.com/111114507/198520206-6d49d4ab-90a2-4d9a-a249-9d1c4aa70d49.png)
<br>

- 조회 후!
![image](https://user-images.githubusercontent.com/111114507/198528319-6fd15d6e-a236-4629-a6e9-2f8aa0d844b8.png)
<br>

## 2. EMP 과제 refactoring ✔
### 🔔 1. DAO, DTO, 기존 부트스트랩 자료 등등을 새로운 Dynamic Web Project에 세팅해줌
![image](https://user-images.githubusercontent.com/111114507/198530203-31f8b0e2-f675-4164-bb36-0925bb5a2bfe.png)
<br>

<br>

<hr>

### 🔔 2. Main 파일 작업
<details>
<summary>Main code</summary>

```jsp
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Team Enjo2!!</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/style.css" rel="stylesheet" />
        
        <script type="text/javascript">

            window.onload = function(){
                    document.getElementById("submit").addEventListener("click",function(){
                        let data = document.getElementById("submit").value;
                        sendData(data);
                    });
            }

            let httpReq=null;
            
            function getInstance(){
                    if(window.XMLHttpRequest){
                        httpReq = new XMLHttpRequest();
                    }else if(window.ActiveXObject){
                        httpReq = new ActiveXObject("Msxml2.XMLHTTP");
                    }else{
                        throw new Error("AJAX 지원하지 않습니다"); 
                    }
                return httpReq;  
            }
            
            
            function handlerStateChange(){
                    if(httpReq.readyState == 4){
                        if(httpReq.status >= 200 && httpReq.status < 300){
                            document.getElementById("EMP").innerHTML = httpReq.responseText;
                        }
                    }
            }
            
            
            function sendData(data){
                httpReq = getInstance();
                httpReq.onreadystatechange = handlerStateChange;  // x >> ()
                httpReq.open("POST","Servlet?EMP=" + data); //<form 태그 구성 method=  action=
                httpReq.send(); // form submit 버튼 클릭
            }
            
        </script>
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <!-- ********* Sidebar *********-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">Menu</div>
                <jsp:include page="/Team2_Module/left.jsp"></jsp:include>
            </div>
            
            <!-- ****************** Page content wrapper ******************-->
            <div id="page-content-wrapper">
            
                <!-- ********* Top navigation *********-->
	             <jsp:include page="/Team2_Module/top.jsp"></jsp:include>
	             <jsp:include page="/Team2_Module/main.jsp"></jsp:include>  
	             <p id="EMP"></p>
	             
	             <!--********* EMP 전체조회하기 *********-->
	             <div style="background-color: white;">
	             <input type = "submit" id= "submit" value="Click me!">
	             
                </div>
            </div>
        </div>
```
</details>

- 처음에는 EMP 목록을 top에 생성해서 클릭시 비동기로 데이터를 불러오려 했지만 번거로운 것 같아, bootstrap 메인 소스에 바로 비동기 소스를 가져와서 가공했음!
<br>

### < window.onload = function() >
[before]  
```javascript
window.onload = function(){
    document.getElementById("submit").addEventListener("click",function(){
        let data = document.getElementById("submit").value;
        sendData(data);
    });
}
```
▶data를 받아오는게 없음, 전체조회이기 때문에 click 액션이 전부
<br>

[after]
```javascript
window.onload = function(){
    document.getElementById("submit").addEventListener("click",function(){
    sendData();
    });
}
```
- input 태그에서 id = "submit"으로 지정했기에, 그 input 태그가 "click" 되었을 때 sendData() 실행
- data 받아오는 액션이 있을 때(검색, 옵션 선택 등등)에는 [before]처럼 .value, data 받기를 해주는 코드가 필요함
<br>

### < function handlerStateChange() >
```javascript
function handlerStateChange(){
    if(httpReq.readyState == 4){
        if(httpReq.status >= 200 && httpReq.status < 300){
            document.getElementById("EMP").innerHTML = httpReq.responseText;
        }
    }
}
```
```javascript
<!-- ********* Top navigation *********-->
    <jsp:include page="/Team2_Module/top.jsp"></jsp:include>
    <jsp:include page="/Team2_Module/main.jsp"></jsp:include>  
    <p id="EMP"></p>
```
- document.getElementById("EMP").innerHTML = httpReq.responseText;
- "<p id="EMP"></p>"
- httpReq.responseText : 화면에 출력되는 모든 텍스트 (${})를 낚아채서 여기에 저장.
- 그 저장한 텍스트들을 "EMP"에 저장하고, 그것의 innerHTML 속성값을 httpReq.responseText 값으로 덮어씌움
- 그래서 p 태그에 아이디값으로 EMP 묶어줘서 출력할 수 있게 -> p 뿐이 아니라 다른것도 적용 가능!!
<br>

### < function sendData(data) >
[before]  
```javascript
httpReq = getInstance();
httpReq.onreadystatechange = handlerStateChange;  // x >> ()
httpReq.open("POST","Servlet?EMP=" + data); //<form 태그 구성 method=  action=
httpReq.send(); // form submit 버튼 클릭
```
▶ < 비동기 - window.onload = function() >에서와 같은 이유로 받아오는 data가 없다는점 파악
<br>

[after]
```javascript
function sendData(){
    httpReq = getInstance();
    httpReq.onreadystatechange = handlerStateChange;  // x >> ()
    httpReq.open("POST","Servlet"); //<form 태그 구성 method=  action=
    httpReq.send(); // form submit 버튼 클릭
}
```
- parameter 없애주기
- "Servlet?EMP=" + data => 마찬가지인 이유로 전체조회이기에 필요 없음
<br>

<br>

<hr>


### 🔔 3. Servlet 파일 작업
<details>
<summary>Servlet code</summary>

```java
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmpDAO;
import DTO.Emp;
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response , String method) throws ServletException, IOException {
    	//1. 한글처리
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8"); // 클라언트에게 전달한 페이지의 정보 구성
        PrintWriter out = response.getWriter();
        
    	//2. 요청받기 (데이터) request
    	String data = request.getParameter("EMP");
    	System.out.println(data);
    	
    	//->여기 필요 없어짐
    	
    	//3. 요청판단
		 String msg="";

		 //java 파일 용이 (DAO , DTO)
		 EmpDAO edao = new EmpDAO();
		 Emp emp = new Emp();
		 
		 
		 List<Emp> list = edao.getEmpAllList();
		 System.out.println(list);

		//4. 데이터 저장
		 request.setAttribute("emplist", list);
		 
		//5. view 페이지 설정
		//뷰 지정하기 (Dispatcher)
		RequestDispatcher dis = request.getRequestDispatcher("/Team2_Main_EMP.jsp");
		 
		 
		//6. view 데이터 전달(forward)
		 dis.forward(request, response);

		 }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "POST");
	}

}
```
</details>
<br>

### < doProcess(...) >
[before]
```java
//2. 요청받기 (데이터) request
String data = request.getParameter("EMP");
System.out.println(data);
 ```

 [after]
 ```java
 아예 필요가 없어짐!
 ```
- 비동기의 function sendData(data)에서 'httpReq.open("POST","Servlet?EMP=" + data);'을 'httpReq.open("POST","Servlet");'으로 수정하며 'EMP'를 뺐기에 요청받을 데이터가 사라짐
<br>


```java
//3. 요청판단
    String msg="";
    //java 파일 용이 (DAO , DTO)
    EmpDAO edao = new EmpDAO();
    Emp emp = new Emp();
    
    List<Emp> list = edao.getEmpAllList();
    System.out.println(list);

//4. 데이터 저장
    request.setAttribute("emplist", list);
```
- 3번에서 DAO, DTO를 생성해서 SQL에 있는 EMP 테이블 불러옴
- 그 다음 DAO에 있던 getEmpAllList()를 통해 전체 리스트 데이터를 'list'에 저장
- 3번에서 생성된 'list'를 setAttribute로 "emplist"에 저장시켜줌
<br>

```java
//5. view 페이지 설정
//뷰 지정하기 (Dispatcher)
RequestDispatcher dis = request.getRequestDispatcher("/Team2_Main_EMP.jsp");
```
- 화면에 띄워줄 파일 'Team2_Main_EMP.jsp' 을 생성하고 Dispatcher으로 연결해줌
<br>

<br>

<hr>

### 🔔 4. Team_Main_EMP 파일 작업
<details>
<summary>Team_Main_EMP</summary>

```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
  <thead>
    <tr>
      <th scope="col">empno</th>
      <th scope="col">ename</th>
      <th scope="col">job</th>
      <th scope="col">mgr</th>
      <th scope="col">hiredate</th>
      <th scope="col">sal</th>
      <th scope="col">comm</th>
      <th scope="col">deptno</th>
    </tr>
  </thead>
  
  <tbody>
  <c:forEach var="emplist" items="${emplist}" varStatus="status">
    <tr>
        <td>${emplist.empno }</td>
        <td>${emplist.ename }</td>
        <td>${emplist.job }</td>
        <td>${emplist.mgr }</td>
        <td>${emplist.hiredate }</td>
        <td>${emplist.sal }</td>
        <td>${emplist.comm }</td>
        <td>${emplist.deptno }</td>
    </tr>

  </c:forEach>
  </tbody>
</table>
```
</details>
- <c:forEach>로 배열을 돌면서 출력하도록!