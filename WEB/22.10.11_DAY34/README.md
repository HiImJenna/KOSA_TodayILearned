# 2022.10.11. MON 📅
----------------
<br>

## 1. 데이터 모델링 ✔
### 🔔 속성
- 속성 정의시 고려사항 : 파생된 값은 실제 성능을 위해서 사용되기도 하지만, 이런 값의 중복은 나중에 심각한 무결성 문제를 발생할 수 있으므로 조심해서 사용
<br>

### 🔔 도메인 지정
- 엔티티 내 속성에 대한 데이터 타입과 크기, 제약 사항 지정
<br>

### 🔔 식별자
#### 1) 식별자란?  
: 하나의 엔터티 내에서 각각으 ㅣ인스턴스를 유일하게 구분해 낼 수 있는 속성 또는 속성 그룹
<br>

#### 2) 내부식별자 / 외부 식별자 : 스스로 생성 여부
- 내부 : 자신의 엔텉 네에서 스스로 생성되어 존재하는 식별자
- 외부 : 다른 엔터티로부터 관계에 의해 주식별자 속성을 상속받아 자신의 속성에 포함되는 식별자 (FK 의미)
<br>

#### 3) 단일식별자 / 복합식별자 : 단일 속성 여부
- 단일 : 주식별자의 구성이 한가지 속성으로 이루어진 경우
- 복합 : 두개 이상의 속성으로 구성된 경우 -> 복합의 경우 우선순위가 매우 중요
<br>

#### 4) 원조식별자 / 대리식별자 : 대체여부
- 대리 : 주 식별자의 속성이 복합식별자일 경우 여러개의 속성을 묶어 하나의 속성으로 만들어 주식별자로 활용하는 경우
<br>

## 2. CSS ✔
### 🔔 Selector
- 기본 선택자 (기존에 존재하는 태그 : p, div, hr, h3)
    ex) p{colour:red}

- 다중선택자(group)
ex) p, h1, h2, h3 {colour:red}

- 사용자정의선택자 : (. >> class ... # >> id)

- 결합선택자
p{colour:red}
p.one {border:1px} >> <p class = "one"
                    >> <p class = "two"
- 자손, 후손 선택자
div p {colour:green;}

- 자식요소
.parent > p

- 속성선택자 (attribute > colour, font, size)
input[type=text] {colour:red}
input[type=button] {font-size:10px}

- + 인접형제 ~ 일반형제

- 가상선택자
<br>

### 🔔 Overflow
![image](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fcfile8.uf.tistory.com%2Fimage%2F236ABC4555526A2B1046D2%22&type=cafe_wa740)
<br>

### 🔔 반응형 웹
![image](https://www.nextree.co.kr/content/images/2021/01/jsseo-140329-CSS-01-1024x415-1.png)
- 디바이스 종류에 따라 웹페이지의 크기가 자동적으로 재조정 되는 것
<br>

### 🔔 position
#### 1) static
- Static positioned elements are not affected by the top, bottom, left, and right properties.
<br>

#### 2) relative
- Setting the top, right, bottom, and left properties of a relatively-positioned element will cause it to be adjusted away from its normal position. Other content will not be adjusted to fit into any gap left by the element.
- 원래 위치를 기준으로 상대적(relative)으로 배치해준다고 생각
- top, bottom, left, right 속성을 이용해서, 요소가 원래 위치에 있을 때의 상하좌우로 부터 얼마나 떨어지게 할지를 지정할 수 있음!
<br>

#### 3) fixed
- always stays in the same place even if the page is scrolled. The top, right, bottom, and left properties are used to position the element.  
- 스크롤 내려도 같은 자리에 계속 있음
<br>

#### 4) absolute
- An element with position: absolute; is positioned relative to the nearest positioned ancestor (instead of positioned relative to the viewport, like fixed).

- However; if an absolute positioned element has no positioned ancestors, it uses the document body, and moves along with page scrolling.

- Note: Absolute positioned elements are removed from the normal flow, and can overlap elements.

#### 5) sticky
- A sticky element toggles between relative and fixed, depending on the scroll position. It is positioned relative until a given offset position is met in the viewport - then it "sticks" in place (like position:fixed).  
- 스크롤 내리면 화면 맨 위에 걸려서 끈적하게 남아있음!  
![image](https://user-images.githubusercontent.com/111114507/195031102-a45570c1-f250-41cd-a130-02ded4a3a457.png)
<br>




