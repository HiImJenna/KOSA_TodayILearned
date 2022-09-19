import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MonthSchedule april = new MonthSchedule(30); //4월달의 할 일

        System.out.println("이번달 스케쥴 관리 프로그램");

        april.run();
    }
}

class Day{
    private String work; //하루의 할 일을 나타내는 문자열

    public Day(String work) {
        this.work = work;
    }

    public void set(String work) { 
        this.work = work; 
    }

    public String get() {
        return work; 
    }

    public void show() {
        if(work == null) System.out.println("없습니다.");
        else System.out.println(work +  "입니다.");

        System.out.println();
    }
}

class MonthSchedule {
    private int x;
    Day[] day = null;

    Scanner sc = new Scanner(System.in);   

    public MonthSchedule(int x) {
        this.x = x;
        day = new Day[x];
    }

    void input (){
        System.out.print("날짜(1~30)?");
        int d = sc.nextInt();

        System.out.print("할 일(빈칸없이입력)?");
        String work = sc.next();
        day[d] = new Day(work);

        System.out.println();
    }
    

    void view(){
        System.out.print("날짜(1~30)?");
        int date = sc.nextInt();

        System.out.println(date + "일의 할 일은" + day[date]);
    }

    void finish(){
        System.out.println("프로그램을 종료합니다");
    }

    void run(){
        while(true){
            System.out.print("할 일(입력: 1, 보기: 2, 끝내기: 3)" + ">>");
            int choice = sc.nextInt();

            if(choice == 1) {
                input();
            } else if (choice == 2) {
                view();
            } else if (choice == 3) {
                finish(); 
                break;
            }     
            else {
                System.out.println("1, 2, 3 중에 입력하세요.");
            }
            
        }
    }
}