import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 Set  인터페이스 (원 안에 들어가세요) : 순서 보장x >> 중복 허락 x
 순서가 없고 중복을 허락하지 않는 데이터 집합
 구현하는 클래스
 HashSet, TreeSet(자료구조)
 */
public class Ex10_Set {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		//순서가 없는 중복되지 않는 데이터 집합
		hs.add(1);
		hs.add(100);
		boolean bo = hs.add(55);
		System.out.println("정상 : " + bo);
		
		bo = hs.add(1);
		System.out.println("결과 : " + bo); //false //이미 원 안에는 1이라는 데이터가 존재
		
		//중복 ... 로또, 차량번호
		System.out.println(hs.toString()); //재정의 o //[1, 100, 55]

		HashSet<String> hs2 = new HashSet<String>();
		hs2.add("b");
		hs2.add("a");
		hs2.add("f");
		hs2.add("c");
		hs2.add("z");
		hs2.add("a");
		hs2.add("b");
		hs2.add("h");
		hs2.add("b");
		hs2.add("b");
		
		System.out.println(hs2.toString()); //[a, b, c, f, h, z]
		
		String[] strobj = {"A", "B", "C", "D", "B", "A"}; //1000건 (1건씩 중복)
		HashSet<String> hs3 = new HashSet<String>();
		for (int i = 0; i < strobj.length; i++) {
			hs3.add(strobj[i]); //중복데이터는 add하지 않는다
		}
		
		System.out.println(hs3.toString());
		
		//Quiz
		//HashSet을 사용해 1~45까지의 난수 6개를 넣으세요
		/*
		 int[] lotto
		 lotto[i] = (int)(Math.random()*45 + 1);
		 
	 	for(int j = 0; j<i; j++) {
	 		if(lotto[i] == lotto[j]) {
	 		i--;
	 		break;
	 		}
	 	}
		 */
		HashSet<Integer> lotto = new HashSet<Integer>();
		for (int j = 0; lotto.size()<6; j++) {
			int num = (int)(Math.random()*45 + 1);
			lotto.add(num);
			System.out.println("i : " + j + " / num : " + num);
		}
		
		System.out.println(lotto.toString());
		
		//HashSet 다형성 >> 부모 >> Set
		
		Set set2 = new HashSet();
		int index = 0;
		while(set2.size() < 6) {
			int num = (int)(Math.random()*45 + 1);
			set2.add(num); // add 추상 함수를 HashSet클래스가 재정의 
		}
		System.out.println(set2.toString());
		
		//Generic
		//HashSet<String> set3 = new HashSet<String>();
		Set<String> set3 = new HashSet<String>();
		set3.add("AA");
		set3.add("BB");
		set3.add("CC");
		set3.add("ABCD");
		
		System.out.println(set3.toString());
		
		Iterator<String> st = set3.iterator();
		while(st.hasNext()) {
			System.out.println(st.next());
		}
	}
}

