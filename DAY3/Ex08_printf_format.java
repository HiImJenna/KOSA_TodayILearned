
public class Ex08_printf_format {

	public static void main(String[] args) {
		System.out.println(); //출력하고 줄바꿈(엔터)
		System.out.print("A");
		System.out.print("B");
		System.out.print("C");
		System.out.println();
		System.out.println("C");
		System.out.println();
		
		int num = 100;
		System.out.println(num);
		System.out.println("num값은" + num + " 입니다.");
		
		//형식 format
		System.out.printf("num 값은 %d입니다.", num);
		System.out.printf("num 값은 [d%] 입니다. 또 [%d]도 있습니다. \n" , num, 12345);
		
		//format 형식문자
		/*
		 * %d (10진수 형식의 정수)
		 * %f (실수)
		 * &s (문자열)
		 * %c (문자)
		 * \t tabl, \n enter
		 */

		float f = 3.14f;
		System.out.println(f);
		System.out.printf("f변수값 %f 입니다. \n", f);
		
	}

}
