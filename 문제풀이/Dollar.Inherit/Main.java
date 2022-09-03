import java.util.Scanner;

abstract class Converter{
    abstract protected double convert(double src); // 추상 메소드
    abstract protected String getSrcString(); // 추상 메소드
    abstract protected String getDestString(); // 추상 메소드
    protected double ratio; // 비율
 
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println(getSrcString() + "을 " +getDestString() + "로 바꿉니다.");
        System.out.println(getSrcString() + "을 입력하세요>> ");
        double val = sc.nextDouble();
        double res = convert(val);
        System.out.println("변환 결과: " + res + getDestString() + "입니다");
        sc.close();
    }
}

class Won2Dollar extends Converter{
    public Won2Dollar(int ratio){
        this.ratio = ratio;
    }

    @Override
    protected double convert(double src) {
        return src / ratio;
    }
    @Override
    protected String getSrcString() {
        return "원";
    }
    @Override
    protected String getDestString() {
        return "달러";
    }
}

public class Main {
    public static void main(String[] args) {
        Won2Dollar toDollar = new Won2Dollar(1200); //1달러는 1200원
        toDollar.run();
    }
}
