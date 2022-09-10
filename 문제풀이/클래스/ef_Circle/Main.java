package 클래스.ef_Circle;
import java.util.Scanner;

class Circle {
    private double x, y;
    private int radius;
    public Circle(double x, double y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
    }

    public void show(){
        System.out.printf("(%.1f,%.1f)%d", x, y, radius);
        System.out.println();
    }

    public int getRadius(){
        return radius; 
    }
}

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
  
       Circle c[] = new Circle[3] ; //3개의 Circle 배열 선언

       for (int i = 0; i < c.length; i++) {
        System.out.print("x, y, radius >>");
        Double x = sc.nextDouble(); // x 값 읽기
        Double y = sc.nextDouble(); // y 값 읽기
        int radius = sc.nextInt(); //반지름 읽기

        c[i] = new Circle(x, y, radius); // Circle 객체 생성
       }
       
       for (int j = 0; j < c.length; j++)
        c[j].show(); //모든 Circle 객체 출력

       int max = 0;

       for (int i = 0; i < c.length; i++) {
        if(c[i].getRadius() > max) {
            max = c[i].getRadius();
        }
       }

       for (int i = 0; i < c.length; i++) {
        if(max == c[i].getRadius())
        System.out.println("가장 큰  원은" + max);
        c[i].show();
       }
       }

    }

