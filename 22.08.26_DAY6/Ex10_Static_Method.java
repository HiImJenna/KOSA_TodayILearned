package DAY6;
/*
 * static member field : 객체간 공유자원 ...
 * static method : why : 첫 날 첫 시간 했던 코드
 * 1. 객체 생서 없이 .... 
 * 2. 많이 사용해요
 * 3. 설계도를 만들때 고려해요 (당신이 그 자원을 많이 사용한다면)
 * 4. 자원 많이 쓰네 ... 편하게 쓰게 해줄게 ... new 객체 ... 불편하지 ... 
 */

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
