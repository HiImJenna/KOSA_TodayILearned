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

<br>

## 2. 정규표현식 조별과제 ✔
-----------------------------
### [1] 휴대폰번호📱
```java
 정규표현식 : "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$"

- ^ : 문자열이나 행의 처음
- ( ) - 하위식 : 여러 식을 하나로 묶을 수 있다.
- ?: : 비캡쳐, 그룹화 할 때 사용되지만 문자열의 일치 / 캡처 된 부분으로 저장하지는 않는다.
- | : 가능성 있는 항목들을 구별하여 선택한다.
- [(공백)] : 가능한 문자열의 집합과 일치시킨다.
- \\d{3} : 숫자 0~9가 3개
- \\d{4} : 숫자 0~9가 4개 (d = 숫자를 의미)
- $ : 문자열이나 행의 끝

1) ^01(?:0|1|[6-9])
 - ^ 으로  문자열 시작
 - 01 + '0, 1, 6, 7, 8, 9 중 하나'

2) (?:\\d{3}|\\d{4})
 - 0~9 중의 숫자 3개(d{3}), 혹은 4개를 가진다.(d{4})

3) \\d{4}$
 - 0~9 중의 숫자 4개를 가진다.
 - $로 문자열 끝
 ```
[유효성검사]
 ![image](https://cafeptthumb-phinf.pstatic.net/MjAyMjA5MTNfNzkg/MDAxNjYzMDMxNTE5NjM5.udQD-_a55xH5M65QUkaWEGfc1Ea_hyoumAg0GnyXiykg.ijj4kNCdxoGlS3wnDM6dlXMZ7ClLqs_zadEPlZkMMeAg.PNG/image.png?type=w1600)
 
 <br>

 ### [2] 차량번호
 ```java
 정규표현식 : "([가-힣]{2})?\\s?(\\d{1,3})\\s?([가-힣])\\s?(\\d{4})"

1) ([가-힣]{2})?
    [가-힣] : 모든 한글 문자를 찾음
    {2} : 수량자, 앞 문자 2개, [가-힣]{2} 이면 한글 2자를 찾음
    () : 그룹의 집합을 표현, ([가-힣]{2}) 한글 2자를 한 집합으로 인식하고 찾음
    ? : 앞 문자가 없거나 하나 있음, ([가-힣]{2})? 한글 2자가 하나인 집합이 
       있을 수도 있고 없을 수도 있음

2) \\s?
    \ : 이스케이프 문자
    \s : 공백
    공백이 있을 수도 있고 없을 수도 있음

3) (\\d{1,3})
    \d : 모든 숫자 == [0-9]
    {1,3} : 수량자, \d{1,3} 숫자 1개 이상 3개 이하

4) ([가-힣])
    [가-힣] : 한글 1자

5) (\\d{4})
    \d{4} : 숫자 4자
```
[유효성검사]
![image](https://cafeptthumb-phinf.pstatic.net/MjAyMjA5MTNfMTM2/MDAxNjYzMDMxNjQ2MTk0.YpbXmI72Yr-KY8-I310bWNLFZT8rzwZlRk5uds5J62Ag.CRDxDl31v2bqrQCKUm0U9tBb0VFf6pwljMfrIt2VK5Ug.PNG/image.png?type=w1600)

<br>

### [3] 우편번호
```java
정규표현식 : "^(6[0-3]|[0-5]\\d)\\d{3}$"

1) '^' 문자열 시작, '$' 문자열 종료, [X-X]그 숫자의 범위, [0-9] == \\d , d뒤에{}에는 숫자의 개수 만약 d{3,4}일 경우 3자리 혹은 4자리 

2) 앞자리가 6이면 두번째 수는 0-3까지만 or연산자를 걸어서 앞자리가 0-5이면 두번쨰 수는 0-9까지 그 뒤 3자리는 0-9 상관없이
```
[유효성검사]
![image](https://cafeptthumb-phinf.pstatic.net/MjAyMjA5MTNfMTUz/MDAxNjYzMDMyMzY4ODgy.0LMXTV_XeCDAUW-BbivMoIpBecp6GfgWZwpbwlzM_log.iLe8nEzo41K2RS_oifBQ5nGNvhJ6nYUITB4xHFexZu8g.PNG/image.png?type=w1600)

<br>

### [4] 우편번호
```java
정규표현식 : "(http(s)?://)([a-z0-9]+\\.*)+([a-z0-9]{2,4})\\/?"

1) / : 정규식 시작

2) http(s) : http or https 를 찾음

3) :// : '://' 찾음

4) ([a-z0-9\\w]+\\.*)+ : a ~ z, 0 ~ 9 까지의 문자가 + 1 개 이상
    끝에는 '\.' 있는 문자 감지하고 마지막으로 + 이것도 1개 이상

5) [a-z0-9]{2,4} : ".com", ".co.kr", ".net" 등을 찾음 {2,4} 2이상 4이하

6) / : 정규식 끝
```
[유효성검사]
![image](https://cafeptthumb-phinf.pstatic.net/MjAyMjA5MTNfMjg0/MDAxNjYzMDMyNTg1ODcz.5uFDtMroxMeqLy4KJVq58ecFBlA_K-EVs_KWz1J4ktsg.U-MNRPfgm46vU0PbtgEX7ouU4ZIyDDUEaocN5U8Rh-Ug.PNG/image.png?type=w1600)

<br>

### [5] 이메일주소
```java
정규표현식 : "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z]){0,63}\\@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$"

1) 시작하는 문자는 [^]이고 숫자, 영대,소문자만 들어갈수 있다.

2) () 소괄호 안의 문자를 하나의 문자로 인식하고,  &&  [-] 또는 [_] 또는[.] 문자가 [?]를 통해서 하나 있거나 없음을 나타낸다. && 나머지는 숫자 영 대소문자 나타낸다.

3)  [*]는 앞 문자가 없을 수도 무한정 많을수도 있음을 나타낸다.   &&  [@]는 그냥 골뱅이 문자

4)  [@]뒤에는 [] 로 숫자 영대소문자 나타낸다.  &&  [*] 앞에까지 위의 설명과 동일함 [.] 은 임의의 한문자 (문자의 종류 가리지 않음, 단 , \는 넣을수 없슴)

5) 영대소문자 범위 내에서 사용가능하다.   &&   2개 또는 3개 << {}는 횟수 또는 범위를 나타낸다. 영문자 2개 또는 3개입력,  &&  [$]로 문자열의 종료
```
[유효성검사]
![image](https://cafeptthumb-phinf.pstatic.net/MjAyMjA5MTNfMjA4/MDAxNjYzMDMyNjMxNDky.d-Js7OGsb57HLpgCWnEsJgziMGtFPRuj7jzlDYyFeTAg.5-m4_Li0d7Dp-G0MyxCG-rebzSuMpF7xborDnZI8zpMg.PNG/image.png?type=w1600)