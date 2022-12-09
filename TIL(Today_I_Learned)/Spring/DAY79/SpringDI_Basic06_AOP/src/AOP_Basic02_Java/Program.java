package AOP_Basic02_Java;


import java.lang.reflect.Proxy;

public class Program {

   public static void main(String[] args) {
      
      //1. 실객체의 주소
      Calc calc = new NewCalc();
      
      //2. 가짜 생성
      //getClass() 객체가 속하는 클래스의 정보를 알아내는 메소드
      //proxy의 사전적 정의는 대리인이다.프록시는 타겟의 기능을 확장하거나 타깃에 대한 접근을 제어하기 위한 목적으로 사용하는 클래스를 말한
      //https://live-everyday.tistory.com/216 선행
      //https://live-everyday.tistory.com/217 후행 (다이나믹 프록시) 우리와 같은 방식
      
      Calc cal = (Calc)Proxy.newProxyInstance(calc.getClass().getClassLoader(), //실객체의 메타 정보(내부정보)  프록시 클래스를 만들 클래스로더
                                 calc.getClass().getInterfaces(),       //행위정보(인터페이스) 프록시 클래스가 구현할 인터페이스 목록
                                 new LogPrintHandler(calc));            //보조객체(공통관심) 객체 정보 메서드 호출시 실행될 핸들러
   /////////////////////////////////////////////////////////////////////////////////
      //사용자는
      int result = cal.ADD(555, 555);
      System.out.println("result : " + result);
   }

}