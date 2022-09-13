import java.util.ArrayList;

class EmpData {
	private String name; // default >> null
	private int[] numbers; // default >> null
	private ArrayList elist; // default >> null

	// 초기화
	public EmpData() {
		this.name = "아무개";
		// 사용자가 만든 타입, Array, ArrayList >> 초기화 > 메모리(new)
		this.numbers = new int[10];
		this.elist = new ArrayList();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// int[] numbers gettter, setter 만들어보기 (같은 타입의 주소값을**)
	public int[] getNumbers() {
		return this.numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public ArrayList getElist() {
		return this.elist;
	}

	public void setElist(ArrayList elist) {
		this.elist = elist;
	}
}

public class Ex04_ArrayList {

	public static void main(String[] args) {

		EmpData empdata = new EmpData();
		System.out.println(empdata.toString()); // 출력값 : 주소값
		System.out.println(empdata.getElist().toString()); // 재정의 >> [ ]

		ArrayList li = new ArrayList();
		li.add(100);
		li.add(200);

		empdata.setElist(li);
		System.out.println(empdata.getElist().toString());

		
		ArrayList<String> slist = new ArrayList<String>();
		slist.add("superman");
		slist.add("hullk");
		slist.add("captin");
		System.out.println(slist.toString()); //[superman, hullk, captin]
		
		ArrayList<Integer> intlist = new ArrayList<Integer>(20);
		System.out.println(intlist.size()); //0
		System.out.println(intlist.add(100)); //true 정상적으로 처리 되었어
		System.out.println(intlist.size()); // 1
	}

}
