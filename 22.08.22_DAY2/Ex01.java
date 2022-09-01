
public class Ex01 {
	public static void main(String[] args) {
		System.out.println("Hello");
	
		int i =100;
		//Emp 설계도를 구체화 (객체를 만들거야)
		Emp emp = new Emp();
		emp.setEmpno(-8888);
		int empno = emp.getEmpno();
		System.out.println(empno);
		
		emp.number = -100;
		emp.print();
		
	}
}
