# 2022.10.17. MON 📅
----------------
<br>

## 1. Javascript - DOM 계층트리 ✔
```js
    <script>
        window.onload=function(){
            //DOM 객체 자원 ... 
            //모든 자원에 대한 사용이 가능 ...

            //계층트리 (node 개념 접근 : 부모, 자식, 형제 개념)
            let menode;
            menode = document.getElementById("me");
            menode.style.backgroundColor = "gold";

            let parentnode = menode.parentNode; //body
            parentnode.style.backgroundColor="green";

            let grandnode = parentnode.parentNode; //html
            grandnode.style.backgroundColor="blue";

            let my = document.getElementById("mychild");
            console.log(my);
            console.log(my.firstChild.nodeName);//LI
            console.log(mt.firstChild.innerText); //LI >> AA
            //innerHTML, innerText >> value 없는 친구 >> p, div, li, span
            //BB라는 Text 값을 가지고 오고 싶으면?
            console.log(my.firstElementChild.nextSibling.innerText); //BB

            console.log(my.childNodes);
            //질문 : mychildNodes return type >> Array
            //[<li>AA</li>][<li>BB</li>][<li>CC</li>]
            console.log(my.childNodes[0]);
            console.log(my.childNodes.length);


        }
    </script>
</head>
<body>
    <div>A</div><div>B</div><div id="me">C</div><div>D</div><div>E</div>
    <ul id="mychild"><li>AA</li><li>BB</li><li>CC</li></ul>
</body>
```

## 2. Javascript - event ✔
- 하나의 요소는 여러개의 event를 가질 수 있다.
- 이벤트가 더 이상 필요하지 않다면 removeEventListner() 제거 가능 (단 addEvent 추가)
```js
<body>
    <button id="mybtn">클릭</button>
</body>
<script text="text/javascript">
    let x = document.getElementById("mybtn");

    x.addEventListener("mouseover", myFunc);
    x.addEventListener("mouseout", myFunc2);
    x.addEventListener("mouseclick", myFunc3);


    function myFunc(){
        document.getElementById("mybtn").innerHTML += "Mouse Over<br>";
    }
    function myFunc2(){
        document.getElementById("mybtn").innerHTML += "Mouse Out<br>";
    }

    function myFunc3(){
        document.getElementById("mybtn").innerHTML += "Click<br>";
    }

</script>

```
<br>

### 🔔 캠쳐링 & 버블링
- #### 캡쳐링  
![image](https://joshua1988.github.io/images/posts/web/javascript/event/event-capture.png)
<br>
 
- #### 버블링  
![image](https://joshua1988.github.io/images/posts/web/javascript/event/event-bubble.png)
<br>

## 4. JavaScript - Object ✔
### 🔔 <클래스 정의 3가지 방법>
#### 1) 프로토타입 방식 :  일반적인 클래스 제작 방법
-  인스턴스마다 공통된 메서드를 공유해서 사용하는 장점 
```js
function 클래스이름() {
    this.프로퍼티1 = 초기값;
    this.프로퍼티2 = 초기값;
}

클래스이름.prototype.메서드1 = function() {

}

클래스이름.prototype.메서드2 = function() {

}

​var 인스턴스 = new 클래스이름(); 
var carObj = new Car();
var carObj2 = new Car();
var carObj3 = new Car();
 ```
 <br>


#### 2) 함수 방식 : 간단한 클래스 제작 시 사용 
- 인스턴스마다 메서드가 독립적으로 만들어지는 단점
- 클래스 :  function Car(){ this.name = , this.age=}
- 함수 :   function car(){}
```js
function 클래스이름() {
    this.프로퍼티1 = 초기값;
    this.프로퍼티2 = 초기값;
        this.메서드1 = function() {
        }

    this.메서드2 = function() {

    }

}

​var 인스턴스 = new 클래스이름(); 
var carObj = new Car();
var carObj2 = new Car();
var carObj3 = new Car();
```
<br>

#### 3) 리터럴 방식 : 
- 클래스 만드는 용도는 아니며 주로 여러개의 매개변수를 그룹으로 묶어 함수의 매개변수로 보낼때 정의와 함께 인스턴스가 만들어지는 장점이 있음           
- 단 인스턴스는 오직 하나
```js
{"a" : 데이터}
```
<br>

### 4) ECMA6 버전부터 : class 키워드 제공
```js
class Person {
    constructor(name) {
        this._name = name;
    }

    sayHi() {

    console.log(`Hi! ${this._name}`);
    }
}
```
<br>

### 🔔 <javascript 객체 생성>
- 오브젝트 리터럴 방식 (객체를 만드는 방법): 클래스 생성과  동시에 객체가 만들어진다
- -> 리터럴 방식 >> 제일 간단한 방법 > var obj = {}; //var objarr = [] 배열 
- -> JSON 표기 : {} >> JSON: JavaScript Object Notation
-        ​        ex) var myObj = { "name":"John", "age":31, "city":"New York" };
<br>

```js
//class Product {public String 제품명 = "사과"}
//Product p = new Product();
//System.out.Println(p.제품명);

let product = {제품명: '사과', 년도 : '2000', 원산지 : '대구'};
console.log(product);
console.log(product.제품명);
console.log(product.원산지);
console.log(product.toString());
```
