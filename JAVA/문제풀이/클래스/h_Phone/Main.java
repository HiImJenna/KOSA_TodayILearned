package 클래스.h_Phone;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        PhoneBook phonebook = new PhoneBook(); //4월달의 할 일

        System.out.println("전화번호부 관리 프로그램");

        phonebook.run();
    }
}

class PhoneBook {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    Main[]phone = null;

    PhoneBook(){
        phone = new Main[x];
    }

    void input(){
        System.out.println("인원수 >> ");

        for (int i = 0; i < phone.length; i++) {
            System.out.println("이름과 번호는 빈 칸 없이 입력");

            String name = sc.next();
            String number = sc.next();

            phone[i].name = name;
            phone[i].number = number;
        }
        System.out.println("저장되었습니다 ... ");
    }

    void view() {
        System.out.println("검색할 이름 >> ");

        String searchName = sc.next();
        while(true){
            if(searchName.equals(phone[i])){
                System.out.printf("%s의 번호는 %s입니다", searchName, phone[i][i]);
                break;
            } else if(searchName.equals("그만")){
                finish();
            } else {
                System.out.printf("%s이(가) 없습니다", phone[i]);
                break;
            }
        }
    }

    void finish(){
        System.out.println("프로그램을 종료합니다");
    }

    void run(){
        while(true){
            System.out.print("할 일(입력: 1 / 검색: 2 / 끝내기: 3)" + ">>");
            int choice = sc.nextInt();

            if(choice == 1) {
                input();
            } else if (choice == 2) {
                view();
            } else if (choice == 3) {
                finish(); 
                break;
            } else {
                System.out.println("1, 2, 3 중에 입력하세요.");
            }
        }
    }

}

