import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/*
 File 처리 (DISK) : 입력 출력은 Byte 단위로 (한 Byte) read, write
 
 여러 학생을 모아서 하나의 버스에 태워서 목적지 ... 놀면
 버스 : buffer
 1. I/O 성능 개선 (접근 횟수 줄이기)
 2. Line 단위 (엔터)
 
 BufferedInputStream(보조 스트림) >> 주 클래스에 의존
 */

public class Ex04_Stream_Buffer {

	public static void main(String[] args) {
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("data.txt"); //파일 없으면 create
			bos = new BufferedOutputStream(fos); // FileOutputStream 사용
			
			/*
			 JAVA Buffer 크기 (8kbyte : 8192byte) 
			 1. buffer 안에 내용이 채워지면 스스로 출발 (버퍼를 비우는 작업)
			 2. 강제로 출발 (buffer 강제로 비우기) : flush() or close()
			 3. close() 자원해제 >> 내부적으로 flush() 호출 >> 자원해제
			 */
			
			for (int i = 0; i < 10; i++) {
				bos.write('A'); //data.txt에
			}
			bos.flush();
			
		} catch (Exception e) {
			
		}
	}
}
