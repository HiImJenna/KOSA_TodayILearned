import kr.or.bit.Emp;S

public class Ex06_Array_Object {
   public static void main(String[] args) {
      /*
      사원 3명을 만드세요
      단 Array 사용
      
      사원정보
      1000, 홍길동
      2000, 김유신
      3000, 유관순
      을 만드시고 사번과 이름을 출력하세요
      
       */
      
      Emp[] emplist = {new Emp(1000, "홍길동"), new Emp(2000, "김유신"), new Emp(3000, "유관순")};
      
      for (Emp e  : emplist) {
         e.empInfoPrint();
      }
      
      for (int i = 0; i < emplist.length; i++) {
         emplist[i].empInfoPrint();
      }
      
      
   }
}
