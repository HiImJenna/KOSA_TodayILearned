package FactoryPattern;
abstract class Character {
    public void makeCharacter() {
        decideID();
        selectFace(); s
        selectTall(); 
        addNickName();
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

public class TemplateMethodPatternMain {
    public static void main(String[] args) {

        Character human = new Human();
        human.makeCharacter();

        Character elf = new Elf();
        elf.makeCharacter();
    }
}

