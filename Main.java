import java.util.Scanner;

public class Main{
 
	public static void main(String[] args) {

        int unit = 10000;
        int num = 0;
        boolean sw = false;

        

        Scanner sc = new Scanner(System.in);
        int money = Integer.parseInt(sc.nextLine());
        
        while ( true ){
        num = (int)(money / unit);

        System.out.printf("%d %d개 \n", unit, num );

        if (unit > 1) {
            money = money - unit * num;
        } 
        if ( sw = false ) {
            unit = unit / 2;
            sw = true;
        } 
        else  {
            unit = unit / 5;
            sw = false;
        }
    }
 

    }
}