package DAY6;

import java.util.Scanner;

/*우리 회사는 비행기를 주문 제작 판매 하는 회사입니다
 * 우리 회사는 비행기를 생산하는 설계도를 만들려고 합니다
 * 
 * 요구사항
 * 1. 비행기를 생산하고 비행기의 이름과 번호를 부여해아함
 * 2. 비행기가 생산되면 비행기의 이름과 번호가 맞게 부여되었는지 확인하는 작업이 필요함(출력)
 * 3. 공장장은 현재까지 만들어진 비행기의 총 누적대수를 확인할 수 있다.
 * 
 * AirPane air101 = new AirPlane();
 * air101 이름 >> 대한항공
 * air101 번호 >> 707
 * 출력 확인..
 * ... 5대
 * 관리자 비행기 누적 대수 확인 ... 5대 제작 되었습니다.
 */


public class AirPlane {
	
	private int airnum;
	private String airname;
	private static int airtotalcount; //모든 객체가 공유하는 자원
	
	public void makeAirPlane(int num, String name) {
		airnum = num;
		airname = name;
		//airtotalcount 누적대수
		airtotalcount++;
		
		AirDisplay();
	}
	
	private void AirDisplay() {
		System.out.printf("번호[%d], 이름[%s] \n", airnum, airname);
	}
	
	public void airPlaneTotalCount() {
		System.out.printf("총 비행기 제작 대수 : [%d] \n", airtotalcount );
	}
	
	
	
	
	
	
//	
//	Scanner sc = new Scanner(System.in);
//	int number = sc.nextInt();
//	String name = sc.nextLine();
//	
//	
//	public void check_num(int data) {
//		if (data == number) {
//			System.out.println("비행기 번호가 알맞게 부여되었습니다");
//		} else if(data != number) {
//			System.out.println("올바른 비행기 번호를 부여하십시오");
//		}
			
	}
	
	
	
	
	
	
	
	
	