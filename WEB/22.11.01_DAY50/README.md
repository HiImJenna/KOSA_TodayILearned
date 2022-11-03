# 2022.11.02. WED 📅
----------------
<br>

## 1. jQuery Intro ✔
- jQuery is a JavaScript Library.
- jQuery greatly simplifies JavaScript programming.
- jQuery is easy to learn.
- The jQuery library contains the following features : 

```
- HTML/DOM manipulation
- CSS manipulation
- HTML event methods
- Effects and animations
- AJAX
- Utilities
```

1. jquery.com 공식사이트(버전 다운로드 , 학습(API))
2. https://www.w3schools.com/jquery/default.asp
3. Jquery
- HTML/DOM manipulation (추가 , 변경 , 삭제)
- CSS manipulation
- HTML event methods
- Effects and animations
- AJAX  (비동기 처리 ^^)
- Utilities
4. Jquery(Javascript 라이브러리 (함수의 집합)) >> *.js 배포
- <jquery 사용방법> : js 파일만 배포 .....

```
- 다운로드 받아서 내 서버에서 배포 (소스 수정, 추가 )(281kb)  
- Download the uncompressed, development jQuery 3.5.1   
- 편집하지 않고 배포 (88kb)  
- Download the compressed, production jQuery 3.5.1  
- CDN 방식(링크만 걸어서 외부사이트(글로벌) 배포 권장)
- 안정적인 다운로드 제공
```

5. jquery version (웹 브라우져 호환성 지원)
1.3.x ~ 3.5.x  
1.x.x ~ 3.x.x  
3.x : 현재 사용 (기존 필요없는 것은 제거 , 새로운 것은 추가)  
- 회사 (1.x 버전 개발 ....... >> 사장님 3.x)
- 문제는 기존 소스가 1.x 버전에 있는 함수(add() ) ->> 3.x *(add() 삭제 addOn() )
- 코드 add() . add() >> 3.x >> 해결 >> 소스에 있는 add() >> addOn()
- migrate : 하위 버전 호완성 (사라진 자원) >> add()
Download the compressed, production jQuery Migrate 1.4.1
<br>

```javascript
/*
window.onload=function(){
    document.getElementById("btn").onclick=function() {
        alert("DOM Script");
    }
}
*/

$(document).ready(function() {
    $('#btn').click(function() {
        $(this).hide(); //button 감추기
    });
});
```
<br>

## 2. jQuery Selector ✔
```javascript
//선택자
//https://api.jquery.com/ 사이트에서 API 검색하고 찾아서 사용
$('body > *').css("color", "gold"); //자식 선택자
$('div > *').css('color','red'); //div 자식 요소
$('input[type=text]').css("color", "green"); //속성 선택자
/*
DOM script : text, value (innerHtml,innerText)

jQuery
3개함수 (val(), text(), html()) > 값을 read, write > getter, setter
ex) val('홍길동') > write(setter)
ex) val() > read(getter)

jQuery id 활용
<input type="text" id="userid" value="aaa">
>> $('#userid').val() >> aaa 값을 받을 수 있다

<input type="text" id="userid" value="aaa">
>> $('#userid').val("bbb") >> id="userid" value="bbb">

DOM > document.getElementById("userid") value="id">

*/
```
<br>

### 🔔 read
- 처음 만나는 요소
```javascript
console.log($('input[type=text]').val());
```
<br>

### 🔔 write
- 모든 요소 적용 가능
```javascript
$('input[type=text').val("hong");

$('input[type=password').val("11111"); //모든 요소에 적용

$('tr:odd').css("background", "gray"); //1,3,5 //tr:odd - > 홀수적용
$('tr:even').css("background", "pink"); //0,2,4 //tr:even -> 짝수적용
```
<br>

### 🔔 jQuery하고 javascript 같이 사용
```javascript
setTimeout(function(){
    let value = $('select > option:selected').val();
    alert("select tag value : " + value);
    
}, 3000) //3000 = 3초
```
<br>

[화면]  
![image](https://user-images.githubusercontent.com/111114507/199448862-ff7c864a-b917-4f99-9bff-b7a83e2374d4.png)
<br>

## 3. jQuery Event ✔
<details>
<summary>code</summary>

```javascript
    <script>
      $(function () {
        $('#btncopy').click(function(){
         // let data= $('#txtuserid').val();
          // $('#txtcopyuserid').val(data);
          $('#txtcopyuserid').val($('#txtuserid').val());
        });
        //select 태그
        $('#select_hobby').change(function(){//값의 변화가 일어나면
          const text=$(':selected').text();
          console.log(text);
  
          const text2=$('#select_hobby option:selected').text();
          console.log(text2);
  
          const val=$('#select_hobby').val(); //value 없는 경우 text value 값으로
          console.log(val);
        });

        $('#txtpwd2').keyup(function(){
            if($('#txtpwd').val() != $('#txtpwd2').val()) {
                //div p 태그 : innerText, innerHTML
                $('#message').text("<h3>암호가 일치하지 않습니다</h3>") //텍스트 그대로 전달
            } else{
                $('#message').html("<h3>암호가 일치합니다</h3>") //코드 적용
            }
        });
      });
  
    </script>
```
</details>

- .text()와 .html() 차이 
![image](https://user-images.githubusercontent.com/111114507/199377002-eb503342-af54-4b94-a70c-0dd0900eee62.png)     
![image](https://user-images.githubusercontent.com/111114507/199377098-f8ea7419-81e2-4868-ac5b-0564f7a1578e.png)     
<br>

### 🔔 Quiz

```
- body 안에 있는 모든 input 태그 focus가 오면 input 태그 background-color gray
- body 안에 있는 모든 input 태그 blur가 오면 input 태그 background-color white
```

```javascript
$('input').focus(function(){ //커서가 들어왔을 때
    console.log(this); //$(this).action()
    $(this).css('background-color', 'gray')
});

$('input').blur(function(){ //커서가 나갔을 때
    console.log(this); //$(this).action()
    $(this).css('background-color', 'pink')
});
```
- focus : 커서가 올라갔을 때
- blur : 커서 나갔을 떄
![image](https://user-images.githubusercontent.com/111114507/199378020-ae3e223d-bdef-4684-8d84-fff7eaf559e4.png)  
<br>

## 4. jQuery method ✔

## 5. jQuery content ✔

## 6. jQuery Form ✔
```javascript
<script type="text/javascript">
$(function(){
    //Form 안에 요소들을 jQuery
    $('#txtname').val("hong");
    console.log( $('#txtname').val());

    //1. radio 기본 값 설정하기 (checked) 속성
    $("input:radio").val(['F']); //F 값을 가진 요소 checked

    console.log($('input:radio').val()); 
    console.log($('input:checked').val());

});
</script>
```
- radio name값이 똑같으니까 배열로 생각해서 []안에 넣어줘야함
- 여러개의 radio가 checked 되어있으면 처음 만나는 것으로 뜸
- 🔔 그렇다면 여러개의 radio 있을땐?
```javascript
console.log($('input:radio[name=gender]:checked'))
```
<br>

### 🔔 Quiz

```
btnok 클릭했을 떄,
isF2 태그에 선택된 요소의 값들을 모두 출력 (hint : array)
```

```javascript
<script>
console.log(data);
$('#btnok').click(function(){
    const data = $('#isF2').val();
    console.log(data);
    for(let index in data){
    console.log("value : " + data[index]);
    }
}
</script>

```
