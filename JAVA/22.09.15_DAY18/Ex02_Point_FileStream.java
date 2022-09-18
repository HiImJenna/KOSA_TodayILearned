import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
Byte 데이터를 read, write >> 그 대상이 >> File
FileInputStream
FileOutputStream

(이미지, 엑셀파일) read, write

File >> 1.txt, data.txt (데이터를 파일에 기록)


FileInputStream fs = null; 굳이 이렇게 하는 이유

I/O 클래스는 예외를 강제 해야하기 때문에 하는거임

I/O 자원은 개발자가 직접적으로 자원에 해제 (여러 사용자들이 접근 사용 가능)
>> close() 
 */


public class Ex02_Point_FileStream {
   public static void main(String[] args) {
      FileInputStream fs = null;
      FileOutputStream fos  = null;         
      
      String path = "C:\\Temp\\a.txt";      //파일의 경로
      
      try {
         fs = new FileInputStream(path);
         fos = new FileOutputStream("C:\\Temp\\new.txt");
         /*
          fileOutputStream
          1. write 파일이 존재하지 않으면 >> 자동파일 생성
          2. FileOutputStream("C:\\Temp\\new.txt",false);
             false >> overwrite (덮어쓰기)
             
          2. FileOutputStream("C:\\Temp\\new.txt",true);
             true >> append (추가하기)
          */
         int data = 0;
         while((data = fs.read()) != -1) {
            System.out.println("정수: " + data + " : " + (char)data);
            //문자값 char c = (char)data
            //read 한 데이터를 새로운 파일에 write 목적
            fos.write(data); // data값을 내부적으로 read해서 new.txt >> write
         }
         
      } catch (Exception e) {
         
      } finally {
         //정상, 비정상이어도 실행
         //함수가 return 해도 finally 블럭은 ***무조건*** 실행
         //그렇기에 파일 입출력하였으면 close를 finally에 작성해주어 메모리 해제 해주기
         try {
            fs.close();
            fos.close();
         } catch (Exception e2) {
            
         }
      }
   }
}