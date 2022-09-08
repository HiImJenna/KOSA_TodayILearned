import java.util.ArrayList;

import kr.or.kosa.Emp;

public class Ex03_ArrayList_Object {
	public static void main(String[] args) {
		//1. 사원 1명
		Emp emp = new Emp(1000, "김유신", "장군");
		System.out.println(emp.toString());
		
		//2. 사원 2명(Array)
		Emp[] emplist = {new Emp(2000, "손정원", "학생"), new Emp(3000, "강사님", "강사")};
		for(Emp e : emplist) System.out.println(e.toString());
		
		//3. 사원이 1명 더 (300, 이씨, IT) -> 방 3개짜리 배열 생성 후 이사 ... >> ArrayList
		
		//ArrayList
		ArrayList elist = new ArrayList();
		elist.add(new Emp(2000, "손정원", "학생"));
		elist.add(new Emp(3000, "강사님", "강사"));
		elist.add(new Emp(300, "이씨", "IT"));
	
		
		for (int i = 0; i < elist.size(); i++) {
			System.out.println(elist.get(i).toString());
			
			//Emp e = (EMP)elist.get(i);
			//e.toString();
		}
		
		elist.add(new Emp(400, "최씨", "관리"));
		
		//toString() 사용하지 말고 4명의 사원의 사번, 이름, 직종을 출력하세요
		//for문 안에서 getEmpno, getEname, getJob
		for (int i = 0; i < elist.size(); i++) {
			Object obj = elist.get(i);
			//ob.toString()
			//Object : 모든 타입의 부모타입 (downcasting)
			
			Emp e = (Emp)obj;
			System.out.println(e.getEmpno() + "." + e.getEname() + "." + e.getJob());

		}
		
		
		//현업개발자 ... Object type >> downcasting ... 자식요소 접근
		//Object 쓰지 말자 ... 대안
		//타입을 강제(그 타입만 쓰도록) > 하나의 타입만을 가지고 데이터 관리
		//제너릭(객체 생성시 타입 강제 방법)
		ArrayList<Emp> list2 = new ArrayList<Emp>();
		// list2.add(emp)
		list2.add(new Emp(1, "A", "IT"));
		
		for(Emp e : list2); System.out.println(e.getEmpno());
	}
}
