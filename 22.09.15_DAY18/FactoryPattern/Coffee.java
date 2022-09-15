/**
 * 상위 클래스와 하위 클래스가 분리되기 때문에 느슨한 결합을 가지며
 * 상위 클래스에서는 인스턴스 생성 방식에 대해 전혀 알 필요가 없기 때문에 많은 유연성을 갖는다
 * 객체 생성 로직이 따로 떨어져 있기 때문에 코드를 리팩토링하더라도 한 곳만 고칠 수 있게되어 유지 보수성이 증가한다.
 */
abstract class Coffee {
    /**
     * Coffee 라는 추상 클래스는 중요한 뼈대를 결정한다.
     * 이를 상속하는 하위 클래스는 객체 생성에 관한 구체적인 내용을 결정한다.
     * DefaultCoffee, Latte, Americano
     */
    public abstract int getPrice();

    @Override
    public String toString(){
        return "Hi this coffee is "+ this.getPrice();
    }
}
class DefaultCoffee extends Coffee {
    private int price;

    public DefaultCoffee() {
        this.price = -1;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
class Latte extends Coffee {
    private int price;

    public Latte(int price){
        this.price=price;
    }
    @Override
    public int getPrice() {
        return this.price;
    }
}
class Americano extends Coffee {
    private int price;

    public Americano(int price){
        this.price=price;
    }
    @Override
    public int getPrice() {
        return this.price;
    }
}
class CoffeeFactory {
    public static Coffee getCoffee(String type, int price) {
        if("Latte".equalsIgnoreCase(type)) return new Latte(price);
        else if("Americano".equalsIgnoreCase(type)) return new Americano(price);
        else{
            return new DefaultCoffee();
        }
    }
}
public class Factory_Pattern1 {
    /**
     * 이해하기 위하여 알아야 하는 것
     * 추상 클래스, 추상 메서드
     * static 키워드
     */
    public static void main(String[] args) {
        Coffee latte = CoffeeFactory.getCoffee("Latte", 4000);
        Coffee americano = CoffeeFactory.getCoffee("Americano",3000);
        System.out.println("Factory latte ::" + latte);
        System.out.println("Factory americano ::" + americano);
    }
}