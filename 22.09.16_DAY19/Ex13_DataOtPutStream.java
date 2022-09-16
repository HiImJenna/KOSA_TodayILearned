import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.nio.file.attribute.DosFileAttributes;

import javax.xml.stream.events.EntityReference;

/*
보조스트림
DataOutPutStream
DataInputStram

java 8가지 기본 타입(타입별로 write, read)
단 조건 (DataOutPutStream, DataInputStream 같이 사용)

만약)
성적.txt
100,20,60,88 >> 문자열 > split > 배열 > 연산하려면 숫자로 >
 */


public class Ex13_DataOtPutStream {

	public static void main(String[] args) {
		int[] score = {100, 60, 55, 95, 50};
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("score.txt");
			dos = new DataOutputStream(fos);
			for (int i = 0; i < score.length; i++) {
				dos.writeInt(score[i]); //정수값으로 그대로 write
				//조건 read 반드시 DataInputStream
				//dos.writeUTF(null); //채팅 입력 출력
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
