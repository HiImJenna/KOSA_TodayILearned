# 2022.09.07.Wed 📅
<br>

## 1. UML ✔
-----------------------------
<br>

### 🔔 UML이란?
> Unified Modeling Lanuguage의 약자로 1997년 OMG에서 표준으로 채택한 통합모델링 언어로써 모델을 만드는 표준 언어이다. 모델이란 것은 어떤 것을 실제로 만들 때 이렇게 만들면 잘 작동할 지 미리 검증해보는 것이며 실제 물건을 만드는 비용보다 비용이 훨씬 적을 경우에 모델을 만들어 설계를 검사합니다.

### <UML의 사용 목적>
- 다른사람들과의 의사소통 또는 설계 논의
- 전체 시스템의 구조 및 클래스의 의존성 파악
- 유지보수를 위한 설계의 back-end 문서

<br>

## 2. 클래스 다이어그램 Class Diagram ✔
-----------------------------
<br>

### <UML다이어그램의 종류>

![사진](https://www.nextree.co.kr/content/images/2021/01/--1-UML---.png)
<br>

### <목적별 클래스 다이어그램>
- 개념의 차원 : 문제 도메인의 구조를 나타내며 사람이 풀고자 하는 문제 도메인 안에 있는 개념과 추상적인 개념을 기술하기 위한 것. 소스코드와 관계가 적고 의미론적 규칙에 얽매이지 않는다.
- 명세 & 구현의 차원 : 소스코드와 관계가 깊다, 제약이 많아 반드시 의미론을 지켜야하며 모호성이 거의 없도록하고 형식도 맞춰야 한다.
![image](https://www.nextree.co.kr/content/images/2021/01/--2--------------2.png)



## 🔔 클래스 다이어그램의 요소 (Element)
###     1) Class
![image](https://www.nextree.co.kr/content/images/2021/01/--3----.png)
<br>

###     2) Stereo Type
![image](https://www.nextree.co.kr/content/images/2021/01/--4--------.png)
<br>

###     3) 추상클래스 Abstract Class & 메서드 Method 
![image](https://www.nextree.co.kr/content/images/2021/01/--5------.png)
    -> Italic체로 표기하기도 함
<br>

## 🔔 클래스간의 관계
![image](https://www.nextree.co.kr/content/images/2021/01/--6-----------.png)
![image](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fcfile8.uf.tistory.com%2Fimage%2F135576465051426D26333D%22&type=cafe_wa740)
<br>

### 1) 일반화 Generalization
![image](https://www.nextree.co.kr/content/images/2021/01/--7-Generalization1.png)
- 부모클래스와 자식클래스 간의 상속 관계를 나타낸다.
- 부모클래스가 추상클래스인 경우에는 추상 메서드를 반드시 오버라이딩 하여 구현해야 한다.
<br>

### 2) 실체화 Realisation
![image](https://www.nextree.co.kr/content/images/2021/01/--8-Realization.png)
- interface의 정의만 있는 메서드를 오버라이딩 하여 실제 기능으로 구현하는 것을 말한다.
<br>


### 3) 의존 Dependency
![image](https://www.nextree.co.kr/content/images/2021/01/--9-Dependency.png)
- 클래스 다이어그램에서 일반적으로 제일 많이 사용되는 관계로서, 어떤 클래스가 다른 클래스를 참조하는 것을 말한다.
- 참조의 형태는 메서드 내에서 대상 클래스의 객체 생성, 객체 사용, 메서드 호출, 객체 리턴, 매개변수로 해당 객체를 받는 것 등을 말한다...
<br>

<Dependency Stereo Type>

![image](https://www.nextree.co.kr/content/images/2021/01/--10-Dependency2.png)

### 4) 연관 Association & 방향성 있는 연관 Directed Association
- Association : 보통 다른 객체의 참조를 가지는 필드를 의미한다.
![image](https://www.nextree.co.kr/content/images/2021/01/--16-Aggregation.png)

<br>

### 5) 집합 Aggregation
- whole(전체)와 part(부분)의 관계를 나타낸다.  
   ▶part가 whole에 독립적이기에 whole이 part를 빌려쓰는 것과 비슷하다.
![image](https://www.nextree.co.kr/content/images/2021/01/--16-Aggregation.png)
<br>

### 6) 합성 Composition
- Aggregation과 비슷하게 whole(전체)와 part(부분)의 관계를 나타지만 개념적으로 Aggregation보다 더 강한 집합을 의미한다.  
   ▶ part가 whole에 종속적이기에 part가 whole의 소유이다.
![image](https://www.nextree.co.kr/content/images/2021/01/--19-Composition1.png)
<br>

출처 : https://www.nextree.co.kr/p6753/