import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.FieldPosition;

public class Ex06_FileReader_FileWriter_Buffer {

	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("Lotto.txt",true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("로또");
		bw.newLine();
		bw.write("1,3,5,7,9");
		bw.newLine();
		bw.flush();
	}

}
