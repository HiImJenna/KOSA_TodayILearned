import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 HashMap<K, V>
 
 HashMap<String, String>
 HashMap<Integer, String> 
 HashMap<String, Student> **POINT** 
 
 >> put("kglim", new Student());
 
Student st = new Student();
 >> put("kglim", st);
 
 class Student{ //클래스 == 데이터 타입
 
 }
 
 */

class Student {
	int kor;
	int maths;
	int eng;
	String name;
	
	public Student(int kor, int maths, int eng, String name) {
		super();
		this.kor = kor;
		this.maths = maths;
		this.eng = eng;
		this.name = name;
	}
}

class ArrayTest {
	//주의사항
	//Generic 타입으로 배열 가능
	ArrayList <String[]> al = new ArrayList<String[]>();

}


public class Ex15_Map_Generic {

	public static void main(String[] args) {
		HashMap<String, String> sts = new HashMap<String, String>();
		sts.put("A", "AAA");
		System.out.println(sts.get("A")); ///AAA
		
		//실무에서는 Map
		//학생들의 성적 데이터 
		//kim, [국어, 영어, 수학] >> Array, Collection(ArrayList (o))
		//value값은 객체타입(Emp, Student)
		
		//Map<String, Student> smap = new HashMap<String, Student>();
		
		//Today's Point
		HashMap<String, Student> smap = new HashMap<String, Student>();
		smap.put("hong", new Student(100, 80, 50, "홍길동"));
		smap.put("kim", new Student(50, 30, 60, "김유신"));
		
		Student sd = smap.get("hong");
		System.out.println(sd.kor);
		System.out.println(sd.maths);
		//System.out.println(smap.get("hong").kor);
		
		// ...
		ArrayTest at = new ArrayTest();
		String[] starr = {"A", "B", "C"};
		at.al.add(starr);
		
		//Tip 1
		Set set = smap.entrySet(); //Map key, value 가공 >> key + "=" + value
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//hong=Student@9a7504c
		//kim=Student@2c039ac6

		//Tip 2 : key, value 분리돼서 결과를 보고 싶어요
		//class Entry{Object key, Object value}
		// MAp {Entry[] elements} >> Map.Entry
		for(Map.Entry m : smap.entrySet()) System.out.println(m.getKey() + "/" + ((Student)m.getValue()).name);
	}

}
