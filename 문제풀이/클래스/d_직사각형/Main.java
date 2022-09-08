package 클래스.d_직사각형;


public class Main {
    public static void main(String[] args) {
        
        Rectangle r = new Rectangle (2, 2, 8, 7);
        Rectangle s = new Rectangle (2, 2, 8, 7);
        Rectangle t = new Rectangle (2, 2, 8, 7);

        r.show();
        System.out.println("s의 면적은 " + s.squared);
        if(t.contains(r)) System.out.println("t는 r을 포함합니다");
        if(t.contains(s)) System.out.println("t는 s을 포함합니다");
    }
}

class Rectangle{
    int x;
    int y;
    int z;
    int q;

    Rectangle(int x, int y, int z, int q){
        this.x = x;
        this.y = y;
        this.z = z;
        this.q = q;
    }

    void show(){
        System.out.printf("(%d,%d)에서 크기가 %dx%d인 사각형", x, y, z, q);
    }

    void contains(int r){

    }

}