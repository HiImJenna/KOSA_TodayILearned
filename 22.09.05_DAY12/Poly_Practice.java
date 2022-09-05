
/*시나리오(요구사항)
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
public class Poly_Practice {
*/
class Poly_Practice{
	public static void main(String[] args) {
        LgTv lgtv = new LgTv();
        Radio radio = new Radio();
        Xbox xbox = new Xbox();
        Purchase purchase = new Purchase();

        purchase.Buy(xbox);
        purchase.Buy(xbox);
        purchase.Buy(xbox);
        purchase.Buy(radio);
        purchase.Buy(lgtv);

    }
}

class Product {
    int price;
    int point;

    Product(int price){
        this.price = price;
        this.point = (int)(this.price / 10.0);
    }
}

class LgTv extends Product {
    LgTv() {
        super(500);
    }

    public String toString(){
        return "LgTv";
    }
}
class Radio extends Product{
    Radio() {
        super(180);
    }

    public String toString(){
        return "Radio";
    }
}
class Xbox extends Product{
    Xbox() {
        super(600);
    }

    public String toString(){
        return "Xbox";
    }
}

class Purchase {
    int money = 10000;
    int point;

    void Buy(Product n){
    if(this.money < n.price){
        System.out.println("잔액이 부족합니다" + this.money);
    }
    this.money -= n.price;
    this.point += n.point;

    }
}