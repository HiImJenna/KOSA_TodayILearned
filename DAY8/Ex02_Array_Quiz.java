
public class Ex02_Array_Quiz {

	public static void main(String[] args) {
	//국문과 학생들의 기말고사 시험점수입니다.
		int[] score = new int[] {79, 88, 97, 54, 56, 95};
		int max = score[0]; //max = 79
		int min = score[0]; //min = 79
		/*
		 * 제어문을 통해서 max라는 변수에 시험점수 중에 최대값을 담고
		 * min이라는 변수에 시험점수 중에 최소값을 담으세요.
		 * 출력결과 : max > 97, min > 54
		 * 단, for문 한번만 사용
		 */
			for (int i = 0; i < score.length; i++) {
				if (score[i] > max) {max = score[i];}
				if (score[i] < min) {min = score[i];}
				
				//삼합연산자
				// max = (score[i] > max) ? score[i] : max;
				// min = (score[i] < min) ? score[i] : min;
			}
			System.out.println(max);
			System.out.println(min);
			
			int[] numbers = new int[10];
			//10개의 방의 값을 1 ~ 10까지로 초기화
			//for문을 통해서 
			
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = i + 1;
				//0 > 1
				//1 > 2
			}
			for (int i = 0; i < numbers.length; i++) {
				System.out.println(numbers[i]);
			}
			
			
			//어느 학생의 기말고사 시험 점수 (5과목)
			int[] mark = {100, 55, 90, 60, 78};
			int sum = 0;
			float avg = 0f;
			
			//1. 총 과목의 수
			//2. 과목의 합
			//3. 과목의 평균
			//단, 2 & 3번 문제는 하나의 for문으로 해결
			//sum을 할때마다 평균을 구할 필요는 없다
		
			System.out.println("과목 수 : " + mark.length);
			
			for (int i = 0; i < mark.length; i++) {
				sum = sum + mark[i];
				avg = sum / (float)mark.length;
				//if ( i == mark.length-1) { //마지막 방이라면 
				//avg = sum / (float)mark.length;
				//}
				
			System.out.println("총 합 : " + sum);
			System.out.println("과목 평균 : " + avg);
			
		}
	}
}


