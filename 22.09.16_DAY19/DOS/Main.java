package DOS;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {

    }

    void readTextFile(String[] input){

        FileReader fr = null;
        BufferedReader br = null;        

        File f = new File(input[0]); //File f = new File("C:\\Temp);
        
		if(!f.exists() || !f.isFile()) {
			//존재하지 않거나 또는 파일이 아니라면
			System.out.println("유효하지 않은 파일");
			System.exit(0);
		}

        for (int i = 1; i < input.length; i++) {
            try {
                fr = new FileReader(input[i]);
                br = new BufferedReader(fr);
                String line = "";
    
                for (int j = 0;  (line = br.readLine()) != null; j++) {
                    System.out.println(line);
                }
                
            } catch (Exception e) {
                System.out.println("에러");
            } catch (FileNotFoundException e) {
                System.out.println("파일이 존재하지 않아요");
            } catch (IOException e) {
                System.out.println("파일을 읽을 수 없어요");
            } catch (Exception e) {
                System.err.println("나머지 예외");
            } finally {
                try {
                    br.close();
                    fr.close();
                } catch (Exception e2) {
                }
            }
        }
    }
}