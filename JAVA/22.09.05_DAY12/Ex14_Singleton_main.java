import kr.or.kosa.Singleton;

public class Ex14_Singleton_main {

	public static void main(String[] args) {
		//Singleton singleton = new Singleton();
		Singleton s = Singleton.getInstance();
		System.out.println(s);
		Singleton s2 = Singleton.getInstance();
		System.out.println(s2);
		Singleton s3 = Singleton.getInstance();
		System.out.println(s3);
		//출력값 모두 [kr.or.kosa.Singleton@3e57cd70]
	}

}
