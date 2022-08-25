package DAY5;

public class NoteBook {
	public Mouse mouse = new Mouse(); //Mouse라는 타입은 클래스 >> 참조변수 mouse >> 주소값
	
	
	
	public String colour;
	//객체 지향 언어 (캡슐화, 은닉화 : 직접적으로 값을 변경하고 쓰는 것 방지)
	//year 마이너스값 넣지 말기로 -> 미리 막기 >> 사용불가 >> 간접적으로 사용 가능하도록 허용 ... >> 누군가 통해서 read, write
	//간접 >> 개발자가 논리를 통해 제어하겠다
    //public int year;
	private int year;
	
	//약속 : 캡슐화시 read, write 함수 필요 >> 표준화 >> getYear.., setYear >> setter, getter
	
	
	public void setYear (int data) { //간접할당의 장점 = 내가 원하는대로 )
		if(data < 0 ) {
			year = 1999;
		} else {
			year = data;
		}
	}
	
	public int getYear() { //간접적으로 year member field값을 return
		return year;
	
		//year read 함수S
//		public int readYear() { //간접적으로 year member field값을 return
//			return year;
//		}
//		
		
		
}
}
