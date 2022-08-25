package DAY5;
/*
 기능 (행위) 만드는 방법
 함수 (method)
 
 method: 행위 또는 기능의 최소단위 구현 : 하나의 함수는 하나의 기능만 구현
 ex)먹는다, 잔다, 걷는다 ...
 
 클래스: field + method
 
 ex) 롯데월드: 게임방 : 농구,동전,동전 뽑기 ....
 
 ** method 함수는 호출에 의해서만 동작된다 **
 누군가 이름 부르지 않으면 동작하지 않는다...
 
 JAVA) 
 1. void, parameter(0): void print(String str){실행코드}   
 2. void, parameter(x): void print(){실행코드}         >> 공짜
 3. return type , parameter(0) : int print(int data){return 100;} 
 4. return type , parameter(x) : int print(){return 100;}

 *** void > 돌려주는 것이 없어요 > return type 없어요
 return type >> 기본 8가지 + String + Array, class, collection, interface
 이 중에서 기본 8가지 + String + class 인정 ....
 
 boolean print (return true)
 
 Car print(){Car c = new Car(); return c;}
 //나는 당신에게 Car 객체의 주소를 return 하는것
 
 String print(){return "A";}
 
 parameter type >> void print(String 파라메터)
 >> 기본 8가지 + String + Array, class, collection, interface 
 
 void print(int i){}
 void print(String Str){}
 void print(Car car){}
 
 print(c); // print 함수 호출시 c라는 변수값(주소값)
 
 어려워요 ... 동전 구멍이 여러개 ...
 ------------------------------------------
 void print (int a, int b, int c, int d){}
 
 print(10, 20) //실행 x
 print(100,100,100) //실행 x
 print(100,100,100,200) //실행 o
 ------------------------------------------
 void print(Car c, String str, int i){}
 각 파라미터 외의 값이 들어가면 실행 x
 
 
 관용적인 표현
 코드 규칙 : 관용적
 class 이름의 첫글자는 대문자 : class Car, class Person
 method의 이름은 단어의 첫글자 소문자 이어지는 단어의 첫글자는 대문자 ..: getNumber()
 
 사원번호를 가지고 사원의 모든정보를 가지고 와라 (함수 생성)
 ex) getEmpListByEmpno()  // get Emp List By Empno 가지고온다 사원의 리스트를 사원번호를 가지고
 
 함수의 이름으로 대략적이 내용 파악 가능하도록!
 
 */

public class Fclass {
   public int data;
   
//   void m() >> 컴파일러가 >> default void m() >> 같은 폴더 내에서
//   함수 70% public
//   함수 30% private  why? : hint) public, private 클래스 내부 동등 ...
//   클래스 내부에서 만 사용해라 >> 이런 함수 >> 공통함수 >> 다른 함수를 도와주는 함수
   
   public void m() { //void, parameter(x)
      //기능 구현
      //main 함수에서 사용했던 코드를 그대로 구현
      System.out.println("일반함수 : void, parameter(x)");
   }
   
   //void m2(int)
   public void m2(int i) {
      System.out.println("일반함수 : void, parameter(0)");
      System.out.println("parameter 값은 활용   i변수 함수 내부 : " + i);
   }
   
   //return type m3(x)
   public int m3() {
      //무조건, 강제로 ,,,
      return 1000; //return type이 존재하면 반드시 return 키워드 명시 필수
   }
   
   public int m4(int data) {
      return 100 + data;
   }
   //요거까진 기본 4가지
   
   //확장..
   //return type(0), parameter(0) 단지 개수 ....
   public int sum(int i, int j, int k) {
      return i + j + k;
   }
   
   
   
   //함수의 접근자
   //default int subSum(){} 같은 폴더 ...
   //private int subSum(){} 같은 폴더도 안돼요
   //클래스 내부에서 다른 함수를 도와주는 공통함수 ...
   //private 함수 만들어서 사용
   
   private int subSum(int i) { //다른 함수가 호출해서 사용...
      return i + 100;         //로직이 모든 함수가 가지고 있다면... 변경이 쉬움 >> 유지보수!
   }
   
   public void callSubSum() {
      //함수는 다른 함수를 호출할 수 있다.\
      int result = subSum(100);
      System.out.println("call result : " + result);
   }
   
   private int operationMethod (int data) {
      return data * 200;
   }
   
   
   public int opSum(int data) {
      int result = operationMethod(data);
      //제어문
      if (result > 0) {
         return 1;
      } else {
         return -1;
      }
   }
   
   /*
    a 와 b 둘중에 큰값을 return 하는 함수를 만드세요
    */
   public int max(int a, int b) {
      return (a>b) ? a : b;
   }
}