package DAY5;

/*
     TV 설계도 요구사항 정의
     TV는 채널 정보를 가지고 있다(예를 들면 1~200 값을 가질 수 있다)
     TV는 브랜드 이름을 가지고 있다 (예를 들면 엘지 , 삼성)
     TV는 채널 전환 기능을 가지고 있다 (채널은 한 채널 씩 이동이 가능하다)
     ->채널을 증가 시키는 기능을 가지고 있다
     ->채널을 감소 시키는 기능을 가지고 있다
     TV의 채널정보와 브랜드 이름을 볼 수 (출력) 있는 기능을 가지고 있다.
 */

public class TV {
    public int ch; //default >0
    public String brandname; //default > null
    public void Ch_up() {
        ch++;
    }
    public void ch_down() {
        ch--;
    }
    public void tvInfo() {
        System.out.printf("[%s] , [%d] \n", brandname , ch);
    }
}
