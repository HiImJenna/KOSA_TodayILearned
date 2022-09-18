package DAY5;
public class Ex04_Modifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoteBook notebook = new NoteBook();
		notebook.setYear(-2000);
		int year = notebook.getYear();
		System.out.println("year : " + year);
		
		notebook.number = -100;
		notebook.mouse.x= 5;
		notebook.mouse.y = 4;
		
		
		
		
		
		
		
	}
	
	

}
