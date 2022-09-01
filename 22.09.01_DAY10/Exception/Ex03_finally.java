import java.io.IOException;

public class Ex03_finally {
	
	static void copyFiles() {
		System.out.println("copyFiles");
	}
	
	static void startInstall() {
		System.out.println("install");
	}
	
	static void fileDelete() {
		System.out.println("fileDelete");
	}
	//실제로 예외는 아니지만
	//개발자가 필요에 따라서 어떤 상황을 예외적인 상황이라 정의하고 예외를 발생 
	// 사용자 정의 예외처리
	//throw new IOException
	public static void main(String[] args) {
		
		try {
			copyFiles();
			startInstall();
			throw new IOException("install 중 문제가 발생");
			
		} catch (Exception e) {
			System.out.println("예외 메세지 출력 : " + e.getMessage());
		} finally {
			//강제 실행 블럭 예외 발생 실행 되고, 정상건이어도 실행된다
			//함수의 강제 종료인 return을 만나도  finally 강제 실행(먼저)
			fileDelete(); 
		}
		
		
		
		
		
		
	}

}

/*
* try{
* 
* } catch(Exception e) {
* 
* }
* 나는 예외가 발생하던, 예외가 발생하지 않던 강제적으로 실행되어야 하는 구문을 가지고 있다
* 
* >>게임 CD 설치 PC
* >>1. 설치 파일 >> C:\Temp >> 복사
* >> 2. 복사한 파일 >> 프로그램 설치
* >> 3. 정상 설치 >> C:\Temp 복사한 파일 삭제
* >> 4. 비정상 설치 >> 강제 종료 >> 복사한 파일 삭제
*/
	
	