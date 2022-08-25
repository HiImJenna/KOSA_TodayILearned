# 2022.08.24.Wed 📅
<br>

# 제어문 ✔
===
<br>

▪ 조건문 : if (3가지), switch(조건) {case : ...break}
▪ 반복문 : for(반복 횟수가 명확), while(진위){}, do {} ~ while ()
▪ 분기분 : break(블럭탈출), continue(아래구문 skip)
<br>

## 1. for문
* ### for 문제 풀이
    #### Q1. 1 ~ 100 누적값

	```java
    int sum = 0;
	
	    for (int i = 1; i <= 100; i++) {
		System.out.println(" i : " + i);
		sum += i; 
        }
    ```

<br>

 * ### continue & break
    #### for + (분기문) continue, break

	```java
       for(int i =2; i<=9; i++ ) {
		for (int j = 0; j <= 9; j++) {
			if(i == j) {
				continue; //아래 구문 스킵
			}
			
			System.out.printf("[%d]*[%d]=[%d]\t", i, j, i*j);
		}
		System.out.println();
       }
     ```
   ✨ _continue (아래 구분 skip), break(for, while 블럭 탈출)_

<br>

   * #### break lable문
   > break label문은 앞에서 배운 하나의 반복문을 빠져나가는 break문과는 달리 중첩된 여러 개의 반복문을 탈출할 때 사용한다.

    ![이미지링크](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fcafeptthumb3.phinf.naver.net%2F20140523_98%2Fvenus0720_1400848435178wV26N_PNG%2Fbreak_label1.png%3Ftype%3Dw740%22&type=cafe_wa740)
    ▶중첩된 반복문에 사용된 예

     ![이미지링크](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fcafeptthumb4.phinf.naver.net%2F20140523_231%2Fvenus0720_1400848564395fc1P2_PNG%2Fbreak_label2.png%3Ftype%3Dw740%22&type=cafe_wa740)
    ▶반복문 내에 switch문 사용된 예


## 2. while문
------------------

![이미지링크](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fcafeptthumb2.phinf.naver.net%2F20140516_83%2Fvenus0720_1400242020196dqaBm_PNG%2Fwhile%25B5%25BF%25C0%25DB.png%3Ftype%3Dw740%22&type=cafe_wa740)

<br>

## 3. do - while문
--------------------
![이미지링크](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fcafeptthumb1.phinf.naver.net%2F20140516_22%2Fvenus0720_1400244016895cXwq5_PNG%2Fdo_while%25B5%25BF%25C0%25DB.png%3Ftype%3Dw740%22&type=cafe_wa740)

<br>

## 4. 플로차트 과제
---------------------
![이미지링크](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fpostfiles14.naver.net%2F20130420_13%2Fjavaking75_1366386553628N8kWb_PNG%2F2013-04-20_004909.png%3Ftype%3Dw2%22&type=cafe_wa740)


```java
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
```

