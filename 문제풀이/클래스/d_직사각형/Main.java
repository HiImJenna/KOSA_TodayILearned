package 클래스.d_직사각형;

public class Main {
    public static void main(String[] args) {
        
        Rectangle r = new Rectangle (2, 2, 8, 7);
        Rectangle s = new Rectangle (2, 2, 8, 7);
        Rectangle t = new Rectangle (2, 2, 8, 7);

        r.show();
        System.out.println("s의 면적은 " + s.square());
        if(t.contains(r)) System.out.println("t는 r을 포함합니다");
        if(t.contains(s)) System.out.println("t는 s을 포함합니다");
    }
}

class Rectangle{
    int x;
    int y;
    int z;
    int q;

    //매개변수로 받아 필드를 초기화하는 생성자
    Rectangle(int x, int y, int z, int q){
        this.x = x;
        this.y = y;
        this.z = z;
        this.q = q;
    }

    //int square() : 사각형 넓이 리턴
    public int square(){
        return z*q;
    }

    //사각형의 좌표와 넓이를 화면에 출력
    void show(){
        System.out.printf("(%d,%d)에서 크기가 %dx%d인 사각형", x, y, z, q);
    }

    //boolean contains(Rectangle r)
    void contains(int r){
        for (int i = 0; i < array.length; i++) {
            
        }
    }

}