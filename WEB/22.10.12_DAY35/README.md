# 2022.10.12. WED 📅
----------------
<br>

## 1. Javascript ✔
-  Web > 해석 실행 > 웹 브라우져(해석기:엔진) > 라인단위(순서) 실행
- 객체지향언어 > class 개념 > 상속 , 다형성, 재사용성 ....
<br>

### 🔔 Why Study JavaScript❓
- HTML to define the content of web page
- CSS to specify the layout of web pages
- JavaScript to program the behavior of web pages
<br>

### 🔔 <Javascript 사용>
- html 의 content , attribute 변경 , 삭제 , 추가 [동적]으로
- css 속성 변경 , 삭제 , 추가 [동적]으로
- 유효성 검증 (id 입력, 주민번호 맞는지 , 데이터 숫자 ...검증)
- 동적인 웹 화면 구성 (화면구성)
- 전 세계적으로 1위 언어
- 신규 : vue.js , react.js (Front) 단점: 버전변경 .... 사라질 수 도 있다
- Front 최소 : vue.js 또는 react.js 
- 웹 브라우져 없이 로컬 서버에서 동작 (마치 java 처럼)
- Node.js®는 Chrome V8 JavaScript 엔진으로 빌드된 JavaScript 런타임
- back 단의 코드 javascript 대체 >> 서브 (채팅 서버, 보조 서버) >> npm 학습
<br>

### 🔔 <Javascript 문법> 
- 대소문자를 엄격하게 구분
- 종결자 ;
- 타입(var , const , let) : let i="A"; let s = "aaa"; const NUM=100;   
     ex) int i =10; double d = 3.14;   
- 연산자 , 제어문(java 동일) , 객체 
- 사용법 (css 사용법과 동일)
- 1)in-line (태그 안쪽에 : <p onclick="<script>...")
- 2)internal(page 안에서 일반적으로 <head><script> ...코드</head>)
- 3) external(외부 파일 :common.js >> link 방식) 선호 (유지보수 , 재사용)
<br>

### 🔔 window.document
![image](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fvb9rz%2FbtraHYSvo8t%2FDqbwzXomWdckBw47UfPNmk%2Fimg.png)  

- window.document.write : 화면에 입력
- document.write : 앞에 window는 생략해도 ok
```js
 //javascript 해석 > 웹 브라우저 (해석 + 내장객체 제공)
//내장객체(자원들) >> window 객체

window.document.write("방가방가<br>");

//window 객체 생략
document.write("window객체 생략 가능<br>");

console.log("디버깅, 결과미리보기, 오류메세지 확인");
console.log(10+10);

document.write("<b>hello world</b>");
document.write('<table border="1">');
document.write('<tr><td>aa</td></tr><tr><td>bb</td></tr>')
document.write('</table>')

```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/195234657-d10e8a9d-dea6-4ffb-84c5-3d4e51f18705.png)

## 2. Javascript 변수 ✔
### 1) 변수 생성
- var a; 정의 되지 x
- let b; 정의 되지 x
- a = 10; 타입설정 (num)
- b = "A" 타입설정 (String)
- Es5 이전 문법 (var) >> 2015 Es6(ECMA) let, const
- let name = "kglim"; 페이지 전체(global : 전역)
- 함수 안에 있는 let age=20; 함수 안에 유효 (local : 지역)
```js
let n; //초기화가 되어있지 않아요 (타입이 없어요)
console.log(n); //undefined
n = 100;
//****javascript는 전역, 지역변수를 초기화하고 사용하자 ****//
let i,j;
i = 200;
j = 300;
let result = i + j;


console.log(result);

let intnum = 100; //정수
let dnum = 12.345 //실수
let flag = true; //boolean
let str = null; //값이 없다
let str2 = "ABC"; //문자열

console.log(typeof(intnum));
console.log(typeof(dnum));
console.log(typeof(flag));
console.log(typeof(str));
console.log(typeof(str2));

```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/195242058-d4bdcaa1-a956-4b60-83cb-7b59123b03e4.png)

```js
var num; //타입이 정해지지 않아요 (정수, 문자, 날짜 올 수 있음)
console.log(num); //undefined 정상 출력 ... 정의되지 않았음
num = 10; //값을 가지는 순간 내부적으로 타입 결정
console.log("num : " + num);

let num2 = 100;
console.log(num2);
console.log(typeof(num)); //number
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/195233200-a5da9ecd-8dbc-403f-8190-67d3e833e964.png)  
<br>


## 3. Javascript - DOM script  ✔
![image](http://www.tcpschool.com/lectures/img_js_htmldom.png)
```js
문서가 실행되면 ... 웹 브라우저 메모리에 body 안에 요소가 로딩 ...
메모리에 DOM tree 형태로... 필요에 따라서 접근
DOM
html
|
head - body

