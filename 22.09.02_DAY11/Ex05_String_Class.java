import java.util.Iterator;

/*
String 클래스 (문자열)
String 수 많은 함수 ... 문자열 조작(자르고, 합치고 ...)
String >> static 
 */
public class Ex05_String_Class {
   public static void main(String[] args) {
      String str = "";
      String[] strarr = {"aaa","bbb","ccc"};
      for(String s : strarr) {
         System.out.println(s);
      }
      //사용방법 : int, double 값타입 처럼 사용
      
      String st = "홍길동";
      System.out.println(st.length());
      System.out.println(st);   //st.toString()
      System.out.println(st.toString());   //주소로 가서 데이터를 리턴 설계(재정의
      //String 클래스는 Object 부모 클래스 toString() 상속관계 재정의 ...
      
      //정식
      String sdata = new String("홍길동");
      System.out.println(sdata);
      
      String name = "가나다라마";
      //String 내부족으로 char[] member field >> [가] 나[] [다] [라] 
      //class String extends Object { private char[] str ... @Override to String()
      
      String str1 = "AAA";
      String str2 = "AAA";
      
      //문자열 비교
      System.out.println(str1);
      System.out.println(str2.toString()); //toString() 재정의 주소값이 아니고 값이 나온다
      System.out.println(str1 == str2);
      // == 연산자는 값을 비교 str1(주소값), str2(주소값)
      //같은 주소 판명
      //**메모리에 실제로 같은 문자열이 있으면 [재사용]
      //Point
      System.out.println(str1.equals(str2)); //주소를 찾아가서 그 안에 있는 값을 비교
      
      //why : equlas 문자열의 비교 ..
      String str3 = new String("BBB");
      String str4 = new String("BBB");
      
      System.out.println(str3 == str4); //false
      //문자열은 값이 중요
      System.out.println(str3.equals(str4)); //주소를 찾아가서 그 안에 값을 비교
      
      String s = "A";
      s += "B";
      s += "c";
      System.out.println(s);
      
      s = "A";
   }
}