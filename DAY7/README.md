# 2022.08.29.Mon 📅
<br>

## 1. 'call by value' _vs_ 'call by ref' ✔
--------------
 ![image](https://user-images.githubusercontent.com/111114507/187102683-0b9937a6-2466-40c9-b33e-b4e0162ecbf7.png)
 ▶메소드에 객체를 전달할 경우 메소드에서 객체의 객체변수(속성) 값을 변경할 수 있다.
 <br>
 <br>

 ![image](https://user-images.githubusercontent.com/111114507/187105490-00839732-7029-49d2-b18d-c5af576782c0.png)


 ## 2. overloading ✔
 -----------------------
 ### overloading : 하나의 이름으로 여러가지 기능을 하는 함수
```
  함수 이름은 한개 ... 사용 방법은 여러개
  1. 오버로딩은 성능 향상과 무관
  2. 편하게 사용하라고 ... 
  3. 오버로딩을 사용하지 않아도 문제 되지 않는다 ...
  ```
 
 <br>

 ### <문법> : 함수 이름은 같고 parameter [개수]와 [타입]을 다르게

 ```
 1. 함수 이름은 동일
 2. parameter 개수 또는 타입은 달라야 한다
 3. return 타입은 오버로딩의 판단 대상이 아니다
 4. parameter의 순서가 다름을 인정(주의)
 ```
 <br>

 ![image](https://user-images.githubusercontent.com/111114507/187106351-a75af047-9a7a-4a54-8a51-145eb31d3f2d.png)
 ![image](https://4.bp.blogspot.com/-T_rzdCAe3p4/W8ni6-U1_1I/AAAAAAAAA2I/F5zh_qSmSgotYJoH2oH-lxeHAPW42J89QCLcBGAs/s640/Method%2BOverloading.png)
 <br>

```java
class Human2 {
	String name;
	int age;
}

class Test2{
	Human2 add(Human2 h) {
		h.name = "아무개";
		h.age = 200;
		return h;
//		return null; //human2는 주소를 가지고 있지 않아요
		
	}
	
	Human2 add(Human2 h, Human2 h2) {
		
		h2.name = h.name;
		h2.age = h.age;
		
		return h2;
	}
}

public class Ex14_Method_Overloading {

	public static void main(String[] args) {

		Test2 t = new Test2();
		
		Human2 man = new Human2 (); //man 0x123 주소
		Human2 man2 = t.add(man); //man2 0x123주소
		
		System.out.println(man == man2); //true
	}
}
```
![image](https://user-images.githubusercontent.com/111114507/187110975-3f19ba9c-52ba-4d14-93fe-cf62292c559f.png)

## 3. 생성자함수 (constructor) ✔
---------------------
```
  1. 함수 (특수한 목적)
  2. 목적(member field 초기화)>> static {}, {초기자 블럭}
  3. 일반함수와 다른점
   1) 함수의 이름이 고정(class 이름과 동일하게)
   2) return 타입이 없음 (객체 생성과 동시에 호출) (return을 받을 대상이 없다)
   3) 실행 시점 >> new객체 생성 >> heap 공간 생성 >> member field 자리 >> 자동으로 생성자 함수 호출
   4) return type(x) >> void >> public void(생략) 클래스 이름() {}
  4. why : 생성되는 객체마다 강제적으로 member field 값을 [초기화] 할 수 있다
  5. 생성자 함수 (overloading기법 적용 가능)
  6. 생성자 오버로딩을 통해서 다양한 강제사항구현
   
   *** 생성자를 쓰는 가장 중요한 목적은 강제적 초기화 (member field) ***
  ```

  ### 1. 문제 풀이
  ### Q1❓ )
  
  ![image](https://user-images.githubusercontent.com/92353613/187064414-f667b7cc-a35a-463e-8490-a9a9d41dcdd9.png)
   추가 -> 누적 대수 (count) 표시하도록
  ```java
  public class Main {
    public static void main(String[] args) {
        
        TV myTV = new TV("SS", 2017, 32);
        myTV.show();
        TV myTV1 = new TV("SS", 2017, 32);
        myTV1.show();
        TV myTV2 = new TV("SS", 2015, 50);
        myTV2.show();
    }
  }
  ```

  ``` java
	class TV {
    String brand;
    int year;
    int inch;
    static int count;

    public TV(String a, int b, int c) {
        this.brand = a;
        this.year = b;
        this.inch = c;
        count++;  //count = count + 1
    }


    public void show() {
        System.out.println(brand + " " + year + " " + inch + " " + count);
    }
   }


```

### Q2❓)

```
<요구사항>
1. 책은 책 이름과 가격 정보를 가지고 있다.
2. 책이 출판되면 반드시 책 이름과 책의 가격 정보를 가지고 있어야한다. >> default constructor
3. 책의 이름과 가격 정보는 특정 기능을 통해서만 볼 수 있고, 출판된 이후에는 수정할 수 없다.(책의 가격, 이름) >> private
4. 책 이름과 가격 정보는 각각 확인할 수 있다. >> getter 사용

```

```java
public class Book {
	
	private String name;
	private int price;
	
	//public Book() {} 요구사항 (x)
	public Book (String a, int b) {
		name = a;
		price = b;
	}

	public void BookInfo() {
		System.out.printf("책 이름은 [%d], 책 가격은 [%s]입니다", name, price);
	}
	
	public String getname() {
		return name;
	}
	
	public int getprice() {
		return price;
	}
}	
```

## Exception
-------------
```java 
try {
    ...
} catch(예외1) {
    ...
} catch(예외2) {
    ...
...
}
```

```
try 문안의 수행할 문장들에서 예외가 발생하지 않는다면 catch문 다음의 문장들은 수행이 되지 않는다.  

하지만 try 문안의 문장을 수행하는 도중에 예외가 발생하면 예외에 해당되는 catch문이 수행된다.
```