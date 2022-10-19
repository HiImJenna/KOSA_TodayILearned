# 2022.10.19. WED 📅
----------------
<br>

## 1. 오전 조별 과제 ✔
- 영화진흥원에서 일일 영화 박스오피스 api를 가져와서 테이블에 넣어보기
```js
<body>

    <table class="table" id="table">

        <thead class = "thead-light">
            <tr>
                <th>순위</th>
                <th>영화제목</th>
                <th>개봉일</th>
                <th>관객수 증감 비율</th>
                <th>일일 관객수</th>
            </tr>
        </thead>
    </tbody id="table">
    </table>
</body>


<script>

    let data = (사이트에서 가져온거 넣기)

    
window.onload = function(){

    let table = document.getElementById('table'); 


    let list = data.boxOfficeResult.dailyBoxOfficeList;

    for( let i = 0; i < 10; i++ ) {
        // let resultBody = document.createElement('resultBody');
        let tr = document.createElement("tr");
        let td = [document.createElement('td'), document.createElement('td'), document.createElement('td'), document.createElement('td'), document.createElement('td')];

        td[0].appendChild(document.element.rank);
        td[1].appendChild(document.element.movieNm);
        td[2].appendChild(document.element.openDt);
        td[3].appendChild(document.element.audiChange);
        td[4].appendChild(document.element.audiInten);

        tr.appendChild(td[0]);
        tr.appendChild(td[1]);
        tr.appendChild(td[2]);
        tr.appendChild(td[3]);
        tr.appendChild(td[4]);
        
        console.log(tr);
        console.log(table);
        table.appendChild(tr);
    }
 }
   
</script>

```
![images](https://cafeptthumb-phinf.pstatic.net/MjAyMjEwMTlfMjI4/MDAxNjY2MTcxMDQ4Mjc5.fDvQzWHTJ_LnfbPLIM9CUVQ7WmN2eIrf5Y-AB280F2gg.bvbemAPQ4XjsU3dFz1QvAOxJwfSMBxuACIRcu01d2Gwg.PNG/image.png?type=w1600)


## 2. ETC Try ✔
```js
<body>
	<!-- <p id="demo"></p> -->
	<input type="text" id="demo">
	<button onclick="myFunc()">TEST INPUT</button>
	<p id="p01"></p>
</body>
<script type="text/javascript">
		/*
		try{
			add("welcome!!");
		}catch(err){
			document.getElementById("demo").innerHTML = err.message;
		}
		*/
		function myFunc(){
			let message , x;
			message = document.getElementById("p01");
			message.innerHTML="";
			
			x = document.getElementById("demo").value;
			
			try{
				if(x == "") throw "empty";	
				if(isNaN(x)) throw "not a number";
				X = Number(x);
				if(x < 5) throw "too low";
				if(x > 10) throw "too high";
			}catch(err){ //내부적으로 생성된 예외 객체의 주소를 받는다 
				message.innerHTML = "input is " + err;
			}finally{
				document.getElementById("demo").value="";
			}
		}
	</script>
</html>
```
<br>

## 3. Arrow Function ✔
- https://www.w3schools.com/js/js_arrow_function.asp
<br>

#### 🔔 매개변수가 없는 함수 구현
```js
let bar = () => console.log("bar....");
bar();
```
<br>

#### 🔔 매개변수 1개  return 함수
```js
//let foo2 = function(x) { return x}
let foo2 = x => x;
let data = foo2(100);
console.log(data);

let hello;
//hello = function(val){return "hello" + val}
//hello = (val)=> "hello" + val;
hello = val => "hello" + val;
let v = hello("aaaa");
console.log(v);
document.getElementById("demo").innerHTML = hello("방가방가");
```
<br>

#### 🔔 매개변수가 2개 이상인 경우
```js
//function call(a,b){}
//let foo3 = (a,b) => {return a + b};
let foo3 = (a,b) => a + b;
let v2 = foo3(10,20);
console.log(v2)
```
<br>

#### 🔔 함수에 여러개의 논리가 포함된다면 { 구현  }
```js
let foo4 = (a,b) => {let c = 100; return a+b+c};
let v3 = foo4(100,100);
console.log(v3)
```
<br>

#### 🔔 즉시 실행 함수
```js
(
    function(){
        console.log("즉시 실행 함수 ....");
        //함수는 호출에 의해서 실행
    }()		
);
//위 코드를
//화살표 표현식으로 바꾸어 보세요
(
    ()=>{console.log("즉시 실행 함수 ....")}
        //함수는 호출에 의해서 실행
    )();

```
<br>

#### 🔔 1.번에서 한 과제를 forEach를 사용해 바꿔보기
```js
let list = data.boxOfficeResult.dailyBoxOfficeList;

list.forEach(element => {
console.log(element);

let tr = document.createElement("tr");
let td = [document.createElement('td'), document.createElement('td'), document.createElement('td'), document.createElement('td'), document.createElement('td')];

td[0].appendChild(document.createTextNode(element.rank));
td[1].appendChild(document.createTextNode(element.movieNm));
td[2].appendChild(document.createTextNode(element.openDt));
td[3].appendChild(document.createTextNode(element.audiChange));
td[4].appendChild(document.createTextNode(element.audiInten));

tr.appendChild(td[0]);
tr.appendChild(td[1]);
tr.appendChild(td[2]);
tr.appendChild(td[3]);
tr.appendChild(td[4]);

console.log(tr);
console.log(table);
table.appendChild(tr);
    })
```