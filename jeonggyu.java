import java.util.regex.Pattern;

class jeonggyu {
    public static void main(String[] args) {
          String tel = "010-1234-5678";
         
          //유효성 검사
          boolean tel_check = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", tel);
          
          //출력
          System.out.println("전화번호 : " + tel_check);
    }
}