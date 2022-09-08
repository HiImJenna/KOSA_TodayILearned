

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력 >> ");
        int math = sc.nextInt();
        int science = sc.nextInt();
        int english = sc.nextInt();

        Grade me = new Grade(math, science, english);
        System.out.println("평균은 " + me.average()); //average는 평균을 계산하여 리턴

        sc.close();

    }
}

class Grade {
    int math;
    int science;
    int english;

    Grade(int math, int science, int english){
        this.math = math;
        this.science = science;
        this.english = english;
    }

    public int average(){
     return (math + science + english) / 3 ;
    }
}