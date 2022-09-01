# 2022.9.01.Thu 📅
<br>

## 1. 상속  ✔
-----------------
```java
실무(현업) 환경
한개의 클래스만 설계 사용경우 (x)

설계도 1장 모든 업무를 구현 현실적으로 불가능 
설계도 여러개의 나눈다 ... 문제발생 ...(기준 , 관계)

쇼핑몰 : 결재관리 , 배송관리 , 판매처 , 회원관리 , 관리자관리 , 상품관리 >> 각각의 업무 > 별도의 설계도
****기준*****
여러개의 설계도를 관계 ..이어주는 기준

1. 상속 (is ~ a : 상속) 은(는) ~이다 (부모를 뒤에)
2. 포함 (has ~ a : 포함) 은(는) ~을 가지고 있다 

예)
원은 도형이다 
원 extends 도형
삼각형은 도형이다 
삼각형 extends 도형

원과 점 관계
원은 점이다 (x)
원은 점을 가지고 있다 (0)
has ~ a (부품정보)
>>class 원 {점이라는 부품이 member field}

경찰 권총
경찰은 권총이다 (x)
경찰은 권총을 가지고 있다 (0)
>>class 권총 {}
>>class 경찰 {권총 member field}

원은 도형이다
삼각형은 도형이다
사각형은 도형이다

도형은 분모 (공통적) 공통자원 : 추상화 , 일반화   (그리다 , 색상)
원은 구체화 , 특수화 (본인만이 가지는 특징) (반지름 , 한점)

점 : 좌표값 (x,y)
원은 점을 가지고 있다
삼각형은 점을 가지고 있다
사각형은 점을 가지고 있다 

class Shape{그리다 , 색상} >> 상속관계 부모 (원, 삼각형 ,사각형)
class Point{좌표값} >> 포함관계 (부품) 

구체화 , 특수화 : Circle , Triangle
```

![image](http://www.tcpschool.com/lectures/img_java_inheritance_diagram.png)

<br>

## 2. Override
------------------
```java
 <Today's Point>
 [상속관계]에서 override : 상속관계에서 자식이 부모의 함수를 [재정의]
 [상속관계]에서 [자식클래스]가 [부모클래스]의 메서드(함수)를 재정의(내용을 바꿈)
 재정의 : 틀의 변화가 없고 (함수의 이름, 타입) 아니고, 내용만 변화 { 중괄호 안에 것 }
 
 * 문법)
 1. 부모 함수 이름 동일
 2. 부모 함수의 parameter 동일
 3. 부모 함수 return type 동일 
 4. 부모 함수 return type 동일
 5. 결국 { 안에 실행블럭 안의 코드만 변경 가능 }
```

```java
<오버로드 vs 오버라이드>
* 오버로드 : 하나의 메소드가 여러가지 일을 할 수있는것

* 오버라이드 : 부모의 함수를 재정의 하는것
```
![image](https://1.bp.blogspot.com/-mcytVS6SIqE/VJU6HxvD7iI/AAAAAAAACOc/nG02KqkDOoc/w1200-h630-p-k-no-nu/Difference%2Bbetween%2Bmethod%2Boverloading%2Band%2Boverriding%2Bin%2BJava.gif)

<br>

## 3. Annotation
------------------
🔔 Annotation은 Java code만으로 전달할 수 없는 부가적인 정보를 컴파일러나 개발툴로 전달할 수 있다.
🔔 @Override
```java
//*재정의(검증)
	@Override
	void print() {
		System.out.println("자식이 부모의 함수를 재정의");	
	}
```

<br>

## 4. toString()
-----------------

<br>

## 5. Final
----------------

<br>
