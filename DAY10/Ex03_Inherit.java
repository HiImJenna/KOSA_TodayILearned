//두개의 설계도
class Tv{
	boolean power; //default = false
	int ch;
	
	void power() {
		
		this.power = !this.power;
	}
	
	void chUp() {
		this.ch++;
		
	}
	
	void chDown() {
		this.ch--;
	}
}

class Vcr { //비디오 플레이어
	boolean power;
	void power() {
		this.power = !this.power;
	}
	void play() {
		System.out.println("재생하기");
	}
	void stop() {
		System.out.println("정지하기");
	}
	void rew() {}
	
	void ff() {}	
}

//Tv 설계도
//Vcr 설계도

//TvVcr 이런 제품
//class TvVcr extends Tv, Vcr(x) 다중 상속 금지
//계층적 상속 이상(자원 이름 동일 ... 사용 불가)

// 한 놈은 상속, 한 놈은 포함 ...
//어떤 놈을 상속하고 어떤 놈을 포함할까 ...
//기준: 메인 기능을 누가 가지고 있느냐, 비중이 어디가 더 크냐

class TvVcr2 extends Tv{
	Vcr vcr;
	
	public TvVcr2(){
		vcr = new Vcr();		
	}
}

class TvVcr {
	Tv t;
	Vcr v;
	
	public TvVcr() {
		this.t = new Tv();
		this.v = new Vcr();
		
	}
}


public class Ex03_Inherit {
	public static void main(String[] args) {
		TvVcr tv = new TvVcr();
		tv.t.power();
		tv.v.power();
		
		System.out.println(tv.t.power);
		//////////////////////////////
		TvVcr2 tv2 = new TvVcr2();
		tv2.power();
		System.out.println("Tv전원 : "+ tv2.power);
		tv2.chUp();
		
		tv2.vcr.power();
		System.out.println("비디오 전원 : " + tv2.vcr.power);
		tv2.vcr.play();
	}

}
