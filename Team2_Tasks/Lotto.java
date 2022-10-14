
// 기능 구현

public class Lotto {

    // 정수 배열을 사용
    static int[] lottoNumber = new int[6];

    public static void main(String[] args) {
        // 아래의 순서로 기능 배치
        createLottoNumber();
        sortLottoNumber();
        //printLottoNumber();
    }

    // 아래 세 메서드 실제 구현
    private static void printLottoNumber() {
		
    }

    private static void sortLottoNumber() {
        for(int i = 0; i < lottoNumber.length; i++) {
            for(int j=i+1;j<lottoNumber.length; j++){
                if(lottoNumber[i] > lottoNumber[j]) {
                    swap(i, j);
                }
            }
        }
    }

    private static void swap(int a, int b) {
        int temp = lottoNumber[a];
        lottoNumber[a] = lottoNumber[b];
        lottoNumber[b] = temp;
    }

    private static void createLottoNumber() {
        // lottoNumber 라는 int형 배열에 중복없이 1 ~ 45 수 채우기
		int random = (int)Math.random() * 45 + 1;
        for (int i = 0; i < lottoNumber.length; i++) {
           lottoNumber[i] = random;
           for (int j = 1; j < lottoNumber.length; j++) {
            if(lottoNumber[j] == lottoNumber[j-1]){
                return;
            }
            System.out.print(lottoNumber[i]);
           }
        }
    }
}