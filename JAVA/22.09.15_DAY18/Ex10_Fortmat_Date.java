import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex10_Fortmat_Date {

	public static void main(String[] args) {
		
		Date currdate = new Date();
		Calendar cal = Calendar.getInstance();
		System.out.println("date : " + currdate);
		//date : Thu Sep 15 09:20:31 KST 2022
		
		System.out.println("cal : " + cal); //문자열의 조합
		//[time=1663201231171,areFieldsSet=true,areAllFieldsSet ... 
		
		System.out.println("cal getTime()함수 : " + cal.getTime());
		//Thu Sep 15 09:21:48 KST 2022
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmm");
		
		String s = dateformat.format(currdate);
		String s2 = dateformat.format(cal.getTime());
		System.out.println(s);
		System.out.println(s2);
		
		//사이트 어떤 정보 입력
		//문자열 >> 날짜형식으로
		//"202209150925"
		String StringDate = "202209150925"; //형식에 문제 없다면
		Date stringdate = null;
		
		try { 
			stringdate = dateformat.parse(StringDate);
			
			long datelong = stringdate.getTime();
			System.out.println(datelong);
			}
			//parse 만든 설계자 (문제 발생 고민) throws .. 사용자는 예외처리
			catch (ParseException e) { e.printStackTrace();}
			finally { System.out.println(stringdate); }
		
		System.out.println();

	}

}
