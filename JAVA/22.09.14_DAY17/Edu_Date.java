
import java.util.Calendar;

//설계도
//날짜를 적용하는 [함수]는 많이 사용되요 .... 편하게 쓰고 싶어요
//static ... 이름 ....overloading 
public class Edu_Date {
	public static String DateString(Calendar date) {
		return date.get(Calendar.YEAR) + "년" + 
				(date.get(Calendar.MONTH)+1) + "월" +
				date.get(Calendar.DATE) + "일";
	}
	
	public static String DateString(Calendar date , String opr) {
		return date.get(Calendar.YEAR) + opr + 
				(date.get(Calendar.MONTH)+1) + opr +
				date.get(Calendar.DATE);
	}
	
	//요구사항
	//2020-9-14
	//1~9월 >> 01 , 02 .... 09
	//10 , 11 , 12 >> 그대로
	public static String monthFormat_DateString(Calendar date) {
		String month="";
		if((date.get(Calendar.MONTH)+1) < 10) {
			month="0" + (date.get(Calendar.MONTH)+1);
		}else {
			 month = String.valueOf((date.get(Calendar.MONTH)+1));
		}
		return  date.get(Calendar.YEAR) + "년" + 
				month + "월" +
		        date.get(Calendar.DATE) + "일";
	}
}