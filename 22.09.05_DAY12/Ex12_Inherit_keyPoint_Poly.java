/*
시나리오(요구사항)
저희는 가전제품 매장 솔루션을 개발하는 사업팀입니다
A라 전자제품 매장이 오픈되면

[클라이언트 요구사항]
가전제품은 제품의 가격 , 제품의 포인트 정보를 모든 제품이 가지고 있습니다
각각의 가전제품은 제품별 고유한 이름정보를 가지고 있다
ex)
각각의 전자제품은 이름을 가지고 있다 (ex) Tv , Audio , Computer
각각의 전자제품은 다른 가격정보를 가지고 있다( Tv:5000 , Audio : 6000)
제품의 포인트는 가격의 10%적용한다

시뮬레이션 시나리오
구매자: 제품을 구매하기 위한 금액정보 , 포인트 정보를 가지고 있다
ex) 10만원 , 포인트 0
구매자는 제품을 구매할 수 있다 , 구매행위를 하게 되면 가지고 있는 돈은 감소하고 (가격) 포인트는 증가한다
구매자는 처음 초기 금액을 가질 수 있다

1차 오픈 ....
하와이 휴가 ...

공식 오픈
매장에 제품 1000개 다른 제품이 추가 (마우스 , 토스트기 ) 제품 등록 POS (자동 등록)
매장에 1000개의 제품 전시 (Product 상속하는 제품)
1. 매장에서 3개 제품만 구매 ... 997제품 구매 기능
>> PC 방  >> 국내 전상망 >> 개발 서버 접속 >> 997구매 함수 추가 ...

>>변화에 대응하는 코드  (다형성)

>>즐거운 휴가를 보내기 위한 방법 제시 (제품이 10000개 추가되더라)
1. 함수의 paramter 를 부모 (Product)  
  

*/
class Product{
	int price;
	int bonuspoint;
	//Product(){}
	Product(int price){
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
}

class KtTv extends Product{
	KtTv(){
		super(500);
	}
	//KtTv(int price){
	//	super(price);
	//}
	
	//이름
	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product{
	Audio(){
		super(100);
	}
	
	@Override
	public String toString() {
		return "Audio";
	}
}


class NoteBook extends Product{
	NoteBook(){
		super(150);
	}
	//이름
	@Override
	public String toString() {
		return "NoteBook";
	}
}

//구매자
class Buyer{
	int money = 5000;
	int bonuspoint;
	
	/*
	
	//구매자 구매행위 (기능 : method)
	//구매행위 (구매자의 잔액에서 - 제품의 가격 , 포인트 정보 갱신 +)
	//**구매자는 매장에 있는 모든 전자제품을 구매할 수 있다 ** 3개 구매가능
	void kttvBuy(KtTv n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
	}
	void AudioBuy(Audio n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
	}
	
	void NoteBookBuy(NoteBook n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
	}
	
	*/
	//1차 개선 
	//하나의 이름으로 여러가지 기능(method overloading)
	/*
	void Buy(KtTv n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
	}
	void Buy(Audio n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
	}
	
	void Buy(NoteBook n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
	}
	*/
	
	//2차개선
	//제품이 추가 되더라도 구매행위는 계속 되어야 한다
	//하나의 이름 , 중복되는 코드 (중복코드 제거)
	//모든 제품은 Product상속 >> 부모타입의 참조변수는 자식객체의 주소를 받을 수 있다
	void Buy(Product n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
	}
}

public class Ex12_Inherit_keyPoint_Poly {

	public static void main(String[] args) {
		//매장이라고 가정하고
		//KtTv kt = new KtTv();
		//System.out.println(kt.price);
		//System.out.println(kt.bonuspoint);
		//System.out.println(kt);
		
		KtTv kt = new KtTv();
		Audio audio = new Audio();
		NoteBook notebook = new NoteBook();
		
		Buyer buyer = new Buyer();
		/*
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.NoteBookBuy(notebook);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		*/
		buyer.Buy(kt);
		buyer.Buy(kt);
		buyer.Buy(notebook);
		buyer.Buy(kt);
		buyer.Buy(kt);
		buyer.Buy(kt);
		buyer.Buy(kt);
		buyer.Buy(kt);
	
	}

}