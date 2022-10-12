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

### 🔔 var, let, const
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


