
public class Ex02_Exception {

	public static void main(String[] args) {
	
		System.out.println("main start");
		int num = 100;
		int result = 0;
		
		//원인분석(코드 끝까지)
		try {
			for(int i = 0; i < 10 ; i++) {
			result = num / (int)(Math.random() * 10); //0 ~ 9
			System.out.println("result : " + result + " i : " + i);
			} 
		} catch (ArithmeticException e) { //문제가 발생되면 발생객체의 주소를 받아서 원인 분석
			System.out.println("문제가 발생하면 발생 객체의 주소를 받아서 원인 분석");
			System.out.println("원인 : " + e.getMessage());
			//catch (Exception e)보다는 구체적인 객체를 명시하는것이 가독성을 좋게 한다
		}
		
		System.out.println("main end");
		
		
		
		
		
		
		
		
		
		

	}

}
