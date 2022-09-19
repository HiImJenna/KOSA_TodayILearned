# 2022.09.19.Fri 📅
<br>

## 1. Design Pattern ✔
-----------------------------
### 🔔 Factory Pattern
![002](https://user-images.githubusercontent.com/111114507/190994480-7b8001c7-0697-4631-8b3e-01f33181cac6.jpg)
![003](https://user-images.githubusercontent.com/111114507/190994603-9aa0f939-68d4-441f-8a99-4735aa9f4884.jpg)
![004](https://user-images.githubusercontent.com/111114507/190994669-c5905007-df46-4a2b-adb2-ad9d516dda82.jpg)
![005](https://user-images.githubusercontent.com/111114507/190994712-e9be3ef1-c383-44a7-9c1b-f6ac75889ce3.jpg)

#### [소스]
```java
abstract class Coffee {
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
public class FactoryPattern {
    public static void main(String[] args) {
        Coffee latte = CoffeeFactory.getCoffee("Latte", 4000);
        Coffee americano = CoffeeFactory.getCoffee("Americano",3000);
        System.out.println("Factory latte ::" + latte);
        System.out.println("Factory americano ::" + americano);
    }
}
```

### 🔔 Template Pattern
![006](https://user-images.githubusercontent.com/111114507/190995234-a34d71ba-0536-40d3-b5af-73c8105ad6e3.jpg)
![007](https://user-images.githubusercontent.com/111114507/190995292-b81df7b7-ec4d-437e-8664-9e97d7ae70d9.jpg)
![008](https://user-images.githubusercontent.com/111114507/190995332-4302f4b9-21d8-420c-b2d6-9295e74bb663.jpg)
![009](https://user-images.githubusercontent.com/111114507/190995508-31394de0-0013-4ae3-86f4-953a50e36ab1.jpg)

#### [소스]
```java
abstract class Character {
    /**
     * 상속하는 클래스가 Human 과 Elf 가 있음
     * 그런데 각각 Human과 Elf는 얼굴 선택이 다를 수 있음
     * 마찬가지로 키 또한 다를 수 있음
     */

    // final 키워드를 붙이면 상속은 하지만 재정의 하는 것을 금지할 수 있음
    public void makeCharacter() {
        /**
         * selectFace()와 selectTall()은 Human과 Elf가 다를 수 있지만
         * Human과 Elf가 얼굴과 키가 다를 수 있지만
         * 캐릭터를 만드는 과정은 아래와 같이 동일함
         *
         * 다만 selectFace()와 selectTall()은 Character의 자식 클래스인
         * Human과 Elf에서 각기 다르게 구현될 것임
         */
        decideID();
        selectFace(); // Human과 Elf 가 다를 수 있음
        selectTall(); // Human과 Elf 가 다를 수 있음
        addNickName();// 기호에 따라 선택할 수 있음, 선택 사항
    }

    protected void decideID() {
        System.out.println("id 선택");
    }
    protected abstract void selectFace();
    protected abstract void selectTall();
    protected void addNickName() {
        System.out.println("nickName 추가");
    }
}

class Human extends Character {
    @Override
    protected void selectFace() {
        System.out.println("인간 종족 중 얼굴 선택 모드 실행!!");
    }

    @Override
    protected void selectTall() {
        System.out.println("인간종족의 키 범위 선택!!!");
    }
}

class Elf extends Character {

    @Override
    protected void selectFace() {
        System.out.println("엘프 종족 중 얼굴 선택!!!");
    }

    @Override
    protected void selectTall() {
        System.out.println("엘프 키 범위 중 고르세요~~!!");
    }
}

public class TemplatePattern {
    public static void main(String[] args) {

        Character human = new Human();
        human.makeCharacter();

        Character elf = new Elf();
        elf.makeCharacter();
    }
}
```