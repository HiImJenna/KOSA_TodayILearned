package DAY7;
public class Ex11_Static_Method {
	
	
	
	public void method() { //heap 메모리에 로드 되고 나서 사용 가능(new ...)
		System.out.println("나 일반함수야");
	}
	
	public static void smethod() {
		System.out.println("나 static 함수야");
	}

	public static void main(String[] args) {
		
		//안에서 smethod 사용 가능
		//Ex11_Static_Method.smethod(); Ex11_Static_Method의 자원
		smethod(); //호출
		
		Ex11_Static_Method ex11 = new Ex11_Static_Method();
		//ex11참조변수 (주소를 가지고 있는 변수)는 static접근, 일반 접근 가능
		ex11.method();
		
	}

}

