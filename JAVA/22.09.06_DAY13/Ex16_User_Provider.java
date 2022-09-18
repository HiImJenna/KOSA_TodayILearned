
/*
 user 사용자<> privider 제공자
 
 class A{}
 classB{}
 관계 : A는 B를 사용합니다
 
 1. 상속 : A extends B
 2. 포함 : A라는 클래스가 Member field B를 사용 class A {B b};
 	1) 부분
 	2) 전체
 	
 public class B {}
 public class A {
 	 public int i;
 	 public B b; //A는 B를 사용합니다(포함)
 	 public A() {
 	 b = new B(); //생성자를 통해서 초기화(주소값)
 	 }
 }
 
 >>main 함수
 A a = new A();
a.b.자원

 >>포함관계로 사용시
 >>B는 독자생성 불가능 >> A라는 객체가 만들어져야 B도 생성
 >>A a = new A() 해야만 B객체 생성된다
 >>A, B같은 운명 공동체 (전체집합)
   >>  자동차와 엔진, 노트북과 CPU
 __________________________________________________________________
 class B{}
 class A{
 	public int i;
 	public B b; //A는 B를 사용합니다
 	public A() {  }
 	
 	//method
 	  void m(B b) {
 	  this.b = b;
 	  }
 }
 >> A a = new A();
 >> B b = new B();
 >> a.m(b);
 >> 같은 운명이 아니다
 >> 학교(A)와 학생(B) (부분집합), 노트북과 마우스
 
 class A{}
 class B{}
 관계 : A는 B를 사용합니다
 
 A는 B를 참조합니다 (포함)
 B는 member field 사용
 */

interface Icall {
	void m();
}

class D implements Icall {
	@Override
	public void m() {
		System.out.println("D Icall 인터페이스의 m() 재정의");
	}
}

class F implements Icall {
	@Override
	public void m() {
		System.out.println("F Icall 인터페이스의 m() 재정의");
	}
}

//현대적인 프로그래밍 방식 (interface 대세) >> 유연성 >> 대충 만들어도 대충 ... 
//>> 느슨하게 >>

class C {
	void method(Icall ic) { // Icall을 구현하는 모든 객체의 주소로 올 수 있다
		ic.m();

	}
	/*
	 * 확장성 변환 무시 ... void method(D d) { } void m(F f) { }
	 */
}

public class Ex16_User_Provider {

	public static void main(String[] args) {

		C c = new C();
		D d = new D();
		F f = new F();

		c.method(d);
		c.method(f);

	}

}
