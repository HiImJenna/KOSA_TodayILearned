# 2022.08.30.Tue 📅
<br>

## 1. 배열 Array ✔
--------------
```java
 * 배열은 객체다(Array)
 1. new를 통해서 생성
 2. heap 메모리 생성(관리자원)
 3. 고정배열(정적배열) : 배열을 한번 선언하면 (크기가 정해지면) 변경 불가 <-> collection(동적)
 4. 자료구조 (알고리즘) 기초적인 학습
 ```

 ```java
 //배열 생성 3가지
int[] arr = new int[5]; //기본
int[] arr2 = new int[] {100, 200, 300}; //초기값을 통해서 배열 개수를 정의하고 값을 할당
int[] arr3 = {11, 22, 33}; //컴파일러에게 자동으로 new 부분 부탁 (0)
```
        

 ### 문제 풀이
 ### Q1) 
``` java
어느 학생의 기말고사 시험 점수 (5과목)
1. 총 과목의 수
2. 과목의 합
3. 과목의 평균
단, 2 & 3번 문제는 하나의 for문으로 해결
sum을 할때마다 평균을 구할 필요는 없다
```

```java
int[] mark = {100, 55, 90, 60, 78};
int sum = 0;
float avg = 0f;

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
```
<br>

### Q2)
```java
1. 1 ~ 45까지의 난수를 발생 시켜서 6개의 정수값을 배열에 담으세요.
2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안됩니다. (중복값에 대한 검증 코드가 필요)
3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요. >> sort (정렬 : 자리바꿈 : swap)
4. 위 결과를 담고있는 배열을 출력하세요.
5. main 안에서 모두 작성해도 ok, static 함수 사용도 ok, 클래스로 만들지 x


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
```

 ![image](https://user-images.githubusercontent.com/111114507/187410453-e81b7c95-2101-4680-8d99-c1404e9f4e78.png)

 ### 2차원 배열
 ![image](http://www.tcpschool.com/lectures/img_java_array23.png)