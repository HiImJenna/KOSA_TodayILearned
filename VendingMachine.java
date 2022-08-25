import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            int money = 0;
            String choice= "";
            int change = 0;
            int chunWon, obackWon, backWon = 0; // 천원, 오백원, 백원
            
            
            // 상품 정보 입력
            Product info = new Product();
            info.name = "1.콜라";
            info.price = 1000;
            info.stock = 7;
            info.ProductPrint();
            
            Product info2 = new Product();
            info2.name = "2.커피";
            info2.price = 800;
            info2.stock = 12;
            info2.ProductPrint();
            
            Product info3 = new Product();
            info3.name = "3.우유";
            info3.price = 1200;
            info3.stock = 3;
            info3.ProductPrint();

            // 금액 입력
            System.out.println("\n금액을 입력하세요.");
            money = sc.nextInt();
            
            // 상품 선택
            System.out.println("상품이름 입력하세요.");
            choice = sc.nextLine();
            System.out.println(choice);
            
            
        }
     
    }
    
