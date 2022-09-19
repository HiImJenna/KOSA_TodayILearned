/**
 * 의도 실제 행위(메서드, 기능)를 하위 클래스에게 구현을 맡김
 * 활용 예제 수많은 Framework에서 발견됨
 *
 * 예제 게임 캐릭터를 만듦
 */

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