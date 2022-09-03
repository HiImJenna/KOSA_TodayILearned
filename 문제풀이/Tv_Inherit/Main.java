// package 문제풀이.Tv_Inherit;
// class TV {
//     private int size;
//     public TV(int size) {this.size = size;}
//     protected int getSize() {return size;}
// }

// class ColourTv extends TV {
//     public int colour;

//      public ColourTv(int size, int colour){ 
//          super(size);
//          this.colour = colour;
//      } 

//     public void printProperty(){
//         System.out.printf("%d인치 %d컬러", getSize(), colour);
//     }
// }

// class IPTV extends ColourTv {
//     String address;
    
//     public IPTV (String address, int size, int colour) {
//         super(size, colour);
//         this.address = address;
//     }

//     @Override
//     public void printProperty(){
//         System.out.printf("나의 IPTV는 %d 주소의 %d인치 %d컬러", getSize(), colour);
//     }
// }

// public class Main{
//     public static void main(String[] args) {
//         //ColourTv myTV = new ColourTv(32, 1024);
//         //myTV.printProperty();
//         IPTV iptv = new IPTV("192.1.1.2", 32, 2048);

//         iptv.printProperty();
//     }
// }

class TV{
    private int size;
    
    public TV(int size) {
    this.size = size;
    }
    protected int getSize() {
        return size;
    }
}

class ColorTV extends TV{
    private int color;
    public void setColor(int color) {
        this.color = color;
    }
    public int getColor() {
        return color;
    }

    public ColorTV(int size, int color){
        super(size);
        this.color = color;
    }

    public void printProperty(){
        System.out.printf("%d인치 %d컬러",getSize(),getColor());
    }
}

class IPTV extends ColorTV{
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public IPTV(String ip, int size, int color){
        super(size, color);
        this.ip = ip;
    }

    @Override
    public void printProperty() {
        System.out.println("나의 IPTV는 " + ip + " 주소의 " + getSize() + "인치 " + getColor() + "컬러");
    }
}


public class Main {
    public static void main(String[] args) {
        // ColorTV myTV = new ColorTV(32, 1024);
        // myTV.printProperty();

        IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
        iptv.printProperty();
    }
}
