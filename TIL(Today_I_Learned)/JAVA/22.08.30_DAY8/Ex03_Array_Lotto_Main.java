import java.util.Arrays;

/*
	1. 1 ~ 45까지의 난수를 발생 시켜서 6개의 정수값을 배열에 담으세요.
	2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안됩니다. (중복값에 대한 검증 코드가 필요)
	3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요. >> sort (정렬 : 자리바꿈 : swap)
	4. 위 결과를 담고있는 배열을 출력하세요.
	
	main 안에서 모두 작성해도 ok, static 함수 사용도 ok, 클래스로 만들지 x
 */


public class Ex03_Array_Lotto_Main {
	static int[] arr = new int[6]; //6자리 배열 지정
	
	
	public static void main(String[] args) {
	
		for (int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random()*45 + 1); //난수 6개 생성해서 배열로 지정
			boolean result = check(random);
			
			if(result == true) { //중복값이 있는지 확인
				i--;			 // 
				continue; //중복값이 있다면 반복문 맨 위부터 다시 실행 (난수 다시 뽑기)
			}
			arr[i] = random;	
		} 
		Arrays.sort(arr); //작은 수 부터 정렬 (bubble sort는 못하겠음..)
		String resultArray = Arrays.toString(arr);
		System.out.println(resultArray); //출력
	}
	
	public static boolean check (int random) { //중복값 확인 함수 (중복값이 있다면 true를 없다면 false를 return)
		for (int i = 0; i < arr.length; i++) {
			if (random == arr[i]) {
				return true;
			}
		}
			return false;
	}

}
