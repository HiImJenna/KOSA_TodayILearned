package DAY7;


/*
자동차 영업소 입니다.
영업사원은 고객에게 자동차를 팔려고 합니다.
고객은 자동차의 기본 사양을 살 수 도 있고 ....  여러가지 선택 옵션을 선택 할 수 있습니다.
자동차의 기본은
문의 개수 4개 , 자동차의 색상 기본은 red가 기본 입니다
그런데 고객은
문의 개수만 변경 가능하고  자동차의 색상 기본은 red  으로 할 수 있고
문의 개수는 기본으로 하고 자동차의 색상 변경 가능하고
문의 개수와 자동차의 색상 모든 변경 하여 차를 구매할 수 있습니다
​
자동차 구매
1. 기본 사양  
2. 옵션 : 문 변경 , 자동차의 색상 기본
3. 옵션 : 자동차의 색상 변경 , 문 기본
4. 옵션 : 자동차의 색상 변경 , 휠 변경

*/


// public class Ex16_Constructor_Quiz {

// 	public static void main(String[] args) {
// 		Car myCar = new Car("red", 4);
// 		myCar.show();
		
// 	}
// }

// class Car8{
// 	int door = 4;
// 	String colour = "red";
	
// 	public Car8 (String a, int b) {
// 		colour = a;
// 		door = b;
// 	}
		
// 	public void show() {
// 		System.out.println("선택하신 사양은 " + "색상 : " + colour + " , " + "문 : " + door + "입니다." );
		
// 	}
	
	
	
// }


public class Ex16_Constructor_Quiz {

	public static void main(String[] args) {
		Car myCar = new Car(); //기본 옵션
		carInfoPrint();
		Car myCar = new Car(8); //문 8개
		carInfoPrint(); 
		Car myCar = new Car(5, yellow); //문 5개 색 yellow
		carInfoPrint(); 
	}

  
}

class Car6{
	
	int door;
	String colour;
	
	public Car6() {
		door= 4;
		colour = "red";
	}
	
	public Car6(int d) { //문의 개수
		door = d;
		colour = "red";
		
	}
	
	public Car6(int d, String s) {
		door = d;
		colour = s;
	}
	
	public void carInfoPrint() {
		System.out.printf("door [%d] colour [%s] 차랑 입니다", door, colour);
	}
}












