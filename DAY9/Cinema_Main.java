import java.util.Scanner;

public class Cinema_Main {

    /**
     * 멤버 필드
     */
    private String[][] theater;

    static final int row = 4;
    static final int col = 5;

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