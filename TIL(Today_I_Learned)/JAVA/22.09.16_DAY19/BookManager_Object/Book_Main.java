package BookManager_Object;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Book_Main {
	public static void main(String[] args) {
		BookManager bm = new BookManager();
        bm.Run();
	}

    public static void Read(){
        String filename = "BookManager.txt";

        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream out = null;

        try {
            fos = new FileOutputStream(filename, true);
            bos = new BufferedOutputStream(fos);
            out = new ObjectOutputStream(bos);
        } catch (Exception e) {

        }
    }
}
