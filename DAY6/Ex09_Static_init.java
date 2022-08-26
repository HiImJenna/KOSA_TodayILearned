package DAY6;

//static 변수는 객체마다 같은 값을 가지게 할거야를 목적으로 설계
//instance 변수는 객체마다 다른 값을 가지게 할거야를 목적으로 설계

//두 변수에 대해서 초기화 .... 

class InitTest{
	static int cv = 10;
	static int cv2;
	int iv = 11;
	//3놈은 사실 default 값은 초기화를 하지 않아도 됨
	
	static {
		//static 자원에 초기화 블럭
		//언제 실행 : static int cv = 10;과 static int cv2;이 메모리에 올라간 직후
		cv = 1111;
		cv2 = cv + 2222; //조작된 표현이 가능
		
	}
	
	{
		//초기자 블럭(member field 초기화)
		//객체가 생성되고 나서 int iv가 메모리에 올라가고 나서 바로 호출됨 ({ } <-- 이게)
		//인위적인 코드 if(iv>10) iv = 100;
		
		System.out.println("초기자 블럭");
//		int iv = 2222; 
		if(iv >10) iv = 1000;
		
		//cv = 100; 초기화 >> 객체 new하지 않으면 초기화가 되지 않음(static)
	}
}

public class Ex09_Static_init {

	public static void main(String[] args) {
		//InitTest t = new InitTest();
		//System.out.println(t.iv);
		
		System.out.println(InitTest.cv);
		System.out.println(InitTest.cv2);

	}
}
