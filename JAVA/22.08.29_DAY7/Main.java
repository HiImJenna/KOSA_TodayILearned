public class Main {

	public static void main(String[] args) {
		Car myCar = new Car("red", 4);
		myCar.show();
	}
}

class Car{
	int door = 4;
	String colour = "red";
	
	public Car (String a, int b) {
		colour = a;
		door = b;
	}
		
	public void show() {
		System.out.println("선택하신 사양은 " + "색상 : " + colour + " , " + "문 : " + door + "입니다." );
		
	}
}