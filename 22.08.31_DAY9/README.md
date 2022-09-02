# 2022.08.31.Wed 📅
<br>

## 1. Lotto 시나리오✔
-----------------------------
### * 시나리오

```
1. 로또 추첨 방식은 2가지 -> 오토(완전 랜덤), 세미오토(사용자가 원하는 만큼 숫자 입력, 나머지 랜덤)
2. 로또 번호는 중복될 수 없다.
3. 로또 번호는 오름차순으로 정렬된다.
```
### * class

```java
public class Lotto {

    private int[] number;
    private boolean isAuto;

    public Lotto(int[] number) {
        this.number = number;
    }

    public void auto() {
        isAuto = true;

        for(int i = 0 ; i < number.length; i++) {
            number[i] = (int)(Math.random()*45)+1;
            for(int j = 0 ; j < i ; j++) {
                if(number[i] == number[j]) {
                    --i;
                    break;
                }
            }
        }

        sort();
    }

    public void semiAuto() {
        isAuto = false;

        int count = 0;
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 6; ++i) {

            if (count > 0) {
                System.out.printf("현재까지 %d개 입력하셨습니다. ", count);
                System.out.print("[");
                for (int j = 0; j < count; ++j) {
                    System.out.print(number[j]);
                    if (j != count - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println("]\n");
            }

            System.out.println("1 ~ 45 번호를 입력해주세요 [0 : 나머지 자동]\n");
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }

            if (1 > num || num > 45) {
                System.out.printf("잘못된 입력입니다 [%d]\n", num);
                --i;
                continue;
            }

            boolean isSame = false;
            for(int j = 0; j <= i ;j++) {
                if (num == number[j]) {
                    System.out.println("중복되는 수입니다 다시 입력 하세요.");
                    i--;
                    isSame = true;
                    break;
                }
            }

            if (isSame) {
                continue;
            }

            number[i] = num;
            count++;
        }

        if (count == 0) {
            isAuto = true;
        }

        for(int i = count ; i < number.length; i++) {
            number[i] = (int)(Math.random()*45)+1;
            for(int j = 0 ; j < i ; j++) {
                if(number[i] == number[j]) {
                    --i;
                    break;
                }
            }
        }

        sort();
    }

    private void sort() {
        for(int i = 0; i < number.length;i++) {
            for(int j=i+1;j<number.length;j++){
                if(number[i] > number[j]) {
                    swap(i,j);
                }
            }
        }
    }

    private void swap(int a ,int b) {
        int temp = number[a];
        number[a] = number[b];
        number[b] = temp;
    }

    public void print() {
        String str = "수동";
        if (isAuto) {
            str = "자동";
        }

        System.out.print(str + " : ");
        for(int i = 0; i < 6; ++i) {
            System.out.printf("[%d] ", number[i]);
        }
    }
}
```

### * main
```java
public class Lotto_Main {

    public static void main(String[] args) {
        //1. 랜덤으로 할지 auto , 사용자가 번호 몇개 입력하고 나머지를 랜덤으로 할지 semi-auto
        // -> 랜덤, 세미랜덤 선택지 물어보고 선택한거 프린트, 실행, 실행값 출력
        //2. 실행값 출력, 계속 할지 말지 선택할 수 잇게
        boolean run = true;
        runLotto(run);
    }


    static void runLotto(boolean run) {
        Scanner sc = new Scanner (System.in);

        while (run) {
            System.out.println();
            System.out.println("**로또 추첨 방식을 선택해주세요.**");
            System.out.println("------------------------------");
            System.out.println(" 1. 자동  2. 직접 입력 3. 종료");
            System.out.println("------------------------------");

            int lotto = sc.nextInt();

            Lotto l = new Lotto(new int[6]);

            switch (lotto) {
                case 1 : lotto = 1;
                    System.out.println("'1. 자동'을 선택하셨습니다.");
                    System.out.println();
                    l.auto(); //auto 메소드 실행
                    l.print();//System.out.println("로또 추첨 결과 : " + number); //6개 랜덤 난수 출력
                    System.out.println();

                    break;

                case 2 : lotto = 2;
                    System.out.println("'2. 직접 입력'을 선택하셨습니다.");
                    System.out.println();
                    l.semiAuto(); //semiauto 실행
                    l.print();
                    System.out.println();

                    break;

                case 3 : lotto = 3;
                    System.out.println("프로그램을 종료하겠습니다.");
                    run = false;

                    break;

                default :
                    System.out.println("올바른 숫자를 선택해주세요");
                    break;
            }
        }
    }
}
```

## 2. Cinema 시나리오 ✔
---------------------------
### * 시나리오
```
1. 영화관은 예매하기, 예매조회, 예매취소의 기능을 가진다.
2. 예매시 입력한 휴대전화 뒷번호 4자리로 조회와 취소를 할 수 있다.
3. 예매시 좌석 선택은 행과 열을 고려해야한다.
4. 예매와 취소 현황이 좌석 현황에 업데이트 된다.
```
### * class

