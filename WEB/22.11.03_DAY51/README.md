# 2022.11.03. TUR 📅
----------------
<br>

## 1. jQuery DyTag_Add ✔
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

## 2. jQuery AJAX ✔
- https://api.jquery.com/category/ajax/
- https://www.w3schools.com/jquery/jquery_ajax_intro.asp
- Jquery 비동기 함수는 내부적으로 XmlHttpRequest 객체를 사용
<br>

### 🔔 Ajax
- Global Ajax Event Handlers  (10%)
- Helper Functions (10%)
- Low-Level Interface : 30% (모든 옵션을 개발자 제어) >> $.ajax()
- Shorthand Methods   : 50% (기본 옵션을 가지고 있는 함수) >> load() , get()




