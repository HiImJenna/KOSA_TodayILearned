import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
 Collection FrameWork
 (수 많은 인터페이스와 그 것을 구현하고 있는 수 많은 클래스가 있어요)
 
 Interator 인터페이스
 (반복자)
 [나열된 자원에 대해 순차적으로 접근해서 값을 리턴하는 **표준**을 정의]
 추상함수로 정의하고 있다 >> ArrayList는 추상함수를 구현(표준화된)
 
  Interator 인터페이스가 가지고 있는 추상 함수
  >> hasNext(), Next(), remove() 추상
  >> ArrayList implements Interator{ hasNext()를 재정의 구현하고 있음 }
 */
public class Ex09_Collection_Interator {

	public static void main(String[] args) {
	
		ArrayList list = new ArrayList();
		list.add(100);
		list.add(200);
		list.add(300);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//표준화된 출력 방식 ( 순서대로 나열된 데이터에 대해서 )
		Iterator it = list.iterator(); //호출하면 함수안에서 인터페이스를 구현하는 객체가 생성되고 그 주소를 리턴
		//Iterator it 부모타입
		while(it.hasNext()) { //현어코드 권장사항(표준화)
			System.out.println(it.next());
		}
		
		ArrayList<Integer> intlist = new ArrayList<Integer>();
		intlist.add(1);
		intlist.add(2);
		intlist.add(3);
		
		Iterator it2 =  list.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		System.out.println("================");
		for (int i = 0; i < intlist.size()-1; i--) {
			System.out.println(intlist.get(i));
		}
		
		////////////////////////////////////////////
		// Interactor 인터페이스 표준화중 순 방향 출력 ...
		// 역방향 조회 표준화?
		ListIterator<Integer>it3 = intlist.listIterator();
		
		//순방향
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
		//역방향
		while(it3.hasPrevious()) {
			System.out.println(it3.previous());
		}
	}
}
