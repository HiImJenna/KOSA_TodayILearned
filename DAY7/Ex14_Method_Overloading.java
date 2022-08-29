package DAY7;

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
