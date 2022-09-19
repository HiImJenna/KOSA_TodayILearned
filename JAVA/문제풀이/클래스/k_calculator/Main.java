package 클래스.k_calculator;

import java.util.Scanner;

class Add{
    int a, b;

    void setValue(int a, int b){
        this.a = a;
        this.b = b;
    }

    int calculate(){
        return a+b;
    }
}

class Sub{
    int a, b;

    void setValue(int a, int b){
        this.a = a;
        this.b = b;

    }

    int calculate(){
        return a-b;
    }

}

class Mul{
    int a, b;

    void setValue(int a, int b){
        this.a = a;
        this.b = b;

    }

    int calculate(){
        return a*b;
    }

}

class Div{
    int a, b;

    void setValue(int a, int b){
        this.a = a;
        this.b = b;

    }

    int calculate(){
        return a/b;
    }

}

public class Main {
    public static void main(String[] args) {
        System.out.print("두 정수와 연산자를 입력하시오 >>  ");

        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        String operator = sc.next();

        if (operator.equals("+")){
            Add add = new Add();
            add.setValue(first, second);
            System.out.println(add.calculate());

        } else if(operator.equals("-")){
            Sub sub = new Sub();
            sub.setValue(first, second);
            System.out.println(sub.calculate());

        } else if(operator.equals("*")){
            Mul mul = new Mul();
            mul.setValue(first, second);
            System.out.println(mul.calculate());

        } else if(operator.equals("/")){
            Div div = new Div();
            div.setValue(first, second);
            System.out.println(div.calculate());

        }
        
    }
}

//whats the difference between sc.next / sc.nextLIne.. ?