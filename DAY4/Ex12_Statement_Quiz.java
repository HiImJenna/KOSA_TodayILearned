import java.util.Scanner;

public class Ex12_Statement_Quiz {

	public static void main(String[] args) {
		
		// 메뉴를 보여주고 사용자에게 선택
		//다른 것을 선택하면 다시 선택하도록 강제 메뉴
		//while (true)
		//do ~ while()
		
		boolean auto = true;
		int balance = 0; //잔액
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("*****************************");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("*****************************");
			System.out.println("선택하세요");
			
			int input = Integer.parseInt(sc.nextLine());
			
			//판단
			switch(input) {
				case 1 : System.out.println("예금처리");
				      balance += Integer.parseInt(sc.nextLine());
				      break;
				case 2 : System.out.println("출금처리");
					  balance -= Integer.parseInt(sc.nextLine());
			      break;      
				case 3 : System.out.println("잔고");
			      break;
				case 4 : System.out.println("종료합니다");
					   auto = false;
				  break;
				default : System.out.println("올바른 메뉴를 선택하세요");
			}
			
			if (auto == false) { 
				break; //또는 return
				
			}
		}
		
		
//		가위 , 바위 ,보 게임을 제어문을 통해서 작성하세요 (IF)
//
//		import java.util.Scanner;

       Scanner sc = new Scanner(System.in);

       double result = (int)Math.random()*3 + 1;

           System.out.println("가위, 바위, 보 게임을 시작합니다!");
           System.out.println("1. 가위 | 2. 바위 | 3. 보 ");
           System.out.println("숫자를 입력해보세요.");

        
        int input = sc.nextInt();

           if (input == 1) {
            System.out.println("가위를 내셨군요!");
             } else if (input == 2) {
            System.out.println("바위를 내셨군요!");
             } else if (input == 3) {
            System.out.println("보를 내셨군요!");
             } 
            
            if (result == 1.0) {
                System.out.println("컴퓨터는 가위를 냈습니다.");
            } else if (result == 2.0) {
                System.out.println("컴퓨터는 바위를 냈습니다");
            } else if (result == 3.0) {
                System.out.println("컴퓨터는 보를 냈습니다");
            }

             if ((input - result) == 0 ) {
                System.out.println("결과는 무승부입니다");
            } else if (((input - result) == -1) && ((input - result) == 2)) {
                System.out.println("결과는 패배입니다");
            } else if (((input - result) == -2) && ((input - result) == 1)) {
                System.out.println("결과는 승리입니다");
            }
	    }

	}


