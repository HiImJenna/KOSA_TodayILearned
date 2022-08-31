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