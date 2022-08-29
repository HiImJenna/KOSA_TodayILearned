package DAY7;

/*
 * 원칙 : 객체를 만들 때 생성자는 1개만 호출 가능(new Car() or new Car(10)...)
 * this(객체) : 여러개의 생성자 호출 가능
 * 코드량도 감소
 */


public class Ex20_this {

	public static void main(String[] args) {
	
		Zcar zcar= new Zcar();
		zcar.print();

	}

}

class Zcar{
	String colour;
	String geartype;
	int door;
	
	Zcar() { //default
		this("red", "auto", 2);
		// this.colour = "red";
		// this.geartype = "auto";
		// this.door = 2;
				
		System.out.println("default ... ");
	}
	
	Zcar(String colour, String geartype, int door) {
		this.colour = colour;
		this.geartype = geartype;
		this.door = door;
		System.out.println("overloading ...");
	}
	
	void print() {
		System.out.println(this.colour + " , " + this.geartype + " , " + this.door);
	}
}