```java
import java.util.Scanner;

public class Cinema {

    /**
     * 멤버 필드
     */
    private String[][] theater;

    static final int row = 4;
    static final int col = 5;
    // static x 

    /**
     * 생성자
     */
    public Cinema_Main() {
        theater = new String[row][col];
    }

    /**
     * 메서드
     */
    // 0. 극장 운영
    public void run() {
        while (true) {
            System.out.println("********************************");
            System.out.println("*********영화 예매 시스템*********");
            System.out.println("********************************");
            System.out.println("1. 예매하기");
            System.out.println("2. 예매조회");
            System.out.println("3. 예매 취소");
            System.out.println("4. 종료");
            Scanner sc = new Scanner(System.in);
            int op = sc.nextInt();
            switch (op) {
                case 1: reserve();
                    break;
                case 2: searchReservation();
                    break;
                case 3: cancelReservation();
                    break;
                case 4:
                    System.out.println("이용해주셔서 감사합니다. 안녕히가세요~!");
                    return;
                case 5: printSeatInfo();
                    break;
                default:
                    System.out.println("1 ~ 4 번호만 입력해주세요.");
                    break;
            }
        }
    }

    // 1. 예매하기
    private void reserve() {
        //1. 좌석현황 보여주기
        printSeatInfo();
        while (true) {
            System.out.println("좌석을 선택해주세요.");
            System.out.println("이미 예매된 좌석은 \"예매\"라고 표시됩니다.");
            //2.1 사용자 행 입력
            System.out.println("행을 입력해주세요");
            Scanner sc = new Scanner(System.in);
            int r = Integer.parseInt(sc.nextLine());
            //2.2 사용자 열 입력
            System.out.println("열을 입력해주세요");
            sc = new Scanner(System.in);
            int c = Integer.parseInt(sc.nextLine());

            if (r <= 0 || r > row || c <= 0 || c > col) {
                System.out.println("잘못된 좌석 번호입니다. 다시 입력해주세요.");
                continue;
            }

            //3. 예매 가능 유무 확인
            if (theater[r - 1][c - 1] == null) {
                System.out.println("예매 가능한 좌석입니다");
            } else {
                System.out.println("이미 예약된 좌석입니다");
                continue;
                //3-1 예매 되었으면 다시 1로
            }

            //4.폰 번호 입력
            String phone = "";
            while (true) {
                System.out.println("휴대폰 번호 뒷자리 4자리를 입력해주세요");
                phone = sc.nextLine();

                if (phone.length() != 4) {
                    System.out.println("뒷번호 네 자리만 입력해주세요.");
                    continue;
                }
                break;
            }

            //5. 해당 행과 열 배열에 Person 객체 생성
            theater[r - 1][c - 1] = phone;
            System.out.println("예매된 좌석번호 : " + r + "행 " + c + "열 \n예매시 등록한 휴대전화 뒷 4자리 : " + phone);
            break;
        }
    }

    // 2. 예매 조회하기
    private void searchReservation() {
        System.out.println("전화번호를 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        String phone = sc.nextLine();
        System.out.println();
        for(int i =0;i<row;i++) {
            for(int j =0;j<col;j++) {
                if(theater[i][j] == null) {
                    continue;
                }
                if(theater[i][j].equals(phone)) {
                    System.out.println("고객님이 예매하신 좌석은 "+ (i + 1) +" - " + (j + 1) +" 입니다.");
                    System.out.println();
                    return;
                }
            }
        }
        System.out.println("예매하신 좌석이 없습니다.");
        System.out.println();
    }

    // 3. 예매 취소하기
    private void cancelReservation() {
        System.out.println("전화번호 뒷자리 네자리를 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        String phone = sc.nextLine();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                // 예매가 되지 되지 않은 경우
                if (theater[i][j] == null) {
                    continue;
                }
                if(theater[i][j].equals(phone)) {
                    String yn;
                    System.out.println("예약하신 좌석은 " + (i + 1) + " - " + (j + 1) +" 입니다.");
                    System.out.println();
                    System.out.println("예약을 취소하시겠습니까?(y/n)");
                    yn = sc.nextLine();
                    if(yn.equals("y")) {
                        theater[i][j] = null;
                        System.out.println("예약이 취소 되었습니다.");
                    } else {
                        System.out.println("메인 화면으로 돌아갑니다.");
                    }
                    return;
                }
            }
        }
        System.out.println("예매 내역이 없습니다.");
    }

    private void printSeatInfo() {
        System.out.println("*******좌석 현황*******");
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (theater[i][j] == null) {
                    System.out.print("[" + (i + 1) + "-" + (j + 1) + "]");
                } else {
                    System.out.print("[예매]");
                }
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }
}

```
### * main 
```java
public class Cinema {
    public static void main(String[] args) {
        Cinema_Main cinema = new Cinema_Main();
        cinema.run();
    }
}

```
