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

