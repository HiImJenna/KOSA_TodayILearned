# 2022.08.26.Fri 📅
<br>

## 1. Airplane 설계 ✔
--------------

    
 ### 🔔요구사항
 * 비행기를 생산하고 비행기의 이름과 번호를 부여해아함
 * 비행기가 생산되면 비행기의 이름과 번호가 맞게 부여되었는지 확인하는 작업이 필요함(출력)
 * 공장장은 현재까지 만들어진 비행기의 총 누적대수를 확인할 수 있다.

 <br>

 > class 생성
```java
public class AirPane {
	
	private int airnum;
	private String airname;
	private static int airtotalcount; //모든 객체가 공유하는 자원
	
	public void makeAirPlane(int num, String name) {
		airnum = num;
		airname = name;
		//airtotalcount 누적대수
		airtotalcount++;
		
		AirDisplay();
	}
	
	private void AirDisplay() {
		System.out.printf("번호[%d], 이름[%s] \n", airnum, airname);
	}
	
	public void airPlaneTotalCount() {
		System.out.printf("총 비행기 제작 대수 : [%d] \n", airtotalcount );
	}
}
    ```


> main
``` java
public class Ex07_Static_AirPlane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//비행기 3대를 만드시고 확인하세요
		AirPane air1 = new AirPane();
		air1.makeAirPlane(101, "대한항공");
		air1.airPlaneTotalCount();
		air1.airPlaneTotalCount();
		
		AirPane air2 = new AirPane();
		air2.makeAirPlane(707, "대한항공");
		air2.airPlaneTotalCount();
		air2.airPlaneTotalCount();
		
		AirPane air3 = new AirPane();
		air3.makeAirPlane(707, "대한항공");
		air3.airPlaneTotalCount();
		air3.airPlaneTotalCount();
	}

}
```
💥설계도를 메모리 구조로 그려보기
![image](https://user-images.githubusercontent.com/111114507/186837680-fd67bc77-82ea-4e82-8ffc-1adfadad0212.png)
<br>

 ## 2.Card 설계✔
 -----------------

 ### 🔔요구사항
 * 만드는 카드의 번호, 모양을 가지고 있다.
 * 카드는 크기를 가지고 있다. 커기는 높이와 너비를 가지고 있다.
 * 카드의 크기는 h = 50, w = 20
 * 그리고 제작되는 카드의 높이와 너비는 동일하다.
 * 제작해서 고객에게 제작했으나 크기가 너무 커서 다시 만들어야 함
 * 설계도를 변경하지 않고 53장 카드의 높이와 너비를 변경할 수 있도록 설계도 구성
 * hint)한장의 카드를 높이와 너비를 변경해서 모든 카드는 같이 변경된다

 <br>

 > class 생성

 ```java
 public class Card {
	
	private int number;
	private String kind;
	
	public static int h = 50;
	public static int w = 20; //모든 객체가 공유하는 자원
	
	public void makeCard (int num, String name) {
		number = num;
		kind = name;
	 }
	
	public void cardDisplay() {
		System.out.printf("번호 %d, 카드모양 %s, h : %d, w : %d \n", number, kind, h, w);
	}
 }
 ```
> main
``` java
public class Ex08_Static_Card {

	public static void main(String[] args) {
		
		//카드 53장 제작
		//메모리(heap)
		
		Card c = new Card();
		c.makeCard(1, "heart");
		c.h = 40;
		c.w = 10;
		c.cardDisplay();
		
		Card c2 = new Card();
		c.makeCard(2, "heart");
		c.cardDisplay();
		
		Card c3 = new Card();
		c.makeCard(3, "heart");
		c.cardDisplay();
	}

}
```

## 3. instance 변수 ✔
---------------

![image](https://user-images.githubusercontent.com/111114507/186840274-a05f6012-4271-4e95-9e73-3409d85eb4a2.png)
![image](https://user-images.githubusercontent.com/111114507/186840845-1d5b9a6c-60bb-4b71-b312-56c9a953c296.png)
<br>

## 4. static 함수와 일반 함수 ✔
---------------------
<br>

* static 함수가 항상 우선 ▶ 후에 일반 함수 생성
* 그렇기에 일반 함수는 static 함수 제어 가능, static 함수는 일반 함수 제어 불가능

<br>

```java
class StaticClass{
	int iv;
	
	static int cv;
	
	void m() {
		//일반함수
		//new heap > 사용
		//1. iv 제어 가능
		cv = 100;
		//why: 생성 시점(static 자원은 객체 생성 이전에 메모리에 로드된다)
	}
	
	
	static void print() {
		//static 함수
		//1. cv 제어 가능
		//2. 일반변수 iv를 제어 가능할까 안될까 -> static이 항상 우선이기에 iv가 생성되기 전에 static이 생성되어있음. static 실행 시점에 iv가 없는거니까 제어 불가능(static자원은 일반 자원보다 우선)
		
		//결과 : 일반함수는 static 제어가능, static함수는 static 함수끼리만 제어 가능
		cv = 100000;
		
		
	}
	
	
}
public class Ex10_Static_Method {

	public static void main(String[] args) {
		StaticClass.print(); //new 없이 함수 사용
		System.out.println(StaticClass.cv);
		
		//일반 자원을 가지고 놀기 위해선 객체 생성 필요
		StaticClass sc = new StaticClass();
		sc.print();

	}

}
```

