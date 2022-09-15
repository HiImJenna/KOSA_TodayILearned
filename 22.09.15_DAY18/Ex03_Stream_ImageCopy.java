import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex03_Stream_ImageCopy {

   public static void main(String[] args) {
      String orifile = "C:\\Temp\\java.jpg";
      String targetfile = "copy.jpg";
      //경로가 없으면 내부적으로 default 경로가 잡힘 : C:\KOSA_IT\JAVA\Labs\Ex09_IO
      //소스파일이 있는 프로젝트 폴더가 기본 경로가 됨.
      
      FileInputStream fs = null;
      FileOutputStream fos = null;
      
      try {
         fs = new FileInputStream(orifile);
         fos = new FileOutputStream(targetfile,false);
         
         int data = 0 ;
         while((data = fs.read()) != -1) {
            fos.write(data);   //byte값
         }
       } catch (Exception e) {
         
      }finally {
         try {
            fs.close();
            fos.close();
         } catch (Exception e2) {
            // TODO: handle exception
         }
      }
   }
}