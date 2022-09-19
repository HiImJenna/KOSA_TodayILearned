import java.util.Vector;

/*
 Collection FrameWork
 다수의 데이터를 다루는 표준화된 인터페이스를 구현하고 있는 [클래스 집합]
 
 Collection 인터페이스 -> 상속 List (구현 : ArrayList), Set (구현 : HashSet .. )
 
 >> ArrayList 부모타입은 List 이다 (OK) >> 다형성
 >> Collection 은 ArrayList의 부모타입이다.(OK) >> 다형성
 
 Map 인터페이스(key, value) 쌍의 배열 -> (구현 : HashMap)
 
 1. List (줄을 서시오)
 순서(번호표), ㅈ중복(허용) > 내부적으로 데이터 (자료) > 배열관리 > [홍길동][홍길동][홍길동]
  1) Vector(구버전) -> 동기화 보장(멀티스레드) -> Lock(장치)보호 -> 성능 조금
  2) ArrayList(신버전) -> 동기화 보장(멀티스레드) -> Lock옵션(기본x) -> 성능 우선 
  
--------------------------------------------------------------------------------

기존 다수의 데이터를 다루는 방법: Array (정적, 고정)
****기존 배열은 방의 개수가 한번 정해지면 방의 크기는 변경 불가****

int[] arr = new int[5];
arr[0] = 100;
int[] arr2 = {10, 20, 30}
데이터가 많아지면 새로운 크기의 배열 만들고 데이터 이동 (코드로 직접 구현) ***

Array
1. 배열의 크기가 고정: Car[] cars = {new Car(), new Car()}; 방 2개
2. 접근 방법 (index 첨자) 방번호 접근 : cars[0] ,,, n(length-1)방
  
List 인터페이스를 구현하고 있는 (Vector, ArrayList)
1. 배열의 크기를 동적으로 확장 or 축소 가능 >> 진실은 컴파일러가 새로운 배열 만들고 이동을 알아서
2. 순서를 유지 (내부적으로 배열 사용)
3. 데이터 저장 공간 : Array

 */

public class Ex01_Vector {

	public static void main(String[] args) {
		
		Vector v = new Vector();
		System.out.println("초기 default 용량 : " + v.capacity()); //10
		System.out.println("size : " + v.size()); //0 - 실데이터 크기
		
		v.add("AA");
		v.add("AA");
		v.add("AA");
		v.add(10);
		
		System.out.println("size : " + v.size());
		System.out.println(v.toString()); //[AA, AA, AA, 10] 재정의 데이터 출력
		//Array >> length >> 편법으로 index 개념을 만들어서 마치 size처럼
		//Collection >> size
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i)); //get(index) 값을 return : 정적 array[index]			
		}
		//개선된 for문
		for (Object obj : v) System.out.println();
		// 단점 : 작은 데이터 (같은 타입의 데이터) ... 가장 큰 타입을 사용하는 것 불합리
		// 제너릭 : 타입을 강제 >> 추후 별도 학습 예정(POINT)
		Vector<String> v2 = new Vector<String>();
		v2.add("hello");
		v2.add("world");
		
		for(String str : v2) System.out.println(str);
		
		Vector v3 = new Vector();
		System.out.println(v3.capacity());
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A"); //11번째
		
		System.out.println(v3.toString());
		System.out.println(v3.capacity());
		
		// 증명 : 그냥 쓰면 돼용 (시스템이 알아서 하니까)
	}
}
