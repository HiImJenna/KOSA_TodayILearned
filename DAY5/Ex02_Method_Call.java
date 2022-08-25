package DAY5;


public class Ex02_Method_Call {
   public static void main(String[] args) {
      //Fclass 생성 ... 메모리에 올려야 한다 ... 객체 생성
      Fclass fclass = new Fclass();
      fclass.m(); // 호출했다 그의 이름을 불러 주었어요 call
      fclass.m2(100);
      int result = fclass.m3();
      System.out.println("m3 함수 호출시 돌려받은 값: " + result);
      
      int result2 = fclass.m4(555);
      System.out.println("m4 함수 호출시 돌려받은 값: " + result2);
      
      result2 = fclass.sum(100, 200, 300);
      System.out.println("sum 함수 호출시 돌려받은 값: " + result2);
      
      fclass.callSubSum();
      
      result2 = fclass.opSum(1111);
      System.out.println("opSum 함수 호출시 돌려받은 값: " + result2);
      
      result2 = fclass.max(100, 50);
      System.out.println("max 함수 호출시 돌려받은 값: " + result2);
   } 
}