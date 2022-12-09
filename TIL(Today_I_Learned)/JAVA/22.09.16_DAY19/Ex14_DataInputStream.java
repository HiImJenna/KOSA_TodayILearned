import java.io.DataInputStream;
import java.io.FileInputStream;

public class Ex14_DataInputStream {

	public static void main(String[] args) {
		// 파일 학생 점수 기록
		// read 합계, 평균
		// DataOutputStream>> dos.writeInt
		// 반드시 >>DataInputStream >> read
		
		int sum = 0;
		int score = 0;
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("score.txt");
			dis = new DataInputStream(fis);
			while(true) {
				score = dis.readInt();
				System.out.println("score int type : " + score);
				sum += score; //기능 정수 타입
				//read할 자원이 없으면 IOexception
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("sum 결과 : " + sum);
		} finally {
			try {
				dis.close();
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
