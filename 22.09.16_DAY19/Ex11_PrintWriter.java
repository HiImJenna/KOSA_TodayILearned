import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

/*
 출력 형식 저장
 1. printf
 2. String.format
 3. PrintWriter(레포팅)
 4. 현업 : 레포팅 소프트웨어 (양식지 : 전표, 세금계산서, 인사(휴가지원서))
  1) 크리스탈 레포트, 오즈
 */

public class Ex11_PrintWriter {

	public static void main(String[] args) {
		try {
			/*
			 * PrintWriter pWriter = new PrintWriter("C:\\Temp\\homework.txt");
			 * pWriter.println("***********************************");
			 * pWriter.println("*            HOMEWORK           *");
			 * pWriter.println("***********************************");
			 * pWriter.printf("%3s : %5d %5d %5d %5.1f", "아무개", 100, 99, 80,
			 * (float)((100+99+80)/3)); pWriter.println(); pWriter.close();
			 */

			// read(line 단위)
			FileReader fReader = new FileReader("C:\\Temp\\homework.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			String string = "";
			while ((string = bReader.readLine()) != null) {
				System.out.println(string);
			}
		} catch (Exception e) {
			
		}
	}
}
