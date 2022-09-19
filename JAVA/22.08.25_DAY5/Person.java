package DAY5;

/*
 * class == 설계도 == 데이터 타입
 * 설계도는 종이 ... 구체화 (메모리) ... 객체
 * 구체화된 것 : 객체, 인스턴스
 * 
 * 설계도 : field(고유, 상태, 부품) + method(기능) + constructor(생성자 함수)
 * 
 * public class Ex01_Basic{
 * 	public static void main(String[] args {
 *	여기 안에다가 코드 연습
 *	main이름을 가진 함수 안 지역
 *	String name = "초기화"; local variable > 접근자 > 함수가 호출시 생성 > 함수 종료시 같이 소멸 
 * int age = 0;
 * 
 * 
 *  }
 * }
 */

public class Person {
	public String name;//default (자동) null
	public int age; //default (자동) 0
	public boolean power; //default (자동)
	
	//member field >> instance variable >> 객체변수
	//1. instance variable - 초기화를 하지 않아도 됨>> 이유 : default값
	//2. 초기화 : 변수가 처음으로 값을 할당 받는 것
	//질문 : name member field 초기화 가능? >> 필요하다면 가능 : public int age = 100
	//Today's point : 초기화를 하지 않는 이유
	//********** 생성되는 객체(사람)마다, [다른 이름을 가질 수 있다] **********	
	//Person member field 당신이 사람을 만들때마다 다른 값을 가지게 할건데 굳이 초기화를?
	
	
	
/* main() {
 * Person 남자 = new Person(); 사람 1명
 * 남자.name = "고범종"
 * 남자.age = 100;
 * 남자.power = true;
 * 
 * Person 여자 = new Person(); 사람 2명
 * 여자.name="손정원"
 * 여자.age=20;
 * 여자.power = false;
 * 
 * Person 인간 = new Person();
 * 
 */
	
	
	
	//기능
	//정보를 출력하는 기능
	public void personPrint() {
		System.out.printf("이름은 %s 나이는 %d 파워는 %s", name, age, power);
		
	}
}
