package DAY7;


/*
		 * 오류
		 * 1. 에러 (error) : 네트위크 장애, 메모리, 하드웨어 >> 개발자가 코드적으로 해결 불가
		 * 2. 예외 (exception) : 개발자가 코드의 실수에의해 발생 >> 문제 코드 찾아서 수정 >> 배포
		 * 						>> 프로그램 컴파일시가 아니라 실행시 알 수 없음(테스트..)
		 * 						>> 문제가 발생하면 (exception) 프로그램 강제 종료
		 * 
		 * 3. 예외처리 >> 예외발생에 대한 코드 수정하는 것이 아니고 일반 임시방편으로 문제가 생기더라도 프로그램이 안정적으로 종료되는 것을 처리
		 *  				>> 결국 얘외처리를 통해서 문제가 생긴 부분을 찾고 다시 코드 수정 >> 배포
		 * 
		 * try{
		 *    >> 문제가 의심되는 코드 실행
		 *    >> 문제가 발생(exception)
		 * } catch(Exception e) {
		 * 	  >> 문제가 발생한 예외 ㅂ분을 파악 ..
		 * 	  >> 처리 (코드를 수정하는 것이 아님, 보고하는 것)
		 * 		1) 관리자에게 이메일
		 * 		2) 로그 파일에 기록
		 * 		3) 강제 프로그램 종료 막음(일단은)
		 * 			>> 결국 개발자가 수정하는 것이 답 .. 
		 * } finally {
		 * 	>> 문제가 발생하던, 발행하지 않던 강제적으로 실행해야 할 코드
		 *  >> DB작업 문제 (특정 자원에 종료) 강제
		 * 
		 * 
		 */

        public class Ex01_Exception {
	

            public static void main(String[] args) {
                
            
            /*	
                System.out.println("main start");
                System.out.println(0/0); //java.lang.ArithmeticException: / by zero
                //프로그램 강제 종료
                System.out.println("main end");
                
            }
             */
            
            System.out.println("main start");
            
            try {
                System.out.println(0/0);
                //연산 예외가 발생 ... try{} catch() 처리 프로그램이 강제 종료되진 않음
                //Exception 클래스 사용 (예외 클래스의 최상위 부모 )
                //e라는 변수는 무엇을 받는걸까?
                //Exception e >> Exception 객체의 주소값 ...
                
                //ArithmeticException 문제가 발생
                //컴파일러에 의해서 연산 예외 객체(ArithmeticException)가 생성 되고 
                //그 객체에게 문제가 되는 메세지, 코드 전달
                
            } catch (Exception e) { //부모 type의 변수는 자식 type의 주소값을 받을 수 있다(다형성)
                //어떤 문제인지를 파악하고 그 정보를 전달
                // 관리자, email, log 기록
                System.out.println(e.getMessage());
            }
            
            System.out.println("main end");
            
            }
        }