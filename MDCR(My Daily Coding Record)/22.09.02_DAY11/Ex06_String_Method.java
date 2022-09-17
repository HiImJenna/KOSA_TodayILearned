
import java.util.StringTokenizer;

public class Ex06_String_Method {

	public static void main(String[] args) {
		
		String str = "hello";
		String concatstr = str.concat(" world");
		System.out.println(concatstr);
		
		boolean bo =  str.contains("elo");
		System.out.println(bo);
		
		String str2 = "a b c d";//[a][ ][b][ ][c][ ][d]...
		System.out.println(str2.length());
		
		String filename="hello java world";
		System.out.println(filename.indexOf("h"));
		System.out.println(filename.indexOf("java"));
		System.out.println(filename.indexOf("개폭망")); 
		//-1 을 return ... 배열에서 값이 없다 (-1)
		//신문사설에서 원하는 검색 ... 내가원하는 문자열 포함되었는 파악  ... 
		if(filename.indexOf("wo") != -1) {
			System.out.println("wo 단어가 하나라도 있다");
		}
		System.out.println(filename.lastIndexOf("a")); //9번째 방 ^^
		
		//length() , indexOf() , substring() , replace() , split()		
		
		String result = "superman";
		System.out.println(result.substring(0)); //시작 index ~ 
		System.out.println(result.substring(1)); //시작 index ~ 
		System.out.println(result.substring(1,2)); // "u"
		//beginIndex - the beginning index, inclusive.
		//endIndex - the ending index, exclusive. // endindex -1
		System.out.println(result.substring(0,0)); // (0 , -1)
		System.out.println(result.substring(0,1));  //s
		
		//Quiz
		String filename2 = "home.jpeg"; //or h.png or aaaaa.hwp
		//여기서 파일명과 확장자를 분리해서 출력하세요
		//파일명 : home
		//확장자 : jpeg 
		//단 위에서 배운 함수만 사용해서 출력하세요
		int position = filename2.indexOf("."); //규칙  (.위치)
		String file = filename2.substring(0,position);
		
		String extention2 = filename2.substring(position,filename2.length());
		String extention = filename2.substring(++position);
		
		
		System.out.println(position);
		System.out.println(file);
		System.out.println(extention);
		System.out.println(extention2);
		
		//replace
		String str3 = "ABCDADDDDDA";
		String result3 = str3.replace("DDDDD", "오늘은 금요일");
		System.out.println(result3);
		
		result3 = str3.replace("A", "a");
		System.out.println(result3);
		
		//ETC
		System.out.println(str3.charAt(0));
		System.out.println(str3.charAt(3));
		System.out.println(str3.endsWith("DDDA"));
		System.out.println(str3.endsWith("BDDDA"));
		System.out.println(str3.equalsIgnoreCase("aBCDADDDDDa")); //대소문자 구별 없이 비교
		
		//Today point
		String str4="슈퍼맨,팬티,노랑색,우하하,우하하";
		String[] namearray = str4.split(",");
		
		for(String s : namearray) {
			System.out.println(s);
		}
		
		String str5="슈퍼맨.팬티.노랑색.우하하.우하하";
		String[] namearray2 = str5.split("\\.");
		
		for(String s : namearray2) {
			System.out.println(s);
		}
		//https://ko.wikipedia.org/wiki/%EC%A0%95%EA%B7%9C_%ED%91%9C%ED%98%84%EC%8B%9D
		// "." 정규표현식 데이터 아니고 ..
		
		//정규표현식 (문자들을 조합해서 규칙을 만들고 : 그 규칙하고 데이터 비교해서 판단)
		//우편번호 : {\d3}-{\d3} >> 12-123 (false) , 123*123(false) , 111-111(true)
		
		//정규 표현식(java , javascript , Oracle , C#) 표준 
		//핸드폰 , 차량번호 , 도메인주소 , 이메일 정규표현으로 구현 >> 입력한 데이터 유효성 검증 
		//다음주 과제로 제출 
		
		String filename3 = "kosa.hwp";
		//파일명과 확장자 분리
		String[] filearray = filename3.split("\\.");
		for(String s : filearray) {
			System.out.println(s);
		}
		
		String str6 = "a/b,c-d.f";
		StringTokenizer sto = new StringTokenizer(str6,"/,-.");
		while(sto.hasMoreElements()) {
			System.out.println(sto.nextToken());
		}
		
		//넌센스
		String str7 = "홍        길       동";
		//저장 >> 공백제거 >> "홍길동"
		System.out.println(str7.replace(" ","")); //"홍길동"
		
		String str8 = "     홍길동      ";
		System.out.println(">" + str8 + "<");
		System.out.println(">" + str8.trim() + "<");
		
		String str9 = "   홍   길   동    ";
		//"홍길동"
		
		String result5 = str9.trim();
		String result6 = result5.replace(" ","");
		System.out.println(result6);
		//무식한 인간 ....

//*********여러개의 함수를 사용 (method chain 기법)
		   int sum = 0;
		   int sum2 = 0;
		 
		     
		 //Quiz
	        String jumin="123456-1234567";
	         //위 주민번호의 합을 구하세요_1
	         int sum2=0;
	         for(int i = 0 ; i < jumin.length() ; i++) {
	            String numstr =jumin.substring(i, i+1);
	            if(numstr.equals("-")) continue;
	            sum2+= Integer.parseInt(numstr);
	         } 
	         System.out.println("주민번호 합:" + sum2);
	         
	       //위 주민번호의 합을 구하세요_2
	       //String jumin="123456-1234567";
	         String[] numarr2 = jumin.replace("-","").split("");
	         int sum3=0;
	         for(String i : numarr2) {
	            sum3+= Integer.parseInt(i);
	         }
	         System.out.println("주민번호 합2:" + sum3);
	         
	       //위 주민번호의 합을 구하세요_3
	         String jumin4 = jumin.replace("-", "");
	         int sum4=0;
	         for(int i = 0 ; i < jumin4.length() ;i++) {
	            sum4+=Integer.parseInt(String.valueOf(jumin4.charAt(i)));
	         }
	         System.out.println("주민번호 합4:" + sum4);
		     }
			
		
		
	}

