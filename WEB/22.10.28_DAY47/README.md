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

## 1. EMP 과제 refactoring ✔
### 🔔 1. DAO, DTO, 기존 부트스트랩 자료 등등을 새로운 Dynamic Web Project에 세팅해줌
![image](https://user-images.githubusercontent.com/111114507/198530203-31f8b0e2-f675-4164-bb36-0925bb5a2bfe.png)
<br>

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

### < 비동기 - window.onload = function() >
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

### < 비동기 - function handlerStateChange() >
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
- <p id="EMP"></p>
- 두 코드의 연관성을 잘 모르겠음..
<br>

### < 비동기 - function sendData(data) >
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

