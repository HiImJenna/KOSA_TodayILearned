import kr.or.kosa.Emp;

class Test2{
	int x = 100;
	void print() {
		System.out.println("부모함수 Test2");
	}
}

class Test3 extends Test2 {
	int x = 300; // 부모 무시하기
	
	
	//재정의(검증)
	@Override
	void print() {
		System.out.println("자식이 부모의 함수를 재정의");	
	}
	
	//overloading
	void print (String str) {
		System.out.println("나는 overloading 함수야 : " + str);
	}
}

public class Ex05_Inherit_Override {
	public static void main(String[] args) {
		Test3 t3 = new Test3();
		System.out.println(t3.x); //부모의 x가 아니라 나 자신의 x를 사용 (부모무시)
		
		t3.print(); //
		t3.print("오버로딩");
		
		Emp emp = new Emp(1000, "홍길동");
		System.out.println(emp);
		System.out.println(emp.toString());
		
		//emp 출력하면 사실은 emp.toString() 동일한 효과
		// toString()은 Object의 자원 ... 주소값 return
		
		//toString() 재정의 했다면 결과는 재정의 된 내용으로 출력됨 
		//Emp [empno=1000, ename = "홍길동"]
		//Emp [empno=1000, ename = "홍길동"]
		
		//JAVA API 제공하는 수많은 클래스가 Object 클래스의  toString() 재정의 하고 있다
	}

}
