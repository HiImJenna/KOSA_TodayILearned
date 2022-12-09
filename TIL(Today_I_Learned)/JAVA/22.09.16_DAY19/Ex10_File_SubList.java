import java.io.File;
import java.io.FileReader;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.List;

public class Ex10_File_SubList {

	static int totalfiles = 0; //파일 개수
	static int totaldirs = 0; //폴더 개수
	
	static void printFileList(File dir) {
		System.out.println("Full path : " + dir.getAbsolutePath());
		
		//코드 ... 자유 ...
		List<Integer> subdir = new ArrayList<Integer>();
		File [] files = dir.listFiles(); //하위 자원 정보를 다...
		//[0] > a.txt
		//[1] > aaa폴더
		//[2] > bbb폴더
		//[3] > java.jpg
		for (int i = 0; i < files.length; i++) {
			String filename = files[i].getName(); //폴더명 or 파일명
			if(files[i].isDirectory()) { //폴더
				filename = "[DIR]" + filename;
				//Point
				subdir.add(i); //WHY >> 폴더인 녀석의 index 값을 (i) > arrayList
				//subdir[0] = 1
				//subdir[1] = 2
			} else {
				filename = filename + "/" +files[i].length() + "byte";
			}
		}
		
		//폴더의 개수 확인
		int dirnum = subdir.size(); //현재 주어진 폴더의 하위 폴더 개수
		int filenum = files.length - dirnum; //파일개수
		
		//누적개수
		totaldirs += dirnum; //총 누적 폴더 개수 (하위 하위까지)
		totalfiles += filenum; //총 누적 파일 개수 (하위 하위까지)
		
		System.out.println("[Current DirNum] : " + dirnum);
		System.out.println("[Current FileNum] : " + filenum );
		System.out.println("*********************************");
		//Point (하위폴더의 다시 하위 폴더 정보 ... )
		//[0] > a.txt >> 각 방의 타입은 File 타입
		//[1] > aaa폴더 >> a-1 폴더,  a-2 폴더
		//[2] > bbb폴더 >> b-1 폴더, b.txt, b-1.jpg
		//[3] > java.jpg
		
		for (int i = 0; i < subdir.size(); i++) { //C
			int index = subdir.get(i); //폴더의 방 위치값
			//한 줄의 코드
			printFileList(files[index]); //재귀호출 (내가 내 자신을 또 호출)
			//C:
		}
	}
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("사용법 : java[실행할 파일명] [경로명]");
			System.out.println("예시 : java Ex10_File_SubList C:Temp");
			System.exit(0);
		}
		File f = new File(args[0]); //File f = new File("C:\\Temp);
		if(!f.exists() || !f.isDirectory()) {
			//존재하지 않거나 또는 디렉토리가 아니라면
			System.out.println("유효하지 않은 디렉토리");
			System.exit(0);
		}
		//정상적인 경로, 그리고 폴더구나 ...
		printFileList(f); //호출(반복)
		//하위 폴더 안까지의 폴더 개수, 파일 누적 개수
		System.out.println("누적 총 파일 수 : " + totalfiles);
		System.out.println("누적 총 폴더 수 : " +totaldirs);
	}
}
