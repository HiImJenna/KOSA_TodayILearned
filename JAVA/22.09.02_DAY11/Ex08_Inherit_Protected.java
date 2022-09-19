import kr.or.kosa.Pclass;

/*
상속관계에서 ... 접근자 : protected

public 
private
default (같은 폴더)
protected

protected : 양면성(박쥐) >> default , public 
>>상속이 없는 클래스 안에서 protected >> default 동일 
>>결국 상속관계에서만 의미를 가진다 >> public 
*/
class Dclass{
	public int i;
	private int p;
	int s; //default 
	protected int k; //default (why ... 사용하지 않아요)
}

class Child2 extends Pclass { //상속관계
	void method() {
		this.k = 100; //상속관계 >> 자식은 부모의 protected 자원을 public 처럼 사용
		System.out.println(this.k);
	}
}

public class Ex08_Inherit_Protected {
	public static void main(String[] args) {
		Pclass p = new Pclass();
		//p.i
		//p.k  >> 객체 생성 사용 (default)
		Child2 ch = new Child2();
		ch.method();
	}

}
