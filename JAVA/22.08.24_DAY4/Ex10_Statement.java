import java.util.Iterator;

public class Ex10_Statement {

	public static void main(String[] args) {
		
		//제어문
		//조건문 : if (3가지), switch(조건) {case 값 ...break}
		///반복문 : for(반복 횟수가 명확), while(진위){}, do {} ~ while ()
		//분기분 : break(블럭탈출), continue(아래구문 skip)
		
		int count = 0;
		if (count < 1) System.out.println("true");
		if (count < 1) {
			System.out.println("true");
		}
	
	
	char data = 'A';
	
	switch(data) {
		case 'A' : System.out.println("문자 비교, 같아요");
			break;
		case 'B' :
			break;
		default : System.out.println("나머지 처리 ... ");
	}
	
	///for문
	///1 ~ 100 누적값
	
	int sum = 0;
	
	for (int i = 1; i <= 100; i++) {
		System.out.println(" i : " + i);
		sum += i;
	}
	System.out.printf("1~100까지의 누적값 : %d ", sum);
	System.out.println();
	
	//1~5까지의 합
	///for & while 사용 X
	///개수 * (시작 + 끝) / 2
	sum = 5 * (1 + 5) / 2;
	System.out.println("sum : " + sum);
	
	//for문을 사용해서 1~10까지의 홀수의 합을 구하세요. 
	//단, for문만 사용 (if문 사용 X)
	
	int result = 0;
	
	for (int i = 1; i <= 10; i+=2) {
		result += i;
	}
	System.out.println("1부터 10까지의 홀수의 합 : " + result);
	
	
	/// for문 안에 if문을 사용해서 1~1000까지의 짝수의 합을 구하세요.
	
	int result2 = 0;
	
	for (int i = 1; i <= 1000; i++) {
		if (i % 2 == 0) {
			result += i;
		} 
	}
	System.out.println("1부터 1000까지의 짝수의 합 : " + result);
	
	/// 구구단
	/// 중첩 for
	/// 한개의 값을 고정 ... 반복
	
	for (int i = 2; i <= 9; i++) { //i라는 블럭변수는 유효범위
		for(int j = 1; j<= 9; j++) { //j라는 블럭변수
			System.out.printf("[%d]*[%d]=[%d]\t", i, j, i*j);
		}
		System.out.println();
	}
	
	// for + (분기문) continue, break
	//Today's point : continue (아래 구분 skip), break(for, while 블럭 탈출)
	for(int i =2; i<=9; i++ ) {
		for (int j = 0; j <= 9; j++) {
			if(i == j) {
				continue; //아래 구문 스킵
			}
			
			System.out.printf("[%d]*[%d]=[%d]\t", i, j, i*j);
		}
		System.out.println();
	}
	
	for (int i = 2; i <= 9; i++) {
		for (int j = 1; j < i; j++) { //j <= 9콛를 변경 >> j < i
			System.out.println("*");
		}
		System.out.println();
	}
	
	//100부터 0까지 출력
	for (int i = 100; i >= 0; i--) {
		System.out.println(i);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	}
}