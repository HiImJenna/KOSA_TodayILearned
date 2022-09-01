package DAY7;


/*
 * 함수 사용시 parameter 값을 전달, 주소 전달
 * void m(int x){} >> x변수는 값을 받는다
 * int y = 200;
 * 호출 m(y);
 * 
 * y = 1000;변경 ...
 * 
 * call by value
 * ------------------------------------------------------------
 * 
 *  void m(Car c) {c.colour = "red"} >>c변수는 주소를 받는다
 * 
 * Car c2 = new Car();
 * 호출 m2(c2); //같은 타입의 주소값을 전달한다 (Today's point)
 * 
 * 
 * call by ref
 */


class Data { //default class
	int i;
	
}

public class Ex12_Method_Call {
	static void scall(Data sdata) { //default static
		System.out.println("함수 : " +sdata.i);
		sdata.i = 111; //0xA번지 i값을 111로 
		
	}
	
	static void vcall(int x) { //default static
		System.out.println("before x : " + x);
		x = 8888;
		System.out.println("after x : " + x);
		//////////////////////////////////////
		
	}
	
	
	public static void main(String[] args) {
		Data d = new Data(); //d의 주소값 OxA ... 
		d.i = 100;
		//1. 
		System.out.println("d.i : " + d.i);
		//2.
		scall(d); //주소값 전달 (0xA번지)
		//3. 
		System.out.println("after d.i : " + d.i);
		
		vcall(d.i); //값만 전달 (100)
		System.out.println("d.i : " + d.i); //값은 변경되지 않음
	
	}

}
