import java.io.FileReader;

/*
 문자 기반의 데이터 처리 (char[])
 String 클래스 : String str = "ABC" : 내부적으로 char[] >> [A] [B] [C]
 
 한글 1자, 영문 1자 >> 2Byte >>
 */

public class Ex05_Reader_Writer {

	public static void main(String[] args) {
		FileReader fr = null;
		FileReader fw = null;

		try {
			fr = new FileReader("Ex01_Stream.java");
			fw = new FileReader("copy_Ex01.txt"); // 파일 생성 >> 파일에 같은 내용 write

			int data = 0;
			while ((data = fr.read()) != -1) {
				if (data != '\n' && data != '\r' && data != '\t' && data != ' ') {
				}
				// System.out.println(data);
				fw.write(data);
				//엔터, 탭, 빈문자는 파일에 쓰지 않겠다 
				//압축파일버전
				//https://jquery.com/download/ 실사례
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {

			} catch (Exception e2) {

			}
		}

	}

}
