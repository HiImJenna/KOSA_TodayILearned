# 2022.11.03. TUR 📅
----------------
<br>

## 1. jQuery - DyTag_Add ✔
```javascript
$(function(){
    // $('#sdata').change(function(){ //시점의 이벤트 연결이 안됨
    //     alert("이벤트 처리");
    // });
    $(document).on('change', '#sdata', function(){
        alert("이벤트 처리");
    });
    //특정이벤트를 실행할때 순간 객체를 찾아서 연결 메서드를..
});
```
<hr>

```javascript
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

    <script>
        $(function(){
            // $('#sdata').change(function(){ //시점의 이벤트 연결이 안됨
            //     alert("이벤트 처리");
            // });
            $(document).on('change', '#sdata', function(){
                alert("이벤트 처리");
            });
            //특정이벤트를 실행할때 순간 객체를 찾아서 연결
        });

        function appendElement() {
            let html = "";
            html += "<select id = 'sdata'>";
                html += "<option>data_1</option>";
                html += "<option>data_2</option>";
                html += "<option>data_3</option>";
                html += "<option>data_4</option>";
            html += "</select>";

            $('#parent').empty(); //remove(자기 자신 삭제)
            $('#parent').append(html); 
        }

    </script>
</head>
<body>
    <div id="parent"></div>
    <button onclick="appendElement()">Append</button>
</body>
</html>
```
<br>

## 2. jQuery - AJAX ✔
- https://api.jquery.com/category/ajax/
- https://www.w3schools.com/jquery/jquery_ajax_intro.asp
- Jquery 비동기 함수는 내부적으로 XmlHttpRequest 객체를 사용
<br>

### 🔔 Ajax
- Global Ajax Event Handlers  (10%)
- Helper Functions (10%)
- Low-Level Interface : 30% (모든 옵션을 개발자 제어) >> $.ajax()
- Shorthand Methods   : 50% (기본 옵션을 가지고 있는 함수) >> load() , get()
<br>

### 🔔 .load() 방식 (Shorthand Methods)
```javascript
$( "#x" ).load( "y.html");
```
- #x에 y.html을 비동기로 불러오겠다
<br>

```javascript
$( "#x" ).load( "y.html"), function() {
}
```
- callback 함수
<br>

```javascript
$(function(){
    $('btn').click(function(){
        //비동기 서버에 요청
        //Jquery > .load함수
        //Ex01_Server_Date.jsp?msg=hello
        $('#display').load("Ex01_Server_Date.jsp", {"msg":$('#msg2').val()},
                function(responceText, textStatus, xhr){
                //함수는 응답이 오면 자동 호출 > readyState > 4번이라면
                //responseText > 서버가 응답한 결과물 (html or text)
                // textStatus (성공(success), 실패(fail))
        });
    });
});
```
- msg2에 입력한 값을 .val()으로 read 해서 msg에 넣어준다.
<br>

### 🔔 $.ajax() 방식 (Low-Level Interface)
```javascript
$(function(){
    $('#message').click(function(){
        //비동기 함수 호출
        $.ajax(
            {
                url:"Ex02_Server_menu.html",
                dataType:"html", //서버가 클라이언트에 응답하는 데이터는 순수한 html형식
                success:function(responsetext){//응답이 왔고 .. 그 응답이 정상건이라면 자동호출 콜백
                    $('#menudiv').html($(responsetext).find('li'));   
                }
            }         
        );
    });
});
```
- message 클릭시
- 불러올 파일 url으로 적고
- 그 파일의 확장자를 dataType
- responseText에 그 파일에 있는 값들을 넣어서, find('li')로 li만 골라서 menudiv에 넣어준다.






## 3. jQuery - Shorthand Methods ✔
### 🔔 $.get()
- The $.get() method loads data from the server using a HTTP GET request.
- HTTP GET 요청을 하여 서버로부터 데이터를 로드 한다.
```javascript
$.get(
    "Ex04_Company.xml",
    function (data) { // 응답이 왔고.. 그 응답이 정상
        // 정상이라면
        console.log(data);
        $('#display').empty();
        //console.log($(data).find('Company'));
        //return Array
        // 여러개 $.each() $().each
        $(data).find('Company').each(function(){
            console.log("this : " + this);
            console.log(this);
            let entry = $(this);
            let html = "<div>" + entry.attr('CompanyType') + "</div>";
                html += "<div>" + entry.find('CompanyName').text() + "</div>";
                html += "<div>" + entry.find('CompanyNumber').text() + "</div>";
                html += "<div>" + entry.find('CompanyAddress').text() + "</div>";
                html += "<div>" + entry.find('Name').text() + "</div>";
            $('#display').append(html);
        })
    }
)
```
#### [xml]  
```xml
<Companys>
	<Company CompanyType="private">
		<CompanyName>Bit</CompanyName>
		<CompanyNumber>2019</CompanyNumber>
		<CompanyAddress>서울시 서초구</CompanyAddress>
		<Name></Name>
	</Company>
	<Company CompanyType="crop">
		<CompanyName>kakaT</CompanyName>
		<CompanyNumber>2020</CompanyNumber>
		<CompanyAddress>제주 서귀포시</CompanyAddress>
		<Name></Name>
	</Company>
</Companys>
```
- $.get( "Ex04_Company.xml", : "Ex04_Company.xml" 값을 요청해서 받아와서 function (data)의 data에 저장한다.
-  $(data).find('Company').each(function(){ : 그 data에서 'Company'를 찾아서 for문처럼 돌면서 ...
- let entry = $(this); : 여기서 this는 data, 이 값을 entry에 저장
- let html = "div" + entry.attr('CompanyType') + "/div"; : CompanyType은 속성이기에 attr으로 가져와야 출력이 됨!!
- $('#display').append(html); : display에 let html append 해준다.
<br>

### 🔔 $.post()
- The $.post() method loads data from the server using a HTTP POST request.
- HTTP POST 요청을 하여 서버로부터 데이터를 로드 한다.
- 전송할 데이터를 정의하는 부분을 제외하고 $.get() 방식과 동일하다.
```javascript
$(function(){
    $('#btn').click(function(){
    const data = {"name":$('#name').val(), "pwd":$('#pwd').val()}
    $.post("Ex05_Server.jsp", data, function(responsedata){
        //응답이 왔고 정상건이라면
        $('#message').html(responsedata);
    });
    });
});
```
- const data = {"name":$('#name').val(), "pwd":$('#pwd').val()} : name과 pwd에 값을 읽어서 넣고, 그 값들을 data에 저장
<br>

### 🔔 $..getJSON()
- The getJSON() method is used to get JSON data using an AJAX HTTP GET request.
- jQuery.getJSON( url [, data ] [, success ] )
```javascript
$(selector).getJSON(url,data,success(data,status,xhr))
```
```javascript
$(function(){
    //jQuery.getJSON( url [, data ] [, success ] )
    //기본 옵션 : dataType >> JSON 설정되어 있어요
    //dataType:"JSON", 
    $('#btn .btnload').click(function(){
        $.getJSON("Ex06_json.json",function(data){
            //응답이 왔고 응답이 정상이라면
            console.log(data);
            //$.each(data,function(index ,obj){
                    //마음대로 가공
            //})
        });
    });
});
```
#### [json]  
```json
[
    {"num":"1","Name":"hong"},
    {"num":"2","Name":"kim"},
    {"num":"3","Name":"park"},
    {"num":"","Name":"you"}
 ]
```

- Ex06_json.json을 data에 넣어서...
- get과 같지만 html이 아닌 json을 가져올때 사용하는 함수! 라고 나는 이해했다.







