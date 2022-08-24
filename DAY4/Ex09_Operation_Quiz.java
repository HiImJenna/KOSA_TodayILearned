import java.util.Scanner;

public class Ex09_Operation_Quiz {
    public static void main(String[] args) {
        
/*

		간단한 사칙 연산기 (+ , - , * , /)

		입력값 3개 (입력값은 nextLine() 받아서 필요하다면 숫자 변환)

		목적 : Integer.parseInt() ,  **equals() 활용**

		화면

		>입력값:숫자

		>입력값(기호): +

		>입력값:숫자 

		>연산결과 :200

		​

		-------------

		>입력값:100

		>입력값(기호): -

		>입력값:100

		>연산결과 :0​

		*/
		
		Scanner sc = new Scanner(System.in);
		
        System.out.print("입력값 : ");
		int number1 = Integer.parseInt(sc.nextLine());

        System.out.print("입력값(기호) : ");
		String symbol = sc.nextLine();

        System.out.print("입력값 : ");
		int number2 = Integer.parseInt(sc.nextLine());

	    int result = 0;
      

		
		if (symbol.equals("+") ) {
			result = number1 + number2;
		} else if (symbol.equals("-") ) {
			result = number1 - number2;
        } else if (symbol.equals("/") ) {
			result = number1 / number2;
        } else if (symbol.equals("*") ) {
			result = number1 * number2;
        }
		
        System.out.println("입력결과 : " + result);

		sc.close();
		
		
	}
}
