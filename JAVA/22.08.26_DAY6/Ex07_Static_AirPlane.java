package DAY6;

import kr.or.kosa.AirPane;

public class Ex07_Static_AirPlane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//비행기 3대를 만드시고 확인하세요
		AirPane air1 = new AirPane();
		air1.makeAirPlane(101, "대한항공");
		air1.airPlaneTotalCount();
		
		AirPane air2 = new AirPane();
		air2.makeAirPlane(707, "대한항공");
		air2.airPlaneTotalCount();
		
		AirPane air3 = new AirPane(); 
		air3.makeAirPlane(707, "대한항공");
		air3.airPlaneTotalCount();
	}

}
