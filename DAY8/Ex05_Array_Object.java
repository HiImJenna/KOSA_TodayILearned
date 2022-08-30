//클래스 == 타입 == 설계도

class Person {
	String name;
	int age;
	//사람을 만들 때 반드시 이름, 나이를 가지게 할려면
	//Person(String name, int age) {this.name = name; this.age = age}
	void print() {
		System.out.println(this.name + " , " + this.age);
	}
	
}
public class Ex05_Array_Object {

	public static void main(String[] args) {
		int[] intarr = new int[10]; //값타입 배열(8가지) + String
		boolean[] booarr = new boolean[5]; //값타입 (5개 방에 false)
		
		Person p = new Person(); //참조변수(p라는 변수는 주소값)
		p.name = "홍길동";
		p.age = 100;	
		
		//사람 3명을 만드세요
		//Person p = new Person();
		//Person p2 = new Person();
		//Person p3 = new Person();
		
		// int[] intarr = new int[10];
		Person[] people = new Person[3];
		System.out.println("people : " + people);
		System.out.println("people[0] :" + people[0]); //각각의 방은 null default 값
		//객체 배열은 방을 만들고 방에 객체를 넣어주는 작업을 행해야함
		//people[0] person 객체의 주소를 가진다
		people[0] = new Person();
		Person p2 = new Person();
		people[1] = p2;
		people[2] = new Person();
		
		System.out.println("people[0] :" + people[0]);
		System.out.println("people[1] :" + people[1]);
		System.out.println("people[2] :" + people[2]);
		
		people[0].name = "김유신";
		people[0].age = 100;
		//객체 배열은 방을 만드는 것과 방을 채우는 작업은 별도다.
		for(int i = 0; i <people.length; i++) {
			System.out.println(people[i].name);
		}
		
		
		//객체 배열 3가지 방법으로 만들기 
		//1. int[] arr = new int[10]
		Person[] parray = new Person[10]; //방만 생성
		for (int i = 0; i < parray.length; i++) {
			parray[i] = new Person();
			System.out.println("주소값 : " + parray[i]);
		}
		
		
		//2. int[] arr = new int[] {10, 20, 30}
		Person[] parray2 = new Person[] {new Person(), new Person(), new Person()}; //주소를 만들어서 넣어주면 됨
		
		//3. int[] arr= {10, 20, 30}
		Person[] parray3 = {new Person(), new Person(), new Person()};
	}

}
