# 2022.10.18. TUE 📅
----------------
<br>

## 1. 데이터 모델링 - 정규화 ✔
- 1차 정규화 : 모든 속성은 원자값을 가짐, 복수의 속성값을 가지는 속성을 분리
- 2차 정규화 : 주식별자에 종속적이지 않은 속성의 분리, 부분 종속 속성을 분리 - 부분함수종속성
- 3차 정규화 : 속성에 종속적인 속성의 분리, 이전 종속 속성의 분리 - 이행함수종속성
- 보이스-코드 정규화 : 다수의 주식별자 분리
- 4차 정규화 : 속상간의 다중속성 제거 - 다중종속성
<br>   
      
### 🔔 Q) 정규화 조별과제!
#### 1번 - 승복님
[기존 테이블]   
![image](https://user-images.githubusercontent.com/111114507/196319386-edd9a5d3-8109-4a0c-ba22-f7a74a52a3a3.png)
[정규화]  
![image](https://user-images.githubusercontent.com/111114507/196325066-a51fed8f-94b3-4f75-b4db-dcab782ee521.png)
<br>

#### 2번 - 동재님
[기존 테이블]   
![image](https://user-images.githubusercontent.com/111114507/196319514-fd52f12e-b44a-4d52-b59a-8ef48517e05e.png)
[정규화]  
![image](https://user-images.githubusercontent.com/111114507/196325037-def1a905-10fb-4072-8215-6456ee062a5b.png)
- 제 3 정규화까지 쪼개면 조회시 어려워질 수 있다는 피드백!
<br>

#### 3번 - 영남님   
[기존 테이블]   
![image](https://user-images.githubusercontent.com/111114507/196319618-f660b81d-399f-4e89-ab58-f20a3f15f70e.png)
[정규화]  
![image](https://cafeptthumb-phinf.pstatic.net/MjAyMjEwMThfMjY5/MDAxNjY2MDYxOTYyODQ4.yM9Dg_YIHVO5YcL2CsR2oxsWWXD8xP5OfRBhWsUuXfIg.mFfFQpLI-KedY_1jzicJ0jVv_lOIJn4Ow6Of09eVOhgg.JPEG/h3.JPG?type=w1600)
<br>

#### 4번 - 나
[기존 테이블]   
![image](https://user-images.githubusercontent.com/111114507/196319700-7f89db82-1c60-441c-a7fe-e45910df4209.png)
[정규화]  
![image](https://user-images.githubusercontent.com/111114507/196324437-b09660e1-a7ba-4dec-a6e1-76c1e89725c4.png)
<br>

## 2. JSON ✔
- 자바스크립트로 객체를 표기하는 방법
```js

    let product = {제품명: '사과', 년도 : '2000', 원산지 : '대구'};
    console.log(product);
    console.log(product.제품명);
    console.log(product.원산지);
    console.log(product.toString());

    //객체 {} >> 리터럴 >>JSON
    let Person = {
        name:"홍길동",
        addr:"서울시 강남구 역삼동",
        eat: function(){
            document.write(this.name + "/" + this.addr + "/" + food + "냠냠")
        }
    };

    document.write("<hr>");
    Person.eat("사과"); //eat함수 호출

    //1. 속성 제거 기능
    delete(product.년도);
    console.log(product);

    for (let key in product) { //변수명 key
        console.log("key : " + key);
        console.log(product[key]);
    }

    for(let key in person){
        console.log("key : " + key + "=" + Person[key]);
    }
    
```
```js
<script type="text/javascript">
    //1. 배열 >> [] >> let arr=[]; >> push(), pop()
    //2. JSON >> {} >> let obj = {}; >>obj.속성명, obj.함수명

    //우리가 원하는 데이터는 단순하지 않아요
    //날씨, 영화 정보, 지하철 정보 데이터, 원하는 정보를 추출(OPEN API) >> xml, json
    //이런 데이터 객테와 객체, 객체안에 배열, 배열안에 객체가 혼재 ... 원하는 값만 추출

    let students = [];
    students.push({이름:"홍길동", 국어:80, 영어: 60}); //배열의 0번째 방에 객체 (JSON)
    students.push({이름:"아무개", 국어:100, 영어: 50}); //배열의 0번째 방에 객체 (JSON)
    students.push({이름:"이순신", 국어:10, 영어: 100}); //배열의 0번째 방에 객체 (JSON)

    //[{}{}{}]
    //기존에 만들어진 객체에 함수 추가
    for(let index in students) {
        //students[index] >> {이름:"홍길동", 국어:80, 영어: 60}
        students[index].getSum = function() {return this.국어 + this.영어}
        students[index].getAvg = function() {return this.getSum()/2}
    }

    //{이름:"홍길동", 국어:80, 영어: 60, getSum:function ... , getAvg:function}
    console.log(students);

    for(let index in students) {
        console.log(students[index].이름);
        console.log(students[index].getSum());
        console.log(students[index].getAvg());
    }

</script>
```
<br>

### 🔔 [객체 데이터]를 [문자열 데이터]로
```js
//login.jsp?name = json&age = 30 & city = seoul
let stringobj = JSON.stringify(MyObj); //POINT
console.log(stringobj); //'name:"john", age:30, city:"seoul"'
console.log(typeof(stringobj));
```
<br>

### 🔔 [문자열 데이터를] [객체 데이터로]로
```js
let stringstr = 'name:"john", age:30, city:"seoul"';
console.log(stringstr);
console.log(typeof(stringstr));

let Myjson = JSON.parse(stringstr);
console.log(Myjson);
```
<br>

### 🔔 POINT
```js
console.log(Myjson.name); //접근: 객체 속성명
console.log(Myjson["name"]); //접근 : 객체["속성명"] 암기
```
<br>

### Q) JSON으로 이미지 슬라이드 만들기
[문제]  
```js
"m" 값을 가지고 와서 https:\/\/live.staticflickr.com\/65535\/52421936483_165a532d02_m.jpg
배열에 넣으세요
let images = [];
슬라이드 만들기
```
```js
<script>
window.onload=function(){
    let images= [];

    for(let index in data.items) {
        images.push(data.items[index].media.m);
    }

    
    let index = 1;

    document.getElementById("prv").addEventListener("click", function(){
        if(index == 1) {
            index = images.length;
        }

        document.getElementById("imgs").src = images[--index];
    });

    document.getElementById("next").addEventListener("click", function(){
        if(++index == images.length){ 
            index = 0;
        }

        document.getElementById("imgs").src = images[index];
    });
}
</script>
```
</head>
<body>
    <h3>JSON API 슬라이드</h3>
    <img src="anna.png" alt="이미지를 로드하는데에 실패했습니다." id="imgs" width="300" height="300">
    <hr>
    <a href="#" id="prv">이전</a>||<a href="#" id="next">다음</a>
</body>
</html>