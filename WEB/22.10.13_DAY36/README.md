# 2022.10.13. THU 📅
----------------
<br>

## 1. Javascript - Function ✔
### 🔔 eval ()
- 문자형 수식 > 계산식으로 >> "10+20+30" >> eval() >> 10+20+30 >> 계산
- "10+20+30" >> Error
- 문자형 숫자 -> 숫자
```js
document.write("eval()" + eval(str) + "<br>");
```
<br>

### 🔔 isNaN ()
- Not a Number
- 너 숫자 아니니 > true > false(숫자)
```js
document.write(isNaN("12345") + "<br>"); //false
document.write(isNaN("12345A") + "<br>"); //true
document.write(isNaN("대한민국") + "<br>"); //true
document.write(isNaN('12345') + "<br>"); //false
```
<br>

### 🔔 문자열 함수 refer
- https://www.w3schools.com/js/js_string_methods.asp
<br>

### 🔔 숫자 함수(Number)
- https://www.w3schools.com/js/js_number_methods.asp
<br>

## 2. Event ✔
- onchange : An HTML element has been changed
- onclick : The user clicks an HTML element
- onmouseover : The user moves the mouse over an HTML element
- onmouseout : The user moves the mouse away from an HTML element
- onkeydown : The user pushes a keyboard key
- onload : The browser has finished loading the page
```js
      function bodyload(){
         console.log("load");
         //보장을 받는다
         //******body안에 있는 모든 요소를 가지고 놀 수 있다.
         let data = document.myform.money.value;
         console.log(isNaN(data));         
      }
      
      function focusFunc(){
         document.getElementById("myinput").style.background="gold";
      }
      
      function blurFunc(){
         document.getElementById("myinput").style.background="white";
      }
      
      function selectTag(){
         let value = document.myform.sel.value;
         alert(value);
      }

      function changeColor(obj){
        //JAVA : this (객체자신)
        //JavaScript : this (POINT) (자신:요소자신)
        console.log(obj); //<input type="text" onmouseover="changeColor(this)"
        obj.style.backgroundColor="gold";

      }

      function changeColor2(obj){
        //JAVA : this (객체자신)
        //JavaScript : this (POINT) (자신:요소자신)
        console.log(obj); //<input type="text" onmouseover="changeColor(this)"
        obj.style.backgroundColor="white";
        
      }

   </script>
</head>
<body onload="bodyload()">
   <form action="#" name="myform">
      <input type="text" id="myinput" name="myinput" onfocus="focusFunc()" onblur="blurFunc()">
      <br>
      <select name="sel" onchange="selectTag()">
         <option value="A">AA</option>
         <option value="B">BB</option>
         <option value="C">CC</option>
         <option value="D">DD</option>
      </select>
      <br>
      <input type="text" onmouseover="changeColor(this)" onmouseout="changeColor2(this)">
      <br>
      <input type="text">
      <br>
      <input type="text" value="1000" name="money">
   </form>
</body>
```
<br>

## 3. Javascript - 내장 객체
### 🔔 Date()
```js
 let today = new Date();
console.log(today);
console.log(today.getFullYear());
console.log(today.getMonth() + 1);
console.log(today.getDate());
console.log(today.getHours());
console.log(today.getMinutes());
console.log(today.getSeconds());
```
<br>

```js
console.log(Math.random()); //0<=범위<1
console.log(parseInt(Math.random)*45 + 1);
```
<br>

```js
console.log(Math.random(3.5678)); //4 반올림
console.log(Math.max(3, 8, 99, 55, 10));
```
<br>

### 🔔 write()
```js
with(document){
write(str + "<br>");
write(str.lenth+"<br>");
write(str.charAt(2)+"<br>");
write(str.indexOf("D")+"<br>");
write(str.concat("홍길동")+"<br>")
}
```
<br>

#### - 문자열함수
- substring(start, end)
```js
//str="ABCDE"
write(Str.substring(2,4)+"<br>"); //CD
write(Str.substring(1,1)+"<br>"); //
write(Str.substring(1,2)+"<br>"); //자기자신 B
write(Str.substring(2,4)+"<br>"); //BCDEF
```
-  split(" ")
```js
let strarr = "A B C D";
let arr = strarr.split(" ");
write(arr); //toString() 재정의 -> javascript Array가
```