DOM script : getElementById
```
<br>

## 4. JavaScript - 연산자
#### 1) 산술 (+,-,/,%)
```js
 let num1=10;
let num2=3;
document.write(num1/num2+"<br>");//실수
document.write(num1%num2+"<br>");//나머지
```
#### 2) 관계 == (===(값과 타입 비교), !=, >= ... )
```js
let a = 3;
let b = 5;
console.log(a==b)
console.log(a!=b)
console.log(a>b)
```
#### 3) 논리 (&&, ||)
```js
console.log((10>5)&&(1!=3));
console.log((10>5)||(1!=3));
```
#### 4) 삼항
```js
let result2 = (4%2 == 0) ? "짝수" : "홀수";
console.log(result2);
```
#### 5) 대입 연산자 (+=, -=, *=, /=)
```js
let p = 10;
let k = 5;
p += k;
console.log(p);

let x = 5+5;
let y ="5" + 5; //+ (산술, 결합)
console.log(x);
console.log(y);

let v = "5";
let v2 = 5;
let v3 = 5;
console.log(v==v2) //== : 값을 비교하는 연산자
console.log(v===v2) //=== : 값만 같은 것이 아니라 타입도 동일
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/195259378-05694a44-9f38-4693-b8ba-3a6087d8cd91.png)
<br>

## 5. JavaScript - function ✔
```js
/*
< JAVA >
public void print(){}
public String print() {return ""}
public int print(int num, int num2){return num + num2}

< JS >
function 함수명 () {}
void(x), return type(x)
*/
function callConfirm(){ //사용자 정의함수
    if(window.confirm("삭제하시겠습니까")){ //confirm() 내장함수 return true or false
        alert("네");
    } else {
        alert("아니오")
    }
    }
</script>
</head>
<body>
<hr3>내장함수, 사용자 정의 함수</hr3>
<button onclick="">클릭 사건 발생(함수(행위))호출</button>
<br>
```
- onclick"" : "" 안에 들어오는 메소드 실행 -> 버튼 누르면 그 메소드 실행!
<br>

## 6. JavaScript - pop up ✔
- 팝업창 디자인 Sweetalert : https://sweetalert.js.org/guides/
- window.open(URL, name, specs, replace)
```js
function showPopup() {
window.open("Ex06_popup.html", "zipcode", "width=200, height=200") //내장함수
}

function myFunc(){
let popupwindow = window.open("Ex06_popup.html", "zipcode", "width=200, height=200")
//popupwindow가 팝업창이에요
popupwindow.document.write("<p>this is zipcode window</p>");
//새 창에 대한 제어 가능
//JAVA: public void goUrlTime(String url){}
function goUrlTime(url){
window.setTimeout("location.href='" + url + "'", 3000);
//setTimeout 내장함수
//3초가 지나면 ... "location.href='"+ url + "'" 실행해라
//location.href 이동
//location.href'httl://www.daum.net'
}

//JAVA: public int myFunc(int i, int j, int k) {return i+j+k;}
function myFunc(i,j,k){
return i+j+k;
}

let result = myFunc(10,20,30);
console.log("result: " + result);
}

</script>
</head>
<body>
<hr3>내장함수, 사용자 정의 함수</hr3>
<br>
<button onclick="">클릭 사건 발생(함수(행위))호출</button>
<br>
<button onclick="showPopup()">팝업창</button>
<br>
<button onclick="">팝업 Object</button>
<br>
<button onclick="goUrlTime('http://www.daum.net')">3초후 이동</button>
</body>
```
<br>

### 🔔 익명함수
- 일회성 함수
- function(){}
- callback함수(프로그램 논리(흐름)에 의해서 자동으로 호출되는 함수) -> 1초마다, 재호출, 익명함수가 ... 
```js
let mytime = window.setInterval(function(){  //익명(콜백)함수
    let d = new Data(); //JAVA: Date d = new Date();
    let t = d.toLacaleTimeString();
    document.getElementById("time").innerHTML=t;
}, 1000);

//mytime == setInterval
function myTimeStop(){
    window.clearInterval(mytime);
}
```





