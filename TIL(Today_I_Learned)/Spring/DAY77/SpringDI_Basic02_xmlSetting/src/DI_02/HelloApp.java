package DI_02;

public class HelloApp {

	public static void main(String[] args) {
		//영문
		//MessageBean_en messagebean_en = new MessageBean_en();
		//messagebean_en.sayHello("hong");

		//한글
		//MessageBean_kr messagebean_kr = new MessageBean_kr();
		//messagebean_kr.sayHello("hong");
		
		//인터페이스 사용 (다형성)
		MessageBean messagebean = new MessageBean_kr(); // new MessageBean_en();
		messagebean.sayHello("hong");
	}
	

}
