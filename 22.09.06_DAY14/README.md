# 2022.09.07.Wed 📅
<br>

## 1. UML ✔
-----------------------------
<br>

### < UML이란? >
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

<br>

### <시나리오 실습>
### Q1)
![image](https://user-images.githubusercontent.com/111114507/188814839-c83f0314-5786-4eb1-8e58-cdb550282888.png)
```java
interface Unit {
	void InitPosition(); // 초기 좌표값

	void move(); // 이동 위치
}

class King implements Unit {

	@Override
	public void InitPosition() {
		// TODO Auto-generated method stub
		System.out.println("정해진 왕의 위치");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("모든 방향으로 한칸 움직입니다.");
	}

	public void endgame() {
		System.out.println("킹이 죽어서 게임이 종료됩니다.");
	}

}

class Queen implements Unit {

	@Override
	public void InitPosition() {
		// TODO Auto-generated method stub
		System.out.println("정해진 여왕의 위치");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("어디든 팔방으로 거리제한 없이 이동 가능");
	}
}

class Pawn implements Unit {

	@Override
	public void InitPosition() {
		System.out.println("정해진 폰의 위치");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("앞으로 한칸 이동 가능");
	}
}

class Player {

	String color;
	Unit[] unit;

	public Player(String color, Unit[] unit) {
		this.color = color;
		this.unit = unit;
	}

	void play(Unit ut) {
		ut.move();
	}
}
```
![image](https://user-images.githubusercontent.com/111114507/188814428-e665a95e-f9ad-40e9-9cfb-3994544e4e04.png)
<br>

----------------------------------------------
### Q2) Ex12_Inherit_Keypoint 시나리오
![image](https://cafeptthumb-phinf.pstatic.net/MjAyMjA5MDdfMzQg/MDAxNjYyNTIwODg3MDc0.jQCpJdO2VBiwjQdIcWxilsbE6UuRqo_AeJWeZ5sEJqcg.ShG0a4OyK9g6MYEs3URs9scbSehXiqC4JAxCj4jSoqcg.PNG/2.PNG?type=w1600)

<br>

## 3. 유케이스 Ucase ✔
------------------------------
<br>

- 외부사용자(External entity)를 찾아낸다. 
- 사용자를 역할에 따라 동질성 있는 집단으로 분류하여 이를 행위자, 또는 액터(Actor)라고 부른다.  
- 각 행위자는 시스템에 대하여 각기 다른 관점과 용도를 가지며, 이를 유스케이스라 한다.  
- 각 유스케이스에 대하여 시나리오를 작성한다. 시나리오는 사건의 흐름과 과정을 나타내며 시스템과 행위자들이 주고 받는 정보 뿐만 아니라  
   상호작용이 발생하는 상황, 환경, 배경등을 포함할 수 있다.  
- 유스케이스 모델링은 시스템 외부의 모습을 분석하는 도구이다.  
- 유스케이스는 시스템의 최상위 기능에 해당한다.  
- 유스케이스 시나리오는 동적모델링에 해당한다.  
- 유스케이스 기법을 사용하면 다양한 이해관계자를 개발 프로세스에 참여시킬 수 있다.  

<br>

![image](https://user-images.githubusercontent.com/111114507/188844641-2c7e516e-7c4f-4323-93db-7bec541a38f8.png)
<br>

### Ex)
 ### - 잘 한 경우
 ![image](https://camo.githubusercontent.com/ce640bef8f06529ce6792a1b649d3e7d13fe90108bd9ef3e574941223dce861a/68747470733a2f2f706f737466696c65732e707374617469632e6e65742f4d6a41784e7a41314d5442664e5441672f4d4441784e446b304d7a6b784d6a45794f4451792e5f583930646d696a644866383436335a6a50574564566f5f746350704e5264736d5731314c5f68666a7873672e526c397856383045443550675179757a37433136767973656433795231785959696b3438436b6739724530672e504e472e6c6a6830333236732f696d6167652e706e673f747970653d77393636)   
 
 ### - 못 한 경우
 ![image](https://camo.githubusercontent.com/172edd16491dceab0f436b3d7d7de893761b19d2caa9cfe7b7def61719478280/68747470733a2f2f706f737466696c65732e707374617469632e6e65742f4d6a41784e7a41314d5442664d6a63672f4d4441784e446b304e4445774e4467314e4455782e772d523975383251755a7670485979784879705235437236522d544f61714a76454c4b695f6842662d516f672e6d794e4974316f345467533976686e41585a51654532624d474c527738506a6c66547478527161367a4877672e504e472e6c6a6830333236732f696d6167652e706e673f747970653d77393636)  
▶ (A) : 유스케이스를 흐름도처럼 그린 경우  
        -> 유스케이스간의 관계는 포함, 확장, 일반화 관계만 존재하고 실행 순서 관계는 존재하지 않는다.  
        <br>
        
▶ (B) : 포함관계를 과도하게 사용하는 경우    
<br>

출처 : https://github.com/Bamjong
<br>

### <Ucase 실습>
```java
[시나리오]
<배달앱>

목표 : 사용자는 배달앱 시스템을 통해 결제하고 음식을 주문할 수 있다

시나리오 샘플

우리가 관리하는 배달앱 시스템이 있다

배달앱시스템에서 판매하는 음식점과 음식의 종류는 여러가지가 있다

관리자는 음식점과 음식에 대해 관리하고 사용자에게 제공한다

사용자가 배달앱에서 음식점과 상품을 선택하고 

결제시스템(외부)을 통해 금액을 결제후 판매자가 수락하면 배달서비스가 진행된다

사용자는 구매상품에 대해 리뷰기능을 사용할 수 있다

판매자는 매출에 대한 정보, 리뷰정보, 메뉴정보 등을 관리할 수 있다

<간단 시나리오 샘플>

배달앱을 사용하려는 고객은 배달 리스트에서 원하는 음식을 구매하기 위해

고객이 선택한 음식의 가격에 맞는 돈을 외부 결제시스템을 통해 결제한다.

배달앱시스템은 고객이 결제한 정보를 판매자에게 전달한다

판매자가 수락하면 고객에게 상품이 배달된다

고객은 리뷰를 작성할 수 있고

판매자는 그 리뷰를 확인할 수 있다.
```

```java
1. 유스케이스명  : 배달서비스
2. 액터명    : 주 액터 - 사용자, 판매자

               부 액터 - 관리자

3. 사전조건  :  사용자가 회원가입(주소정보 포함)이 되어 있어야한다.

                판매자는 시스템에서 영업 중인 상태여야한다.

                관리자는 사용자의 정보,결제정보를 판매자에게 제공하고,

                판매자의 상품정보를 사용자에게 제공해야한다.

4. 사후조건 :    사용자는 결제내역을 확인 가능하다.

                관리자는 해당 상점에 대해 리뷰평점과 같은 정보를 업데이트한다

​
5. 정상흐름 : 1) 고객은 로그인해야한다.

              2) 관리자는 유효한 상품 정보를 제공한다

              3) 구매자는 선택하고 결제시스템을 통해 결제한다.

              4) 판매자는 수락한다.

6. 대안흐름 : 1. GPS 위치와 다를 경우 주소를 다시 입력할 수 있도록 권유한다

               사용자는 사후조건 확인시 해당 상품에 대해 리뷰를 작성할 수 있다

               판매자는 해당 상품에 대해 리뷰를 확인할 수 있다

예외흐름 : 정상흐름 1.에서 로그인 실패시 고객에게 재입력을 요청하거나, 회원가입을 받는다 
```
![image](https://user-images.githubusercontent.com/111114507/188845471-48a9f627-20ea-41d1-8831-deccd3f59b85.png)

### ✨피드백 사항
- include 화살표 잘못 그림
- 굳이 관리자를 넣어야 할 필요가 있을까? -> 1번을 수정하면 해결
- 관리자에게 판매자 / 소비자를 include 할 필요 없음
- 로그인은 음식 주문에다 include 시키기


## 4. 정규표현식 ✔
-----------------------------
<br>

### <휴대폰 번호📱> 
> ^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$

- ^ : 문자열이나 행의 처음
- ( ) - 하위식 : 여러 식을 하나로 묶을 수 있다.
- ?: : 비캡쳐, 그룹화 할 때 사용되지만 문자열의 일치 / 캡처 된 부분으로 저장하지는 않는다.
- | : 가능성 있는 항목들을 구별하여 선택한다.
- [(공백)] : 가능한 문자열의 집합과 일치시킨다.
- \\d{3} : 숫자 0~9가 3개
- \\d{4} : 숫자 0~9가 4개 (d = 숫자를 의미)
- $ : 문자열이나 행의 끝

 #### 1) ^01(?:0|1|[6-9])
 - 01 + '0, 1, 6, 7, 8, 9 중 하나'

 #### 2) (?:\\d{3}|\\d{4})
 - '?:' ???
 - 0~9 중의 숫자 3개, 혹은 4개를 가진다.
 
 #### 3) \\d{4}$
 - 0~9 중의 숫자 4개를 가진다.
 - $로 문자열

#### 4) 유효성 검사
```java
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
          String tel = "010-1234-5678";
         
          //유효성 검사
          boolean tel_check = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", tel);
          
          //출력
          System.out.println("전화번호 : " + tel_check);
    }
}
```